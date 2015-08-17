package tr.org.lkd.lyk2015.camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
            return "admin/createInstructorForm";
        }

        if (!passwordAgain.equals(instructor.getPassword())) {
            //TODO error
        }
        instructorService.create(instructor);

        return "redirect:/instructors";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getInstructorUpdate(@PathVariable(value = "id") Long id, Model model) {

        Instructor instructor = instructorService.getById(id);
        model.addAttribute("instructor", instructor);

        return "admin/updateInstructorForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String postInstructorUpdate(@PathVariable(value = "id") Long id, @ModelAttribute Instructor instructor, Model model) {

        instructorService.update(instructor);
        return "redirect:/instructors";
    }
}