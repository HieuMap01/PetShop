package vn.devpro.javaweb32.controller.administrator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.javaweb32.controller.BaseController;
import vn.devpro.javaweb32.dto.Jw32Contanst;
import vn.devpro.javaweb32.dto.ProductSearch;
import vn.devpro.javaweb32.model.Category;
import vn.devpro.javaweb32.model.Product;
import vn.devpro.javaweb32.model.ProductImage;
import vn.devpro.javaweb32.model.User;
import vn.devpro.javaweb32.service.CategoryService;
import vn.devpro.javaweb32.service.ProductService;
import vn.devpro.javaweb32.service.UserService;

@Controller
@RequestMapping("/admin/product/")
public class ProductAdminController extends BaseController implements Jw32Contanst {

	@Autowired
	ProductService ps = new ProductService();

	@Autowired
	UserService us = new UserService();

	@Autowired
	CategoryService cs = new CategoryService();

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String view(final Model model, final HttpServletRequest request) {

		ProductSearch productSearch = new ProductSearch();

		// Xử lý các thông tin liên quan đến tìm kiếm
		productSearch.setStatus(2); // all status
		String str = request.getParameter("status");
		if (str != null && !StringUtils.isEmpty(str)) {
			productSearch.setStatus(Integer.parseInt(str));
		}

		productSearch.setCategoryId(0); // all category
		str = request.getParameter("categoryId");
		if (str != null && !StringUtils.isEmpty(str)) {
			productSearch.setCategoryId(Integer.parseInt(str));
		}

		productSearch.setKeyword(null);
		str = request.getParameter("keyword");
		if (str != null && !StringUtils.isEmpty(str)) {
			productSearch.setKeyword(str);
		}

		productSearch.setBeginDate(null);
		productSearch.setEndDate(null);

		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");

		if (beginDate != null && !StringUtils.isEmpty(beginDate) && endDate != null && !StringUtils.isEmpty(endDate)) {
			productSearch.setBeginDate(beginDate);
			productSearch.setEndDate(endDate);

		}

		// tất cả sản phẩn tìm kiếm được
		// List<Product> product = ps.findAll();
		List<Product> allProductSearch = ps.search(productSearch);

		// tính toán phân trang
		productSearch.setCurrentPage(1);// mặc định khởi độn web lên là trang 1

		// lấy trang hiện tại(do bấm nút)
		str = request.getParameter("currentPage");
		if (str != null && !StringUtils.isEmpty(str)) {
			productSearch.setCurrentPage(Integer.parseInt(str));

		}

		// nếu là bấm nút search thì phải reset trang hineje tại về 1
		str = request.getParameter("totalItems");
		if (str != null && !StringUtils.isEmpty(str)) {
			int oldTotalItems = Integer.parseInt(str);
			if (allProductSearch.size() != oldTotalItems) {
				productSearch.setCurrentPage(1);
			}
		}

		// số sản phẩm trong 1 trang
		productSearch.setItemsOnPage(ITEMS_ON_PAGE);

		// tổng số sản phẩm
		productSearch.setTotalItems(allProductSearch.size());
		// tổng số trang
		int totalPages = allProductSearch.size() / ITEMS_ON_PAGE;
		if (allProductSearch.size() % ITEMS_ON_PAGE != 0) {
			totalPages++;
		}
		productSearch.setTotalPages(totalPages);
		// lấy danh sách của trang hiện tại (cần hiển thị)
		List<Product> products = new ArrayList<Product>();
		int firstIndex = (productSearch.getCurrentPage() - 1) * ITEMS_ON_PAGE;
		int lastIndex = firstIndex + ITEMS_ON_PAGE;
		if (lastIndex > allProductSearch.size()) {
			lastIndex = allProductSearch.size();
		}

		products = allProductSearch.subList(firstIndex, lastIndex);

		model.addAttribute("products", products);
		model.addAttribute("productSearch", productSearch);

		List<Category> categories = cs.findAllActive();
		model.addAttribute("categories", categories);

		return "administrator/product/product-list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(final Model model) {

		Product product = new Product();
		List<Category> category = cs.findAllActive();
		List<User> user = us.findAllActive();

		product.setCreateDate(new Date());

		model.addAttribute("product", product);
		model.addAttribute("categories", category);
		model.addAttribute("users", user);
		return "administrator/product/product-add";
	}

	// kiểm tra danh sách file avatar
	public boolean isUploadFile(MultipartFile avatar) {
		if (avatar != null && !StringUtils.isEmpty(avatar.getOriginalFilename())) {
			return true;
		}
		return false;

	}

