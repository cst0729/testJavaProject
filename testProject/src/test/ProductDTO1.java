package test;

public class ProductDTO1 {
	private String prod_no,address,prod_name,company,prod_date,day;
	private int price, amount, total;
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProd_date() {
		return prod_date;
	}
	public void setProd_date(String prod_date) {
		this.prod_date = prod_date;
	}	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ProductDTO1() {
		
	}
	public ProductDTO1(String prod_no, String address, String prod_name, String company, String prod_date, String day, int price,
			int amount) {
		this.prod_no = prod_no;
		this.address = address;
		this.prod_name = prod_name;
		this.company = company;
		this.prod_date = prod_date;
		this.day = day;
		this.price = price;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ProductDTO [prod_no=" + prod_no + ", address=" + address + ", prod_name=" + prod_name + ", company="
				+ company + ", prod_date=" + prod_date + ", day=" + day + ", price=" + price + ", amount=" + amount
				+ ", total=" + total + "]";
	}

}
