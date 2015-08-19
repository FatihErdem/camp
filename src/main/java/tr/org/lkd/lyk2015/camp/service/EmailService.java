package tr.org.lkd.lyk2015.camp.service;

import org.springframework.stereotype.Service;


public interface EmailService {

    public abstract boolean sendEmail(String to, String subject, String content);
}
