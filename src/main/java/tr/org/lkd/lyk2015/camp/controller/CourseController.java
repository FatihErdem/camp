package tr.org.lkd.lyk2015.camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.org.lkd.lyk2015.camp.model.Course;
import tr.org.lkd.lyk2015.camp.service.CourseService;

import java.util.List;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    public CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCourseList(Model model){

        List<Course> courses = courseService.getAll();
        model.addAttribute("courseList", courses);

        return "admin/listCourse";

    }
}
