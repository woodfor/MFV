import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;
public class Order {
	ArrayList<Product> productList ;
    private double totalPrice;
    private String createTime;
    private boolean paid;
    private String id;
    
    public Order()
    {
    	id=UUID.randomUUID().toString().replace("-", "");
    	productList = new ArrayList<Product>();
    	totalPrice = 0;
    	createTime = "";
    	paid=false;
    	  	
    }
    
    
    public void addPList(ArrayList<Product> p)
    {
    	productList = p;
    	for(Product i : p)
    	{
    		
            totalPrice += i.getQuantity() * i.getPrice()* i.getDiscount() * 0.01 ;
    	}
    	 Calendar calendar = Calendar.getInstance();
 		Date time = calendar.getTime();		
     	String str = time.toString();    	
     	createTime = str;
    }
    
    public void setPaid(boolean p)
    {
    	paid = p;
    }
    
    public boolean getPaid()
    {
    	return paid;
    }
    
    public ArrayList<Product> getProductList()
    {
        return productList;
    }
    

    
    public double getTotal()
    {
    	return totalPrice;
    }
    
    public String getCreateTime()
    {
    	return createTime;
    }
    
    public String getID()
    {
    	return id;
    }

}
