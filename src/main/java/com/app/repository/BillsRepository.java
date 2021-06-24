package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills, Integer> {

	@Query(value="SELECT  s.id,s.name,s.amount,b.billid,b.student_id,b.billamount from students s \n" + 
			"LEFT JOIN bills b ON s.id = b.Student_Id\n" + 
			"UNION\n" + 
			"SELECT s1.id,s1.name,s1.amount,b1.billid,b1.student_id,b1.billamount FROM students s1 \n" + 
			"RIGHT JOIN bills b1 ON s1.id = b1.Student_Id", nativeQuery=true)
	List<Object> matchBills();
	
	

}
