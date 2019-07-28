package com.cts.projectmanager.web;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.cts.projectmanager.model.ParentTask;
import com.cts.projectmanager.model.Project;
import com.cts.projectmanager.model.ServiceResult;
import com.cts.projectmanager.model.Task;
import com.cts.projectmanager.model.User;
import com.cts.projectmanager.service.ProjectManagerImpl;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import org.hamcrest.Matchers;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest {
	@InjectMocks
    ProjectController projectController;

    @Mock
    ProjectManagerImpl manager;

    @Captor
    private ArgumentCaptor<Task> pmTaskArgument;

    @Captor
    private ArgumentCaptor<Project> projectArgument;

    @Captor
    private ArgumentCaptor<User> userArgument;
    @Captor
    private ArgumentCaptor<String> stringArgument;
    @Test()
    public void ping() {
    	projectController.ping();
    }
    private Project getProject() {
        Project project = new Project();
        project.setId("1");
        project.setProject("Project 1");
        return project;
    }
    private Task getTask() {
    	Task task = new Task();
    	task.setId("1");
    	task.setTask("Task 1");
        return task;
    }
    private ParentTask getParentTask() {
        ParentTask parentTask = new ParentTask();
        parentTask.setId("1");
        parentTask.setParentTaskName("Parent Task 1");
        return parentTask;
    }
    private User getUser() {
        User user = new User();
        user.setId("1");
        user.setFirstName("HGHG");
        user.setLastName("MKB");
        return user;
    }
    @Test
    public void getProjects() throws Exception {
        List<Project> expectedProjects = new ArrayList<Project>();
        Project project = getProject();
        expectedProjects.add(project);

        when(manager.getAllProjects()).thenReturn(expectedProjects);
        ResponseEntity<ServiceResult<Project>> res = projectController.getAllProjects();
        assertSame(expectedProjects, res.getBody().getDataList());
    }
    
    @Test
    public void getParentTasks() throws Exception {
        List<ParentTask> expectedParentTasks = new ArrayList<ParentTask>();
        ParentTask parentTask = getParentTask();
        expectedParentTasks.add(parentTask);

        when(manager.getAllParentTasks()).thenReturn(expectedParentTasks);
        ResponseEntity<ServiceResult<ParentTask>> res = projectController.getAllParentTasks();
        assertSame(expectedParentTasks, res.getBody().getDataList());
    }
    
    @Test
    public void getUsers() throws Exception {
        List<User> expectedUsers = new ArrayList<User>();
        User user = getUser();
        expectedUsers.add(user);

        when(manager.getAllUsers()).thenReturn(expectedUsers);
        ResponseEntity<ServiceResult<User>> res = projectController.getAllUsers();
        assertEquals(expectedUsers, res.getBody().getDataList());
    }
    
    @Test
    public void getTasks() throws Exception {
        List<Task> expectedTasks = new ArrayList<Task>();
        Task task = getTask();
        expectedTasks.add(task);

        when(manager.getAllTasks()).thenReturn(expectedTasks);
        ResponseEntity<ServiceResult<Task>> res = projectController.getAllTasks();
        assertSame(expectedTasks, res.getBody().getDataList());
    }
    
    @Test
    public void createOrUpdateUser() throws Exception {
        User user = getUser();

        assertThat(projectController.saveOrUpdateUser(user), Matchers.any(ResponseEntity.class));
        verify(manager).createOrUpdateUser(userArgument.capture());
        verify(manager, times(1)).createOrUpdateUser(any(User.class));
    }
    @Test
    public void createOrUpdateTask() throws Exception {
        Task task = getTask();

        assertThat(projectController.saveOrUpdateTask(task), Matchers.any(ResponseEntity.class));

        verify(manager).createOrUpdateTask(pmTaskArgument.capture());
        verify(manager, times(1)).createOrUpdateTask(any(Task.class));
    }
    
    @Test
    public void createOrUpdateProject() throws Exception {
        Project project = getProject();

        assertThat(projectController.saveOrUpdateProject(project), Matchers.any(ResponseEntity.class));
        verify(manager).createOrUpdateProject(projectArgument.capture());
        verify(manager, times(1)).createOrUpdateProject(any(Project.class));
    }
    @Test
    public void deleteUser() throws Exception {
        User user = getUser();

        assertThat(projectController.deleteUser(user), Matchers.any(ResponseEntity.class));
        verify(manager).deleteUser(stringArgument.capture());
        verify(manager, times(1)).deleteUser(any(String.class));

    }
}
