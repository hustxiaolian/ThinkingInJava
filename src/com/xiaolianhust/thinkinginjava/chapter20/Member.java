package com.xiaolianhust.thinkinginjava.chapter20;

@DBTable(name="Member")
public class Member {
	@SQLString(value=30) String firstName;
	@SQLString(value=50) String lastName;
	@SQLInteger Integer age;
	@SQLString (value=30, constraints=@Constraints(primaryKey=true)) String handle;
	static int memberCount;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getAge() {
		return age;
	}
	public String getHandle() {
		return handle;
	}
	public static int getMemberCount() {
		return memberCount;
	}
	@Override
	public String toString() {
		return "Member [handle=" + handle + "]";
	}
}
