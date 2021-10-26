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
        Set<Integer> hiredYearSet = new HashSet<>();
        List<Integer> salaryList = new ArrayList<>();
        List<String> personalCodeList = new ArrayList<>();
        List<String> fullNameList = new ArrayList<>();
        for (Employee item: employeeList) {
            hiredYearSet.add(item.getHiredYear());
            salaryList.add(item.getSalary());
            personalCodeList.add(item.getPersonalCode());
            fullNameList.add(item.getFirstName() + item.getLastName());
        }
        printRowTable();
        printHiredYear(hiredYearSet);
        printSalaryRange(salaryList);
        printPersonalCode(personalCodeList);
        printFullName(fullNameList);
    }

    private static void printFullName(List<String> fullNameList) {
        for (String fullName: fullNameList) {
            System.out.println(fullName);
        }
    }

    private static void printPersonalCode(List<String> personalCodeList) {
        for (String code: personalCodeList) {
            System.out.println(code);
        }
    }

    private static void printSalaryRange(List<Integer> salaryList) {
        Map<String, List<Integer>> salaryMap = new HashMap<>();
        List<Integer> firstRange = new ArrayList<>();
        List<Integer> secondRange = new ArrayList<>();
        List<Integer> thirdRange = new ArrayList<>();
        for (Integer salary: salaryList) {
            if(salary >= 1000000 && salary < 5000000){
                firstRange.add(salary);
                salaryMap.put("1-5", firstRange);
            }else if(salary >= 6000000 && salary < 10000000){
                secondRange.add(salary);
                salaryMap.put("5-10", secondRange);
            }else if(salary >= 10000000){
                thirdRange.add(salary);
                salaryMap.put("Higher than 10", thirdRange);
            }
        }
    }

    private static void printHiredYear(Set<Integer> hiredYearSet) {
        for (Integer year: hiredYearSet) {
            String yearStr = Integer.toString(year);
            System.out.println(yearStr.substring(2));
        }
    }

    private static void printRowTable(){
        Set<Integer> rowSet = new HashSet<>();
        Collections.addAll(rowSet, 1, 2, 3, 4, 5);
        for (Integer number: rowSet) {
            System.out.println(number);
        }
    }
}
