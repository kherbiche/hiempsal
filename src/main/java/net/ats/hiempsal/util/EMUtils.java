////////////////////////////////////////////////////////////////////////////////////
//
// This following class utilizes an EntityMangerFactory, EntityManger, ThreadLocal
// to manage persistence and transaction in the application for.
//
// The net.ats.hiempsal.util.EMUtils program needs the EntityMangerFactory bean,
// in order to create EntityManager instance.
//
// Method syntax:
//     EntityManager getEm(String url)
//
////////////////////////////////////////////////////////////////////////////////////

package net.ats.hiempsal.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

import net.ats.hiempsal.user.UserRepository;

/**
 * 
 * @author L KHERBICHE
 */
@Component
public class EMUtils {
	@Autowired
	@Qualifier("h2dbEMF")
	private EntityManagerFactory emfh2;
	private static final ThreadLocal<EntityManager> threadLocalEnityManagerH2;
	private EntityManager emh2;
	static {
		threadLocalEnityManagerH2 = new ThreadLocal<EntityManager>();
	}
	public EntityManager getEM() {
		emh2 = threadLocalEnityManagerH2.get();
		if(emh2 == null) {
			emh2 = emfh2.createEntityManager();
			threadLocalEnityManagerH2.set(emh2);
		}
		return emh2;
	}
	public UserRepository getUserRepo(){
	        return new JpaRepositoryFactory(getEM()).getRepository(UserRepository.class);
	}
}
