package JavaQuestionTwo;
import java.util.*;
import java.io.*;


public class addUser {

	public ArrayList<user> users ;
	public user user1;
	public HashSet<Integer> rollSet= new HashSet<>();
	Scanner sc = new Scanner(System.in);

	public addUser() {
		displayUser disp = new displayUser();
		this.users=disp.readFromFile();

		for(user u1:users)
			rollSet.add(u1.getRollno());
	}

	public ArrayList<user> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<user> user) {
		users = user;
	}

	public void AddUser() {

		String name , address;
		int age,rollno;
		ArrayList<String> subj = new ArrayList<String>();

		System.out.println("enter name");
		name=sc.next();

		System.out.println("enter roll no");
		rollno=sc.nextInt();

		if(rollSet.contains(rollno)) {
			System.out.println("This user Already Exists !! ");
			return;
		} else {
			rollSet.add(rollno);
		}

		System.out.println("enter age");
		age = sc.nextInt();

		System.out.println("enter address");
		address = sc.next();

		System.out.println("Available Subjects are A,B,C,D,E,F ");
		subj = addCourse(subj);

		user1 = new user(name,age,rollno,address,subj);
		users.add(user1);
	}

	private ArrayList<String> addCourse(ArrayList<String> subj) {
		int max_sub=6;
		String allowedCourses = "ABCDEF";
		while(subj.size()<max_sub)
		{
			System.out.println("want to add subject ? if yes type 'y/Y' else type any character ");
			String st = sc.next();
			if(st.equalsIgnoreCase("y"))
			{
				String sub = sc.next();
				if(allowedCourses.contains(sub)) {
					subj.add(sub);
				}else {
					System.out.println("Available Subjects are A,B,C,D,E,F only.Select Among these !!");
				}
			}
			else {
				if (subj.size() < 4) {
					System.out.println("enter atleast 4 subjects");
				} else {
					break;
				}
			}
		}
		return subj;
	}
}
