package tr.org.lkd.lyk2015.camp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tr.org.lkd.lyk2015.camp.model.Admin;
import tr.org.lkd.lyk2015.camp.service.AdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAdminList(Model model) {

        List<Admin> admins = adminService.getAll();
        model.addAttribute("adminList", admins);

        return "admin/listAdmin";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getAdminCreate(@ModelAttribute Admin admin) {

        return "admin/createAdminForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postAdminCreate(@ModelAttribute @Valid Admin admin,
                                  @RequestParam("passwordAgain") String passwordAgain,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/createAdminForm";
        }

        if (!passwordAgain.equals(admin.getPassword())) {
            //TODO error
        }
        adminService.create(admin);

        return "redirect:/admins";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getAdminUpdate(@PathVariable(value = "id") Long id, Model model) {

        Admin admin = adminService.getById(id);
        model.addAttribute("admin", admin);

        return "admin/updateAdminForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String postAdminUpdate(@PathVariable(value = "id") Long id, @ModelAttribute Admin admin, Model model) {

        adminService.update(admin);
        return "redirect:/admins";
    }
}
