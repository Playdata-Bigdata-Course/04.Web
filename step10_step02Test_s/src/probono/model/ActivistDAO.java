/* CREATE TABLE activist (
       activist_id          VARCHAR2(20)  PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       major                VARCHAR2(50) NULL
);  */
package probono.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import probono.model.dto.ActivistDTO;
import probono.model.entity.ActivistEntity;
import probono.model.util.PublicCommon;

@Slf4j
public class ActivistDAO {

	// 기부자 추가
	public static boolean addActivist(ActivistEntity activist) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(activist);
			tx.commit();
			log.info("addActivist 성공");
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.warn("addActivist 오류");
			throw e;
		} finally {
			em.close();
		}
	}

	// 수정
	// 기부자 id로 주요 기부 내용 수정하기
	public static boolean updateActivist(String activistId, String major) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("update activist set major=? where activist_id=?").setParameter(1, major)
					.setParameter(2, activistId).executeUpdate();
			tx.commit();
			log.info("updateActivist 성공");
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.warn("updateActivist 오류");
			throw e;
		} finally {
			em.close();
		}

	}

	// 기부자 삭제
	public static boolean deleteActivist(String activistId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.createNativeQuery("delete from activist where activist_id=?").setParameter(1, activistId)
					.executeUpdate();
			tx.commit();
			log.info("deleteActivist 성공");
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.warn("deleteActivist 오류");
			throw e;
		} finally {
			em.close();
		}
	}

	// id로 해당 기부자의 모든 정보 반환
	public static ActivistEntity getActivist(String activistId) throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			log.info("getActivist 성공");
			return em.find(ActivistEntity.class, activistId);

		} catch (Exception e) {
			log.warn("getActivist 오류");
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}

	// 모든 기부자 검색해서 반환
	public static List<ActivistDTO> getAllActivists() throws Exception {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			log.info("getAllActivists 성공");
			return em.createNativeQuery("select * from activist", ActivistEntity.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("getAllActivists 오류");
			throw e;
		} finally {
			em.close();
		}
	}
}
