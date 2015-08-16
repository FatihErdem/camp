package tr.org.lkd.lyk2015.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.org.lkd.lyk2015.camp.dao.InstructorDao;
import tr.org.lkd.lyk2015.camp.model.Instructor;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Service
public class InstructorService extends GenericService<Instructor> {

    @Autowired
    private InstructorDao instructorDao;
}