package vn.devpro.javaweb32.controller.administrator;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb32.controller.BaseController;
import vn.devpro.javaweb32.model.Category;
import vn.devpro.javaweb32.model.User;
import vn.devpro.javaweb32.service.CategoryService;
import vn.devpro.javaweb32.service.UserService;

@Controller
@RequestMapping("/admin/category/")
public class CategoryAdminController extends BaseController {

	@Autowired
	CategoryService cs;
	@Autowired
	UserService us;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Category> categories = cs.findAllActive();
		// List<Category> categories = cs.findByName("Mèo Cảnh");
		model.addAttribute("categories", categories);
		// TODO Auto-generated constructor stub
		return "administrator/category/category-list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String view_add(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);

		category.setCreateDate(new Date());

		List<User> users = us.findAllActive();
		model.addAttribute("users", users);

		return "administrator/category/category-add";
	}

	@RequestMapping(value = "add-save", method = RequestMethod.POST)
	public String save_add(Model model, @ModelAttribute("category") Category category) {

		cs.saveOrUpdate(category);

		return "redirect:/admin/category/add";
	}

	@RequestMapping(value = "edit/{categoryId}", method = RequestMethod.GET)
	public String viewEdit(@PathVariable("categoryId") int categoryId, Model model) {
		// lấy dữ liệu trong database
		// lấy category bằng id
		Category category = cs.getById(categoryId);
		model.addAttribute("category", category);

		List<User> users = us.findAllActive();
		model.addAttribute("users", users);

		return "administrator/category/category-edit";
	}

	@RequestMapping(value = "edit-save", method = RequestMethod.POST)
	public String save_edit(Model model, @ModelAttribute("category") Category category) {

		cs.saveOrUpdate(category);

		return "redirect:/admin/category/list";
	}

//	@RequestMapping(value = "delete/{categoryId}", method = RequestMethod.GET)
//	public String deleteEdit(@PathVariable("categoryId") int categoryId) {
//		// lấy dữ liệu trong database
//		// lấy category bằng id
//
//		cs.deleteById(categoryId);
//
//		return "redirect:/admin/category/list";
//	}

	@RequestMapping(value = "delete/{categoryId}", method = RequestMethod.GET)
	public String deleteEdit(@PathVariable("categoryId") int categoryId) {
		// ẩn dữ liệu đi chứ ko phải xóa hoàn toàn vì liên quan đến cơ sở dữ liệu

		Category category = cs.getById(categoryId);
		category.setStatus(false);

		cs.saveOrUpdate(category);

		return "redirect:/admin/category/list";
	}

}
