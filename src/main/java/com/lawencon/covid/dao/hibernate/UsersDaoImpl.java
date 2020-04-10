package com.lawencon.covid.dao.hibernate;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.covid.dao.UsersDao;
import com.lawencon.covid.model.Users;

@Repository
public class UsersDaoImpl extends BaseHibernate implements UsersDao {

	@Override
	public Users cekUsers(String username, String password) throws Exception {
		Query q = em.createQuery("from Users where username = :username and password = :password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (Users) q.getResultList();
	}

	@Override
	public void addUser(Users user) throws Exception {
		em.persist(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUser() throws Exception {
		Query q = em.createQuery("from Users");
		return q.getResultList();
	}

	@Override
	public void updateUser(Users user) throws Exception {
		em.merge(user);
	}

	@Override
	public void deleteUser(Integer id) throws Exception {
		Query q = em.createQuery("from Users where idUser = :id");
		q.setParameter("id", id);
		Users u = new Users();
		u = (Users) q.getSingleResult();
		em.remove(u);
	}
}
