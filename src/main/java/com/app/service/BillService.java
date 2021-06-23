package com.app.service;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Bills;
import com.app.model.MatchBillResponse;
import com.app.repository.BillsRepository;
import com.app.utils.ItemFilterUtils;

@Service
public class BillService {

	@Autowired
	BillsRepository repository;

	public Bills getBills(Integer id) {
		Optional<Bills> bill = repository.findById(id);
		return bill.get();
	}


	public List<Bills> getAll() {
		return repository.findAll();
	}


	public List<MatchBillResponse> matchBills() {	
		List<MatchBillResponse> matches= new ArrayList<MatchBillResponse>();
		List<Object> matchBills = repository.matchBills();
		for (Object object : matchBills) {
			MatchBillResponse match= new MatchBillResponse();
			List<String> stringList = ItemFilterUtils.convertObjectToList(object);
			match.setId((Integer.parseInt(stringList.get(0))));
			match.setName(stringList.get(1));
			match.setAmount((Double.parseDouble(stringList.get(2))));
			matches.add(match);			
		}
		return matches;
	}

}
