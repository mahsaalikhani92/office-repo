package ir.maktab.model;

import java.sql.Date;
import java.util.Comparator;

/**
 * @author Mahsa Alikhani m-58
 */
public class Employee extends Person implements Comparable<Employee> {

    private String personalCode;
    private int salary;
    private Date hiredDate;
    private int personId;

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }


    @Override
    public int compareTo(Employee otherObject) {
        return Integer.compare(this.getSalary(), otherObject.getSalary());
    }
}
