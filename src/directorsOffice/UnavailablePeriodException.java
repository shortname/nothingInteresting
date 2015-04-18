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
public class UnavailablePeriodException extends Exception{
    public String toString(){
        return "Unavailable period - there is a budget set in for this period.";
    }
}
