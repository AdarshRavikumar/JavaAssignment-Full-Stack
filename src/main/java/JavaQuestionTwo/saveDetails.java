package JavaQuestionTwo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

public class saveDetails {
	
	public boolean save(ArrayList<user> listOfUsers) {
		try {
			FileOutputStream file = new FileOutputStream("userdata.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject((ArrayList<user>) listOfUsers);
			return  true;
		} catch (IOException e) {
			System.out.println("IO Exception Caught ");
			return  false;
		}
	}

}
