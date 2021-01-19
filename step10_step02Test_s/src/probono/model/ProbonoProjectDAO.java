/*
CREATE TABLE probono_project (
	   probono_project_id     		NUMBER(5) PRIMARY KEY,
	   probono_project_name 		VARCHAR2(50) NOT NULL,
       probono_id           			VARCHAR2(50) NOT NULL,       
       activist_id          				VARCHAR2(20) NOT NULL,
       receive_id           				VARCHAR2(20) NOT NULL, 
       project_content      			VARCHAR2(100) NOT NULL
);   */
package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.entity.ProbonoProjectEntity;
import probono.model.util.DBUtil;
import probono.model.util.PublicCommon;

@Slf4j
public class ProbonoProjectDAO {

	// 프로젝트 추가
	public static boolean addProbonoProject(ProbonoProjectEntity probonoProject) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(probonoProject);
			tx.commit();
			log.info("addProbonoProject 성공");
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.warn("addProbonoProject 오류");
			throw e;
		} finally {
			em.close();
		}
	}

	// 수정
	// 프로보노 프로젝트 id로 재능기부자 수정
	public static boolean updateProbonoProjectActivist(int probonoProjectId, String activistId) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			em.createNativeQuery("update probono_project set activist_id=? where probono_project_id=?")
					.setParameter(1, activistId).setParameter(2, probonoProjectId).executeUpdate();
			tx.commit();
			log.info("updateProbonoProjectActivist 성공");
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.warn("updateProbonoProjectActivist 오류");
			throw e;
		} finally {
			em.close();
		}

	}

	// 수정
	// 프로보노 프로젝트 id로 수해자 정보 변경
	public static boolean updateProbonoProjectReceive(int probonoProjectId, String receiveId) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			em.createNativeQuery("update probono_project set receive_id=? where probono_project_id=?")
					.setParameter(1, receiveId).setParameter(2, probonoProjectId).executeUpdate();
			tx.commit();
			log.info("updateProbonoProjectReceive 성공");
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.warn("updateProbonoProjectReceive 오류");
			throw e;
		} finally {
			em.close();
		}

	}

	// 삭제
	// 프로보노 프로젝트 id로 프로보노 프로젝트 삭제
	public static boolean deleteProbonoProject(int probonoProjectId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("delete from probono_project where probono_project_id=?")
					.setParameter(1, probonoProjectId).executeUpdate();
			tx.commit();
			log.info("deleteProbonoProject 성공");
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.warn("deleteProbonoProject 오류");
			throw e;
		} finally {
			em.close();
		}
	}

	// 프로젝트id로 해당 프로젝트의 모든 정보 반환
	public static ProbonoProjectEntity getProbonoProject(int probonoProjectId) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			log.info("getProbonoProject 성공");
			return em.find(ProbonoProjectEntity.class, probonoProjectId);
		} catch (Exception e) {
			log.warn("getProbonoProject 오류");
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}
	
	// 모든 프로젝트 검색해서 반환
	public static List<ProbonoProjectDTO> getAllProbonoProjects() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProbonoProjectDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from probono_project");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ProbonoProjectDTO>();
			while(rset.next()){
				list.add( new ProbonoProjectDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6)) );
			}
			
			System.out.println(list.size());
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
		}
	
}
