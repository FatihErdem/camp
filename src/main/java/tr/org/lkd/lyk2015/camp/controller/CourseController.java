package tr.org.lkd.lyk2015.camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.org.lkd.lyk2015.camp.model.Course;
import tr.org.lkd.lyk2015.camp.service.CourseService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    public CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCourseList(Model model) {

        List<Course> courses = courseService.getAll();
        model.addAttribute("courseList", courses);

        return "admin/listCourse";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCourseCreate(@ModelAttribute Course course) {

        return "admin/createCourseForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCourseCreate(@ModelAttribute @Valid Course course,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "admin/createCourseForm";
        }

        courseService.create(course);

        return "redirect:/courses";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getCourseUpdate(@PathVariable(value = "id") Long id, Model model) {

        Course course = courseService.getById(id);
        model.addAttribute("course", course);

        return "admin/updateCourseForm";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String postCourseUpdate(@PathVariable("id") Long id, @ModelAttribute Course course, Model model) {

        courseService.update(course);
        return "redirect:/courses";
    }
}
