import java.util.UUID;

/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
	private String ID;
    private String name;
    private int stockQuantity;
    private double price;
    private String onShelfDate;
    private String expirydate;
    private int discount;
    private boolean donate;
    //the type of product can be fruits or vegetables
    private String type;
    //the source of the product can be overseas or local
    private String source;
    //the form of the product can unit, kg or unit/pakage
    private String form;
    private String belongedCharity;
    

    /**
     * Constructor for objects of class Product
     */
    public Product()
    {
        // initialise instance variables
        name = "";
        stockQuantity = 0;
        price = 0;
        onShelfDate = "";
        expirydate = "";
        discount = 0;
        donate = false;
        belongedCharity="";
    }
    
    public Product(String n, int q, double p, String md, String exp, boolean don, int dis, String type, String form, String source)
    {
    	ID=UUID.randomUUID().toString().replace("-", "");
        name = n;
        stockQuantity = q;
        price = p;
        onShelfDate = md;
        expirydate = exp;
        donate = don;
        discount = dis;
        this.type = type;
        this.form = form;
        this.source =source;
        belongedCharity="";
    }
    
    public Product(String ID, String n, int q, double p, String md, String exp, boolean don, int dis, String type, String form, String source)
    {    	
    	this.ID = ID;
        name = n;
        stockQuantity = q;
        price = p;
        onShelfDate = md;
        expirydate = exp;
        donate = don;
        discount = dis;
        this.type = type;
        this.form = form;
        this.source =source;
        belongedCharity="";
    }
    
    public String getType()
    {
    	return type;
    }
    
    public String getForm()
    {
    	return form;
    }
    
    public String getSource()
    {
    	return source;
    }
    
    public String getID()
    {
    	return ID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getQuantity()
    {
        return stockQuantity;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public String getonShelfDate()
    {
        return onShelfDate;
    }
    
    public String getExpirydate()
    {
        return expirydate;
    }
    
    public boolean getDonate()
    {
        return donate;
    }
    
    public int getDiscount()
    {
        return discount;
    }
    public String getBelongedCharity()
    {
    	return belongedCharity;
    }
    
    public void setBelongedCharity(String c)
    {
    	belongedCharity = c;
    }
    public void setName(String a)
    {
        name = a;
    }
    
    public void setQuantity(String a)
    {
    	
        stockQuantity = Integer.parseInt(a);
    }
    
    public void setQuantity(int a)
    {
    	
        stockQuantity = a;
    }
    public void addQuantity(int a)
    {
    	
        stockQuantity += a;
    }
    
    public void setPrice(double a)
    {
        price = a;
    }
    
    public void setonShelfDate(String a)
    {
        onShelfDate = a;
    }
    
    public void setExpirydate(String a)
    {
        expirydate = a;
    }
    
    public void setDonate(boolean a)
    {
        donate = a;
    }
    
    public void setDiscount(int a)
    {
        discount = a;
    }
    public void setType(String a)
    {
        type = a;
    }
    
    public void setSource(String a)
    {
        source = a;
    }
    
    public void setForm(String a)
    {
        form = a;
    }
}
