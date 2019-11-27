package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//class ProductDAO1{
public class ProductDAO1 {
	 //Vector listProduct() {
	public Vector listProduct() {
		Vector items = new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			StringBuilder sb=new StringBuilder();
			sb.append("select prod_no, address, prod_name, company, prod_date,"); 
			sb.append("DAY, price, amount, (price*amount) total from product1");
			pstmt=conn.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Vector row= new Vector();
				String prod_no=rs.getString("prod_no");
				String address=rs.getString("address");
				String prod_name=rs.getString("prod_name");
				String company=rs.getString("company");
				String prod_date=rs.getString("prod_date");
				String day=rs.getString("day");
				int price=rs.getInt("price");
				int amount=rs.getInt("amount");
				int total=rs.getInt("total");
				row.add(prod_no);
				row.add(address);
				row.add(prod_name);
				row.add(company);
				row.add(prod_date);
				row.add(day);
				row.add(price);
				row.add(amount);
				row.add(total);
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return items;
	}//listProduct()
	
	 int insertProduct(ProductDTO1 dto) {
	//public int insertProduct(ProductDTO1 dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			StringBuilder sb=new StringBuilder();
			sb.append("insert into product1(prod_no,address,");
			sb.append("prod_name,company,prod_date,day,price,amount) ");
			sb.append(" values(?,?,?,?,?,?,?,?)");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getProd_no());
			pstmt.setString(2, dto.getAddress());
			pstmt.setString(3, dto.getProd_name());
			pstmt.setString(4, dto.getCompany());
			pstmt.setString(5, dto.getProd_date());
			pstmt.setString(6, dto.getDay());
			pstmt.setInt(7, dto.getPrice());
			pstmt.setInt(8, dto.getAmount());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}//insertProduct()
	 
	 int updateProduct(ProductDTO1 dto) {
	//public int updateProduct(ProductDTO1 dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			StringBuilder sb=new StringBuilder();
			sb.append("update product1 ");
			sb.append(" set address=?,prod_name=?,company=?");
			sb.append(",prod_date=?, day=?, price=?, amount=? ");
			sb.append("where prod_no=?");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getAddress());
			pstmt.setString(2, dto.getProd_name());
			pstmt.setString(3, dto.getCompany());
			pstmt.setString(4, dto.getProd_date());
			pstmt.setString(5, dto.getDay());
			pstmt.setInt(6, dto.getPrice());
			pstmt.setInt(7, dto.getAmount());
			pstmt.setString(8, dto.getProd_no());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}//updateProduct()
	
	 public ProductDTO1 viewProduct(String prod_no) {
	 //ProductDTO1 viewProduct(String prod_no) {
		ProductDTO1 dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			StringBuilder sb=new StringBuilder();
			sb.append("select prod_no,address,prod_name,company,prod_date,");
			sb.append("day,price,amount,(price*amount) total from product1 ");
			sb.append(" where prod_no=?");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, prod_no);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String address=rs.getString("address");
				String prod_name=rs.getString("prod_name");
				String company=rs.getString("company");
				String prod_date=rs.getString("prod_date");
				String day=rs.getString("day");
				int price=rs.getInt("price");
				int amount=rs.getInt("amount");
				dto=new ProductDTO1(prod_no,address,prod_name,company,prod_date,day,price,amount);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}//finally
		return dto;
	}//viewProduct()
	
	//public int deleteProduct(String prod_no) {
	 int deleteProduct(String prod_no) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
		conn=DB.dbConn();
		StringBuilder sb=new StringBuilder();
		sb.append("delete from product1 where prod_no=?");
		pstmt=conn.prepareStatement(sb.toString());
		pstmt.setString(1, prod_no);
		result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//finally
		return result;
	}//deleteProduct()
	
	//public Vector searchProduct(String prod_name) {
	 Vector searchProduct(String prod_name) {
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			StringBuilder sb=new StringBuilder();
			sb.append("select prod_no,address,prod_name,company,prod_date,day,price,amount,(price*amount) total ");
			sb.append(" from product1 where prod_name like ?");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, "%"+prod_name+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector row=new Vector();
				row.add(rs.getString("prod_no"));
				row.add(rs.getString("address"));
				row.add(rs.getString("prod_name"));
				row.add(rs.getString("company"));
				row.add(rs.getString("prod_date"));
				row.add(rs.getString("day"));
				row.add(rs.getString("price"));
				row.add(rs.getString("amount"));
				row.add(rs.getString("total"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return items;
	}//searchProduct()
}

