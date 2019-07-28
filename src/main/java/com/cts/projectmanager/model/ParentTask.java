package com.cts.projectmanager.model;

import org.springframework.data.annotation.Id;


public class ParentTask {
	@Id
    private String id;
	private String parentTaskName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentTaskName() {
		return parentTaskName;
	}
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}
}
