package vacation.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import vacation.dao.VacationDao;
import vacation.model.Vacation;
import vacation.service.VacationService;

@Service
public class VacationServiceImpl implements VacationService {
    private final VacationDao vacationDao;

    public VacationServiceImpl(VacationDao vacationDao) {
        this.vacationDao = vacationDao;
    }

    @Override
    public Vacation get(Long id) {
        return vacationDao.get(id);
    }

    @Override
    public List<Vacation> getAll() {
        return vacationDao.getAll();
    }

    @Override
    public Vacation update(Vacation vacation) {
        return vacationDao.update(vacation);
    }

    @Override
    public boolean delete(Long id) {
        return vacationDao.delete(id);
    }

    @Override
    public Vacation add(Vacation vacation) {
        return vacationDao.add(vacation);
    }

    @Override
    public List<Vacation> getByEmployee(String name, String lastName) {
        return vacationDao.getByEmployee(name, lastName);
    }
}
