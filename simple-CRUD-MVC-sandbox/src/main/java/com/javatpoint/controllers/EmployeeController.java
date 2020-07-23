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
import com.javatpoint.dao.EmployeeDao;  
@Controller  
public class EmployeeController {  
    @Autowired  
    EmployeeDao dao;//will inject dao from xml file  
 
    @RequestMapping("/employeeform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Employee());
    	return "employeeform"; 
    }  

    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("employee") Employee emp){  
        dao.save(emp);  
        return "redirect:/viewemployee";//will redirect to viewemp request mapping  
    }  

    @RequestMapping("/viewemployee")  
    public String viewemp(Model m){  
        List<Employee> list=dao.getEmployees();  
        m.addAttribute("list",list);
        return "viewemployee";  
    }  
  
    @RequestMapping(value="/editemployee/{id}")  
    public String edit(@PathVariable int id, Model m){  
    	System.out.println(id);
    	Employee emp=dao.getEmployeeById(id);  
    	System.out.println(emp);
        m.addAttribute("command",emp);
        return "employeeeditform";  
    }  
 
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Employee emp){  
        dao.update(emp);  
        return "redirect:/viewemployee";  
    }  

    @RequestMapping(value="/deleteemployee/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewemployee";  
    }   
}  