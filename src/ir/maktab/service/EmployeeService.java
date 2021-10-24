package ir.maktab.service;

import ir.maktab.model.Employee;
import ir.maktab.repository.EmployeeDao;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * @author Mahsa Alikhani m-58
 */
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService() throws SQLException, ClassNotFoundException {
        employeeDao = new EmployeeDao();
    }

    public List<Employee> getAllFiveLastYears() throws SQLException {
        List<Employee> employeeList = employeeDao.findAllFiveLastYears();

        Comparator<Employee> hiredDateComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int cmpResult = Integer.compare(o1.getHiredYear(), o2.getHiredYear());
                if(cmpResult != 0){
                    return cmpResult * -1;
                }
                return o1.compareTo(o2);
            }
        };
        employeeList.sort(hiredDateComparator);
        return employeeList;
    }
}
