package org.lamda;

import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<Employee> buildEmployeeList() {
        return List.of(
                new Employee(111, "Jennifer Flores", 32, "Female", "HR", 2011, 25000.0),
                new Employee(122, "Mr. Jacob Parker", 25, "Male", "Sales And Marketing", 2015, 13500.0),
                new Employee(133, "Tony Williams", 29, "Male", "Infrastructure", 2012, 18000.0),
                new Employee(144, "David King", 28, "Male", "Product Development", 2014, 32500.0),
                new Employee(155, "Christina Baker", 27, "Female", "HR", 2013, 22700.0),
                new Employee(166, "John Murphy", 43, "Male", "Security And Transport", 2016, 10500.0),
                new Employee(177, "Daniel Jackson", 35, "Male", "Account And Finance", 2010, 27000.0),
                new Employee(188, "William Foster", 31, "Male", "Product Development", 2015, 34500.0),
                new Employee(199, "Linda Li", 24, "Female", "Sales And Marketing", 2016, 11500.0),
                new Employee(200, "Justin Ward", 38, "Male", "Security And Transport", 2015, 11000.5),
                new Employee(211, "Lisa Aguilar", 27, "Female", "Infrastructure", 2014, 15700.0),
                new Employee(222, "Daniel Morris", 25, "Male", "Product Development", 2016, 28200.0),
                new Employee(233, "Elizabeth Moody", 27, "Female", "Account And Finance", 2013, 21300.0),
                new Employee(244, "William Williams", 24, "Male", "Sales And Marketing", 2017, 10700.5),
                new Employee(255, "Dr. John Obrien", 23, "Male", "Infrastructure", 2018, 12700.0),
                new Employee(266, "Sara Farrell", 26, "Female", "Product Development", 2015, 28900.0),
                new Employee(277, "Eric Smith", 31, "Male", "Product Development", 2012, 35700.0)
        );
    }

    /**
     * @question How many male and female employees are there in the organization?
     * @param employeesList
     */
    private static void countMaleAndFemaleEmployees(List<Employee> employeesList) {
        Map<String, Long> resultMap = employeesList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.format("%s\n", resultMap);
    }

    /**
     * @question Print the name of all departments in the organization?
     * @param employeesList
     */
    private static void printAllDepartments(List<Employee> employeesList) {
        String departmentsString = employeesList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.joining("\n"));
        System.out.format("Departments:\n%s\n", departmentsString);
    }

    /**
     * @question What is the average age of male and female employees?
     * @param employeesList
     */

    private static void printAverageAgeOfMaleFemaleEmployees(List<Employee> employeesList) {
        Map<String, Double> resultMap = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.format("Average ages: %s\n", resultMap);
    }

    /**
     * @question Get the details of the highest paid employee in the organization?
     * @param employeesList
     */
    private static void printHighestPaidEmployeeDetail(List<Employee> employeesList) {
        Optional<Employee> highestPaidEmployee = employeesList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        System.out.format("Highest Paid Employee: %s\n", highestPaidEmployee.get());
    }

    /**
     * @question Get the names of all employees who have joined after 2015?
     * @param employeesList
     * @param year
     */
    private static void printEmployeeNamesJoinedAfterYear(List<Employee> employeesList, final int year) {
        String employeeNames = employeesList.stream().filter(emp -> emp.getYearOfJoining() > year)
                .map(Employee::getName)
                .collect(Collectors.joining("\n"));

        System.out.format("Employees who joined after %d: \n%s\n", year, employeeNames);
    }

    /**
     * @question Count the number of employees in each department?
     * @param employeesList
     */
    private static void printEmployeeCountInDepartments(List<Employee> employeesList) {
        Map<String, Long> resultMap = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.format("Number of employees in each department: \n%s\n", resultMap);
    }

    /**
     * @qeustion What is the average salary of each department?
     * @param employeesList
     */
    private static void printAverageSalaryOfDepartments(List<Employee> employeesList) {
        Map<String, Double> resultMap = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.format("Average salary of each department: \n%s\n", resultMap);
    }

    /**
     * @question Get the details of the youngest male employee in the product development department?
     * @param employeesList
     * @param department
     */
    private static void printYoungestMaleEmployeeInDepartment(List<Employee> employeesList, @NonNull String department) {
        Optional<Employee> youngestMaleEmployee = employeesList.stream()
                .filter(emp -> emp.getDepartment().equals(department))
                .collect(Collectors.minBy(Comparator.comparingDouble(Employee::getAge)));

        System.out.format("Youngest male employee in '%s' department: %s\n", department, youngestMaleEmployee.get());
    }

    /**
     * @question Who has the most working experience in the organization?
     * @param employeesList
     */
    private static void printEmployeeMostWorkingExperience(List<Employee> employeesList) {
        Optional<Employee> experienceEmployee = employeesList.stream()
                .collect(Collectors.minBy(Comparator.comparingDouble(Employee::getYearOfJoining)));

        System.out.format("Employee with most experience: %s\n", experienceEmployee.get());
    }

    /**
     * @question How many male and female employees are there in the sales and marketing team?
     * @param employeesList
     * @param department
     */
    private static void printMaleFemaleCountInDepartment(List<Employee> employeesList, @NonNull String department) {
        Map<String, Long> resultMap = employeesList.stream()
                .filter(emp -> department.equals(emp.getDepartment()))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.format("Male/Female count in '%s' department: %s\n", department, resultMap);
    }

    /**
     * @question What is the average salary of male and female employees?
     * @param employeesList
     */
    private static void printMaleFemaleAverageSalary(List<Employee> employeesList) {
        Map<String, Double> resultMap = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.format("Average salaries: %s\n", resultMap);
    }

    /**
     * @question List down the names of all employees in each department?
     * @param employeesList
     */
    private static void printEmployeeInEachDepartments(List<Employee> employeesList) {
        Map<String, List<Employee>> resultMap = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));

        for(String department: resultMap.keySet()) {
            System.out.println("Department: " + department);
            for(Employee employee: resultMap.get(department)) {
                System.out.println("\t" + employee);
            }
        }
        System.out.println();
    }

    /**
     * @question What are the average salary and total salary of the whole organization?
     * @param employeesList
     */
    private static void printAverageAndTotalSalary(List<Employee> employeesList) {
        DoubleSummaryStatistics summary = employeesList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average: " + summary.getAverage());
        System.out.println("Total: " + summary.getSum());
    }

    /**
     * @question Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years?
     * @param employeesList
     * @param age
     */
    private static void printEmployeesPartitionedByAge(List<Employee> employeesList, final int age) {
        Map<Boolean, List<Employee>> employeesSplit = employeesList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() < age));
        System.out.format("Employee older than %d: %s\n", age, employeesSplit.get(false));
        System.out.format("Employee younger than %d: %s\n", age, employeesSplit.get(true));
    }

    /**
     * @question Who is the oldest employee in the organization? What is his age and which department does he belong to?
     * @param employeesList
     */
    private static void printOldestEmployee(List<Employee> employeesList) {
        Optional<Employee> oldestEmployee = employeesList.stream()
                .max(Comparator.comparingDouble(Employee::getAge));
        System.out.format("Oldest employee: %s\n", oldestEmployee.get());
    }

    /**
     * @question Get the details of 2nd highest-paid employee in the organization?
     * @param employeesList
     */
    private static void printSecondHighestPaidEmployee(List<Employee> employeesList) {
        assert employeesList != null : "employeeList list cannot be null";
        assert employeesList.size() >= 2 : "employeeList should have two or more employees";
        List<Employee> highestPaidEmployees = employeesList.stream()
                .sorted(Comparator.comparingDouble(emp -> emp.getSalary()))
                .limit(2)
                .collect(Collectors.toList());
        System.out.format("Highest Paid Employee: %s\n", highestPaidEmployees.get(2));
    }


    public static void main(String[] args) {
        List<Employee> employeesList = buildEmployeeList();

        countMaleAndFemaleEmployees(employeesList);
        printAllDepartments(employeesList);
        printAverageAgeOfMaleFemaleEmployees(employeesList);
        printHighestPaidEmployeeDetail(employeesList);
        printEmployeeNamesJoinedAfterYear(employeesList, 2015);
        printEmployeeCountInDepartments(employeesList);
        printAverageSalaryOfDepartments(employeesList);
        printYoungestMaleEmployeeInDepartment(employeesList, "Product Development");
        printEmployeeMostWorkingExperience(employeesList);
        printMaleFemaleCountInDepartment(employeesList, "Sales And Marketing");
        printMaleFemaleAverageSalary(employeesList);
        printEmployeeInEachDepartments(employeesList);
        printAverageAndTotalSalary(employeesList);
        printEmployeesPartitionedByAge(employeesList, 25);
        printOldestEmployee(employeesList);
        printSecondHighestPaidEmployee(employeesList);
    }
}
