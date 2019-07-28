package com.cts.projectmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.projectmanager.model.ParentTask;
import com.cts.projectmanager.model.Project;
import com.cts.projectmanager.model.Task;
import com.cts.projectmanager.model.User;
import com.cts.projectmanager.repository.ParentTaskRepository;
import com.cts.projectmanager.repository.ProjectRepository;
import com.cts.projectmanager.repository.TaskRepository;
import com.cts.projectmanager.repository.UserRepository;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectManagerImplTest {
	@InjectMocks
	ProjectManagerImpl projectManagerService;

    @Mock
    UserRepository userRepository;

    @Mock
    ProjectRepository projectRepository;

    @Mock
    TaskRepository taskRepository;

    @Mock
    ParentTaskRepository parentTaskRepository;
    @Captor
    private ArgumentCaptor<Task> taskArgument;

    @Captor
    private ArgumentCaptor<Project> projectArgument;

    @Captor
    private ArgumentCaptor<User> userArgument;
    @Captor
    private ArgumentCaptor<String> stringArgument;

    @Captor
    private ArgumentCaptor<ParentTask> parentTaskArgument;
    
    private User getUser() {
        User user = new User();
        user.setId("1");
        user.setFirstName("DSF");
        user.setLastName("SFSF");
        return user;
    }
    private Project getProject() {
        Project project = new Project();
        project.setId("1");
        project.setProject("Project 1");
        return project;
    }
    private Task getTask() {
    	Task tsk = new Task();
    	tsk.setId("1");
    	tsk.setTask("Task 1");
    	tsk.setProject(getProject());
    	tsk.setpTask(getParentTask());
    	tsk.setUserOwner(getUser());
        return tsk;
    }
    private ParentTask getParentTask() {
    	ParentTask parentTask = new ParentTask();
    	parentTask.setId("1");
    	parentTask.setParentTaskName("Parent Task 1");
        return parentTask;
    }
    
    @Test
    public void getProjects() throws Exception {
        List<Project> expectedProjects = new ArrayList<Project>();
        Project project = getProject();
        expectedProjects.add(project);

        when(projectRepository.findAll()).thenReturn(expectedProjects);
        List<Project> actualProjects = projectManagerService.getAllProjects();
        assertSame(expectedProjects, actualProjects);
    }
    
    @Test
    public void getUsers() throws Exception {
        List<User> allUsers = new ArrayList<User>();
        User user1 = getUser();

        User user2 = new User();
        user2.setId("2");
        user2.setFirstName("DSF");
        user2.setLastName("SFSF");

        allUsers.add(user1);
        allUsers.add(user2);

        List<User> expectedUsers = new ArrayList<User>();
        
        expectedUsers.add(user1);
        expectedUsers.add(user2);

        when(userRepository.findAll()).thenReturn(allUsers);
        List<User> actualUsers = projectManagerService.getAllUsers();
        assertEquals(expectedUsers, actualUsers);
    }
    
    @Test
    public void getTasks() throws Exception {
        List<Task> tasks = new ArrayList<Task>();
        Task task = getTask();
        tasks.add(task);

        when(taskRepository.findAll()).thenReturn(tasks);
        List<Task> actualTasks = projectManagerService.getAllTasks();
        assertSame(tasks, actualTasks);
    }
    
    @Test
    public void getParentTasks() throws Exception {
        List<ParentTask> expectedParentTasks = new ArrayList<ParentTask>();
        ParentTask parentTask = getParentTask();
        expectedParentTasks.add(parentTask);

        when(parentTaskRepository.findAll()).thenReturn(expectedParentTasks);
        List<ParentTask> actualParentTasks = projectManagerService.getAllParentTasks();
        assertSame(expectedParentTasks, actualParentTasks);
    }
    
    
    
    @Test
    public void createOrUpdateProject() throws Exception {
        Project project = getProject();
        projectManagerService.createOrUpdateProject(project);
        verify(projectRepository, times(1)).save(projectArgument.capture());
    }
    @Test
    public void createOrUpdateUser() throws Exception {
        User user = getUser();
        projectManagerService.createOrUpdateUser(user);
        verify(userRepository, times(1)).save(userArgument.capture());
    }
    @Test
    public void createOrUpdateTask() throws Exception {
        Task task = getTask();
        projectManagerService.createOrUpdateTask(task);
        verify(taskRepository, times(1)).save(taskArgument.capture());
    }
    @Test
    public void deleteUser() throws Exception {
        User user = getUser();
        projectManagerService.deleteUser(user.getId());
        verify(userRepository, times(1)).deleteById(stringArgument.capture());
    }
}
