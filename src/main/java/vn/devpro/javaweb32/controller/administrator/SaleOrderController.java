package vn.devpro.javaweb32.controller.administrator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb32.controller.BaseController;
import vn.devpro.javaweb32.dto.Cart;
import vn.devpro.javaweb32.dto.CartProduct;
import vn.devpro.javaweb32.model.Product;
import vn.devpro.javaweb32.model.SaleOrder;
import vn.devpro.javaweb32.model.SaleOrderProduct;
import vn.devpro.javaweb32.model.User;
import vn.devpro.javaweb32.service.ProductService;
import vn.devpro.javaweb32.service.SaleOrderService;

@Controller
public class SaleOrderController extends BaseController {

	@Autowired
	SaleOrderService ss = new SaleOrderService();

	@Autowired
	ProductService ps = new ProductService();

	@RequestMapping(value = "/place-order", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> placeOder(final HttpServletRequest request,
			@RequestBody SaleOrder saleOrder) {
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		// lưu giỏ hàng

		if (StringUtils.isEmpty(saleOrder.getCustomerName())) {
			jsonResult.put("code", 404);
			jsonResult.put("message", "Bạn chưa điền tên");
			return ResponseEntity.ok(jsonResult);
		}
		if (StringUtils.isEmpty(saleOrder.getCustomerMobile())) {
			jsonResult.put("code", 404);
			jsonResult.put("message", "Bạn chưa điền sđt");
			return ResponseEntity.ok(jsonResult);
		}

		HttpSession session = request.getSession();

		if (session.getAttribute("cart") == null) {
			jsonResult.put("code", 404);
			jsonResult.put("message", "Bạn chưa có giỏ hàng");
			return ResponseEntity.ok(jsonResult);
		}

		Cart cart = (Cart) session.getAttribute("cart");
		if (cart.getCartProducts().size() < 1) {
			jsonResult.put("code", 404);
			jsonResult.put("message", "Bạn chưa có sp nào trong giỏ hàng");
			return ResponseEntity.ok(jsonResult);
		}

		// tạo 1 hoác đơn - sale order
		saleOrder.setTotal(cart.totalCartPrice());// tổng tiền hóa đơn
		Date date = new Date();
		String code = date.getYear() + date.getMonth() + date.getDay() + date.getHours() + date.getMinutes()
				+ date.getSeconds() + saleOrder.getCustomerMobile();
		saleOrder.setCode(code);
		saleOrder.setCreateDate(date);

		User user = new User();
		user.setId(7);
		saleOrder.setUser(user);
		saleOrder.setStatus(true);

		// duyệt danh sách sp trong giỏ hàng để kết nối với order và product

		for (CartProduct cartProduct : cart.getCartProducts()) {
			// lấy sẳn phẩm trong db
			Product product = ps.getById(cartProduct.getId());

			SaleOrderProduct saleOrderProduct = new SaleOrderProduct();

			saleOrderProduct.setCreateDate(date);
			saleOrderProduct.setName(product.getName());
			saleOrderProduct.setPrice(product.getPrice());
			saleOrderProduct.setQuantity(cartProduct.getQuantity().intValue());

			// gắn sp da ban voi sp
			saleOrderProduct.setProduct(product);

			// găn sp bán với hóa đơn
			saleOrderProduct.setSaleOrder(saleOrder);

			// lưu
			saleOrder.addRelationalSaleOrderProduct(saleOrderProduct);

		}

		ss.saveOrUpdate(saleOrder);

		jsonResult.put("code", 200);
		jsonResult.put("message", "Bạn đặt hàng thành công");
		return ResponseEntity.ok(jsonResult);
	}

	@RequestMapping(value = "/admin/order/list")
	public String viewListOrders(final Model model) {
		List<SaleOrder> saleOrders = ss.findAll();
		model.addAttribute("saleOrders", saleOrders);
		return "administrator/order/order-list";
	}

}
