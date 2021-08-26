package vacation.dao;

import java.util.List;
import vacation.model.Vacation;

public interface VacationDao extends GenericDao<Vacation> {
    Vacation get(Long id);

    List<Vacation> getAll();

    boolean delete(Long id);

    List<Vacation> getByEmployee(String name, String lastName);
}
