package directorsOffice;

import java.util.*;
import budgetControl.Amount;

class CategoryNotFoundException extends Exception{
    public String toString(){
        return "Category does not belongs to the budget.";
    }
}

public class Budget {
	private final InCat incomes;
        private final ExCat expenses;
	private Amount initialBallance;
	
	public Budget(Amount initialBallance, InCat incomes, ExCat expenses){
		this.initialBallance = initialBallance;
		this.incomes = incomes;
		this.expenses = expenses;
	}
        
        public Budget(Budget budget){
            this.initialBallance = budget.initialBallance;
            this.incomes = new InCat(budget.incomes);
            this.expenses = new ExCat(budget.expenses);
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
		return incomes;
	}
	
	public ExCat getEx(){
		return expenses;
	}
        
	public void add(InCat cat, Amount amount) throws CategoryNotFoundException{
            if(incomes.includes(cat)){
                cat.add(amount);
            }else{
                throw new CategoryNotFoundException();
            }
	}
	
	public void add(ExCat cat, Amount amount) throws CategoryNotFoundException{
            if(expenses.includes(cat)){
                cat.add(amount);
            }else{
                throw new CategoryNotFoundException();
            }
	}
	
	public void remove(InCat cat, Amount amount) throws CategoryNotFoundException{
            if(incomes.includes(cat)){
                cat.remove(amount);
            }else{
                throw new CategoryNotFoundException();
            }
	}
	
	public void remove(ExCat cat, Amount amount) throws CategoryNotFoundException{
            if(expenses.includes(cat)){
                cat.remove(amount);
            }else{
                throw new CategoryNotFoundException();
            }
	}
        
        private void getReport(Map<ArrayList<Category>, Amount[]> map, ArrayList<Category> supcats, Category cat){
            ArrayList<Category> sc = new ArrayList<Category>(supcats);
            sc.add(cat);
            map.put(sc, cat.getHistory());
            for(Category ct : cat.getGenericSubcats()){
                getReport(map, sc, ct);
            }
        }
        
        public Map<ArrayList<Category>, Amount[]> getBudget(){
            Map<ArrayList<Category>, Amount[]> map = new HashMap<ArrayList<Category>, Amount[]>();
            getReport(map, new ArrayList<Category>(), incomes);
            getReport(map, new ArrayList<Category>(), expenses);
            return map;
        }
	
	public Amount getInitialBallance(){
		return initialBallance;
	}
}
