package by.nick.test_me.controller.command.solve;

import by.nick.test_me.controller.command.Command;
import by.nick.test_me.controller.util.KeyHolder;
import by.nick.test_me.entity.Task;
import by.nick.test_me.entity.User;
import by.nick.test_me.exception.ServiceException;
import by.nick.test_me.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class SolveCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    protected void setComplete(HttpServletRequest request) throws ServiceException {

        Task task= (Task) request.getSession(true).getAttribute(KeyHolder.TASK_KEY);

        User user = (User) request.getSession().getAttribute(KeyHolder.USER_KEY);
        task.setComplete(true);
        LocalDateTime finishTime = LocalDateTime.now();
        long seconds = Math.abs(finishTime.until(task.getStartTime(), ChronoUnit.SECONDS));
        long minutes=seconds/60;
        seconds=seconds%60;
        ServiceFactory.getInstance().getTaskService().completeTask(user, task, minutes, seconds);
    }
}
