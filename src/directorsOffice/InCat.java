/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorsOffice;

/**
 *
 * @author kuba
 */
public class InCat extends Category{
    
    InCat(String description){
        super(description);
    }
    
    InCat(InCat incat){
        super(incat);
    }
    
    void add(InCat subcat){
        subcats.add(subcat);
    }
	
    public InCat[] getSubcats(){
        InCat[] sc = new InCat[subcats.size()];
        for(int i = 0; i < sc.length; i++){
            try{
                sc[i] = (InCat) subcats.get(i);
            }catch(ClassCastException e){
                System.err.println(e);
            }
        }
        return sc;
    }
    
}
