package leetcode.LeetCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransposeFile {
	
	public static void transpose() {
		
		File file = new File("file.txt");
		
		try {
			Scanner scanner1 = new Scanner(file);
			while(scanner1.hasNextLine()) {
				String name = scanner1.next();
				System.out.print(name);
				if(scanner1.hasNextLine()) {
					scanner1.nextLine();
					System.out.print(" ");
				}
			}
			scanner1.close();
		}
		catch(FileNotFoundException exc) {
		}
		System.out.println();
		
		try {
			Scanner scanner2 = new Scanner(file);
			while(scanner2.hasNextLine()) {
				if(scanner2.next().contentEquals("name")) {
					String age = scanner2.next();
					System.out.print(age);
				}
				else {
					int age = scanner2.nextInt();
					System.out.print(age);
				}
				if(scanner2.hasNextLine()) {
					scanner2.nextLine();
					System.out.print(" ");
				}
			}
			scanner2.close();
		}
		catch(FileNotFoundException exc) {
		}
		
	}
}
