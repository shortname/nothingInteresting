package directorsOffice;

import budgetControl.Period;

public class BudgetState {
	private final Period period;
	private final Budget expected;
	private Budget real;
	private boolean closed;
	
	BudgetState(Period period, Budget expected){
		this.period = period;
		this.expected = expected;
		closed = false;
	}
        
        public Period getPeriod(){
            if(closed)
                return new Period(period);
            else
                return period;
        }
        
        public Budget getReal(){
            if(closed)
                return new Budget(real);
            else
                return real;
        }
        
        public Budget getExpected(){
            if(closed)
                return new Budget(expected);
            else
                return expected;
        }
        
        void close(){
            closed = true;
        }
	
}
