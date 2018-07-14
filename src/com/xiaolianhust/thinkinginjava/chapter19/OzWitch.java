package com.xiaolianhust.thinkinginjava.chapter19;

public enum OzWitch {
	XX("xiao"),LL("lian");
	
	private String description;

	private OzWitch(String descrip) {
		this.description = descrip;
	}

	public String getDescription() {
		return description;
	}
	
	public static void main(String[] args) {
		for(OzWitch oz : OzWitch.values()) {
			System.out.println(oz + ": " + oz.getDescription());
		}
	}
	
}
