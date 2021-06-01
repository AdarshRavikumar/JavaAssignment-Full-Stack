package JavaQuestionTwo;

import java.util.Comparator;

public class AgeCompare implements Comparator<user> {
	
	/** 
	 *  asc=1 then it is ascending 
	 *  if asc= 2 then descending 
	 */
	
	int asc;
	int result;
	
	public AgeCompare(int asc) {
		this.asc=asc;
	}
	
	@Override
	public int compare(user u1, user u2) {
		int result= 0;
		result = u1.getAge()>u2.getAge() ? 1 : -1;

		if(asc==2) {
			result*=-1;
		}
		return result;
	}
}
