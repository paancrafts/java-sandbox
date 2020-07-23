package com.javatpoint.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.beans.Employee;
import com.javatpoint.beans.Qualification;
import com.javatpoint.dao.EmployeeDao;
import com.javatpoint.dao.QualificationDao;  
@Controller 
@RequestMapping("qualification")
public class QualificationController {  
    @Autowired  
    QualificationDao dao;//will inject dao from xml file  
    
    @Autowired
    EmployeeDao employeeDao;
 
    @RequestMapping("/qualificationform/{id}")  
    public String showform(@PathVariable int id, Model m){  
    	Employee emp=employeeDao.getEmployeeById(id); 
    	m.addAttribute("command", new Qualification());
    	m.addAttribute("emp", emp);
    	return "qualificationform"; 
    }  

    @RequestMapping(value="/qualificationform/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Qualification emp){  
        dao.save(emp);  
        return "redirect:/qualification/viewqualification/" + emp.getEmployeeId();//will redirect to viewemp request mapping  
    }  

    @RequestMapping("/viewqualification/{id}")  
    public String viewemp(@PathVariable int id, Model m){  
        List<Qualification> list=dao.getEmpQualifications(id);  
        m.addAttribute("list",list);
        
        Employee emp=employeeDao.getEmployeeById(id);
        m.addAttribute("emp", emp);
        return "viewqualification";  
    }  
  
    @RequestMapping(value="/editqualification/{id}")  
    public String edit(@PathVariable int id, Model m){  
    	Employee emp=employeeDao.getEmployeeById(id); 
        Qualification qual=dao.getQualificationById(id);  
        m.addAttribute("command",qual);
        m.addAttribute("emp", emp);
        return "qualificationeditform";  
    }  
 
//    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
//    public String editsave(@ModelAttribute("emp") Qualification emp){  
//        dao.update(emp);  
//        return "redirect:/viewemp";  
//    }  

    @RequestMapping(value="/deletequalification/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
    	Qualification qual=dao.getQualificationById(id);  
        int empId = qual.getEmployeeId();
        dao.delete(id);
        return "redirect:/qualification/viewqualification/" + empId;  
    }   
}  