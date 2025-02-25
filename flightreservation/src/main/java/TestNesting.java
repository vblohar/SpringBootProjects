import java.util.ArrayList;
import java.util.List;

class Portfolio {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", name=" + name + "]";
	}
	
}

class Address {
	
}

class User {
	int id;
	String name;
	
	List<Address> addresses;
	
	List<Portfolio> portfolios = new ArrayList();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Portfolio> getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", portfolios=" + portfolios + "]";
	}
		
}


public class TestNesting {
	
	public static void main(String[] args) {
		
		User user1 = new User();
		user1.setId(100);
		user1.setName("Sarang");
		
		System.out.println(user1);
		
		Portfolio p1 = new Portfolio();
		p1.setId(10);
		p1.setName("Penny Stocks");
		
		Portfolio p2 = new Portfolio();
		p2.setId(11);
		p2.setName("NSE Stocks");

		Portfolio p3 = new Portfolio();
		p3.setId(12);
		p3.setName("Bluechips Stocks");
		
		List list = user1.getPortfolios();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		
		System.out.println(user1);
		
		doOperationOnUser(user1);
	}
	
	
	private static void doOperationOnUser(User user) {
		System.out.println(user);
	}
}