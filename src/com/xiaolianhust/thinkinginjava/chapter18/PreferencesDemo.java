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
		prefs.putInt("UsageCount", usageCount);//从打印输出中，我们可以看到，我们每次运行都增加了，程序运行后没有本地文件，那么信息到底保存到哪里。答案是window注册表
		for(String key : prefs.keys()) {
			System.out.println(key + ": " + prefs.get(key, null));
		}
		
	}

}
