package vacation.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate firstDay;
    private LocalDate lastDay;
    @ManyToOne
    private Employee employee;

    public Vacation() {
    }

    public Vacation(LocalDate firstDay, LocalDate lastDay, Employee employee) {
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(LocalDate firstDay) {
        this.firstDay = firstDay;
    }

    public LocalDate getLastDay() {
        return lastDay;
    }

    public void setLastDay(LocalDate lastDay) {
        this.lastDay = lastDay;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Vacation vacation = (Vacation) object;
        return Objects.equals(id, vacation.id) && Objects.equals(firstDay, vacation.firstDay)
                && Objects.equals(lastDay, vacation.lastDay)
                && Objects.equals(employee, vacation.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstDay, lastDay, employee);
    }

    @Override
    public String toString() {
        return "Vacation{" + "id=" + id
                + ", firstDay=" + firstDay
                + ", lastDay=" + lastDay
                + ", employee=" + employee
                + '}';
    }
}
