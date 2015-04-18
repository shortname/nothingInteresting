/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetControl;

import directorsOffice.Budget;
import directorsOffice.*;
import java.util.*;
/**
 *
 * @author kuba
 */
public class Tester {
    
    public Tester(){
        System.out.println("!");
        Director dir = new Director();
        InCat ins = dir.getIn();
        ExCat exs = dir.getEx();
        InCat sal = dir.add(ins, "Salary");
        InCat beer = dir.add(sal, "Beer");
        Amount forbeer = new Amount(37);
        beer.add(forbeer);
        InCat pf = dir.add(sal, "Pet Food");
        Budget bg = dir.createBudget(new Amount(0.0));
        beer.remove(forbeer);
        InCat insc = bg.getIn();
        ExCat exsc = bg.getEx();
        InCat pm = bg.add(insc, "Pocket Money");
        ExCat food = bg.add(exsc, "Food");
        Period per = null;
        try{
            per = new Period(2014, 02, 12, 2015, 02, 01);
        }catch(IncorrectPeriodException e){
            System.err.println(e);
        }
        BudgetState bs;
        try{
            bs = dir.add(per, bg);
        }catch(UnavailablePeriodException | NullPointerException e){
            System.err.println(e);
        }
        Budget bg2 = dir.createBudget(new Amount(0.0));
        insc = bg2.getIn();
        exsc = bg2.getEx();
        InCat[] toremove = insc.getSubcats();
        dir.remove(insc, toremove[0]);
        food = bg2.add(exsc, "Food");
        food.add(new Amount(10.50));
        food = bg2.add(food, "Outside");
        food.add(new Amount(12.50));
        food.add(new Amount(3));
        food.add(new Amount(4));
        per = null;
        try{
            per = new Period(2016, 02, 12, 2017, 02, 01);
        }catch(IncorrectPeriodException e){
            System.err.println(e);
        }
        try{
            bs = dir.add(per, bg2);
        }catch(UnavailablePeriodException | NullPointerException e){
            System.err.println(e);
        }
        ArrayList<BudgetState> albs = new ArrayList<BudgetState>();
        try{
            albs = dir.get(new Period(2000, 02, 12, 2020, 01, 01));
        }catch(IncorrectPeriodException e){
            System.err.println(e);
        }
        for(BudgetState bss : albs){
            Budget probe = bss.getExpected();
            System.out.println("\n## " + bss.getPeriod() + " ##" );
            Map<ArrayList<Category>, Amount[]> map = probe.getBudget();
            for(Map.Entry<ArrayList<Category>, Amount[]> entry : map.entrySet()){
                for(Category ctg : entry.getKey()){
                    System.out.print(ctg + ". ");
                }
                Amount am = new Amount(0);
                for(Amount amt : entry.getValue()){
                    am = am.add(amt);
                }
                System.out.println(am);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("!");
        Tester tt = new Tester();
    }
    
}
