package JavaQuestionTwo;

import java.util.Comparator;

public class nameCompare implements Comparator<user>{
	/** 
	 *  asc=1 then it is ascending 
	 *  if asc= 2 then descending 
	 */
	int asc;
	int result;
	
	public nameCompare(int asc) {
		this.asc=asc;
	}
	
	@Override
	public int compare(user u1, user u2) {
		if(u1.getName().compareTo(u2.getName())>0) {
			result= 1;
		}
		else if(u1.getName().compareTo(u2.getName())<0) {
			result= -1;
		}
		else {
			//if both names are same then arrange based on their roll numbers
			return u1.getRollno() - u2.getRollno();
		}
		if(asc==2) {
			result*=-1;
		}
		return result;
	}

}
