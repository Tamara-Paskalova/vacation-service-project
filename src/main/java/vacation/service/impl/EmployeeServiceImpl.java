package vacation.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import vacation.dao.EmployeeDao;
import vacation.model.Employee;
import vacation.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee get(Long id) {
        return employeeDao.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(Long id) {
        return employeeDao.delete(id);
    }

    @Override
    public Employee add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public Employee getByNames(String name, String lastName) {
        return employeeDao.getByNames(name, lastName);
    }
}
