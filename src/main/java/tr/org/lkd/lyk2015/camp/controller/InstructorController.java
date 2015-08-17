package tr.org.lkd.lyk2015.camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tr.org.lkd.lyk2015.camp.model.Instructor;
import tr.org.lkd.lyk2015.camp.service.CourseService;
import tr.org.lkd.lyk2015.camp.service.InstructorService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/instructors")
public class InstructorController {


    @Autowired
    private InstructorService instructorService;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getInstructorList(Model model) {

        List<Instructor> instructors = instructorService.getAll();
        model.addAttribute("instructorList", instructors);

        return "admin/listInstructor";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getInstructorCreate(@ModelAttribute Instructor instructor, Model model) {

        model.addAttribute("courseIds", courseService.getAll());
        return "admin/createInstructorForm";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postInstructorCreate(@ModelAttribute @Valid Instructor instructor,
                                       @RequestParam(value = "passwordAgain") String passwordAgain,
                                       @RequestParam("courseIds") List<Long> ids, Model model,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/createInstructorForm";
        }

        if (!passwordAgain.equals(instructor.getPassword())) {
            model.addAttribute("message", "þifreler uyuþmuyor");
            return "admin/createInstructorForm";
        }

        instructorService.create(instructor, ids);

        return "redirect:/instructors";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getAdminUpdate(@PathVariable("id") Long id,
                                 Model model,
                                 @RequestParam(value = "message", required = false) String message) {

        Instructor instructor = instructorService.getById(id);
        model.addAttribute("instructor", instructor);
        model.addAttribute("courses", courseService.getAll());
        model.addAttribute("message", message);
        return "admin/updateInstructorForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String postInstructorUpdate(@PathVariable(value = "id") Long id,
                                       @ModelAttribute Instructor instructor,
                                       Model model) {

        instructorService.update(instructor);
        return "redirect:/instructors";
    }
}