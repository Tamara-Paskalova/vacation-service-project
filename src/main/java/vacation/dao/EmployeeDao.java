package vacation.dao;

import java.util.List;
import vacation.model.Employee;

public interface EmployeeDao extends GenericDao<Employee> {
    Employee get(Long id);

    List<Employee> getAll();

    boolean delete(Long id);

    Employee getByNames(String name, String lastName);
}
