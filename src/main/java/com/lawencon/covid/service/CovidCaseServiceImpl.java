package com.lawencon.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.covid.dao.CovidCaseDao;
import com.lawencon.covid.model.CovidCase;

@Transactional
@Service
public class CovidCaseServiceImpl implements CovidCaseService {

	@Autowired
	CovidCaseDao covidCaseDao;
	
	@Override
	public String addCase(CovidCase covidCase) throws Exception {
		covidCaseDao.addCase(covidCase);
		return "Berhasil Tambah Kasus";
	}

	@Override
	public List<CovidCase> getCase() throws Exception {
		return covidCaseDao.getCase();
	}

	@Override
	public String updateCase(CovidCase covidCase) throws Exception {
		covidCaseDao.updateCase(covidCase);
		return "Berhasil Ubah Kasus";
	}

	@Override
	public String deleteCase(Integer id) throws Exception {
		covidCaseDao.deleteCase(id);
		return "Berhasil Hapus Kasus";
	}
}
