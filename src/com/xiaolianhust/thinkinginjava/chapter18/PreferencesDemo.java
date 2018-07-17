package com.xiaolianhust.thinkinginjava.chapter18;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {

	public static void main(String[] args) throws BackingStoreException {
		// TODO Auto-generated method stub
		Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
		prefs.put("Location", "Oz");
		prefs.put("Footwear", "Ruby Slippers");
		prefs.putInt("Companies", 4);
		prefs.putBoolean("Are there witches?", true);
		
		int usageCount = prefs.getInt("UsageCount", 0);
		++usageCount;
		prefs.putInt("UsageCount", usageCount);//�Ӵ�ӡ����У����ǿ��Կ���������ÿ�����ж������ˣ��������к�û�б����ļ�����ô��Ϣ���ױ��浽�������windowע���
		for(String key : prefs.keys()) {
			System.out.println(key + ": " + prefs.get(key, null));
		}
		
	}

}
