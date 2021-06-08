package JavaQuestionTwo;

import java.util.Comparator;

public class rollCompare implements Comparator<user> {
	/** 
	 *  asc=1 then it is ascending 
	 *  if asc= 2 then descending 
	 */
	
	int asc;
	int result;
	
	public rollCompare(int asc) {
		this.asc=asc;
	}

	@Override
	public int compare(user u1, user u2) {
		int result= 0;
		result = u1.getRollno()>u2.getRollno() ? 1 : -1;

		if(asc==2) {
			result*=-1;
		}
		return result;
	}

}
