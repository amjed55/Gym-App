import java.util.*;
import java.text.DecimalFormat;
/**
 * @author (mony thach)
 * @version (0.01)
 */
public class Members
{
    
    private String name, email, pNum, address, eCN, eCPN;
    private double debt = 0.00;
    
    public Members()
    {
    }
    
    public Members(String newName, String newEmail, String newPNum, String newAddress, String newECN, String newECPN, double newDebt)
    {
        name = newName;
        email = newEmail;
        pNum = newPNum;
        address = newAddress;
        eCN = newECN;
        eCPN = newECPN;
        debt = newDebt;
    }     
    
    public String getName()
    {
        return name; 
    }
    
    public String getEmail()
    {
        return email; 
    }
    
    public String getNumber()
    {
        return pNum; 
    }
    
    public String getAddress()
    {
        return address; 
    }
    
    public String getECN()
    {
        return eCN; 
    }
    
    public String getECPN()
    {
        return eCPN; 
    }
    
    public double getDebt()
    {
        return debt;
    }
    
    public void addDebt(double debtOwed)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        debt += debtOwed;
        debt = Double.valueOf(df.format(debt));
    }
    
    public void addPayment(double amountPaid)
    {
        debt -= amountPaid;
    }
    
}