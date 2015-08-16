package tr.org.lkd.lyk2015.camp.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.org.lkd.lyk2015.camp.model.Instructor;

import java.util.List;

@Repository
public class InstructorDao {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public Long create(final Instructor instructor){

        final Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(instructor);
    }

    @SuppressWarnings("unchecked")
    public List<Instructor> getAll(){

        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(Instructor.class);
        criteria.add(Restrictions.eq("deleted", false));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setFetchMode("*", FetchMode.JOIN);

        return criteria.list();
    }

}
