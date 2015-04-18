package budgetControl;

class IncorrectPeriodException extends Exception{
	public String toString(){
		return "The period is incorrect.";
	}
}

public class Period {
	
	private Date start, end;
	
	public Period(int startY, int startM, int startD, int endY, int endM, int endD) throws IncorrectPeriodException{
		try{
			this.start = new Date(startY, startM, startD);
			this.end = new Date(endY, endM, endD);
		}catch(IncorrectDateException e){
			System.out.println(e);
			return;
		}
		if(start.compareTo(end) <= 0) throw new IncorrectPeriodException();
	}
        
        public Period(Period period){
            this.start = period.start;
            this.end = period.end;
        }
	
	public String toString(){
		return start.toString() + " - " + end.toString();
	}
	
	public Date getStart(){
		return start;
	}
	
	public Date getEnd(){
		return end;
	}
	
	public boolean includes(Date date){
		return start.compareTo(date) >= 0 && end.compareTo(date) <= 0;
	}
	
	public boolean included(Period period){
		return period.start.compareTo(start) <= 0 && period.end.compareTo(end) >= 0;
	}
	
}
