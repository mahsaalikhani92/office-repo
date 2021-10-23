package ir.maktab;

import ir.maktab.model.Employee;
import ir.maktab.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

/**
 * @author Mahsa Alikhani m-58
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        employeeService = new EmployeeService();
        int choiceNumber;
        do {
            System.out.println("***Management Menu***");
            System.out.println("1. Employee salary reports\n2. Exit");
            String choice;
            do {
                choice = scanner.next();
            } while (!choice.matches("[1-9]+"));
            choiceNumber = Integer.parseInt(choice);
            switch (choiceNumber) {
                case 1:
                    viewEmployeeSalaryReport();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid value!");
            }
        } while (choiceNumber != 2);
    }

    private static void viewEmployeeSalaryReport() {
        List<Employee> employee = employeeService.getAll();
    }
}
