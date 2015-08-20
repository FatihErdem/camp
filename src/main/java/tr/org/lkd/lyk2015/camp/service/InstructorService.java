package tr.org.lkd.lyk2015.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tr.org.lkd.lyk2015.camp.dao.CourseDao;
import tr.org.lkd.lyk2015.camp.dao.InstructorDao;
import tr.org.lkd.lyk2015.camp.model.Course;
import tr.org.lkd.lyk2015.camp.model.Instructor;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class InstructorService extends GenericService<Instructor> {

    @Autowired
    private InstructorDao instructorDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void create(Instructor instructor, List<Long> ids) {

        List<Course> courses = courseDao.getByIds(ids);
        instructor.getCourses().addAll(courses);

        instructorDao.create(instructor);
    }

    public Instructor getInstructorWithCourses(Long id) {

        Instructor instructor = instructorDao.getByIdWithCourses(id);

        return instructor;
    }

    @Override
    public Long create(Instructor instructor) {
        instructor.setPassword(passwordEncoder.encode(instructor.getPassword()));
        return super.create(instructor);
    }
}