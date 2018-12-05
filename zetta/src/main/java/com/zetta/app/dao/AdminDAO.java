package com.zetta.app.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zetta.app.dbconnection.DBConnection;
import com.zetta.app.util.DateUtil;
import com.zetta.app.vo.AdminBean;

public class AdminDAO {

	static Connection con;
	static PreparedStatement ps;
	
	public void insertAdmin(AdminBean ab) {
		int count=0;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO admin_register(admin_card_no,admin_name,dob,department,designation,email,mobile,location,role,password1) VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(++count, ab.getAdmin_card_no());
			ps.setString(++count, ab.getName());
			ps.setDate(++count, new Date(DateUtil.getDateFromString(ab.getDob()).getTime()));
			ps.setString(++count, ab.getDepartment());
			ps.setString(++count, ab.getDesignation());
			ps.setString(++count, ab.getEmail());
			ps.setBigDecimal(++count, ab.getMobile()!=null && !ab.getMobile().trim().isEmpty()?new BigDecimal(ab.getMobile().trim()):new BigDecimal("0"));
			ps.setString(++count, ab.getLocation());
			ps.setString(++count, ab.getRole().trim());
			ps.setString(++count, ab.getPassword1()); 
			System.out.println("Admin:" +ps.toString());
			ps.executeUpdate();
			con.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateAdmin(AdminBean ab) {
		int count=0;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("UPDATE admin_register SET admin_name=?,dob=?,department=?,designation=?,email=?,mobile=?,location=?,role=?,password1=? WHERE admin_card_no=?");
			ps.setString(++count, ab.getName());
			ps.setDate(++count, new Date(DateUtil.getDateFromString(ab.getDob()).getTime()));
			ps.setString(++count, ab.getDepartment());
			ps.setString(++count, ab.getDesignation());
			ps.setString(++count, ab.getEmail());
			ps.setBigDecimal(++count, ab.getMobile()!=null && !ab.getMobile().trim().isEmpty()?new BigDecimal(ab.getMobile().trim()):new BigDecimal("0"));
			ps.setString(++count, ab.getLocation());
			ps.setString(++count, ab.getRole().trim());
			ps.setString(++count, ab.getPassword1()); 
			ps.setString(++count, ab.getAdmin_card_no()); 
			System.out.println("AdminDAO Spring Update:" +ps.toString());
			ps.executeUpdate();
			con.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		}
	}
	
	public AdminBean getAdmin(String adminid, String pass) {
		
		AdminBean ab = new AdminBean();
		try {
			
			con=DBConnection.getConnection();
			ps=con.prepareStatement("SELECT * FROM admin_register WHERE admin_card_no=? and password1=?");
			ps.setString(1, adminid);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			/*System.out.println("psdao: " + ps.toString());*/
			
			while(rs.next()) {  
				ab.setAdmin_card_no(rs.getString("admin_card_no"));
				ab.setName(rs.getString("admin_name"));
				ab.setDob(rs.getString("dob"));
				ab.setDepartment(rs.getString("department"));
				ab.setDesignation(rs.getString("designation"));
				ab.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				ab.setMobile(bigdecimal.toString());
				ab.setLocation(rs.getString("location"));
				ab.setRole(rs.getString("role"));
				ab.setPassword1(rs.getString("password1")); 
				 
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		}
		return ab;
	}
	
	public AdminBean editAdmin(String adminid) {
		AdminBean ab = new AdminBean();
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement("SELECT * FROM admin_register WHERE admin_card_no=?");
			ps.setString(1, adminid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ab.setAdmin_card_no(rs.getString("admin_card_no"));
				ab.setName(rs.getString("admin_name"));
				ab.setDob(rs.getString("dob"));
				ab.setDepartment(rs.getString("department"));
				ab.setDesignation(rs.getString("designation"));
				ab.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				ab.setMobile(bigdecimal.toString());
				ab.setLocation(rs.getString("location"));
				ab.setRole(rs.getString("role"));
				ab.setPassword1(rs.getString("password1")); 
			} 
			con.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		} 
		return ab;
	}
	
	public AdminBean deleteAdmin(String adminid) {
		AdminBean ab = new AdminBean();
		try {
			con=DBConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM admin_register WHERE admin_card_no=?");
			ps.setString(1, adminid);
			ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		}
		return ab;
	}
	
	public List<AdminBean> getAdmins(){
		List<AdminBean> list = new ArrayList<>();
		 
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin_register");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("getAdmins list in admindao");
				AdminBean ab = new AdminBean();
				ab.setAdmin_card_no(rs.getString("admin_card_no"));
				ab.setName(rs.getString("admin_name"));
				ab.setDob(rs.getString("dob"));
				ab.setDepartment(rs.getString("department"));
				ab.setDesignation(rs.getString("designation"));
				ab.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				ab.setMobile(bigdecimal.toString());
				ab.setLocation(rs.getString("location"));
				ab.setRole(rs.getString("role"));
				ab.setPassword1(rs.getString("password1")); 
				list.add(ab);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		}
		
		return list;  
	}
	
	public boolean validateLogin(String adminid, String pass) {
		boolean isValid = false;
		ResultSet rs = null;
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement("SELECT * FROM admin_register WHERE admin_card_no=? and password1=?");
			ps.setString(1, adminid);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()) {
			AdminBean ab = new AdminBean();
			ab.setAdmin_card_no(rs.getString("admin_card_no"));
			ab.setRole(rs.getString("role"));
			isValid=true;
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		}
		
		return isValid;
		
	}
	
}
