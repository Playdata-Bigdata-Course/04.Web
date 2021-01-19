package probono.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PublicCommon {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("step10_step02Test_s");
		log.warn("DB 접속");
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		log.warn("Entity Manager 리턴");
		return em;
	}
	
	public static void close() {
		emf.close();	
		log.warn("DB 접속 해제");
	}
}
