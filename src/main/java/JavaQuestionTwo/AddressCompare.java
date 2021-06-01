package JavaQuestionTwo;

import java.util.Comparator;

public class AddressCompare implements Comparator<user>{
	int asc;
	int result;
	
	public AddressCompare(int asc) {
		this.asc=asc;
	}
	
	@Override
	public int compare(user u1, user u2) {
		int result= 0;
		result = (u1.getAddress().compareTo(u2.getAddress())>0 ) ? 1: -1 ;

		if(asc==2) {
			result*=-1;
		}
		return result;
	}
}
