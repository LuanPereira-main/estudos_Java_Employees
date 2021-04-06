package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		//////////////////////////////Reading data//////////////////////////////
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println(); //Utilizado para dar a quebra de linha de um funcionário para o outro na volta do loop.
			System.out.println("Employee #" + i + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.println("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Salary: $ ");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
		}
		
		//////////////////////////////Increase salary//////////////////////////////
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This ID doesn't exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		//////////////////////////////Listing emloyees//////////////////////////////
		
		System.out.println();
		System.out.println("List of employees: ");
		for(Employee obj : list) {
			System.out.print(obj);
		}
		
		sc.close();

	}
	
	//////////////////////////////Method to compare the existing id's//////////////////////////////
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
