package JavaQuestionTwo;

import JavaQuestionTwo.user;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class displayUser {
	public int rollasc;
	private addUser user;

	public displayUser(addUser user) {
		this.user = user;
	}
	public displayUser() {

	}
	public ArrayList<user> readFromFile() {
		
		ArrayList<user> object=null;
		String filename="userdata.txt";
		ArrayList<user> userDet = new ArrayList<user>();
		
		try {    
	        // Reading the object from a file 
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
	       
			object=(ArrayList<user>) in.readObject();
			userDet.addAll(object);

		}catch(EOFException e) {
			System.out.println("EOF here");
		}catch(Exception ex) {
			System.out.println("IOException is caught" );
		}
		
		nameCompare namecomp = new nameCompare(1);
		if(!userDet.isEmpty())
			Collections.sort(userDet,namecomp);
		
		return userDet;
	}
	
	public void takeDisplayOptions()
	{
		System.out.println("Enter 1 to sort Based on Name");
		System.out.println("Enter 2 to sort Based on Age");
		System.out.println("Enter 3 to sort Based on Address");
		System.out.println("Enter 4 to sort Based on RollNo");
		
		Scanner sc = new Scanner(System.in);
		int choice1 = sc.nextInt();
		
		System.out.println("Enter 1 to sort in ascending and 2 to sort in descending");
		
		int choice2 = sc.nextInt();
		rollasc=choice2;
		ArrayList<user> listOfUsers = user.getUsers();
		switch(choice1)
		{
		case 1 : 
			nameCompare namecomp = new nameCompare(choice2);
			Collections.sort(listOfUsers,namecomp);
			break;
		case 2 :
			AgeCompare agecomp = new AgeCompare(choice2);
			Collections.sort(listOfUsers,agecomp);
			break;
		case 3:
			AddressCompare addresscomp = new AddressCompare(choice2);
			Collections.sort(listOfUsers,addresscomp);
			break;
			
		case 4:
			rollCompare rollcomp = new rollCompare(choice2);
			Collections.sort(listOfUsers,rollcomp);
			break;
			
			default:
				System.out.println("Enter the Right Choice");
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        	System.out.println("Name\t\t\tRoll Number\t\tAge\t\t\tAddress\t\t\tCourses");
        	System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		
		for( user u1 : listOfUsers)
		{
			System.out.println(u1.getName()+"\t\t\t"+ u1.getRollno()+"\t\t\t"+ u1.getAge()+"\t\t\t"+ u1.getAddress()+"\t\t"+u1.getCourse().toString());
	        	System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		}
	}
}
