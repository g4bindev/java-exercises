package application;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import utilities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int numEmployees = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
		
		// Define as informações dos empregados a serem registrados
		for(int i = 0; i < numEmployees; i++) {
			System.out.printf("%nEmployee #%d:", i+1);
			
			System.out.printf("%nId: ");
			int id = sc.nextInt();
			
			// Checa se já existe uma instancia com o id inserido
			while(findInstanceWithId(list, id) != null) {
				System.out.printf("%nThis id already exists! Please try again.%n");
				System.out.printf("%nEmployee #%d:", i+1);
				System.out.printf("%nId: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			// Cria uma nova instancia de Employee e adiciona ela na lista
			list.add(new Employee(id, name, salary));
		}
		
		System.out.printf("%nEnter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		Employee emp = findInstanceWithId(list, id);
		
		if(emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage); // Aponta para a instancia dentro da lista e altera ela
		}
		
		System.out.printf("%nList of Employees:%n");
		for(Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}
	
	static Employee findInstanceWithId(List<Employee> list, int id) {
		// Checa se o id inserido existe e retorna a instância desse id para a variável
		// Se não retorna null
		Employee emp = list.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
		return emp;
	}

}
