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
	UsersDao usersDao;
	
	@Override
	public Users cekUsers(Users user) throws Exception {
		return usersDao.cekUsers(user);
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
