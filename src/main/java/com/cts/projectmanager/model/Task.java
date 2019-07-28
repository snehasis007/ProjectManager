package com.cts.projectmanager.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task extends PmBase{
	@Id
    private String id;
	private ParentTask pTask;
	private String isParent;
	private String task;
	private String startDate;
	private String endDate;
	private Integer priority;
	private String isTaskCompleted;
	private User userOwner;
	private Project project;
	private String projectID;
	public Task() {
	}
	
	public Task(String task,String startDate,String endDate
			,Integer priority,String isParent,User userOwner,Project project) {
		this.task=task;
		this.startDate=startDate;
		this.endDate=endDate;
		this.priority=priority;
		this.isParent=isParent;
		this.userOwner=userOwner;
		this.project=project;
	}
	
	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public User getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ParentTask getpTask() {
		return pTask;
	}
	public void setpTask(ParentTask pTask) {
		this.pTask = pTask;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getIsTaskCompleted() {
		return isTaskCompleted;
	}
	public void setIsTaskCompleted(String isTaskCompleted) {
		this.isTaskCompleted = isTaskCompleted;
	}
}
