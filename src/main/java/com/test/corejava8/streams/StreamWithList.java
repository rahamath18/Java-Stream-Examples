package com.test.corejava8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWithList {

	public static void main(String[] args) {
		
		System.out.println("forEach with List");
		System.out.println("-----------------");
		forEachWithList();
		
		System.out.println("\n");
		
		System.out.println("reduce with List");
		System.out.println("----------------");
		reduceWithList();
		
		System.out.println("\n");
		
		System.out.println("filter and map with List");
		System.out.println("------------------------");
		filterAndMapWithList();
		
		System.out.println("\n");
		
		System.out.println("Employee POJO Print");
		System.out.println("------------------------------------");
		employeePOJOPrintWithList();
		
		System.out.println("\n");
		
		System.out.println("Employee POJO Sorting By Employee Id");
		System.out.println("------------------------------------");
		employeePOJOSortingByEmployeeIdWithList();
		
		System.out.println("\n");

		System.out.println("Employee POJO Sorting By Employee Name");
		System.out.println("--------------------------------------");
		employeePOJOSortingByEmployeeNameWithList();
		
		System.out.println("\n");

		System.out.println("Employee POJO Sorting By Employee Salary");
		System.out.println("----------------------------------------");
		employeePOJOSortingByEmployeeSalaryWithList();
		
		System.out.println("\n");
		
		System.out.println("Employee POJO Filter By Employee Salary > 2000");
		System.out.println("---------------------------------------");
		employeePOJOFilterByEmployeeSalaryWithList();
	}
	
	public static void forEachWithList() {
        List<String> fruits = Arrays.asList("apple" ,"banana" ,"citrus" ,"durian");
        fruits.forEach(System.out::println);
    }
	
    public static void reduceWithList() {
        List<String> fruits = Arrays.asList("apple" ,"banana" ,"citrus" ,"durian");

        String actual = fruits
        		.stream()
        		.reduce((t, u) -> t + "|" + u)
                .get();
        System.out.println(actual);
    }
    
    public static void filterAndMapWithList() {
        List<String> fruits = Arrays.asList("apple" ,"banana" ,"citrus" ,"apricots", "durian", "avocados");

        List<String> fruitsFiltered = fruits
        		.stream()
        		.filter((t) -> t.indexOf('a') == 0)
        		.map(String::toUpperCase)
        		.collect(Collectors.toList())
                ;
        System.out.println(fruitsFiltered);
    }
    
    public static void employeePOJOPrintWithList() {
        List<Employee> employees = Arrays.asList(
        		new Employee(1, "John", 2000.15f),
        		new Employee(2, "Adam", 3000.25f),
        		new Employee(3, "Smith", 1000.35f),
        		new Employee(4, "Bean", 1500.45f),
        		new Employee(5, "Cris", 500.55f)
        		);

        employees.stream().forEach(System.out::println);
        
    }
    
    public static void employeePOJOSortingByEmployeeIdWithList() {
        List<Employee> employees = Arrays.asList(
        		new Employee(1, "John", 2000.15f),
        		new Employee(5, "Adam", 3000.25f),
        		new Employee(3, "Smith", 1000.35f),
        		new Employee(2, "Bean", 1500.45f),
        		new Employee(4, "Cris", 500.55f)
        		);
       List<Employee> employeesSortedById = employees
        										.stream()
        										.sorted(Employee.idComparator)
        										.collect(Collectors.toList());
       employeesSortedById.stream().forEach(System.out::println);
        
    }
    
    public static void employeePOJOSortingByEmployeeNameWithList() {
        List<Employee> employees = Arrays.asList(
        		new Employee(1, "John", 2000.15f),
        		new Employee(5, "Adam", 3000.25f),
        		new Employee(3, "Smith", 1000.35f),
        		new Employee(2, "Bean", 1500.45f),
        		new Employee(4, "Cris", 500.55f)
        		);
       List<Employee> employeesSortedById = employees
        										.stream()
        										.sorted(Employee.nameComparator)
        										.collect(Collectors.toList());
       employeesSortedById.stream().forEach(System.out::println);
        
    }
    
    public static void employeePOJOSortingByEmployeeSalaryWithList() {
        List<Employee> employees = Arrays.asList(
        		new Employee(1, "John", 2000.15f),
        		new Employee(5, "Adam", 3000.25f),
        		new Employee(3, "Smith", 1000.35f),
        		new Employee(2, "Bean", 1500.45f),
        		new Employee(4, "Cris", 500.55f)
        		);
       List<Employee> employeesSortedById = employees
        										.stream()
        										.sorted(Employee.salaryComparator)
        										.collect(Collectors.toList());
       employeesSortedById.stream().forEach(System.out::println);
        
    }
    
    public static void employeePOJOFilterByEmployeeSalaryWithList() {
        List<Employee> employees = Arrays.asList(
        		new Employee(1, "John", 2000.15f),
        		new Employee(5, "Adam", 3000.25f),
        		new Employee(3, "Smith", 1000.35f),
        		new Employee(2, "Bean", 1500.45f),
        		new Employee(4, "Cris", 500.55f)
        		);
       List<Employee> employeesFilteredBySalary = employees
        										.stream()
        										.filter(e -> e.getSalary() > 2000)
        										.collect(Collectors.toList());
       employeesFilteredBySalary.stream().forEach(System.out::println);
        
    }

}

class Employee {
	
	private Integer id;
	private String name;
	private Float salary;
	
	public Employee() {}
	
	public Employee(Integer id, String name, Float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	public static Comparator<Employee> idComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if (o1.id == o2.id)
				return 0;
			else if (o1.id > o2.id)
				return 1;
			else
				return -1;
		}
	};
	
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.name.compareTo(o2.name);
		}
	};
	
	public static Comparator<Employee> salaryComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			if (o1.salary == o2.salary)
				return 0;
			else if (o1.salary > o2.salary)
				return 1;
			else
				return -1;
		}
	};
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
