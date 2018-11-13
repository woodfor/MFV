import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.Format;
import java.lang.Object;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *Controller class is the class which contains all the methods of users' actions.
 */
public class MFVSController
{

	ArrayList<Product> tmplist;
    private Account customerList;
    private ProductList productList;
    private Customer customer;
    private ArrayList<Charity> charityList;
    private ArrayList<Product> disposeList;
    /**
     * Constructor for objects of class Contorller
     */
    public MFVSController()
    {
        
    	charityList = new ArrayList<Charity>();
    	tmplist = new ArrayList<Product>();
        customerList=new Account();
        productList = new ProductList();
        disposeList = new ArrayList<Product>();
        
        File fileCust = new File("UserList.txt");
        try
        {
            if(fileCust.exists())
            {                 
                BufferedReader reader = null;
                try 
                {

                    reader = new BufferedReader(new FileReader(fileCust));
                    String tempString = null;
                    int line = 1;
                    while ((tempString = reader.readLine()) != null) 
                    {
                        
                        customerList.addlist(tempString.trim());
                        line++;
                    }

                    reader.close();

                } 
                catch (IOException e) 
                {
                    System.out.println("Unexpected I/O exception occurs");

                } 

            }
            else
            {
                throw new FileNotFoundException();

            }

        }
        catch(FileNotFoundException exception) 
        {                          
        } 

        File productlist = new File("ProductList.txt");
        try
        {
            if(productlist.exists())
            {                 
                BufferedReader reader = null;

                try 
                {

                    reader = new BufferedReader(new FileReader(productlist));
                    String tempString = null;
                    int line = 1;
                    while ((tempString = reader.readLine()) != null) 
                    {
                        createproduct(tempString);

                        line++;
                    }

                    reader.close();

                } 
                catch (IOException e) 
                {
                    System.out.println("Unexpected I/O exception occurs");

                } 

            }
            else
            {
                throw new FileNotFoundException();

            }

        }
        catch(FileNotFoundException exception) 
        {                          
        } 
        findDispose();
    }

    
    /**
     * Add a customer into the list if it's not exist in the list
     */
    public boolean addCustomerList(String a)
    {
        if (customerList.containlist(a))
            return false;
        else
        {
            customerList.addlist(a);
            
            return true;
        }  
    }

    
    /**
     * Remove the products to charity, if the charity is not exist,
     *  create a new charity
     */
    public void addCharity(String n, String address, String pID)
	 {
		 Product p =  findDisposeList(pID);
		 p.setDonate(true);
		 
		 Charity  c = containCharity(n, address);
		 if(c==null)
		 {
			 p.setBelongedCharity(n);
			 Charity tmp = new Charity(n,address);
			 tmp.addProduct(p);
		 charityList.add(tmp);
		 
		 }
		 else
		 {
			 p.setBelongedCharity(n);
			 c.addProduct(p);
		 }
	 }


    /**
     * Add the products to order, if the order list is empty,
     * add the products, if not, check the products which is the same as the
     * added one, if same, plus the quantity, if not, add a new item.
     */
	public void addProductToOrder(String ID,String qs)//merge
	{
		
	Product tmp = findExact(ID);
	     
	    if(tmplist.isEmpty())
	    	tmplist.add(new Product(ID,tmp.getName(),Integer.parseInt(qs),tmp.getPrice(),tmp.getonShelfDate(),tmp.getExpirydate(),tmp.getDonate(),tmp.getDiscount(),tmp.getType(),tmp.getForm(),tmp.getSource()));
	    else
	    {
	    	Product tmpfind = findExactTemp(ID);
	    
	    if(tmpfind ==null)
	    {
	    	tmplist.add(new Product(ID,tmp.getName(),Integer.parseInt(qs),tmp.getPrice(),tmp.getonShelfDate(),tmp.getExpirydate(),tmp.getDonate(),tmp.getDiscount(),tmp.getType(),tmp.getForm(),tmp.getSource()));
	    }                   		
	    else
		{
			 
	       tmp.setQuantity(tmpfind.getQuantity()+Integer.parseInt(qs));
	        
		}		
	}
	    
	                        
	}


    /**
     * Add the product list into the order.
     */
	public boolean addPListToOrder()
	{
		if(tmplist.isEmpty())
    		return false;
    	else
    	{
    	customer.addProduct(tmplist);
    	tmplist = new ArrayList<Product>();
    	return true;
    	}
	}


    /**
     * Owner creates a new products
     */
	public void createproduct(String a)
    {
       
        productList.addList(a);
        
    }
	
