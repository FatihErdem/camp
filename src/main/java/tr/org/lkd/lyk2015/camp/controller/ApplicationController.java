package tr.org.lkd.lyk2015.camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.org.lkd.lyk2015.camp.model.Course;
import tr.org.lkd.lyk2015.camp.model.dto.ApplicationFormDto;
import tr.org.lkd.lyk2015.camp.service.CourseService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getForm(@ModelAttribute ApplicationFormDto applicationFormDto, Model model){

        List<Course> courses = courseService.getAll();
        model.addAttribute("courses", courses);

        return "applicationForm";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postForm(@ModelAttribute @Valid ApplicationFormDto applicationFormDto, BindingResult bindingResult){


        return null;
    }
}
