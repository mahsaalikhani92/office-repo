package ir.maktab;

import ir.maktab.model.Employee;
import ir.maktab.service.EmployeeService;

import java.sql.SQLException;
import java.util.*;

/**
 * @author Mahsa Alikhani m-58
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        employeeService = new EmployeeService();
        int choiceNumber;
        do {
            System.out.println("***Management Menu***");
            System.out.println("1. Employee information for the last five years\n2. Exit");
            String choice;
            do {
                choice = scanner.next();
            } while (!choice.matches("[1-9]+"));
            choiceNumber = Integer.parseInt(choice);
            switch (choiceNumber) {
                case 1:
                    viewEmployeeInfoLastFiveYears();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid value!");
            }
        } while (choiceNumber != 2);
    }

    private static void viewEmployeeInfoLastFiveYears() throws SQLException {
        List<Employee> employeeList = employeeService.getAllFiveLastYears();
        for (Employee item: employeeList) {

        }
    }

    private static void printRowTable(){
        Set<Integer> rowSet = new HashSet<>();
        Collections.addAll(rowSet, 1, 2, 3, 4, 5);
    }
}
