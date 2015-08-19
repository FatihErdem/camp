package tr.org.lkd.lyk2015.camp.service;

import org.springframework.stereotype.Service;

@Service
public class MockEmailValidationService implements EmailService{

    @Override
    public boolean sendEmail(String to, String subject, String content) {
        if (to.equals("b@gmail.com")) {
            return false;
        } else {
            return true;
        }
    }
}
