package JavaQuestionTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
public class home {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		home homeObj = new home();
		homeObj.createFile();
		homeObj.takeUserInput();

	}

	private void createFile() {
		String filename = "userdata.txt";
		File fil = new File(filename);
		if(!fil.exists()) {
			try {
				FileOutputStream file = new FileOutputStream(filename);
			} catch (FileNotFoundException e1) {
				System.out.println("File Not Found Exception ");
			}
		}
	}

	private void takeUserInput() {
		addUser newUser = new addUser();
		saveDetails saveDet = new saveDetails();
		displayUser display = new displayUser(newUser);

		while(true) {
			System.out.println("Enter 1 for Adding User details \n Enter 2 for Displaying User Details \n Enter 3 to Delete User Details \n Enter 4 to Save user details \n Enter 5 to Exit\n ");
			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					// Calling class to add details
					newUser.AddUser();
					break;
				case 2:
					// calling class to display details
					ArrayList<user> users = display.readFromFile();
					for (user u : users)
						System.out.println(u.toString());
					display.takeDisplayOptions();
					break;

				case 3:
					// deleting details
					System.out.println("enter the roll number u want to delete");
					int roll = sc.nextInt();
					newUser.setUsers(display.readFromFile());
					ArrayList<user> listOfuser = newUser.getUsers();
					for (user u : listOfuser) {
						if (u.getRollno() == roll) {
							listOfuser.remove(u);
							break;
						}
					}
					newUser.setUsers(listOfuser);
					saveDet.save(listOfuser);
					break;
				case 4:
					//save details
					saveDet.save(newUser.getUsers());
					break;

				default:
					//Exit
					System.out.println("Do u want to save before exiting ? press Y to save !!");
					sc.nextLine();
					String input = sc.nextLine();
					if (input.equalsIgnoreCase("Y"))
						saveDet.save(newUser.getUsers());
					System.exit(0);
			}
		}
	}

}
