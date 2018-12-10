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
			ps = con.prepareStatement("INSERT INTO knowledgebase (category,topic,subject,created_date,created_by,updated_date,updated_by) VALUES(?,?,?,?,?,?,?)");
			ps.setString(++count, kb.getCategory());
			ps.setString(++count, kb.getTopic());
			ps.setString(++count, kb.getSubject());
			long time = System.currentTimeMillis(); 
			ps.setTimestamp(++count, new java.sql.Timestamp(time)); 
			ps.setString(++count, kb.getCreatedBy());
			ps.setTimestamp(++count, new java.sql.Timestamp(time));
			ps.setString(++count, kb.getUpdatedBy());
			System.out.println("insert" +ps.toString());
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
			ps = con.prepareStatement("UPDATE knowledgebase SET category=?,topic=?,subject=?,updated_date=?,updated_by=? WHERE knowledge_id=?");
			System.out.println("know BEFORE" + ps.toString());
			ps.setString(++count, kb.getCategory());
			ps.setString(++count, kb.getTopic().trim());
			ps.setString(++count, kb.getSubject().trim());
			long time = System.currentTimeMillis();
			ps.setTimestamp(++count, new java.sql.Timestamp(time));
			ps.setString(++count, kb.getUpdatedBy());
			ps.setInt(++count, kb.getKnowledgeid()); 
			System.out.println("know Upbate" + ps.toString()); 
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
				System.out.println("Knowledge List AAA");
				KnowledgeBean kb = new KnowledgeBean();
				kb.setKnowledgeid(rs.getInt("knowledge_id"));
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setCreatedDate(rs.getString("created_date"));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(rs.getString("updated_date"));
				kb.setUpdatedBy(rs.getString("updated_by")); 
				list.add(kb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
	}
	
	public List<KnowledgeBean> getKBbyCategory(String category){
		List<KnowledgeBean> list = new ArrayList<>();
		ResultSet rs=null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM knowledgebase where category=? order by updated_date DESC");
			ps.setString(1, category); 
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("know category: " + ps.toString());
				KnowledgeBean kb = new KnowledgeBean();
				kb.setKnowledgeid(rs.getInt("knowledge_id"));
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setCreatedDate(rs.getString("created_date"));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(rs.getString("updated_date"));
				kb.setUpdatedBy(rs.getString("updated_by")); 
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
			ps = con.prepareStatement("SELECT * FROM knowledgebase order by updated_date DESC"); 
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("know updated date" + ps.toString());
				KnowledgeBean kb = new KnowledgeBean();
				kb.setKnowledgeid(rs.getInt("knowledge_id"));
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setCreatedDate(rs.getString("created_date"));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(rs.getString("updated_date"));
				kb.setUpdatedBy(rs.getString("updated_by"));
				
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
				System.out.println("know edit knowledge id" + ps.toString());
				kb.setKnowledgeid(knowledgeid);
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setCreatedDate(rs.getString("created_date"));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(rs.getString("updated_date"));
				kb.setUpdatedBy(rs.getString("updated_by"));
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
