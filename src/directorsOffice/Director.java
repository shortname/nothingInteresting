package directorsOffice;

import java.util.*;
import budgetControl.*;

public class Director {
	private final InCat inCats;
        private final ExCat exCats;
        private Queue<BudgetState> history;

	public Director(){
		inCats = new InCat("INCOMES");
		exCats = new ExCat("EXPENSES");
                history = new LinkedList<BudgetState>();
	}
        
        public Budget createBudget(Amount initialAmount){
            return new Budget(initialAmount, new InCat(inCats), new ExCat(exCats));
        }

        public BudgetState add(Period period, Budget excepted) throws UnavailablePeriodException{
            for(BudgetState bs : history) {
                    if(period.includes(bs.getPeriod().getStart()) || period.includes(bs.getPeriod().getEnd()))
                        throw new UnavailablePeriodException();
            }
            BudgetState newOne = new BudgetState(period, excepted);
            history.add(newOne);
            return newOne;
        }
        
        public ArrayList<BudgetState> get(Period period){
            ArrayList<BudgetState> albs = new ArrayList<BudgetState>();
            for(BudgetState bs : history){
                if(period.included(bs.getPeriod()))
                    albs.add(bs);
            }
            return albs;
        }
        
        public Queue<BudgetState> get(){
            return history;
        }
        
        public void close(BudgetState bs){
            bs.close();
        }
        
	public InCat add (InCat root, String description){
		InCat cat = new InCat(description);
		root.add(cat);
		return cat;
	}
        
        public ExCat add (ExCat root, String description){
		ExCat cat = new ExCat(description);
		root.add(cat);
		return cat;
	}
	
	public void remove(Category root, Category cat){
		root.remove(cat);
	}
	
	public InCat getIn(){
		return inCats;
	}
	
	public ExCat getEx(){
		return exCats;
	}
}
