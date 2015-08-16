package tr.org.lkd.lyk2015.camp.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import tr.org.lkd.lyk2015.camp.model.Course;

import java.util.List;

@Repository
public class CourseDao extends GenericDao<Course> {

    @Override
    public List<Course> getAll() {

        final Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(type);
        criteria.add(Restrictions.eq("active", true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.setFetchMode("*", FetchMode.JOIN);

        return criteria.list();
    }
}
