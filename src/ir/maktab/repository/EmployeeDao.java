package ir.maktab.repository;

import ir.maktab.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public class EmployeeDao extends BaseDao{
    private final Connection connection;

    public EmployeeDao() throws SQLException, ClassNotFoundException {
        connection = getConnection();
    }

    public List<Employee> findAllFiveLastYears(int currentYear) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlQuery = "select employee.*, person.f_name, person.l_name" +
                " from person " +
                "inner join employee" +
                " on employee.person_id = person.id" +
                " where employee.hired_year <= '"+currentYear+"' and employee.hired_year >= '"+(currentYear-5)+"'";
        ResultSet resultset = statement.executeQuery(sqlQuery);
        List<Employee> employeeList = new ArrayList<>();
        while (resultset.next()){
            Employee employee = new Employee();
            employee.setId(resultset.getInt("id"));
            employee.setFirstName(resultset.getString("f_name"));
            employee.setLastName(resultset.getString("l_name"));
            employee.setPersonalCode(resultset.getString("personal_code"));
            employee.setSalary(resultset.getInt("salary"));
            employee.setHiredYear(resultset.getInt("hired_year"));
            employee.setPersonId(resultset.getInt("person_id"));
            employeeList.add(employee);
        }
        return employeeList;
    }

}
