package directorsOffice;

import java.util.*;
import budgetControl.*;

public class Category {
    protected String description;
    protected ArrayList<Category> subcats;
    protected ArrayList<Amount> history;

    Category(String description){
            this.description = description;
            subcats = new ArrayList<Category>();
            history = new ArrayList<Amount>();
    }
    
    Category(Category category){
        this.description = category.description;
        subcats = new ArrayList<Category>();
        for(Category ct : category.subcats){
            subcats.add(new Category(ct));
        }
        history = new ArrayList<Amount>();
        for(Amount am : category.history){
            history.add(new Amount(am));
        }
    }

    public String toString(){
        return description;
    }

    void remove(Category subcat){
        subcats.remove(subcat);
    }

    public void add(Amount amount){
        history.add(amount);
    }

    public Amount[] getHistory(){
        Amount[] am = new Amount[history.size()];
        for(int i = 0; i<am.length; i++){
            am[i] = history.get(i);
        }
        return am;
    }

    public void remove(Amount amount){
        history.remove(amount);
    }

    public boolean includes(Category category){
        if(this == category){
            return true;
        }
        boolean found = false;
        for(Category subcat : subcats){
            found = subcat.includes(category);
            if(found) break;
        }
        return found;
    }

    public void edit(String description){
            this.description = description;
    }
        
    Category[] getGenericSubcats(){
        Category[] sc = new Category[subcats.size()];
        for(int i = 0; i < sc.length; i++){
            sc[i] = subcats.get(i);
        }
        return sc;
    }
}