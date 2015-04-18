package budgetControl;

class IncorrectDateException extends Exception{}

public class Date{
		private int year, month, day;
		
		public Date(int year, int month, int day) throws IncorrectDateException{
			if(year<=0) throw new IncorrectDateException();
			if(month<1 || month>12) throw new IncorrectDateException();
			if(day<1 || day>31) throw new IncorrectDateException();
			if((month==4 || month==6 || month==9 || month==11) && day>30) throw new IncorrectDateException();
			if(month == 2 && !(year%4==0 && (year%100!=0 || year%1000==0)) && day>28) throw new IncorrectDateException();
			if(month == 2 && day>29) throw new IncorrectDateException();
			this.year = year;
			this.month = month;
			this.day = day;
		}
		
		public String toString(){
			return day + "." + month + "." + year;
		}
		
		public int compareTo(Date date){
			int comparator1 = day + 100*month + 10000*year;
			int comparator2 = date.day + 100*date.month + 10000*date.year;
			return comparator2-comparator1;
		}
	}