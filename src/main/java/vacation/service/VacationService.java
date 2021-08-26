package vacation.service;

import java.util.List;
import vacation.model.Vacation;

public interface VacationService {
    Vacation get(Long id);

    List<Vacation> getAll();

    Vacation update(Vacation vacation);

    boolean delete(Long id);

    Vacation add(Vacation vacation);

    List<Vacation> getByEmployee(String name, String lastName);
}
