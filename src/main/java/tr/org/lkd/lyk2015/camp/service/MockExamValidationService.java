package tr.org.lkd.lyk2015.camp.service;

import org.springframework.stereotype.Service;


@Service
public class MockExamValidationService implements ExamValidationService {

    @Override
    public boolean validate(String email, Long tckn) {
        if (email.equals("aa@gmail.com")) {
            return false;
        }
        return true;
    }
}
