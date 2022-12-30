package Package01;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class UserInteractions{
	
	public UserInteractions() {
		System.out.println("\n*****************************************\n");
        System.out.println("*\tWelcome to LockedMe.com \t*");
        System.out.println("\n*****************************************\n");
        System.out.println("Developer Name : Sai Krishna");
        System.out.println("Role : Software Developer");
	}
	
	protected void options() {
		System.out.println("\nChoose options from below:");
		System.out.println("1. Return File names in current directory");
		System.out.println("2. User operations");
		System.out.println("3. Close the application\n");
		
	}
	
	protected void secondOptionList() {
		System.out.println("\nChoose from below operations\n"
				+ "1. Add file to current directory\n"
				+ "2. Delete file from current directory\n"
				+ "3. Search file from main direcoty\n"
				+ "4. Back to main context");
	}
	
	File getCurrentDir() {
		File folder = new File(System.getProperty("user.dir"));
		System.out.println("Current Directory:\n" + folder + "\n");
		return folder;
	}
}


class SecondOption extends UserInteractions{
	
	public SecondOption() {
		super();
	}
	
	private void addFile(Scanner scanner) {
		System.out.println("Enter file name\n");
		String fileName= scanner.next();
		File file = new File(fileName);
		if(!file.exists())
			try {
				file.createNewFile();
				System.out.println("File Created successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			System.out.println("File already exist");
		}
	}
	
	private void deleteFile(Scanner scanner) {
		System.out.println("Enter file name to delete\n");
		String fileName= scanner.next();
		
//		File file = new File(fileName);
//		if(file.delete())
//			System.out.println("File deleted successfully");
//		else 
//			System.out.println("Failed to delete file");
		try {
            Files.deleteIfExists(Paths.get(getCurrentDir().getAbsolutePath() + "//" + fileName));
            System.out.println("Deletion successful.");
        }
        catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        }
        catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        }
        catch (IOException e) {
            System.out.println("Invalid permissions.");
        }
	}
	
	private void searchFile(String fileName,File dir) {

		File[] files = getCurrentDir().listFiles();
		System.out.println(files);
//		for(File file : files) {
//			if(file.isDirectory()) {
//				searchFile(fileName, dir);
//			}
//			else if(fileName.equals(file.getName())){
//				System.out.println(fileName + " found successfully");
//				return;
//			}
//		}
//		System.out.println(fileName + " not found");
		return;
	}
	
	void Operations() {
		Scanner scanner = new Scanner(System.in);
		int options = 0;
		options = scanner.nextInt();
		scanner.nextLine();
		
		switch(options) {
			case 1: {
				addFile(scanner);
				break;
			}
			case 2: {
				deleteFile(scanner);
				break;
			}
			case 3: {
				System.out.println("Enter file name to search\n");
				String fileName= scanner.next();
				searchFile(fileName, getCurrentDir());
			}
		}
	}
}


public class MyApp extends SecondOption{
	
	public MyApp() {
		super();
	}

	private List<String> listFileNames(File folder, List<String> fileNames) {

		for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFileNames(fileEntry,fileNames);
	        } else {
	            fileNames.add(fileEntry.getName());
	        }
	    }
		return fileNames;
	}
	
	private void returnFiles() {
		
		//Current directory
		File folder = getCurrentDir();
		System.out.println("Files is current directory : ");
		List<String> fileNames = new ArrayList<String>();
		
		//Method to gather all files
		fileNames = listFileNames(folder,fileNames);
		
		//Sort the files
		Collections.sort(fileNames);
		
		Iterator<String> iterator = fileNames.iterator();
		
		//Printing file names
		while(iterator.hasNext()) 
			System.out.println(iterator.next());
	}
	
	
	public static void main(String[] args) {

		MyApp myApp = new MyApp();
		
		myApp.options();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int options = 0;
		options	= scanner.nextInt();
		scanner.nextLine();
		
		switch (options){
			case 1: {
				myApp.returnFiles();
				break;
			}
			case 2: {
				myApp.secondOptionList();
				myApp.Operations();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + options);
			}
	}

}
