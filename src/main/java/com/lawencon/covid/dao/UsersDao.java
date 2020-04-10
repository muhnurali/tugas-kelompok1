package com.lawencon.covid.dao;

import java.util.List;
import com.lawencon.covid.model.Users;

public interface UsersDao {
	abstract Users cekUsers(String username, String password) throws Exception;
	abstract void addUser(Users user) throws Exception;
	abstract List<Users> getUser() throws Exception;
	abstract void updateUser(Users user) throws Exception;
	abstract void deleteUser(Integer id) throws Exception;
}
