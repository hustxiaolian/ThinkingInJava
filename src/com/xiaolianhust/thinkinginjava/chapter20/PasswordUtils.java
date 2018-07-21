package com.xiaolianhust.thinkinginjava.chapter20;

import java.util.List;

public class PasswordUtils {
	@UseCase(id = 47, description="Password must contain at least one numeric")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w"));
	}
	@UseCase(id = 48)
	public String encrptPassword(String password) {
		return new StringBuffer(password).reverse().toString();
	}
	@UseCase(id = 49, description = "can't repeat with all old passwords")
	public boolean checkNewPassword(List<String> prevPasswords, String passwrod) {
		return !prevPasswords.contains(passwrod);
	}
}
