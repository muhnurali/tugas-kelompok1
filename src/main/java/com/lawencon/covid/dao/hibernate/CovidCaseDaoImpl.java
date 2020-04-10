package com.lawencon.covid.dao.hibernate;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.covid.dao.CovidCaseDao;
import com.lawencon.covid.model.CovidCase;

@Repository
public class CovidCaseDaoImpl extends BaseHibernate implements CovidCaseDao {

	@Override
	public void addCase(CovidCase covidCase) throws Exception {
		em.persist(covidCase);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CovidCase> getCase() throws Exception {
		Query q = em.createQuery(" from CovidCase");
		return q.getResultList();
	}

	@Override
	public void updateCase(CovidCase covidCase) throws Exception {
		em.merge(covidCase);
	}

	@Override
	public void deleteCase(Integer id) throws Exception {
		Query q = em.createQuery(" from CovidCase where idCase = :idParam");
		q.setParameter("idParam", id);
		CovidCase temp = new CovidCase();
		temp = (CovidCase) q.getSingleResult();
		em.remove(temp);
	}

}
