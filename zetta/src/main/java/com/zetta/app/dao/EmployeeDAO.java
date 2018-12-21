package com.zetta.app.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zetta.app.vo.EmployeeBean;
import com.zetta.app.dbconnection.DBConnection;
import com.zetta.app.util.DateUtil;

public class EmployeeDAO {

	static Connection con;
	static PreparedStatement ps;
	
	public void insertEmployee(EmployeeBean eb) {
		int count=0;
		try {
			 con=DBConnection.getConnection();
			 ps=con.prepareStatement("INSERT INTO employee_register(emp_card_no,name,dob,department,designation,email,mobile,location) VALUES(?,?,?,?,?,?,?,?)");
			 ps.setString(++count, eb.getEmp_card_no());
			 ps.setString(++count, eb.getName().trim());
			 ps.setDate(++count, new Date(DateUtil.getDateFromString(eb.getDob()).getTime()));
			 ps.setString(++count, eb.getDepartment());
			 ps.setString(++count, eb.getDesignation());
			 ps.setString(++count, eb.getEmail());
			 ps.setBigDecimal(++count, eb.getMobile()!=null && !eb.getMobile().trim().isEmpty()?new BigDecimal(eb.getMobile().trim()):new BigDecimal("0"));
			 ps.setString(++count, eb.getLocation());
			 ps.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			  closeConnectionpscon(ps, con);
			} 
	}
	
	public void updateEmployee(EmployeeBean eb) {
		int count=0;
		try {
			 con=DBConnection.getConnection();
			 ps=con.prepareStatement("UPDATE employee_register SET name=?,dob=?,department=?,designation=?,email=?,mobile=?,location=? WHERE emp_card_no=?");
			 ps.setString(++count, eb.getName().trim());
			 ps.setDate(++count, new Date(DateUtil.getDateFromString(eb.getDob()).getTime()));
			 ps.setString(++count, eb.getDepartment());
			 ps.setString(++count, eb.getDesignation());
			 ps.setString(++count, eb.getEmail());
			 ps.setBigDecimal(++count, eb.getMobile()!=null && !eb.getMobile().trim().isEmpty()?new BigDecimal(eb.getMobile().trim()):new BigDecimal("0"));
			 ps.setString(++count, eb.getLocation());
			 ps.setString(++count, eb.getEmp_card_no()); 
			 ps.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			 closeConnectionpscon(ps, con);
		}
	}
	
	
	public List<EmployeeBean> getEmployees(){
		List<EmployeeBean> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM employee_register ");
			rs=ps.executeQuery();
			while(rs.next()) {
				EmployeeBean eb = new EmployeeBean();
				eb.setEmp_card_no(rs.getString("emp_card_no"));
				eb.setName(rs.getString("name"));
				eb.setDob(rs.getString("dob"));
				eb.setDepartment(rs.getString("department"));
				eb.setDesignation(rs.getString("designation"));
				eb.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				eb.setMobile(bigdecimal.toString());
				eb.setLocation(rs.getString("location")); 
				list.add(eb);
			} 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			 closeConnectionrspscon(rs, ps, con);
			}
		return list; 
	} 

	
	public EmployeeBean editEmployee(String employeeid) {
		ResultSet rs = null;
		EmployeeBean eb=new EmployeeBean();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM employee_register WHERE emp_card_no=?");
			ps.setString(1, employeeid);
			rs=ps.executeQuery();
			while(rs.next()) { 
				eb.setEmp_card_no(rs.getString("emp_card_no"));
				eb.setName(rs.getString("name"));
				eb.setDob(rs.getString("dob"));
				eb.setDepartment(rs.getString("department"));
				eb.setDesignation(rs.getString("designation"));
				eb.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				eb.setMobile(bigdecimal.toString());
				eb.setLocation(rs.getString("location")); 
			} 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return eb;  
	}
	
	
	public EmployeeBean deleteEmployee(String employeeid) {
		EmployeeBean eb = new EmployeeBean();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM employee_register WHERE emp_card_no=?");
			ps.setString(1, employeeid);
			ps.executeUpdate(); 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		} 
		return eb;
	}
	
	public List<EmployeeBean> getEmployeeBirthday() {
		List<EmployeeBean> list = new ArrayList<>();
		
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM employee_register " + 
					"WHERE " + 
					"    DATE_PART('day', dob) = date_part('day', CURRENT_DATE) " + 
					"AND " + 
					" DATE_PART('month', dob) = date_part('month', CURRENT_DATE);");
			rs = ps.executeQuery();
			while(rs.next()) {
				EmployeeBean eb = new EmployeeBean();
				eb.setEmp_card_no(rs.getString("emp_card_no"));
				eb.setName(rs.getString("name"));
				eb.setDob(DateUtil.getDatetoString(rs.getString("dob")));
				eb.setDepartment(rs.getString("department"));
				eb.setDesignation(rs.getString("designation"));
				eb.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				eb.setMobile(bigdecimal.toString());
				eb.setLocation(rs.getString("location")); 
				list.add(eb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con); 
		}
		return list; 
	}
	
	public void closeConnectionpscon(PreparedStatement ps, Connection con) {
		try { 
			if(ps!=null) {
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch(Exception e) {
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
