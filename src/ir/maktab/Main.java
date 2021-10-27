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
        System.out.println("Enter the current year like 1400:");
        int currentYear = scanner.nextInt();
        List<Employee> employeeList = employeeService.getAllFiveLastYears(currentYear);

        printReportTable(employeeList, currentYear);
    }

    public static void printReportTable(List<Employee> employeeList, int currentYear) {
        List<Employee> oneLastYearList = new ArrayList<>();
        List<Employee> twoLastYearList = new ArrayList<>();
        List<Employee> threeLastYearList = new ArrayList<>();
        List<Employee> fourLastYearList = new ArrayList<>();
        List<Employee> fiveLastYearList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getHiredYear() == currentYear - 1) {
                oneLastYearList.add(employee);
            } else if (employee.getHiredYear() == currentYear - 2) {
                twoLastYearList.add(employee);
            } else if (employee.getHiredYear() == currentYear - 3) {
                threeLastYearList.add(employee);
            } else if (employee.getHiredYear() == currentYear - 4) {
                fourLastYearList.add(employee);
            } else if (employee.getHiredYear() == currentYear - 5) {
                fiveLastYearList.add(employee);
            }
        }
        List<Employee> oneFiveOneLastYear = new ArrayList<>();
        List<Employee> fiveTenOneLastYear = new ArrayList<>();
        List<Employee> plusTenOneLastYear = new ArrayList<>();
        for (Employee item: oneLastYearList) {
            if(item.getSalary() >= 1000000 && item.getSalary() < 5000000){
                oneFiveOneLastYear.add(item);
            }else if(item.getSalary() >= 5000000 && item.getSalary() < 10000000){
                fiveTenOneLastYear.add(item);
            }else if(item.getSalary() >= 10000000){
                plusTenOneLastYear.add(item);
            }
        }

        List<Employee> oneFiveTwoLastYear = new ArrayList<>();
        List<Employee> fiveTenTwoLastYear = new ArrayList<>();
        List<Employee> plusTenTwoLastYear = new ArrayList<>();
        for (Employee item: twoLastYearList) {
            if(item.getSalary() >= 1000000 && item.getSalary() < 5000000){
                oneFiveTwoLastYear.add(item);
            }else if(item.getSalary() >= 5000000 && item.getSalary() < 10000000){
                fiveTenTwoLastYear.add(item);
            }else if(item.getSalary() >= 10000000){
                plusTenTwoLastYear.add(item);
            }
        }

        List<Employee> oneFiveThreeLastYear = new ArrayList<>();
        List<Employee> fiveTenThreeLastYear = new ArrayList<>();
        List<Employee> plusTenThreeLastYear = new ArrayList<>();
        for (Employee item: threeLastYearList) {
            if(item.getSalary() >= 1000000 && item.getSalary() < 5000000){
                oneFiveThreeLastYear.add(item);
            }else if(item.getSalary() >= 5000000 && item.getSalary() < 10000000){
                fiveTenThreeLastYear.add(item);
            }else if(item.getSalary() >= 10000000){
                plusTenThreeLastYear.add(item);
            }
        }

        List<Employee> oneFiveFourLastYear = new ArrayList<>();
        List<Employee> fiveTenFourLastYear = new ArrayList<>();
        List<Employee> plusTenFourLastYear = new ArrayList<>();
        for (Employee item: fourLastYearList) {
            if(item.getSalary() >= 1000000 && item.getSalary() < 5000000){
                oneFiveFourLastYear.add(item);
            }else if(item.getSalary() >= 5000000 && item.getSalary() < 10000000){
                fiveTenFourLastYear.add(item);
            }else if(item.getSalary() >= 10000000){
                plusTenFourLastYear.add(item);
            }
        }

        List<Employee> oneFiveFiveLastYear = new ArrayList<>();
        List<Employee> fiveTenFiveLastYear = new ArrayList<>();
        List<Employee> plusTenFiveLastYear = new ArrayList<>();
        for (Employee item: fiveLastYearList) {
            if(item.getSalary() >= 1000000 && item.getSalary() < 5000000){
                oneFiveFiveLastYear.add(item);
            }else if(item.getSalary() >= 5000000 && item.getSalary() < 10000000){
                fiveTenFiveLastYear.add(item);
            }else if(item.getSalary() >= 10000000){
                plusTenFiveLastYear.add(item);
            }
        }
        System.out.println("+---------------------------------------------------------------------------------------------------------+");
        System.out.printf("%6s %12s %15s %15s %15s %15s", "row-number", "hired-year", "salary-range(million)", "personal-code"
                , "first-name", "last-name");
        System.out.println();
        System.out.println("+---------------------------------------------------------------------------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t" +" 1-5"+"\t\t\t\t");
        printRowBySalaryRange( oneFiveOneLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t1\t\t\t 99\t\t\t 5-10\t\t\t\t");
        printRowBySalaryRange(fiveTenOneLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t\t\t\t   \t\t\t +10\t\t\t\t");
        printRowBySalaryRange(plusTenOneLastYear);
        System.out.println("+---------------------------------------------------------------------------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t" +" 1-5"+"\t\t\t\t");
        printRowBySalaryRange(oneFiveTwoLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t2\t\t\t 98\t\t\t 5-10\t\t\t\t");
        printRowBySalaryRange(fiveTenTwoLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t \t\t\t   \t\t\t +10\t\t\t\t");
        printRowBySalaryRange(plusTenTwoLastYear);
        System.out.println("+---------------------------------------------------------------------------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t" +" 1-5"+"\t\t\t\t");
        printRowBySalaryRange(oneFiveThreeLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t3\t\t\t 97\t\t\t 5-10\t\t\t\t");
        printRowBySalaryRange(fiveTenThreeLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t \t\t\t   \t\t\t +10\t\t\t\t");
        printRowBySalaryRange(plusTenThreeLastYear);
        System.out.println("+---------------------------------------------------------------------------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t" +" 1-5"+"\t\t\t\t");
        printRowBySalaryRange(oneFiveFourLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t4\t\t\t 96\t\t\t 5-10\t\t\t\t");
        printRowBySalaryRange(fiveTenFourLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t \t\t\t   \t\t\t +10\t\t\t\t");
        printRowBySalaryRange(plusTenFourLastYear);
        System.out.println("+---------------------------------------------------------------------------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t" +" 1-5"+"\t\t\t\t");
        printRowBySalaryRange(oneFiveFiveLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t5\t\t\t 95\t\t\t 5-10\t\t\t\t");
        printRowBySalaryRange(fiveTenFiveLastYear);
        System.out.println("\t \t\t\t   \t\t\t------------------------------------------------------------------------------+");
        System.out.print("\t \t\t\t   \t\t\t +10\t\t\t\t");
        printRowBySalaryRange(plusTenFiveLastYear);
        System.out.println("+---------------------------------------------------------------------------------------------------------+");
    }
    private static void printRowBySalaryRange(List<Employee> list){
        for (int i=0; i<list.size()-1; i++ ) {
            System.out.print(list.get(i).getPersonalCode() +"\t\t\t" + list.get(i).getFirstName()+
                    "\t\t\t\t"+ list.get(i).getLastName()+"\n\t\t\t\t\t\t\t\t\t\t\t\t");
        }
        System.out.println(list.get(list.size()-1).getPersonalCode() +"\t\t\t" + list.get(list.size()-1).getFirstName()+
                "\t\t\t\t" + list.get(list.size()-1).getLastName());
    }

}
