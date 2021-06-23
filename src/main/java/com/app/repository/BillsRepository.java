package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills, Integer> {

	@Query(value="SELECT students.id, students.name, sum(bills.amount)\r\n" + 
			"FROM students \r\n" + 
			"INNER JOIN bills ON students.id=bills.student_id\r\n" + 
			"group by bills.Student_Id", nativeQuery=true)
	List<Object> matchBills();
	
	

}
