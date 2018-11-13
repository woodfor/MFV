import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductList
{
    // instance variables - replace the example below with your own
    private ArrayList<Product> arraylist;

    /**
     * Constructor for objects of class Product
     */
    public ProductList()
    {
        arraylist = new ArrayList<Product>();

    }

    public void addList(String a)
    {
         boolean tmpb;
        String check[];
        check = a.trim().split("/");
        if(check[5].equals("true"))
            tmpb = true;
        else
            tmpb = false;
        
        Product tmp = new Product(check[0],Integer.parseInt(check[1]),Double.parseDouble(check[2]),check[3],check[4],tmpb,Integer.parseInt(check[6]),
        		check[7],check[8],check[9]);
        arraylist.add(tmp);
    }

    public ArrayList<Product> getList()
    {
        return this.arraylist;
    }

    public void remove(Product a)
    {
        if(arraylist.contains(a))
            arraylist.remove(a);
    }

    public boolean contain(Product a)
    {
        if(arraylist.contains(a))
            return true;
        else
            return false;
    }

   

    public ArrayList<Product> search(String name)
    {
        ArrayList<Product> results = new ArrayList<Product>();
        if(name.isEmpty())
        {
        	for(int i=0; i < arraylist.size(); i++)
            {
            results.add(arraylist.get(i));
            }
        }
        else
        {
	        try
	        { Pattern pattern = Pattern.compile(name,Pattern.CASE_INSENSITIVE);
	            for(int i=0; i < arraylist.size(); i++)
	            {
	            	 
	                
	                Matcher matcher = pattern.matcher(arraylist.get(i).getName());
	                if(matcher.find())
	                {                    
	                    results.add(arraylist.get(i));
	                               
	                }
	            }
	        }
	        catch(Exception e)
	        {
	        }
        }

        return results;
    }
    

    
    public ArrayList<Product> userSearch(String name)
    {
        ArrayList<Product> results = new ArrayList<Product>();
        if(name.isEmpty())
        {
        	for(int i=0; i < arraylist.size(); i++)
            {
            	 
            	 if (arraylist.get(i).getDonate()==false && !(arraylist.get(i).getQuantity()==0))
                 {
            		 results.add(arraylist.get(i));
            				 
							
                 }
            	 
                
               
            }
        }
        else
        {
	        try
	        { Pattern pattern = Pattern.compile(name,Pattern.CASE_INSENSITIVE);
	            for(int i=0; i < arraylist.size(); i++)
	            {            	                 
	                Matcher matcher = pattern.matcher(arraylist.get(i).getName());
	                if(matcher.find())
	                {                                        
	                    if (arraylist.get(i).getDonate()==false && !(arraylist.get(i).getQuantity()==0))
	                    {
	                    results.add(arraylist.get(i));
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
