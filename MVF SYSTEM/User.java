import java.util.UUID;

/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    // instance variables - replace the example below with your own
    private String id;
    private String name;
    private String password;
    private String address;
    private String payment;
    /**
     * Constructor for objects of class User
     */
    public User()
    {
        
        id = "";
        name = "";
        password = "";
        address = "";
        payment = "";
    }
    
    public User(String name, String pass, String a, String p)
    {
        
    	id=UUID.randomUUID().toString().replace("-", "");
        this.name = name;
        password = pass;
        address = a;
        payment = p;
    }
    
    public User(String id, String name, String pass, String a, String p)
    {
        
        this.id = id;
        this.name = name;
        password = pass;
        address = a;
        payment = p;
    }

     public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public String getID()
    {
        return id;
    }
    
    public String getPayment()
    {
        return payment;
    }
        
    public void setName(String a)
    {
        name = a;
    }
    
    public void setPassword(String a)
    {
        password = a;
    }
    
    public void setAddress(String a)
    {
        address = a;
    }
    
    public void setPayment(String a)
    {
        payment = a;
    }
    
    
}
