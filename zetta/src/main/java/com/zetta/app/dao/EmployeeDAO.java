package com.zetta.app.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			 con.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
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
			 con.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public List<EmployeeBean> getEmployees(){
		List<EmployeeBean> list = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM employee_register");
			ResultSet rs=ps.executeQuery();
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
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
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
	
	public EmployeeBean editEmployee(String employeeid) {
		EmployeeBean eb=new EmployeeBean();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM employee_register WHERE emp_card_no=?");
			ps.setString(1, employeeid);
			ResultSet rs=ps.executeQuery();
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
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
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
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		} 
		return eb;
	}
	
}
