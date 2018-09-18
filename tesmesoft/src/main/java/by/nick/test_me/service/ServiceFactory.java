package by.nick.test_me.service;

import by.nick.test_me.service.impl.TaskServiceImpl;
import by.nick.test_me.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();
    private UserService userService=new UserServiceImpl();
    private TaskService taskService=new TaskServiceImpl();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    public UserService getUserService(){
        return userService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    private ServiceFactory() {
    }
}
