package by.nick.test_me.service;

import by.nick.test_me.entity.Task;
import by.nick.test_me.entity.TaskMarkPoint;
import by.nick.test_me.entity.TimeCountPoint;
import by.nick.test_me.entity.User;
import by.nick.test_me.exception.DAOException;
import by.nick.test_me.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface TaskService {

    List<Task> getTasks(int level) throws ServiceException;

    String getTip(int taskId) throws DAOException;

    String getFreeTip(int taskId) throws ServiceException;

    void completeTask(User user, Task task, long minutes, long seconds) throws ServiceException;

    Map<String,Integer> getTaskResults(User user) throws ServiceException;

    List<TimeCountPoint> getTimeCountPoints() throws ServiceException;

    List<TaskMarkPoint> getTaskMarkPoints() throws ServiceException;
}
