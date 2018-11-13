import java.util.ArrayList;
import java.util.UUID;
public class Charity {
private String name;
private String address;
private String id;

ArrayList<Product> productList ;
public Charity()
{
	name = "";
	address = "";
	id="";
	
	}
public Charity(String n, String address)
{
	id=UUID.randomUUID().toString().replace("-", "");
	this.name=n;
	this.address=address;
	productList = new ArrayList<Product>();
}
public Charity(String n, String address, Product p)
{
	id=UUID.randomUUID().toString().replace("-", "");
	this.name=n;
	this.address=address;
	productList = new ArrayList<Product>();
	
}
public void addProduct(Product p)
{
	productList.add(p);
}

public boolean containProduct(String id)
{
	for(Product p: productList)
	{
		if(p.getID().equals(id))
			return true;
	}
	return false;
}

public ArrayList<Product> getProductList()
{
	return productList;
	}

public String getName()
{
	return name;
	}

public String getAddress()
{
	return address;
	}
public String getID()
{
	return id;
	}

}
