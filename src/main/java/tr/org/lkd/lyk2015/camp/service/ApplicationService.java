package tr.org.lkd.lyk2015.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.org.lkd.lyk2015.camp.dao.ApplicationDao;
import tr.org.lkd.lyk2015.camp.dao.CourseDao;
import tr.org.lkd.lyk2015.camp.dao.StudentDao;
import tr.org.lkd.lyk2015.camp.model.Application;
import tr.org.lkd.lyk2015.camp.model.Course;
import tr.org.lkd.lyk2015.camp.model.Student;
import tr.org.lkd.lyk2015.camp.model.dto.ApplicationFormDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ApplicationService extends GenericService<Application> {

    private static final String URL_BASE = "http://localhost:8080/application/validate/";

    @Autowired
    EmailService emailService;

    @Autowired
    CourseDao courseDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    ApplicationDao applicationDao;

    public void create(ApplicationFormDto applicationFormDto) {

        Application application = applicationFormDto.getApplication();
        Student student = applicationFormDto.getStudent();
        List<Long> courseIds = applicationFormDto.getPreferredCourseIds();

        // Generate email verification url
        String uuid = UUID.randomUUID().toString();
        String url = URL_BASE+uuid;

        emailService.sendEmail(student.getEmail(), "LYK Basvuru Onayi", url);

        application.setUuid(uuid);

        //Add preferred courses to Application entity
        List<Course> courses = courseDao.getByIds(courseIds);
        application.getPreferredCourses().addAll(courses);

        // Check if user exists
        Student studentFromDb = studentDao.getUserByTckn(student.getTckn());
        if(studentFromDb == null){
            studentDao.create(student);
            studentFromDb = student;
        }
        // Set application's user
        application.setOwner(studentFromDb);

        applicationDao.create(application);
    }
}