    /**
     * Check if the products is in expire date
     */
    public boolean compareDate(String a, String b)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy"); 
        try{
            Date bt=sdf.parse(a); 
            Date et=sdf.parse(b); 
            if (bt.before(et)||bt.equals(et))
            { 
                return true;
            }
            else
            { 
                return false;
            } 
        }
        catch(Exception e)
        {
            return false;
        }

    }


    /**
     * Create a products by owner
     */
    public String containProduct(String a)
	{
		 boolean tmpb;
	     String check[];
	     check = a.trim().split("/");
	     if(check[5].equals("true"))
	         tmpb = true;
	     else
	         tmpb = false;
	
	     for(Product i : productList.getList())
	     {
	         if(i.getName().equalsIgnoreCase((check[0])) &&            
	         i.getPrice()==(Double.parseDouble(check[2])) &&
	         i.getonShelfDate().equals(check[3]) &&
	         i.getExpirydate().equals(check[4]) &&
	         i.getDonate()==tmpb && 
	         i.getDiscount()==Integer.parseInt(check[6])//mark1
	         )
	         return i.getID();
	     }
	     return null;
	}


    /**
     * Searching the user account by owner
     */
	public ArrayList<String> containAccount(String a)
	{
		ArrayList<String> results = new ArrayList<String>();
	    for(Customer item : customerList.search(a))
	    {
	    	results.add(item.getID()+"/"+
	                            item.getName()
	                           );
	    }
	    return results;
		
	}


	/**
     * check if the charity is exist
     */
	public Charity containCharity(String n,String address)
	{
		 for(Charity i : charityList)
	        {
	            if(i.getName().equalsIgnoreCase(n) &&            
	            i.getAddress().equalsIgnoreCase(address)
	            
	            )
	            return i;
	        }
	
		
		
		return null;
	}


    /**
     * Customer delete the order
     */
	public void deleteOrder(String ID)
	 {
		 Order o = findExactOrder(ID);
		 customer.removeOrder(o);
		 for(Product p : o.getProductList())
		 {
			 findExact(p.getID()).addQuantity(p.getQuantity());
		 }
		 
	 }


    /**
     * Customer can change the quantity of the product when he view the cart
     */
	public void EditProduct(String a, int b)
	{
	    findExact(a).setQuantity(b);
	}


    /**
     * Owner edit the products' information
     */
	public void editProductDetail(String ID,String change)
	{
		String[] check = change.split("/");
		boolean tmpb;
		if(check[5].equals("true"))
			tmpb = true;
		else
			tmpb = false;
	    Product tmp = findExact(ID);
	    tmp.setName(check[0]);
	    tmp.setQuantity(check[1]);
	    tmp.setPrice(Double.parseDouble(check[2]));
	    tmp.setonShelfDate(check[3]);
	    tmp.setExpirydate(check[4]);        
	    tmp.setDonate(tmpb);
	    tmp.setDiscount(Integer.parseInt(check[6]));
	    tmp.setType(check[7]);
	    tmp.setSource(check[8]);
	    tmp.setForm(check[9]);
	
	
	}


    /**
     * User edit the individual information
     */
	public void editAccount(String n,String Pass, String address, String payment)
	 {
		 customer.setName(n);
		 customer.setPassword(Pass);
		 customer.setAddress(address);
		 customer.setPayment(payment);
	 }


    /**
     * User edit the product of the temporal product list
     */
	public void editTmpProduct(String a, String b)
	{
	    findExactTemp(a).setQuantity(b);
	}


    /**
     * Find the same product in adding products to order process
     */
	public Product findExact(String a)
    {
        
        for(Product i : productList.getList())
        {
            if(i.getID().equals(a)) 
                return i;
        }
        return null;
    }
    /**
     * Find the same product in adding products to order process in the temporal product list
     */
    public Product findExactTemp(String a)
    {
    	for(Product i : tmplist)
        {
            if(i.getID().equals(a)) 
                return i;
        }
        return null;
    }
    
    /**
     * Check if the product should be disposed
     */
    public void findDispose()
	 {
		 Calendar calendar = Calendar.getInstance();
			Date time = calendar.getTime();
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			//System.out.println(df.format(time).toString());
		 for(Product p : productList.getList() )
		 {
			 
			 if(!compareDate(df.format(time).toString(),p.getExpirydate()))
			 {
				 disposeList.add(p);
				 
			 }
			
		 }
		 if(!disposeList.isEmpty())
		 productList.getList().removeAll(disposeList);
		 	 
	 }


    /**
     * Find the exist order of customer
     */
	public Order findExactOrder(String a)
    {
    	for(Order i: customer.getOrderList(""))
    	{
    		if(i.getID().equals(a))
    			return i;
    	}
    	return null;
    }
	 
	/**
     * Find the disposed list of products
     */
    public Product findDisposeList(String a)
	 {
		 for(Product i : disposeList)
	     {
	         if(i.getID().equals(a)) 
	             return i;
	     }
	     return null;
	 }


    /**
     * Get quantity of the products in inventory
     */
	public int getQuantity(String a)
	{
		return findExact(a).getQuantity();
	}


	/**
     * Log in validation for users
     */
	public boolean login_validation(String a)
	{
		customer = customerList.ac_valid(a);
	
	
	    if( customer == null)                    
	    	return false;        	       	        	      
	    else
	    {
	    	
	    	return true;
	    }
	    	
	}


	/**
     * Date validation for products
     */
	public boolean isValidDate(String str) {
	    if(!(str.length()==10))
	    {
	        return false;
	    }
	    
	    else
	    {
	        
	        
	        
	            boolean convertSuccess = true;
	           
	            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	            try {
	                
	                format.setLenient(false);
	                format.parse(str);
	            } catch (Exception e) {
	                // e.printStackTrace();
	                
	                convertSuccess = false;
	            }
	
	            return convertSuccess;
	        
	    }
	}


	/**
     * Interger validation
     */
	public boolean isInteger(String str)
	{
		 Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); 
	        if(str.isEmpty())
	            return false;
	        else if(pattern.matcher(str).matches())
	            return true;
	        
	        else
	        	return false;
	}


	/**
     * Double validation
     */
	public boolean isDouble(String str) 
	{
		if (null == str || "".equals(str)) 
		{	
			return false;	
			}	
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");	
		return pattern.matcher(str).matches();
	}


	/**
     * Set the state of the order.
     * If the order is paid or not
     */
	public boolean orderPaid(String n)
	 {
		 for(Order o : customer.getOrderList(""))
		 {
			 if(o.getID().equals(n))
			 {
				 if(o.getPaid()==true)
				 {
					 return true;
				 }
			 }
		 }
		 return false;
	 }


	/**
     * Customer purchase the order
     */
