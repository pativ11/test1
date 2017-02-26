package com.whirlpool.wcloud.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.whirlpool.wcloud.app.BootApplication;
import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.MembersDao;
import com.whirlpool.wcloud.db.dashdb.dao.impl.DashDbGenericDaoImpl;
import com.whirlpool.wcloud.model.Account;
import com.whirlpool.wcloud.model.Members;

@Component
@Configuration
@ComponentScan(basePackages = { "com.whirlpool.wcloud" })
public class MembersDaoImpl extends DashDbGenericDaoImpl implements MembersDao {

	final Logger logger = Logger.getLogger(MembersDaoImpl.class);

	@Override
	public List getMembers() {

		// String sql = "select * from members";
		LoggerUtil.logMessage(logger, "AccountsDaoImpl : getAccounts : executing " + SELECT_ACCOUNTS);

		List list = select(SELECT_ACCOUNTS);

		LoggerUtil.logMessage(logger, "AccountsDaoImpl : getAccounts : Number Of accounts retrieved:   " + list.size());
		LoggerUtil.logMessage(logger, "AccountsDaoImpl : getAccounts : end : returning  " + list);
		return list;
	}

	@Override
	public List get(int id) {

		String sql = "select * from account where ACCOUNT_ID=?";

		List list = get(sql, new Object[] { id });
		return list;
	}

	@Override
	public void updateMember(Members member, int accountId) {
		// TODO Auto-generated method stub
		LoggerUtil.logMessage(logger, "MembersDaoImpl : updateMember : executing " + UPDATE_ACCOUNT);

		//String sql = "update account set (First_name, Last_name, Email, Phone_number) VALUES (?,?,?,?) where ACCOUNT_ID=?";

		update(UPDATE_ACCOUNT, new Object[] { member.getFirst_name(),member.getLast_name(),member.getEmail(),member.getPhone_number(),accountId });

	}

	@Override
	public List deleteMember(int id) {
		LoggerUtil.logMessage(logger, "MembersDaoImpl : deleteMember : executing " + DELETE_ACCOUNT);

		String sql = "delete from account where ACCOUNT_ID=?";

		List list = get(sql, new Object[] { id });

		return list;
	}

	@Override
	public List getMember() {

		LoggerUtil.logMessage(logger, "MembersDaoImpl : getCurrentMember : executing " + SELECT_CURRENTACCOUNT);

		String sql = "select * from account";

		List list = get(sql, new Object[] {});

		return list;

	}

	@Override
	public void createMember(Members member) {

		LoggerUtil.logMessage(logger, "MembersDaoImpl : createMember : executing " + INSERT_ACCOUNTS);

		//String sql = "INSERT INTO account (First_name, Last_name, Email, Phone_no) VALUES (?,?,?,?)";

		 insert(INSERT_ACCOUNTS, new Object[] { member.getId(),member.getCompany_id(),member.getLanguage_id(),member.getStatus_id(),member.getFirst_name(),
		 member.getLast_name(), member.getEmail(),member.getPassword(),member.getEmail_confirmed_at(),member.getSigned_in_count(),member.getCurrent_sign_in_at(),
		 member.getLast_sign_in_at(),member.getLocked_at(),member.getReset_password_sent_at(),member.getConfirmation_sent_at(),member.getPhone_number(),
		 member.getCreated_at(),member.getUpdated_at(),member.getM2m_user_id(),member.getNotification_id()});
		 
		//List list = get(sql, new Object[] {member});
		//return list;

	}

	@Override
	public boolean isMembersExist(Members member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getAccounts() {

		LoggerUtil.logMessage(logger, "MembersDaoImpl : getAccounts : executing " + SELECT_LOCATIONACCOUNTS);

		String sql = "select * INTO account FROM location WHERE LOCATION_ID=?";

		List list = get(sql, new Object[] {});

		return list;

	}

	
}
