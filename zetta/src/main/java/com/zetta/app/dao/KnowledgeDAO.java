package com.zetta.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zetta.app.dbconnection.DBConnection; 
import com.zetta.app.vo.KnowledgeBean;

public class KnowledgeDAO {

	static Connection con;
	static PreparedStatement ps;
	
	public void insertKnowledgebase(KnowledgeBean kb) {
		int count=0;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO knowledgebase (category,topic,subject,date) VALUES(?,?,?,?)");
			ps.setString(++count, kb.getCategory());
			ps.setString(++count, kb.getTopic());
			ps.setString(++count, kb.getSubject());
			long time = System.currentTimeMillis(); 
			ps.setTimestamp(++count, new java.sql.Timestamp(time));
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		} 
	}
	
	public void updateKnowldegebase(KnowledgeBean kb) {
		int count=0;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("UPDATE knowledgebase SET category=?,topic=?,subject=? WHERE knowledge_id=?");
			ps.setString(++count, kb.getCategory());
			ps.setString(++count, kb.getTopic());
			ps.setString(++count, kb.getSubject());
			long time = System.currentTimeMillis();
			ps.setTimestamp(++count, new java.sql.Timestamp(time));
			ps.setInt(++count, kb.getKnowledgeid());
			ps.executeUpdate(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
	}
	
	public List<KnowledgeBean> getKnowledgebases(){
		List<KnowledgeBean> list = new ArrayList<>();
		ResultSet rs=null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM knowledgebase");
			rs = ps.executeQuery();
			while(rs.next()) {
				KnowledgeBean kb = new KnowledgeBean();
				kb.setKnowledgeid(rs.getInt("knowledge_id"));
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setDate(rs.getString("date"));
				list.add(kb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
	}
	
	public List<KnowledgeBean> getknowledgebaselist(){
		List<KnowledgeBean> list = new ArrayList<>(); 
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM knowledgebase order by date DESC"); 
			rs = ps.executeQuery();
			while(rs.next()) {
				KnowledgeBean kb = new KnowledgeBean();
				kb.setKnowledgeid(rs.getInt("knowledge_id"));
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setDate(rs.getString("date"));
				list.add(kb); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public KnowledgeBean editKnowledgebase(Integer knowledgeid) {
		KnowledgeBean kb = new KnowledgeBean();
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM knowledgebase WHERE knowledge_id=?");
			ps.setInt(1, knowledgeid);
			rs=ps.executeQuery();
			while(rs.next()) {
				kb.setKnowledgeid(knowledgeid);
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setDate(rs.getString("date"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return kb;
	}
	
	public KnowledgeBean deleteKnowledgebase(Integer knowledgeid) {
		KnowledgeBean kb = new KnowledgeBean();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM knowledgebase WHERE knowledge_id=?");
			ps.setInt(1, knowledgeid);
			ps.executeQuery(); 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
		return kb;
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
