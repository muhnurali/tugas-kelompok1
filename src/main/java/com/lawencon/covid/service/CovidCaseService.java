package com.lawencon.covid.service;

import java.util.List;

import com.lawencon.covid.model.CovidCase;

public interface CovidCaseService {
	abstract String addCase(CovidCase covidCase) throws Exception;
	abstract List<CovidCase> getCase() throws Exception;
	abstract String updateCase(CovidCase covidCase) throws Exception;
	abstract String deleteCase(Integer id) throws Exception;
}