public void purchase(String a)
 {
	 
	 findExactOrder(a).setPaid(true);
 }

/**
 * Owner remove the users from user list
 */
 public void removeAC(String a)
{
    String[] tmp = a.split("/");
    
    for (Iterator<Customer> iterator = customerList.getlist().iterator(); iterator.hasNext(); ) {
        
    	 if(tmp[0].equals(iterator.next().getID())) 
    	 {
            iterator.remove();
        }      
}
}


 /**
  * Owner remove the users from product list
  */
public void removeproduct(String a)
{
	
    productList.remove(findExact(a));
    
}


/**
 * User remove the products from shopping cart
 */
public void removeTmpproduct(String a)
{
	tmplist.remove(findExactTemp(a));
}

/**
 * Owner delete the product
 */
public void removeDisposeProduct(String id)
{
	disposeList.remove(findDisposeList(id));
}

/**
 * Show the records of the disposed products
 */
public void returnDisposeList(DefaultListModel<String> model, ArrayList<String> searchID, String name)
 {
	
	 
 	if(name.trim().isEmpty())
 	{
 	for(Product item: disposeList)
 	{
 		String donate="";
    	if(!item.getBelongedCharity().trim().isEmpty())
    		donate =  "Donateated to "+ item.getBelongedCharity();
    	String tmp= item.getType()+"/"+item.getName()+"/"+
                item.getQuantity()+ " "+ item.getForm()+ "/" +
                item.getPrice() +" AUD per "+item.getForm()+"/"+"Donateate: " + item.getDonate()+"/"+                        
                "Expiry: "+item.getExpirydate()+"/"+ donate; 
    			model.addElement(tmp);
    			searchID.add(item.getID());
 		
 	
 	}
 	}
 	else
 	{
 		 try
 	        { Pattern pattern = Pattern.compile(name,Pattern.CASE_INSENSITIVE);
 	            for(Product item: disposeList)
 	            {
 	            	 
 	                
 	                Matcher matcher = pattern.matcher(item.getName());
 	                if(matcher.find())
 	                {        
 	                	String donate="";
 	                	if(!item.getBelongedCharity().trim().isEmpty())
 	           			donate =  "Donateated to "+ item.getBelongedCharity();
 	           			String tmp= item.getType()+"/"+item.getName()+"/"+
 	                    item.getQuantity()+ " "+ item.getForm()+ "/" +
 	                    item.getPrice() +" AUD per "+item.getForm()+"/"+"Donateate: " + item.getDonate()+"/"+                        
 	                    "Expiry: "+item.getExpirydate()+"/"+ donate;
 	           			model.addElement(tmp);
 	           			searchID.add(item.getID());
 	                               
 	                }
 	            }
 	        }
 	        catch(Exception e)
 	        {
 	        }
 	}
 	
 }

