package application;

// Importação de pacotes utilitários locais do Java
import java.util.Locale;
import java.util.Scanner;

// Importação do utilitário local do módulo
import util.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Instância uma nova conta sem agregar valor aos atributos iniciais
		Account account;
		
		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		
		System.out.print("Enter account holder: ");
		// Recebe a quebra de linha da entrada anterior para que a próxima alocação na variável não tenha erros
		sc.nextLine();
		String holder = sc.nextLine();
		
		System.out.print("Is there an initial deposit? (y/n) ");
		char response = sc.next().charAt(0);

		if(response == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			
			// Agrega os valores no método constructor apartir da instância anterior
			account = new Account(number, holder, initialDeposit);
		} else {
			account = new Account(number, holder);
		}
		
		System.out.println("\nAccount Data:");
		System.out.println(account);
		
		System.out.print("\nEnter a deposit value: ");
		double depositAmount = sc.nextDouble();
		account.deposit(depositAmount);
		
		System.out.println("\nUpdated account data:");
		System.out.println(account);
		
		System.out.print("\nEnter a withdraw value: ");
		double withdrawAmount = sc.nextDouble();
		account.withdraw(withdrawAmount);

		System.out.println("\nUpdated account data:");
		System.out.println(account);

		sc.close();
	}

}
