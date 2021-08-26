package vacation.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vacation.model.Employee;
import vacation.service.EmployeeService;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String showPage() {
        return "employees/employee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    String addEmployee(@RequestParam String name, @RequestParam String lastName) {
        employeeService.add(new Employee(name, lastName));
        return "employees/employee";
    }

    @RequestMapping(value = "/employee/delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam Long id, Model model) {
        employeeService.delete(id);
        List<Employee> employeeList = employeeService.getAll();
        model.addAttribute("employees", employeeList);
        return "employees/all";
    }

    @RequestMapping(value = "/employee/all", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        model.addAttribute("employees", employeeList);
        return "employees/all";
    }
}
