package by.nick.test_me.controller.command.solve.impl;

import by.nick.test_me.controller.command.solve.SolveCommand;
import by.nick.test_me.controller.util.KeyHolder;
import by.nick.test_me.controller.util.TaskPageHolder;
import by.nick.test_me.entity.Task;
import by.nick.test_me.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SolveAddButtonCommand extends SolveCommand {

    private static final String GO_TASK="start?action=go_new_task";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Task task= (Task) request.getSession(true).getAttribute(KeyHolder.TASK_KEY);

        if (task==null || !task.getPage().equals(TaskPageHolder.ADD_BUTTON_PAGE)){
            response.setStatus(500);
            return;
        }

        try {
            setComplete(request);
            response.sendRedirect(GO_TASK);
        } catch (ServiceException e) {
            Logger.getLogger(getClass()).error(e.getMessage());
        }
    }
}
