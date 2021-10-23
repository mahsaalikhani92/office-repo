package ir.maktab.service;

import ir.maktab.model.Employee;
import ir.maktab.repository.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService() throws SQLException, ClassNotFoundException {
        employeeDao = new EmployeeDao();
    }

    public List<Employee> getAllFiveLastYears() {
        List<Employee> employeeList = employeeDao.findAllFiveLastYears();
        return employeeList;
    }
}
