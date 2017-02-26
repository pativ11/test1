package com.whirlpool.wcloud.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.AccountsDao;
import com.whirlpool.wcloud.db.dashdb.dao.impl.DashDbGenericDaoImpl;
import com.whirlpool.wcloud.model.AccountCreation;

@Component
@Configuration
@ComponentScan(basePackages = { "com.whirlpool.wcloud" })
public class AccountsDaoImpl extends DashDbGenericDaoImpl implements AccountsDao {

	final Logger logger = Logger.getLogger(AccountsDaoImpl.class);

	@Override
	public void createAccount(AccountCreation account) {

		System.out.println("************Reached here************");
		String Pswd = account.getAccount().getUserAccount().getPassword();
		MessageDigest md = null;
		String hashPswd = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(Pswd.getBytes());
			hashPswd = md.toString();
			System.out.println("hashed Password is " + hashPswd);
			int accountId = getKey(INSERT_ACCOUNTS,
					new Object[] { account.getAccount().getUserAccount().getCompanyId(),
							account.getAccount().getUserAccount().getLanguageId(),
							account.getAccount().getUserAccount().getStatus_id(),
							account.getAccount().getUserAccount().getFirst_name(),
							account.getAccount().getUserAccount().getLast_name(),
							account.getAccount().getUserAccount().getEmail(),
//							account.getAccount().getUserAccount().getPassword(),
							 hashPswd,
							account.getAccount().getUserAccount().getEmail_confirmed_at(),
							account.getAccount().getUserAccount().getSigned_in_count(),
							account.getAccount().getUserAccount().getCurrent_signed_in_at(),
							account.getAccount().getUserAccount().getLast_signed_in_at(),
							account.getAccount().getUserAccount().getLocked_at(),
							account.getAccount().getUserAccount().getReset_password_sent_at(),
							account.getAccount().getUserAccount().getConfirmation_sent_at(),
							account.getAccount().getUserAccount().getPhoneNumber(),
							account.getAccount().getUserAccount().getCreated_at(),
							account.getAccount().getUserAccount().getUpdated_at(),
							account.getAccount().getUserAccount().getM2m_user_id(),
							account.getAccount().getUserAccount().getNotification_id() });
			System.out.println("Account id is :: " + accountId);
			System.out.println("Brand id is :: " + account.getAccount().getBrand().getBrandId());
			insert(INSERT_ACCOUNT_BRANDS, new Object[] { account.getAccount().getBrand().getBrandId(), accountId });
			insert(INSERT_LOCATION, new Object[] { account.getAccount().getLocation().getCity(), accountId,
					account.getAccount().getLocation().getState(), account.getAccount().getLocation().getPostalCode(),
					account.getAccount().getLocation().getCreatedAt(),
					account.getAccount().getLocation().getUpdatedAt(),
					account.getAccount().getLocation().getElevation(), account.getAccount().getLocation().getLatitude(),
					account.getAccount().getLocation().getLocaleId(),
					account.getAccount().getLocation().isSmartEnergy(),
					account.getAccount().getLocation().getLocationName(),
					account.getAccount().getLocation().getLongitude(),
					account.getAccount().getLocation().getLoyaltyId(),
					account.getAccount().getLocation().getRatePlanCode(),
					account.getAccount().getLocation().getRatePlanId(), account.getAccount().getLocation().getStatus(),
					account.getAccount().getLocation().getStreet(),
					account.getAccount().getLocation().getSecondLineAddress(),
					account.getAccount().getLocation().getUtilityName(),
					account.getAccount().getLocation().getUtilityId() });

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getKey(final String queryString, final Object[] params) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(queryString, new String[] { "ACCOUNT_ID" });
				ps.setInt(1, (Integer) params[0]);
				ps.setInt(2, (Integer) params[1]);
				ps.setInt(3, (Integer) params[2]);
				ps.setString(4, (String) params[3]);
				ps.setString(5, (String) params[4]);
				ps.setString(6, (String) params[5]);
				ps.setString(7, (String) params[6]);
				ps.setTimestamp(8, (Timestamp) params[7]);
				ps.setInt(9, (Integer) params[8]);
				ps.setTimestamp(10, (Timestamp) params[9]);
				ps.setTimestamp(11, (Timestamp) params[10]);
				ps.setTimestamp(12, (Timestamp) params[11]);
				ps.setTimestamp(13, (Timestamp) params[12]);
				ps.setTimestamp(14, (Timestamp) params[13]);
				ps.setString(15, (String) params[14]);
				ps.setTimestamp(16, (Timestamp) params[15]);
				ps.setTimestamp(17, (Timestamp) params[16]);
				ps.setInt(18, (Integer) params[17]);
				ps.setInt(19, (Integer) params[18]);

				return ps;
			}
		}, keyHolder);
		System.out.println("Keyholder key value is : " + keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
		
	}

	@Override
	public List getAccounts() {

		// String sql = "select * from accounts";
		LoggerUtil.logMessage(logger, "AccountsDaoImpl : getAccounts : executing " + SELECT_ACCOUNTS);

		List list = select(SELECT_ACCOUNTS);

		LoggerUtil.logMessage(logger, "AccountsDaoImpl : getAccounts : Number Of accounts retrieved:   " + list.size());
		LoggerUtil.logMessage(logger, "AccountsDaoImpl : getAccounts : end : returning  " + list);
		return list;
	}

	@Override
	public List get(int accountId) {

		String sql = "select * from account where account_id = ?";

		List list = get(sql, new Object[] { accountId });
		// System.out.println(list.size());
		return list;
	}

	@Override
	public void updateLanguagePref(int accountId, String language) {

		List<Map<String, Integer>> status = getStatus(SELECT_STATUS, new Object[] { accountId });
		int statusId = status.get(0).get("STATUS_ID");
		if (statusId == 1) {
			update(UPDATE_LANGUAGE, new Object[] { language, accountId });
		}
	}

	@Override
	public void logout(int accountId) {
		// Hirens revoke api
		// RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		// RestTemplate restTemplate = restTemplateBuilder.build();
		// restTemplate.execute("Hiren's url", HttpMethod.POST, requestCallback,
		// responseExtractor, uriVariables);
	}

	@Override
	public List getusername() {
		List list = null;
		return list;
	}

	@Override
	public String getBrand() {
		return null;
	}

	@Override
	public List getEmailTimestamp(int accountId) {

		String sql = "select timestampdiff(2,char(current timestamp - (select confirmation_sent_at from account where account_id= ?)))from sysibm.sysdummy1";

		List stamp = get(sql, new Object[] { accountId });

		// Timestamp list = get(sql, new Object[]{accountId});
		// System.out.println(list.size());
		return stamp;
	}

	@Override
	public void updateStatus(int accountId, int statusID) {
		String sql = "update account SET EMAIL_CONFIRMED_AT= CURRENT TIMESTAMP, UPDATED_AT = CURRENT TIMESTAMP,STATUS_ID = ? WHERE ACCOUNT_ID = ?";

		update(sql, new Object[] { statusID, accountId });

	}
}
