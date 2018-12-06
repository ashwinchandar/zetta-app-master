package com.zetta.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.zetta.app.dbconnection.DBConnection;
import com.zetta.app.vo.AnnounceBean;


public class AnnounceDAO {
	static Connection con;
	static PreparedStatement ps;
	
	public void insertAnnouncement(AnnounceBean ab) {
		int count=0;
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement("INSERT INTO announcement(title,announcement,date) VALUES(?,?,?)");
			ps.setString(++count, ab.getTitle());
			ps.setString(++count, ab.getAnnouncement());
			long time = System.currentTimeMillis(); 
			ps.setTimestamp(++count, new java.sql.Timestamp(time)); 
			/*java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());*/
			ps.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
	}
	
	public void updateAnnouncement(AnnounceBean ab) {
		int count=0;
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement("UPDATE announcement SET title=?,date=?,announcement=? where announce_id=?");
			ps.setString(++count, ab.getTitle()); 
			ps.setDate(++count, new java.sql.Date(Calendar.getInstance().getTime().getTime()));  
			ps.setString(++count, ab.getAnnouncement());
			ps.setInt(++count, ab.getAnnounceid());
			ps.executeUpdate(); 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
	}
	
	public List<AnnounceBean> getAnnouncements(){
		List<AnnounceBean> list = new ArrayList<>();
		ResultSet rs=null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM announcement order by date DESC limit 3");
			rs=ps.executeQuery();
			while(rs.next()) {
				AnnounceBean ab=new AnnounceBean();
				ab.setAnnounceid(rs.getInt("announce_id"));
				ab.setTitle(rs.getString("title"));
				ab.setAnnouncement(rs.getString("announcement"));
				ab.setDate(rs.getString("date"));
				list.add(ab);
			} 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			 closeConnectionrspscon(rs, ps, con); 
		}
		return list; 
	}
	
	public List<AnnounceBean> getAnnouncementslist(){
		List<AnnounceBean> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM announcement order by date DESC");
			rs=ps.executeQuery();
			while(rs.next()) {
				AnnounceBean ab=new AnnounceBean();
				ab.setAnnounceid(rs.getInt("announce_id"));
				ab.setTitle(rs.getString("title"));
				ab.setAnnouncement(rs.getString("announcement"));
				ab.setDate(rs.getString("date"));
				list.add(ab);
			} 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			 closeConnectionrspscon(rs, ps, con);
		}
		return list; 
	}
	
	public AnnounceBean editAnnouncement(Integer announceid) {
		AnnounceBean ab = new AnnounceBean();
		ResultSet rs = null;
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement("SELECT * FROM announcement WHERE announce_id=?");
			ps.setInt(1, announceid);
			rs=ps.executeQuery();
			while(rs.next()) {
				ab.setAnnounceid(announceid);
				ab.setTitle(rs.getString("title"));
				ab.setAnnouncement(rs.getString("announcement"));
				ab.setDate(rs.getString("date"));
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			 closeConnectionrspscon(rs, ps, con);
		}
		return ab;
	}
	
	public AnnounceBean deleteAnnouncement(Integer announceid) {
		AnnounceBean ab = new AnnounceBean();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM announcement WHERE announce_id=?");
			ps.setInt(1, announceid);
			ps.executeQuery(); 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
		return ab;
		
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
