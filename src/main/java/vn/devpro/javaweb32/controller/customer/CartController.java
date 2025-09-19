package vn.devpro.javaweb32.controller.customer;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb32.controller.BaseController;
import vn.devpro.javaweb32.dto.Cart;
import vn.devpro.javaweb32.dto.CartProduct;

@Controller
public class CartController extends BaseController {

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String viewCart() {
		return "customer/cart-view";
	}

	@RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCart(HttpServletRequest request,
			@RequestBody CartProduct cartProduct) {
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		String message = "";

		if (cartProduct.getQuantity().intValue() < 1) {
			jsonResult.put("code", 400);
			jsonResult.put("message", "so luong khong hop le");
			return ResponseEntity.badRequest().body(jsonResult);
		} else {// thêm sản phẩm vào giỏ hàng
			// lấy session
			HttpSession session = request.getSession();
			if (session.getAttribute("cart") == null) {// chưa có giỏ hàng
				// khởi tạo giỏ hàng mới
				Cart cart = new Cart();
				session.setAttribute("cart", cart);
			}

			Cart cart = (Cart) session.getAttribute("cart");

			int index = cart.findById(cartProduct.getId());
			if (index == -1) { // sp chưa có trong giỏ hàng
				cart.getCartProducts().add(cartProduct);
			} else {
				cart.getCartProducts().get(index).updateQuantity(cartProduct.getQuantity());
			}
			jsonResult.put("code", 200);
			jsonResult.put("message", "Them san pham thanh cong");
			BigInteger totalCartProducts = BigInteger.ZERO;
			for (CartProduct product : cart.getCartProducts()) {
				totalCartProducts = totalCartProducts.add(product.getQuantity());
			}
			jsonResult.put("totalCartProducts", totalCartProducts);
			return ResponseEntity.ok(jsonResult);
		}
	}

}
