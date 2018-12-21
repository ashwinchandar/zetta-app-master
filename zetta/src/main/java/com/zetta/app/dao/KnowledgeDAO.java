package com.zetta.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zetta.app.dbconnection.DBConnection;
import com.zetta.app.util.DateUtil;
import com.zetta.app.vo.KnowledgeBean;
import com.zetta.app.vo.KnowledgeReplyVO;

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
	
	public void insertKnowledgeReply(KnowledgeReplyVO rvo) {
		int count=0;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("insert into knowledge_reply(topic_id,topic,reply,created_date,created_by,updated_date,updated_by) values(?,?,?,?,?,?,?)");
			ps.setInt(++count, rvo.getTopicid());
			ps.setString(++count, rvo.getTopic());
			ps.setString(++count, rvo.getReply());
			long time = System.currentTimeMillis(); 
			ps.setTimestamp(++count, new java.sql.Timestamp(time)); 
			ps.setString(++count, rvo.getCreatedBy());
			ps.setTimestamp(++count, new java.sql.Timestamp(time));
			ps.setString(++count, rvo.getUpdatedBy());
			System.out.println("Replyinsert :" +ps.toString());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
	}
	
	public List<KnowledgeReplyVO> getKnowledgereply(Integer topic){
		List<KnowledgeReplyVO> list = new ArrayList<>();
		ResultSet rs=null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("Select * from knowledge_reply where topic_id=? order by updated_date DESC");
			ps.setInt(1, topic);
			rs = ps.executeQuery();
			while(rs.next()) {
				KnowledgeReplyVO kvo = new KnowledgeReplyVO();
				kvo.setTopicid(rs.getInt("topic_id"));
				kvo.setTopic(rs.getString("topic"));
				kvo.setReply(rs.getString("reply")); 
				kvo.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				kvo.setCreatedBy(rs.getString("created_by"));
				kvo.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
				kvo.setUpdatedBy(rs.getString("updated_by"));
				list.add(kvo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
	}
	
	public List<KnowledgeReplyVO> getListKnowledgereply(){
		List<KnowledgeReplyVO> list = new ArrayList<>();
		ResultSet rs=null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("Select * from knowledge_reply order by updated_date DESC"); 
			rs = ps.executeQuery();
			while(rs.next()) {
				KnowledgeReplyVO kvo = new KnowledgeReplyVO();
				kvo.setTopicid(rs.getInt("topic_id"));
				kvo.setTopic(rs.getString("topic"));
				kvo.setReply(rs.getString("reply")); 
				kvo.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				kvo.setCreatedBy(rs.getString("created_by"));
				kvo.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
				kvo.setUpdatedBy(rs.getString("updated_by"));
				list.add(kvo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}
		return list;
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
				kb.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
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
				kb.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
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
	public List<KnowledgeBean> getKBbyTopic(String topic){
		List<KnowledgeBean> list = new ArrayList<>();
		ResultSet rs=null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM knowledgebase where topic=? order by updated_date DESC");
			ps.setString(1, topic); 
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("know topic: " + ps.toString());
				KnowledgeBean kb = new KnowledgeBean();
				kb.setKnowledgeid(rs.getInt("knowledge_id"));
				kb.setCategory(rs.getString("category"));
				kb.setTopic(rs.getString("topic"));
				kb.setSubject(rs.getString("subject"));
				kb.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
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
				kb.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
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
				kb.setCreatedDate(DateUtil.getDatetoString(rs.getString("created_date")));
				kb.setCreatedBy(rs.getString("created_by")); 
				kb.setUpdatedDate(DateUtil.getDatetoString(rs.getString("updated_date")));
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
			ps.executeUpdate(); 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
		return kb;
	}  
	
	public KnowledgeReplyVO deleteReply(Integer topicid, String topic) {
		 KnowledgeReplyVO kvo = new KnowledgeReplyVO();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM knowledge_reply WHERE topic_id=? and topic=?");
			ps.setInt(1, topicid);
			ps.setString(2, topic);
			System.out.println("reply: " +ps.toString());
			ps.executeUpdate(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionpscon(ps, con);
		}
		return kvo;  
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
