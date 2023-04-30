package model;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private String name;

	public MemberBean(String name) {
		this.name = name;
	}
	
	public MemberBean() {
		// JavaBeansなので引数なしのコンストラクタも必要
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
