package com.app.service;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

	public List<Bills> getAll() {
		return repository.findAll();
	}


	public List<MatchBillResponse> matchBills() {	
		List<MatchBillResponse> matches= new ArrayList<MatchBillResponse>();
		List<Object> matchBills = repository.matchBills();
		for (Object object : matchBills) {
			MatchBillResponse match= new MatchBillResponse();
			List<String> stringList = ItemFilterUtils.convertObjectToList(object);
			match.setId(stringList.get(0));
			match.setName(stringList.get(1));
			match.setAmount(stringList.get(2));
			match.setBillId(stringList.get(3));
			match.setBillStudentId(stringList.get(4));
			match.setBillAmount(stringList.get(5));
			matches.add(match);			
		}
		addStatus(matches);
		for(MatchBillResponse m:matches) {
			System.out.println(m);
		}
		return matches;
	}


	private void addStatus(List<MatchBillResponse> matches) {
		Map<String, List<MatchBillResponse>> collect = matches.stream().collect(Collectors.groupingBy(MatchBillResponse::getBillStudentId));
	 	for (Map.Entry<String, List<MatchBillResponse>> map : collect.entrySet()) {
				int totalPaid=0;
				for(MatchBillResponse match: map.getValue()) {
					if(!match.getBillId().equalsIgnoreCase("null") && match.getBillAmount() != null && !match.getBillAmount().equals("null")&& !match.getAmount().equalsIgnoreCase("null") && !match.getId().equalsIgnoreCase("null")) 
					{
					totalPaid= totalPaid + Integer.parseInt(match.getBillAmount());
					if(totalPaid== Integer.parseInt(match.getAmount())) {
						match.setStatus("yes");
					}else {
					match.setStatus("No");
					}
						
					}else {
						match.setStatus("No");
					}

				}
	        }
		
	}

}
