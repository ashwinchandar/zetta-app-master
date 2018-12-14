package com.zetta.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zetta.app.dbconnection.DBConnection;
import com.zetta.app.vo.OrganizationVO;

public class OrgUploadDAO {
	static Connection con;
	static PreparedStatement ps;
	
	public void insertOrgfile(OrganizationVO ov) {
		int count=0; 
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into orgupload (filename,filepath,created_date,created_by,updated_date,updated_by) values (?,?,?,?,?,?)");
			ps.setString(++count, ov.getFileName());
			ps.setString(++count, ov.getFilePath());
			long time = System.currentTimeMillis(); 
			ps.setTimestamp(++count, new java.sql.Timestamp(time)); 
			ps.setString(++count, ov.getCreatedBy());
			ps.setTimestamp(++count, new java.sql.Timestamp(time));
			ps.setString(++count, ov.getUpdatedBy());
			ps.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
			 
		}
	}
	
	public List<OrganizationVO> getOrgList(){
		List<OrganizationVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from orgupload");
			rs = ps.executeQuery();
			while(rs.next()) {
				OrganizationVO ov = new OrganizationVO();
				ov.setOrgId(rs.getInt("org_id"));
				ov.setFileName(rs.getString("filename"));
				ov.setFilePath(rs.getString("filepath"));
				ov.setCreatedDate(rs.getString("created_date"));
				ov.setCreatedBy(rs.getString("created_by"));
				ov.setUpdatedDate(rs.getString("updated_date"));
				ov.setUpdatedBy(rs.getString("updated_by")); 
				list.add(ov);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
	}
	
	public List<OrganizationVO> getOrgLists(){
		List<OrganizationVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from orgupload order by updated_date DESC");
			rs = ps.executeQuery();
			while(rs.next()) {
				OrganizationVO ov = new OrganizationVO();
				ov.setOrgId(rs.getInt("org_id"));
				ov.setFileName(rs.getString("filename"));
				ov.setFilePath(rs.getString("filepath"));
				ov.setCreatedDate(rs.getString("created_date"));
				ov.setCreatedBy(rs.getString("created_by"));
				ov.setUpdatedDate(rs.getString("updated_date"));
				ov.setUpdatedBy(rs.getString("updated_by")); 
				list.add(ov);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
	}
	
	public OrganizationVO deleteOrgFile(Integer orgId) {
		OrganizationVO ov = new OrganizationVO();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("delete from orgupload where org_id=?");
			ps.setInt(1, orgId);
			ps.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
		return ov;
		
				
	}
	
	public void closeConnectionrspscon(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void closeConnectionpscon(PreparedStatement ps, Connection con) {
		try { 
			if(ps!=null){
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
