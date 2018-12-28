package com.zetta.app.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zetta.app.dbconnection.DBConnection;
import com.zetta.app.util.DateUtil;
import com.zetta.app.vo.AdminBean;
import com.zetta.app.vo.EmployeeBean;
import com.zetta.app.vo.RoleVO;

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
			ps.setDate(++count, new Date(DateUtil.getDateFromStringinup(ab.getDob()).getTime())); 
			ps.setString(++count, ab.getDepartment());
			ps.setString(++count, ab.getDesignation());
			ps.setString(++count, ab.getEmail());
			ps.setBigDecimal(++count, ab.getMobile()!=null && !ab.getMobile().trim().isEmpty()?new BigDecimal(ab.getMobile().trim()):new BigDecimal("0"));
			ps.setString(++count, ab.getLocation());
			ps.setString(++count, ab.getRole().trim());
			ps.setString(++count, ab.getPassword1()); 
			System.out.println("Admin:" +ps.toString());
			ps.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			 closeConnectionpscon(ps, con);
		}
	}
	
	public void updateAdmin(AdminBean ab) {
		int count=0;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("UPDATE admin_register SET admin_name=?,dob=?,department=?,designation=?,email=?,mobile=?,location=?,role=?,password1=? WHERE admin_card_no=?");
			ps.setString(++count, ab.getName());
			ps.setDate(++count, new Date(DateUtil.getDateFromStringinup(ab.getDob()).getTime()));
			ps.setString(++count, ab.getDepartment());
			ps.setString(++count, ab.getDesignation());
			ps.setString(++count, ab.getEmail());
			ps.setBigDecimal(++count, ab.getMobile()!=null && !ab.getMobile().trim().isEmpty()?new BigDecimal(ab.getMobile().trim()):new BigDecimal("0"));
			ps.setString(++count, ab.getLocation());
			ps.setString(++count, ab.getRole().trim());
			ps.setString(++count, ab.getPassword1()); 
			ps.setString(++count, ab.getAdmin_card_no()); 
			/*System.out.println("AdminDAO Spring Update:" +ps.toString());*/
			ps.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			 closeConnectionpscon(ps, con);
		}
	}
	
	public AdminBean getAdmin(String adminid, String pass) { 
		AdminBean ab = new AdminBean();
		ResultSet rs=null;
		try { 
			con=DBConnection.getConnection();
			ps=con.prepareStatement("SELECT * FROM admin_register WHERE admin_card_no=? and password1=?");
			ps.setString(1, adminid);
			ps.setString(2, pass);
			rs=ps.executeQuery(); 
			while(rs.next()) {  
				ab.setAdmin_card_no(rs.getString("admin_card_no"));
				ab.setName(rs.getString("admin_name").trim());
				ab.setDob(rs.getString("dob"));
				ab.setDepartment(rs.getString("department"));
				ab.setDesignation(rs.getString("designation"));
				ab.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				ab.setMobile(bigdecimal.toString());
				ab.setLocation(rs.getString("location"));
				ab.setRole(rs.getString("role").trim());
				ab.setPassword1(rs.getString("password1"));  
			}  
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return ab;
	}
	
	public AdminBean editAdmin(String adminid) {
		AdminBean ab = new AdminBean();
		ResultSet rs = null;
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement("SELECT * FROM admin_register WHERE admin_card_no=?");
			ps.setString(1, adminid);
			rs=ps.executeQuery();
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
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			 closeConnectionrspscon(rs, ps, con);
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
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnectionpscon(ps, con);
		}
		return ab;
	}
	
	public List<AdminBean> getAdmins(){
		List<AdminBean> list = new ArrayList<>();
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin_register");
			/*ps.setString(1, role);*/
			rs = ps.executeQuery();
			while(rs.next()) {
				/*System.out.println("getAdmins list in admindao");*/
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 closeConnectionrspscon(rs, ps, con);
		} 
		return list;  
	}
	
	public List<AdminBean> getAdminz(String role){
		List<AdminBean> list = new ArrayList<>();
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin_register where role=?");
			ps.setString(1, role);
			rs = ps.executeQuery();
			while(rs.next()) {
				/*System.out.println("getAdmins list in admindao");*/
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 closeConnectionrspscon(rs, ps, con);
		} 
		return list;  
	}
	
	public String getRole(String role){
		System.out.println("role dao:" +role);
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM role WHERE role=?");
			ps.setString(1, role.trim());
			System.out.println("role dao ps:" +ps.toString());
			rs = ps.executeQuery();
			if(rs.next()) {  
				System.out.println("role dao rs:" +rs.getString("access"));
				return rs.getString("access"); 
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 closeConnectionrspscon(rs, ps, con);
		} 
		return "";  
	}
	
	
	public List<AdminBean> getEmployeeBirthday() {
		List<AdminBean> list = new ArrayList<>(); 
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin_register " + 
					"WHERE " + 
					"    DATE_PART('day', dob) = date_part('day', CURRENT_DATE) " + 
					"AND " + 
					" DATE_PART('month', dob) = date_part('month', CURRENT_DATE);");
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminBean ab = new AdminBean();
				ab.setAdmin_card_no(rs.getString("admin_card_no"));
				ab.setName(rs.getString("admin_name"));
				ab.setDob(rs.getString("dob"));
				ab.setDepartment(rs.getString("department"));
				ab.setDesignation(rs.getString("designation"));
				ab.setEmail(rs.getString("email"));  
				list.add(ab);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con); 
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnectionrspscon(rs, ps, con);
		} 
		return isValid; 
	}
	
	public void closeConnectionpscon(PreparedStatement ps, Connection con) {
		try {
			if(ps!=null) {
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnectionrspscon(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
