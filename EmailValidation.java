package Package01;

import java.util.Scanner;

public class EmailValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		System.out.println("Enter number of EmailIds");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		
		String[] emailIds = new String[n];
		System.out.println("Enter EmailIds:");
		for(int i=0;i<n;i++)
			emailIds[i] = scanner.next();
		
		System.out.println("Enter the EmailId to search");
		String element = new String();
		element = scanner.next();
		
		scanner.close();
		
		boolean check = false;
		for(int i=0;i<n;i++) {
			if(emailIds[i].equals(element))
				check = true;
		}
		if(check)
			System.out.println("EmailId is found");
		else
			System.out.println("EmailId is not found");
	}

}
