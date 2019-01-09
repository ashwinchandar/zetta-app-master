package com.zetta.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zetta.app.dbconnection.DBConnection;
import com.zetta.app.util.DateUtil;
import com.zetta.app.vo.FileVo;

public class FileUploadDAO {

	static Connection con;
	static PreparedStatement ps;
	
	public void insertUploadfile(FileVo fv) {
		int count=0;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into fileupload (filename,filepath,created_date,created_by,updated_date,updated_by) values (?,?,?,?,?,?)");
			/*String filename=fv.getFileName().contains(".")?fv.getFileName().substring(0, fv.getFileName().lastIndexOf('.')):"";*/
			/*ps.setString(++count, filename);*/
			ps.setString(++count, fv.getFileName()); 
			ps.setString(++count, fv.getFilePath());
			long time = System.currentTimeMillis(); 
			ps.setTimestamp(++count, new java.sql.Timestamp(time)); 
			ps.setString(++count, fv.getCreatedBy());
			ps.setTimestamp(++count, new java.sql.Timestamp(time));
			ps.setString(++count, fv.getUpdatedBy());
			System.out.println("Fileupload insert" +ps.toString());
			ps.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con); 
		}
	}
	
	public List<FileVo> getFileupload(){
		List<FileVo> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from fileupload");
			rs = ps.executeQuery();
			while(rs.next()) {
				FileVo fv = new FileVo();
				fv.setFileId(rs.getInt("file_id"));
				fv.setFileName(rs.getString("filename"));
				fv.setFilePath(rs.getString("filepath"));
				fv.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				fv.setCreatedBy(rs.getString("created_by")); 
				fv.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
				fv.setUpdatedBy(rs.getString("updated_by")); 
				list.add(fv);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
	}
	
	public List<FileVo> getFileuploadlist(){
		List<FileVo> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from fileupload order by updated_date DESC");
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("fileuploadlistDAo");
				FileVo fv = new FileVo();
				fv.setFileId(rs.getInt("file_id"));
				fv.setFileName(rs.getString("filename"));
				fv.setFilePath(rs.getString("filepath"));
				fv.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				fv.setCreatedBy(rs.getString("created_by")); 
				fv.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
				fv.setUpdatedBy(rs.getString("updated_by"));
				list.add(fv);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
	}
	
	public FileVo deleteFileupload(Integer fileid) {
		FileVo fv = new FileVo(); 
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("Delete from fileupload where file_id=?");
			ps.setInt(1, fileid);
			System.out.println("FUDAO: "+ps.toString());
			ps.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
		return fv;
		
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
	public void  closeConnectionrspscon(ResultSet rs, PreparedStatement ps, Connection con) {
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
