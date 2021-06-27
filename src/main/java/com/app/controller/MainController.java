package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Bills;
import com.app.model.Employee;
import com.app.model.MatchBillResponse;
import com.app.model.Students;
import com.app.service.BillService;
import com.app.service.EmployeeService;
import com.app.service.ExcelService;
import com.app.service.StudentService;


/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@Controller
public class MainController {

	@Autowired
	EmployeeService empService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	ExcelService excelService;
	
	@GetMapping("/")
    public String getForm() {

		return "employeeFrom";
    	
    }
    
    @GetMapping("validate")
    public String validate(@ModelAttribute("employee") Employee emp) {
    	Employee employee = empService.findByNameAndPassword(emp.getName(), emp.getPassword());
    	if(employee != null) {
    		System.out.println("Validated");
    		return "redirect:/list";
    		}
    	else
    		return "error";    	
    }
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		System.out.println("in list");
		List<Students> studentList = studentService.getAll();
		theModel.addAttribute("students", studentList);
		return "list-students";
	}
	
	@GetMapping("/listBills")
	public String listBills(Model theModel) {
		System.out.println("in bills list");
		List<Bills> billList = billService.getAll();
		System.out.println("bills"+billList);
		theModel.addAttribute("bills", billList);
		return "list-bills";
	}
	
	@GetMapping("/matchBills")
	public String matchBills(Model theModel) {
		System.out.println("in match list");
		List<MatchBillResponse> matchBills = billService.matchBills();
		theModel.addAttribute("matches", matchBills);
		return "match-bills";
	}
	
	@GetMapping("/download")
	public String download(Model theModel) {
		List<MatchBillResponse> matchBills = billService.matchBills();	
		excelService.createExcel(matchBills);
        theModel.addAttribute("matches", matchBills);        
		return "match-bills";
	}
	
	@GetMapping("/updateStudent")
	public String showFormForUpdate(@RequestParam("id") int id,
									Model theModel) throws Exception {
		Students theStudent= studentService.getStudent(id);	
		theModel.addAttribute("students", theStudent);
		return "list-students";
	}
}
