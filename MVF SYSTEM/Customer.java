import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
	private ArrayList<Order> orderlist;
	
    
    public Customer(String name, String pass, String a, String p)
    {
        super(name,pass,a,p);
        orderlist = new ArrayList<Order>();
       // tmp = new Order();
    }
    
    public Customer(String id, String name, String pass, String a, String p)
    {
        super(id,name,pass,a,p);
        orderlist = new ArrayList<Order>();
       // tmp = new Order();
    }
    
   
   
    public void addProduct(ArrayList<Product> p)
    {
    	Order tmp = new Order();
    	tmp.addPList(p);
    	orderlist.add(tmp);
    	
    }
    
public ArrayList<Order> getOrderList(String name)
{
	{
        ArrayList<Order> results = new ArrayList<Order>();
        if(name.isEmpty())
        {
        	for(int i=0; i < orderlist.size(); i++)
            {
        		results.add(orderlist.get(i));
            }
            
        }
        else
        {
        try
        { Pattern pattern = Pattern.compile(name,Pattern.CASE_INSENSITIVE);
            for(int i=0; i < orderlist.size(); i++)
            {
            	 
                for(Product j : orderlist.get(i).getProductList())
                {
                	Matcher matcher = pattern.matcher(j.getName());
                    if(matcher.find())
                    {                    
                        results.add(orderlist.get(i));
                                   
                    }
                	
                }
                
            }
        }
        catch(Exception e)
        {
        }
        }

        return results;
    }
	}
      
    public void removeOrder(Order o)
    {
    	orderlist.remove(o);
    }
}
