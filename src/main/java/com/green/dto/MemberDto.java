package com.green.dto;

public class MemberDto {
	private String memberId;
	private String memberName;
	private String memberPwd;
	private String memberBan;
	private String authority;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberBan() {
		return memberBan;
	}
	public void setMemberBan(String memberBan) {
		this.memberBan = memberBan;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
