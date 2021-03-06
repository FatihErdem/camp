package tr.org.lkd.lyk2015.camp.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tr.org.lkd.lyk2015.camp.model.Application;
import tr.org.lkd.lyk2015.camp.model.Student;
import tr.org.lkd.lyk2015.camp.model.dto.ApplicationFormDto;
import tr.org.lkd.lyk2015.camp.service.BlackListValidationService;
import tr.org.lkd.lyk2015.camp.service.EmailService;
import tr.org.lkd.lyk2015.camp.service.ExamValidationService;
import tr.org.lkd.lyk2015.camp.service.TcknValidationService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Component
public class ApplicationFormValidator implements Validator {

    @Autowired
    TcknValidationService tcknValidationService;

    @Autowired
    BlackListValidationService blackListValidationService;

    @Autowired
    ExamValidationService examValidationService;

    @Autowired
    private EmailService emailService;


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(ApplicationFormDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ApplicationFormDto applicationFormDto = (ApplicationFormDto) o;

        if (applicationFormDto.getApplication().getWorkStatus()==Application.WorkStatus.NOT_WORKING&&
                applicationFormDto.getApplication().isOfficer()==true) {
            errors.rejectValue("workStatus", "error.notWorkingOfficer", "Hem calismayip hem de memurum diyosun");
        }

        applicationFormDto.getPreferredCourseIds().removeAll(Collections.singleton(null));

        if (applicationFormDto.getPreferredCourseIds().size()==0) {
            errors.rejectValue("preferredCourseIds", "error.preferredCourseNoSelection", "En az bir kurs secmelisiniz");

        }

        int listSize = applicationFormDto.getPreferredCourseIds().size();
        Set<Long> set = new HashSet<>(applicationFormDto.getPreferredCourseIds());
        int setSize = set.size();

        if (listSize!=setSize) {
            errors.rejectValue("preferredCourseIds", "error.preferredCourseSame", "Birden fazla ayni dersi secemezsin");

        }

        Student student = applicationFormDto.getStudent();

        boolean tcknValid = tcknValidationService.validate(student.getName(),
                student.getSurname(), student.getBirthDate(), student.getTckn());

        if (!tcknValid) {
            errors.rejectValue("student.tckn", "error.tcknInvalid", "TC Kimlik Numarasi Hatali");
        }

        boolean blackListValid = blackListValidationService.validate(student.getName(),
                student.getSurname(), student.getTckn(), student.getEmail());
        if (!blackListValid) {
            errors.rejectValue("student.tckn", "error.blackList", "Kara Listedesiniz. Yuru git lan");
        }

        boolean examValid = examValidationService.validate(student.getEmail(), student.getTckn());
        if (!examValid) {
            errors.rejectValue("student.email", "error.examFail", "Sinavi gecemediniz");
        }

        boolean sendMail = emailService.sendEmail(student.getEmail(), "confirmation", "buraya t�kla");
        if (!sendMail) {
            errors.rejectValue("student.email", "error.checkConfirmation", "Email G�nderilemedi!");
        }
    }
}
