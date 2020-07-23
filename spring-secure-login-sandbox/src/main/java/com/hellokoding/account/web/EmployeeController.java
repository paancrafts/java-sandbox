package com.hellokoding.account.web;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import com.hellokoding.account.model.Employee;
import com.hellokoding.account.service.EmployeeService;  

@Controller  
public class EmployeeController {  
       
    @Autowired
    EmployeeService employeeService;
 
    @RequestMapping("/employeeform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Employee());
    	return "employeeform"; 
    }  

    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("employee") Employee emp){  
    	employeeService.save(emp);  
        return "redirect:/viewemployee";//will redirect to viewemp request mapping  
    }  

    @RequestMapping("/viewemployee")  
    public String viewemp(Model m){  
        List<Employee> list=employeeService.getAllEmployees();  
        m.addAttribute("list",list);
        return "viewemployee";  
    }  
  
    @RequestMapping(value="/editemployee/{id}")  
    public String edit(@PathVariable long id, Model m){  
    	Employee emp=employeeService.findById(id);  
        m.addAttribute("emp",emp);
        return "employeeeditform";  
    }  
 
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("employee") Employee emp){  
    	employeeService.save(emp);  
        return "redirect:/viewemployee";  
    }  

    @RequestMapping(value="/deleteemployee/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable long id){  
    	Employee emp=employeeService.findById(id);
    	employeeService.delete(emp);  
        return "redirect:/viewemployee";  
    }   
}  