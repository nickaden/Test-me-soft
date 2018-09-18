package by.nick.test_me.dao;

import by.nick.test_me.entity.Task;
import by.nick.test_me.entity.User;
import by.nick.test_me.exception.DAOException;

import java.sql.Time;
import java.util.List;

public interface TaskDAO {

    List<Task> getTasks() throws DAOException;

    List<Task> getTasks(int level) throws DAOException;

    String getTip(int tasId) throws DAOException;

    String getFreeTip(int taskId) throws DAOException;

    int getMaxLevel() throws DAOException;

    Task getFinishTask() throws DAOException;

    void completeTask(User user,Task task, String time) throws DAOException;

    int getAverageTime(Task task) throws DAOException;

    float getAverageMark(Task task) throws DAOException;

    List<Task> getCompleteTask(User user) throws DAOException;
}
