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
public class ExCat extends Category{
    
    ExCat(String description){
        super(description);
    }
    
    ExCat(ExCat excat){
        super(excat);
    }
    
    void add(ExCat subcat){
        subcats.add(subcat);
    }
	
    public ExCat[] getSubcats(){
        ExCat[] sc = new ExCat[subcats.size()];
        for(int i = 0; i < sc.length; i++){
            sc[i] = (ExCat) subcats.get(i);
        }
        return sc;
    }
    
}
