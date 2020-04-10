package com.lawencon.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.covid.dao.UsersDao;
import com.lawencon.covid.model.Users;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	@Qualifier
	UsersDao usersDao;
	
	@Override
	public void cekUsers(String username, String password) throws Exception {
		Users u = usersDao.cekUsers(username, password);
		if (!u.getUsername().equals(username) && !u.getPassword().equals(password)) {
			throw new Exception();
		}	
	}

	@Override
	public String addUser(Users user) throws Exception {
		usersDao.addUser(user);
		return "Berhasil Tambah Pengguna";
	}

	@Override
	public List<Users> getUser() throws Exception {
		return usersDao.getUser();
	}

	@Override
	public String updateUser(Users user) throws Exception {
		usersDao.updateUser(user);
		return "Berhasil Ubah Pengguna";
	}

	@Override
	public String deleteUser(Integer id) throws Exception {
		usersDao.deleteUser(id);
		return "Berhasil Hapus Pengguna";
	}

}
