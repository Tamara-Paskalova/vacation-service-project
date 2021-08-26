package vacation.service;

import java.util.List;
import vacation.model.Employee;

public interface EmployeeService {
    Employee get(Long id);

    List<Employee> getAll();

    Employee update(Employee employee);

    boolean delete(Long id);

    Employee add(Employee employee);

    Employee getByNames(String name, String lastName);
}
