package com.lucifer.razerwidget.relationmenuactivity.verticalmenu;
/**
 * 
 * @author lizhong
 * @create date: 2013/6/19
 * @class describe 三级联动实体类
 */
public class ThreeEntity {

	
	/**三级名称*/
	private String threeName;
	
	/**二级名称*/
	private String parentName;

	

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getThreeName() {
		return threeName;
	}

	public void setThreeName(String threeName) {
		this.threeName = threeName;
	}

	
	
}