	// kiểm tra danh sách file ảnh
	public boolean isUploadImages(MultipartFile[] images) {
		if (images != null && images.length > 0) {
			return true;
		}
		return false;

	}

	@RequestMapping(value = "add-save", method = RequestMethod.POST)
	public String save(final Model model, @ModelAttribute("product") Product product,
			@RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("imageFiles") MultipartFile[] imageFiles) throws IOException {

		// xử lý file avatar

		if (isUploadFile(avatarFile)) { // có upload avatar
			// lưu file vào thư mục
			String path = FOLDER_UPLOAD + "Product/Avatar/" + avatarFile.getOriginalFilename();

			File file = new File(path);
			avatarFile.transferTo(file);

			// lưu đường dẫn vào db(product table)
			product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());

		}
		// xử lý danh sách ảnh
		if (isUploadImages(imageFiles)) { // có upload danh sách ảnh
			for (MultipartFile image : imageFiles) {
				if (isUploadFile(image)) { // có upload file
					String paths = FOLDER_UPLOAD + "Product/Image/" + image.getOriginalFilename();

					File file = new File(paths);
					image.transferTo(file);

					// lưu đường dẫn vào db(product table)
					ProductImage pImage = new ProductImage();
					pImage.setCreateDate(new Date());
					pImage.setPath("Product/Image" + image.getOriginalFilename());
					pImage.setStatus(Boolean.TRUE);
					pImage.setTitle(image.getOriginalFilename());

					// dùng phương thức addRelation... của Product để add image vào bảng product

					pImage.setProduct(product);
					product.addRelationalProductImage(pImage);
				}
			}
		}

		ps.saveOrUpdate(product);
		return "redirect:/admin/product/add";
	}

	@RequestMapping(value = "edit/{productId}", method = RequestMethod.GET)
	public String edit(final Model model, @PathVariable("productId") int productId) {

		// lấy product trong DB

		Product product = ps.getById(productId);
		List<Category> category = cs.findAllActive();
		List<User> user = us.findAllActive();

		product.setUpdateDate(new Date());

		model.addAttribute("product", product);
		model.addAttribute("categories", category);
		model.addAttribute("users", user);
		return "administrator/product/product-edit";
	}

	@RequestMapping(value = "edit-save", method = RequestMethod.POST)
	public String update(final Model model, @ModelAttribute("product") Product product,
			@RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("imageFiles") MultipartFile[] imageFiles) throws IOException {

		Product dbProduct = ps.getById(product.getId());

		// xử lý file avatar
		if (isUploadFile(avatarFile)) { // có upload avatar
			// xóa avatar cũ(nếu có)
			if (product.getAvatar() != null && !StringUtils.isEmpty(product.getAvatar())) {
				String path = FOLDER_UPLOAD + product.getAvatar();
				File file = new File(path);
				file.delete();
			}

			// lưu avatar mới
			String path = FOLDER_UPLOAD + "Product/Avatar/" + avatarFile.getOriginalFilename();

			File file = new File(path);
			avatarFile.transferTo(file);

			// lưu đường dẫn vào db(product table)
			product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());

		} else {
			product.setAvatar(dbProduct.getAvatar());
		}

		// xử lý danh sách ảnh
		if (isUploadImages(imageFiles)) { // có upload danh sách ảnh
			for (MultipartFile image : imageFiles) {
				if (isUploadFile(image)) { // có upload file
					String paths = FOLDER_UPLOAD + "Product/Image/" + image.getOriginalFilename();

					File file = new File(paths);
					image.transferTo(file);

					// lưu đường dẫn vào db(product table)
					ProductImage pImage = new ProductImage();
					pImage.setCreateDate(new Date());
					pImage.setPath("Product/Image/" + image.getOriginalFilename());
					pImage.setStatus(Boolean.TRUE);
					pImage.setTitle(image.getOriginalFilename());

					// dùng phương thức addRelation... của Product để add image vào bảng product

					pImage.setProduct(product);
					product.addRelationalProductImage(pImage);
				}
			}
		}

		ps.saveOrUpdate(product);
		return "redirect:/admin/product/list";
	}

	@RequestMapping(value = "delete/{productId}", method = RequestMethod.GET)
	public String deleteEdit(@PathVariable("productId") int productId) {
		// ẩn dữ liệu đi chứ ko phải xóa hoàn toàn vì liên quan đến cơ sở dữ liệu

		Product product = ps.getById(productId);
		product.setStatus(false);

		ps.saveOrUpdate(product);

		return "redirect:/admin/product/list";
	}

}
