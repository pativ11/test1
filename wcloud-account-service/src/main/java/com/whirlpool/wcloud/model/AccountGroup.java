package com.whirlpool.wcloud.model;

import java.sql.Timestamp;

public class AccountGroup {
	 private int groupId;
	 private int accountId;
	 private Timestamp invitationSendAt;
	 private Timestamp invitationAcceptedAt;

	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Timestamp getInvitationSendAt() {
		return invitationSendAt;
	}
	public void setInvitationSendAt(Timestamp invitationSendAt) {
		this.invitationSendAt = invitationSendAt;
	}
	public Timestamp getInvitationAcceptedAt() {
		return invitationAcceptedAt;
	}
	public void setInvitationAcceptedAt(Timestamp invitationAcceptedAt) {
		this.invitationAcceptedAt = invitationAcceptedAt;
	}
	
}
