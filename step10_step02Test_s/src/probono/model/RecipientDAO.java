/*
 * CREATE TABLE recipient (
       recipient_id         VARCHAR2(20) PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       receiveHopeContent   VARCHAR2(50) NULL
);
 */
package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import probono.model.dto.RecipientDTO;
import probono.model.entity.RecipientEntity;
import probono.model.util.DBUtil;
import probono.model.util.PublicCommon;

public class RecipientDAO {
	
//	public static boolean addRecipient(RecipientDTO recipient) throws SQLException{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try{
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("insert into recipient values(?, ?, ?, ?)");
//			pstmt.setString(1, recipient.getId());
//			pstmt.setString(2, recipient.getName());
//			pstmt.setString(3, recipient.getPassword());
//			pstmt.setString(4, recipient.getReceiveContent());
//			
//			int result = pstmt.executeUpdate();
//		
//			if(result == 1){
//				return true;
//			}
//		}finally{
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
	
	public static boolean addRecipient(RecipientEntity recipient) throws Exception{
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try{
			em.persist(recipient);
			tx.commit();
			return true;
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
		
	}

	//수정 로직
	// 프로젝트 명으로 내용 수정하기
	public static boolean updateRecipient(String receiveId, String receiveHopeContent) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update recipient set receiveHopeContent=? where recipient_id=?");
			pstmt.setString(1, receiveHopeContent);
			pstmt.setString(2, receiveId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}


	//삭제 로직
	public static boolean deleteRecipient(String receiveId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from recipient where recipient_id=?");
			pstmt.setString(1, receiveId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
//	public static boolean deleteRecipient(String receiveId) {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		try{
//			RecipientDTO temp1 = em.find(RecipientDTO.class,receiveId);
//			em.remove(temp1);
//			tx.commit();
//			return true;
//		} catch(EntityExistsException e) {
//			return false;
//		} finally {
//			em.close();
//		}
//	}

//	public static RecipientDTO getRecipient(String receiveId, EntityManager em) throws SQLException{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		RecipientDTO recipient = null;
//		
//		try{
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("select * from recipient where recipient_id=?");
//			pstmt.setString(1, receiveId);
//			rset = pstmt.executeQuery();
//			if(rset.next()){
//				recipient = new RecipientDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
//			}
//		}finally{
//			DBUtil.close(con, pstmt, rset);
//		}
//		return recipient;
//	}
	
	public static RecipientEntity getRecipient(String receiveId) throws Exception{
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.find(RecipientEntity.class, receiveId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			em.close();
		}
	}

	public static List<RecipientDTO> getAllRecipients() throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.createNativeQuery("select * from recipient", RecipientEntity.class).getResultList();
		}finally {
			em.close();
		}
	}
	
//	public static ArrayList<RecipientDTO> getAllRecipients() throws SQLException{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<RecipientDTO> list = null;
//		try{
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("select * from recipient");
//			rset = pstmt.executeQuery();
//			
//			list = new ArrayList<RecipientDTO>();
//			while(rset.next()){
//				list.add(new RecipientDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
//			}
//		}finally{
//			DBUtil.close(con, pstmt, rset);
//		}
//		return list;
//	}
}
