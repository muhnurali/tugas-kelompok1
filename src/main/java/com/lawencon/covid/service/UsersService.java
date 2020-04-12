package com.lawencon.covid.service;

import java.util.List;

import com.lawencon.covid.model.Users;

public interface UsersService {
	abstract Users cekUsers(Users user) throws Exception;
	abstract String addUser(Users user) throws Exception;
	abstract List<Users> getUser() throws Exception;
	abstract String updateUser(Users user) throws Exception;
	abstract String deleteUser(Integer id) throws Exception;
}
