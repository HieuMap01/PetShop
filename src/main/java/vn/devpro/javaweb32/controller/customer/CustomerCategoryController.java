
package vn.devpro.javaweb32.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.javaweb32.controller.BaseController;

@Controller
public class CustomerCategoryController extends BaseController{

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category() {
        return "customer/category";
    }

}
