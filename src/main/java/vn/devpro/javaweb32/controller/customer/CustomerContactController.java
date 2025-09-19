package vn.devpro.javaweb32.controller.customer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.devpro.javaweb32.controller.BaseController;
import vn.devpro.javaweb32.dto.Jw32Contanst;
import vn.devpro.javaweb32.model.Contact;

@Controller
@RequestMapping("/contact/")
public class CustomerContactController extends BaseController implements Jw32Contanst{
	
	@RequestMapping(value =  "/view", method = RequestMethod.GET)
	public String contact() {
		return "customer/contact";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveContect(HttpServletRequest request) {	
		//lấy dữ liệu do view gửi sang
		Contact contact = new Contact(
		request.getParameter("name"), // tên của ô input
		request.getParameter("email"),
		request.getParameter("address"),
		request.getParameter("mobile"),
		request.getParameter("message"));
		
		System.out.println("Your name: "+ contact.getName());
		System.out.println("Your email: "+ contact.getEmail());
		System.out.println("Your address: "+ contact.getAddress());
		System.out.println("Your mobile: "+ contact.getMobile());
		System.out.println("Your message: "+ contact.getMessage());
		//Xử lý dữ liệu
		//lưu dứ liệu vào db data base
		
		return "customer/contact";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editView(Model model) {
		Contact contact = new Contact("Bùi Minh Hiếu", "buiminhhieu12092003@gmail.com",
				"Mai Dich", "0123546", "gsmkdlgsl;,digjw09jg");
		model.addAttribute("contact", contact);

		return "customer/contact-edit";
	}
	
//	@RequestMapping(value = "edit-save", method = RequestMethod.POST)
//	public String saveEditContect(HttpServletRequest request) {	
//		//lấy dữ liệu do view gửi sang
//		Contact contact = new Contact(
//		request.getParameter("name"), // tên của ô input
//		request.getParameter("email"),
//		request.getParameter("address"),
//		request.getParameter("mobile"),
//		request.getParameter("message"));
//		
//		System.out.println("Your name: "+ contact.getName());
//		System.out.println("Your email: "+ contact.getEmail());
//		System.out.println("Your address: "+ contact.getAddress());
//		System.out.println("Your mobile: "+ contact.getMobile());
//		System.out.println("Your message: "+ contact.getMessage());
//		//Xử lý dữ liệu
//		//lưu dứ liệu vào db data base
//		
//		return "redirect:/contact/edit";
//	}
	
	@RequestMapping(value = "edit-save", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> editSave(@RequestBody Contact contact){
		System.out.println("Your name: "+ contact.getName());
		System.out.println("Your email: "+ contact.getEmail());
		System.out.println("Your address: "+ contact.getAddress());
		System.out.println("Your mobile: "+ contact.getMobile());
		System.out.println("Your message: "+ contact.getMessage());
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("message", "Thông tin của '"+ contact.getName()+"' đã được lưu");
		return ResponseEntity.ok(jsonResult);
	}
	
	@RequestMapping(value =  "/view-sf", method = RequestMethod.GET)
	public String contactSF(final Model model) {
		Contact contact = new  Contact();
		model.addAttribute("contact", contact);// đẩy đối tượng sang view để khởi tạo spring form
		return "customer/contact-sf";
	}
	
	@RequestMapping(value = "save-sf", method = RequestMethod.POST)
	public String saveContectSF(HttpServletRequest request, 
			@ModelAttribute Contact contact) {	
		//lấy dữ liệu do view gửi sang
		
		
		System.out.println("Your name: "+ contact.getName());
		System.out.println("Your email: "+ contact.getEmail());
		System.out.println("Your address: "+ contact.getAddress());
		System.out.println("Your mobile: "+ contact.getMobile());
		System.out.println("Your message: "+ contact.getMessage());
		//Xử lý dữ liệu
		//lưu dứ liệu vào db data base
		
		return "redirect:/contact/view-sf";
	}
	
	@RequestMapping(value = "sf-edit", method = RequestMethod.GET)
	public String editViewSF(Model model) {
		Contact contact = new Contact(
				"Bùi Minh Hiếu", 
				"buiminhhieu12092003@gmail.com",
				"Mai Dich", "0123546", "gsmkdlgsdigjw09jg");
		model.addAttribute("contact", contact);

		return "customer/contact-sf-edit";
	}
	
	@RequestMapping(value = "save-sf-edit", method = RequestMethod.POST)
	public String saveContectSFEdit(HttpServletRequest request, 
			@ModelAttribute Contact contact, // đọc dư liệu từ form
			@RequestParam("contactFile") MultipartFile file, // đọc file
			RedirectAttributes ra
			) throws IOException{	
		//lấy dữ liệu do view gửi sang
		
		
		System.out.println("Your name: "+ contact.getName());
		System.out.println("Your email: "+ contact.getEmail());
		System.out.println("Your address: "+ contact.getAddress());
		System.out.println("Your mobile: "+ contact.getMobile());
		System.out.println("Your message: "+ contact.getMessage());
		//Xử lý dữ liệu
		//lưu dứ liệu vào db data base
		// kiểm tra xem file có được upload  hay không
	    int saved = 0;
		if(file != null && !file.getOriginalFilename().isEmpty()) {// có
	        // Đảm bảo thư mục tồn tại (giữ style cũ, chỉ thêm mkdirs)
	        File dir = new File(FOLDER_UPLOAD + "ContactFiles/");
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
			// lưu file vào thư mục UploadFiles/ContactFile
			String path = FOLDER_UPLOAD + "ContactFiles/" + file.getOriginalFilename();
			File fileDest = new File(path);
			file.transferTo(fileDest);
	        saved = 1;
		}
		

        ra.addFlashAttribute("toast", "Đã lưu liên hệ"
                + (saved > 0 ? (" và " + saved + " file.") : "."));
        ra.addFlashAttribute("toastType", "success");
		
		return "redirect:/contact/sf-edit";
	}


}

