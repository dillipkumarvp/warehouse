package nl.okbetalen.warehousemanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.okbetalen.warehousemanagement.entity.UserInfo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Implementation class to fetch the USER INFO details.
 * 
 * @author dillipkumar.vp
 *
 */

@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.dao.IUserInfoDAO#getActiveUser(java.lang.String)
	 */
	@Override
	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		short enabled = 1;
		List<?> list = entityManager
				.createQuery(
						"SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
				.setParameter(1, userName).setParameter(2, enabled)
				.getResultList();
		if (!list.isEmpty()) {
			activeUserInfo = (UserInfo) list.get(0);
		}
		return activeUserInfo;
	}
}