/**
 * return the information of products
 */
public String returnProductInfo(String id)
{
	Product p = findExact(id);
	String tmp = p.getName()+"/"+
	p.getQuantity()+"/"+p.getPrice()+"/"+p.getonShelfDate()+"/"+p.getExpirydate()+"/"+p.getDiscount()+"/"+p.getSource()+"/"+p.getType()+"/"+p.getDonate();
		return tmp;
	}


/**
 * return the information of products in shopping cart
 */
public void returnShopCart(DefaultListModel<String> model, ArrayList<String> searchID, String name)
{
	
	if(name.trim().isEmpty())
	{
	for(Product item: tmplist)
	{
		
		String tmp= item.getName()+"/"+
                item.getQuantity()+"/"+                
                item.getonShelfDate()+"/"+
                item.getExpirydate()+"/"+ "total: " + (item.getQuantity()
            	*0.01
            	*item.getPrice() * item.getDiscount())
            	+ " AUD";
       
        	model.addElement(tmp);
        	searchID.add(item.getID());
	}
	}
	else
	{
		 try
	        { Pattern pattern = Pattern.compile(name,Pattern.CASE_INSENSITIVE);
	            for(Product item: tmplist)
	            {
	            	 
	                
	                Matcher matcher = pattern.matcher(item.getName());
	                if(matcher.find())
	                {          String tmp= item.getName()+"/"+ "Quantity: "+
	                        item.getQuantity()+"/"+                
	                        item.getonShelfDate()+"/"+
	                        item.getExpirydate()+"/"+ "total: " + (item.getQuantity()
	                    	*0.01
	                    	*item.getPrice() * item.getDiscount())
	                    	+ " AUD"+ "/"+ item.getID();
	               
	                	model.addElement(tmp);
	                	searchID.add(item.getID());
	                               
	                }
	            }
	        }
	        catch(Exception e)
	        {
	        }
	}
	
}


/**
 * return the order list
 */
public void returnOrderList(DefaultListModel<String> model, ArrayList<String> searchID, String name)//contain null
{
	  ArrayList<Order> results = new ArrayList<Order>();
	  

		for(Order o : customer.getOrderList(name))
        {
			
			 String item ="";
             for(Product p : o.getProductList())
 			{
            	 item+=p.getName()+",";
 			}
             item += "/"+ o.getTotal() +" AUD" +"/"+ "Paid: "+o.getPaid()+"/"+o.getCreateTime();
             model.addElement(item);
             searchID.add(o.getID());
           	
        }
		    	                                              
	
}


/**
 * return the product list
 */
public void returnProductList(DefaultListModel<String> model, ArrayList<String> searchID, String name)
{
	
	for(Product item : productList.search(name))
    {
    	String tmp= item.getType()+"/"+item.getName()+"/"+
                item.getQuantity()+ " "+ item.getForm()+ "/" +
                item.getPrice()+"/"+ 
                item.getonShelfDate()+"/"+
                item.getExpirydate()+"/"+ item.getSource() + "/" +   
                item.getDonate() + "/" +
                item.getDiscount();                       	
        	model.addElement(tmp);
        	searchID.add(item.getID());                   
    }
	
}


/**
 * return user's product
 */
public void returnUserProduct(DefaultListModel<String> model, ArrayList<String> searchID, String name)
{
	
    for(Product item: productList.userSearch(name))
    {
    	String tmp= item.getType()+": "+item.getName()+"/"+ "Available: " +
                item.getQuantity()+ " "+ item.getForm()+ "/" + "Price: "+
                item.getPrice()+" per "+item.getForm()+"/" + "Discount: " +                                 
                item.getDiscount() + " %" +"/"+
                item.getonShelfDate()+"/"+
                item.getExpirydate()+"/"+ item.getSource() ;
    			model.addElement(tmp);
    			searchID.add(item.getID());
    }
   
}

public void unregister()
{
	customerList.remove(customer);
}

/**
 * The attribute of the product
 * whether it can be donated
 */
public boolean whetherDonated(String id)
{
	
		 for(Product p : disposeList)
	     {
	         if(p.getID().equals(id))
	         {
	        	 if(!p.getBelongedCharity().trim().isEmpty())
	        		 return true;
	         }
	        	 
	     }
	     return false;
	 
}
    
}
