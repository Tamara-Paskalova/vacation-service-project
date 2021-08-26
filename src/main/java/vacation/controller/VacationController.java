package vacation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vacation.model.Employee;
import vacation.model.Vacation;
import vacation.service.EmployeeService;
import vacation.service.VacationService;

@Controller
public class VacationController {
    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final VacationService vacationService;
    private final EmployeeService employeeService;

    public VacationController(VacationService vacationService, EmployeeService employeeService) {
        this.vacationService = vacationService;
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/vacation", method = RequestMethod.GET)
    public String showPage() {
        return "vacations/vacation";
    }

    @RequestMapping(value = "/vacation", method = RequestMethod.POST)
    public String addVacation(@RequestParam String firstDay, @RequestParam String lastDay,
                               @RequestParam String name, @RequestParam String lastName) {
        LocalDate start = LocalDate.parse(firstDay, PATTERN);
        LocalDate end = LocalDate.parse(lastDay, PATTERN);
        Employee employee = employeeService.getByNames(name, lastName);
        vacationService.add(new Vacation(start, end, employee));
        return "vacations/vacation";
    }

    @RequestMapping(value = "vacation/all", method = RequestMethod.GET)
    public String getAllVacations(Model model) {
        List<Vacation> vacations = vacationService.getAll();
        model.addAttribute("vacations", vacations);
        return "vacations/all";
    }

    @RequestMapping(value = "vacation/delete", method = RequestMethod.GET)
    public String deleteVacation(@RequestParam Long id, Model model) {
        vacationService.delete(id);
        List<Vacation> vacations = vacationService.getAll();
        model.addAttribute("vacations", vacations);
        return "vacations/all";
    }

    @RequestMapping(value = "vacation/by_employee", method = RequestMethod.GET)
    public String getByEmployee(Model model, @RequestParam String name,
                                @RequestParam String lastName) {
        List<Vacation> vacations = vacationService.getByEmployee(name, lastName);
        model.addAttribute("vacations", vacations);
        return "vacations/all";
    }
}
