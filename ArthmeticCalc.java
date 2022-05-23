import java.util.Scanner;

public class ArthmeticCalc {

	public static void main(String[] args) {

		float num1,num2;
		int operator = 0;
		
		Scanner sc = new Scanner(System.in);
		while(operator != 5) {
			System.out.println("\nEnter first number");
			num1 = sc.nextFloat();
			System.out.println("Enter second number");
			num2 = sc.nextFloat();
			System.out.println("Enter your choice(1-5) from below.\n"
					+ "1.Addition\n"
					+ "2.Subtraction\n"
					+ "3.Multipliction\n"
					+ "4.Divison\n"
					+ "5.Exit\n");
			operator = sc.nextInt();
			switch(operator) {
			case 1:
				System.out.println("Result : " + (num1 + num2));
				break;
			case 2:
				System.out.println("Result : " + (num1 - num2));
				break;
			case 3:
				System.out.println("Result : " + (num1 * num2));
				break;
			case 4:
				System.out.println("Result : " + (num1 / num2));
				break;
			case 5:
				System.out.println("Exiting the Code");
				break;
			}
		}
		

	}

}
