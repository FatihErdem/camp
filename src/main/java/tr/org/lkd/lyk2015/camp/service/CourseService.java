package tr.org.lkd.lyk2015.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import tr.org.lkd.lyk2015.camp.dao.CourseDao;
import tr.org.lkd.lyk2015.camp.model.Course;

public class CourseService extends GenericService<Course> {

    @Autowired
    private CourseDao courseDao;
}
