package nl.okbetalen.warehousemanagement.dao;

import nl.okbetalen.warehousemanagement.entity.UserInfo;

/**
 * 
 * @author dillipkumar.vp
 *
 */

@FunctionalInterface
public interface IUserInfoDAO {
	
	/**
	 * Fetch the User Details from in-mem Datbase for the given User Name.
	 * @param userName
	 * @return
	 */
	UserInfo getActiveUser(String userName);
}