package Package01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {

	void readFile(String fileName) {
		 try {
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      System.out.println("Output :");
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      System.out.println("\n");
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	void writeFile(String fileName, String content,boolean appendtxt) {
		try {
		      FileWriter myWriter = new FileWriter(fileName,appendtxt);
		      myWriter.write(content);
		      myWriter.close();
		      System.out.println("OutPut : Successfully wrote to the file.\n");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = new String();
		System.out.println("Enter the file name to perform the operations\n");
		Scanner scanner = new Scanner(System.in);
		fileName = scanner.nextLine();
		int option = 0;
		
		FileOperations fOperations = new FileOperations();
		while(option!=4) {
			System.out.println("Choose the below options\n"
					+ "1.Read from file\n"
					+ "2.Write to the file\n"
					+ "3.Append to the file\n"
					+ "4.Exit\n");
			option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
				case 1:
					fOperations.readFile(fileName);
					break;
				case 2:
					String content = new String();
					System.out.println("Enter the content to write into the file\n");
					content = scanner.nextLine();
					fOperations.writeFile(fileName,content,false);
					break;
				case 3:
					String appendString = new String();
					System.out.println("Enter the content to append into the file\n");
					appendString = scanner.nextLine();
					fOperations.writeFile(fileName,appendString,true);
					break;
			}
			
		}
		scanner.close();
	}

}
