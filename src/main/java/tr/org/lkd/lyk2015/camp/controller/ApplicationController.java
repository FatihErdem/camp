package tr.org.lkd.lyk2015.camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import tr.org.lkd.lyk2015.camp.controller.validator.ApplicationFormValidator;
import tr.org.lkd.lyk2015.camp.model.Course;
import tr.org.lkd.lyk2015.camp.model.dto.ApplicationFormDto;
import tr.org.lkd.lyk2015.camp.service.ApplicationService;
import tr.org.lkd.lyk2015.camp.service.CourseService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ApplicationFormValidator applicationFormValidator;

    @Autowired
    private ApplicationService applicationService;

    @InitBinder
    protected void InitBinder(final WebDataBinder binder) {
        binder.addValidators(this.applicationFormValidator);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getForm(@ModelAttribute ApplicationFormDto applicationFormDto, Model model) {

        List<Course> courses = courseService.getAll();
        model.addAttribute("courses", courses);

        return "applicationForm";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAdminCreate(@ModelAttribute @Valid ApplicationFormDto applicationFormDto,
                                  BindingResult bindingResult, Model model) {

        model.addAttribute("courses", this.courseService.getAll());
        if (bindingResult.hasErrors()) {
            model.addAttribute("courses", courseService.getAll());
            return "applicationForm";
        } else {
            applicationService.create(applicationFormDto);
            return "applicationSuccess";

        }
    }

    @RequestMapping(value = "/validate/{uuid}", method = RequestMethod.GET)
    public String validateUuid(@PathVariable("uuid") String uuid, Model model) {

        if (applicationService.validate(uuid)) {
            model.addAttribute("message", "Email onayiniz yapildi.");
            return "validated";
        } else {
            model.addAttribute("message", "Basvuru bulunamadi");
            return "validated";
        }
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String getApplicationList(@ModelAttribute ){
//
//    }

}
