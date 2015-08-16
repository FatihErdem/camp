package tr.org.lkd.lyk2015.camp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.org.lkd.lyk2015.camp.model.Admin;

@Controller
@RequestMapping(value = "/admins")
public class AdminController {

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String getAdminCreate(@ModelAttribute Admin admin) {

        return "createAdminForm";
    }
}
