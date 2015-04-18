package budgetControl;

import java.io.ObjectInputStream.GetField;

import directorsOffice.*;

public class Amount {
	private int amount;
        
        //UNIEMOŻLIWIĆ UJEMNĄ WARTOŚĆ!!!
	
	public Amount(double amount){
            this.amount = (int) (amount*100);
	}
        
        public Amount(Amount amount){
            this.amount = amount.amount;   
        }
	
	public String toString(){
		int full = amount/100;
		String fullOut = amount < 0 ? "-"+Math.abs(full) : ""+full;
		int parts = Math.abs(amount%100);
		String partsOut = parts<10 ? "0" + parts : "" + parts;
		return fullOut + "," + partsOut;
	}
	
	public Amount add(Amount amount){
		double newAmount = (this.amount + amount.amount);
		Amount result = new Amount(newAmount/100);
		return result;
	}
	
	public void positive(){
		amount = Math.abs(amount);
	}
	
	public void negative(){
		amount = -Math.abs(amount);
	}
	
	/*public static void main(String[] args){
		Amount a1 = new Amount(11.30);
		Amount a2 = new Amount(-11.29);
		a2.negative();
		System.out.println(a1.add(a2));
	}*/
	
	/*public static void main(String... args){
		Director stephen = new Director();
		Category ins, exs;
		ins = stephen.getIn();
		exs = stephen.getEx();
		stephen.add(ins, "Parents");
		Category job = stephen.add(ins, "Job");
		stephen.add(ins, "University");
		stephen.add(job, "Flyers");
		Category sup = stephen.add(job, "Supermarket");
		stephen.add(sup, "Beer");
		Category food = stephen.add(sup, "Food");
		stephen.add(sup, "Car accessories");
		ins = stephen.getIn();
		stephen.remove(sup, food);
		Category[] inses = ins.getSubcats();
		for(Category c1 : inses){
			System.out.println(c1);
			for(Category c2: c1.getSubcats()){
				System.out.println("\t" + c2);
				for(Category c3 : c2.getSubcats()){
					System.out.println("\t\t" + c3);
				}
			}
		}
	}*/
}
