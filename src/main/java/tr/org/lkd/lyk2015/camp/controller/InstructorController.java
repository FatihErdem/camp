package tr.org.lkd.lyk2015.camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tr.org.lkd.lyk2015.camp.model.Instructor;
import tr.org.lkd.lyk2015.camp.service.InstructorService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/instructors")
public class InstructorController {


    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getInstructorList(Model model) {

        List<Instructor> instructors = instructorService.getAll();
        model.addAttribute("instructorList", instructors);

        return "/admin/listInstructor";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getInstructorForm(@ModelAttribute Instructor instructor) {

        return "/admin/createInstructorForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postAdminCreate(@ModelAttribute @Valid Instructor instructor,
                                  @RequestParam("passwordAgain") String passwordAgain,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/createAdminForm";
        }

        if (!passwordAgain.equals(instructor.getPassword())) {
            //TODO error
        }
        instructorService.create(instructor);

        return "redirect:/admins";

    }
}
