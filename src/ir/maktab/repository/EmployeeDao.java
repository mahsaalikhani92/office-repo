package ir.maktab.repository;

import com.mysql.cj.protocol.Resultset;
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

    public List<Employee> findAllFiveLastYears() throws SQLException {
        Statement statement = connection.createStatement();
        String sqlQuery = "select employee.*, person.f_name, person.l_name" +
                "from person " +
                "inner join employee" +
                "on employee.person_id = person.id" +
                "where employee.hired_date < '1400-01-01' and employee.hired_date >= '1395-01-01'";
        ResultSet resultset = statement.executeQuery(sqlQuery);
        List<Employee> employeeList = new ArrayList<>();
        while (resultset.next()){
            Employee employee = new Employee();
            employee.setId(resultset.getInt("id"));
            employee.setFirstName(resultset.getString("f_name"));
            employee.setLastName(resultset.getString("l_name"));
            employee.setPersonalCode(resultset.getString("personal_code"));
            employee.setSalary(resultset.getInt("salary"));
            employee.setHiredDate(resultset.getDate("hired_date"));
            employee.setPersonId(resultset.getInt("person_id"));
            employeeList.add(employee);
        }
        return employeeList;
    }
}
