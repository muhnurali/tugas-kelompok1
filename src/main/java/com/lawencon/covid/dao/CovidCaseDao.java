package com.lawencon.covid.dao;

import java.util.List;

import com.lawencon.covid.model.CovidCase;

public interface CovidCaseDao {
	abstract void addCase(CovidCase covidCase) throws Exception;
	abstract List<CovidCase> getCase() throws Exception;
	abstract void updateCase(CovidCase covidCase) throws Exception;
	abstract void deleteCase(Integer id) throws Exception;
}