package com.lawencon.covid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.covid.model.Users;
import com.lawencon.covid.service.UsersService;

@RestController
@CrossOrigin("*")
public class UsersController extends BaseController<Users>{

	@Autowired
	UsersService userService;
	
	Users user = new Users();
	List<Users> listUsers = new ArrayList<>();
	
	@PostMapping("/user")
	public ResponseEntity<String> insert(@RequestBody String content) throws Exception {
		try {
			user = super.readValue(content, Users.class);
			return new ResponseEntity<>(userService.addUser(user), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Pengguna, " + e.getMessage(),HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<String> ubah(@RequestBody String content) throws Exception {
		try {
			user = super.readValue(content, Users.class);
			return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Ubah Pengguna",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Users>> get(){
		try {
			listUsers = userService.getUser();
			return new ResponseEntity<List<Users>>(listUsers, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<List<Users>>(listUsers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<Users> login(@RequestBody String content) throws Exception {
		Users users = new Users();
		try {
			user =  super.readValue(content, Users.class);
			users = userService.cekUsers(user);
			return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> hapus(@PathVariable("id") Integer id) throws Exception {
		try {
			return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Pengguna",HttpStatus.BAD_GATEWAY);
		}
	
}
}