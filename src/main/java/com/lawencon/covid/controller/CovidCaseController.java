package com.lawencon.covid.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.covid.model.CovidCase;
import com.lawencon.covid.service.CovidCaseService;

@RestController
public class CovidCaseController extends BaseController<CovidCase>{
	
	@Autowired
	CovidCaseService covidCaseService;
	
	CovidCase covidCase = new CovidCase();
	List<CovidCase> listCovidCase = new ArrayList<CovidCase>();
	
	@PostMapping("/covidcase")
	public ResponseEntity<String> insert(@RequestBody String content) throws Exception {
		try {
			covidCase = super.readValue(content, CovidCase.class);
			return new ResponseEntity<>(covidCaseService.addCase(covidCase), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Customer",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("/covidcase")
	public ResponseEntity<String> ubah(@RequestBody String content) throws Exception {
		try {
			covidCase = super.readValue(content, CovidCase.class);
			return new ResponseEntity<>(covidCaseService.updateCase(covidCase), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Customer",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/covidcase")
	public ResponseEntity<List<CovidCase>> get(){
		try {
			listCovidCase = covidCaseService.getCase();
			return new ResponseEntity<List<CovidCase>>(listCovidCase, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<List<CovidCase>>(listCovidCase, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/covidcase/{id}")
	public ResponseEntity<String> hapus(@PathVariable("id") Integer id) throws Exception {
		try {
			return new ResponseEntity<>(covidCaseService.deleteCase(id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Hapus Kasus",HttpStatus.BAD_GATEWAY);
		}
	}
	
}
