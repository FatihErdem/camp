package tr.org.lkd.lyk2015.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.org.lkd.lyk2015.camp.model.Application;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@Service
public class ApplicationService extends GenericService<Application> {

    @Autowired
    EmailService emailService;

}
