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

public class SolveFormatCommand extends SolveCommand {

    private static final String CORRECT_CODE="1104";
    private static final String CODE_KEY="code";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Task task= (Task) request.getSession(true).getAttribute(KeyHolder.TASK_KEY);

        if (task==null || !task.getPage().equals(TaskPageHolder.FORMAT_PAGE)){
            response.setStatus(500);
            return;
        }

        try {

            String code = request.getParameter(CODE_KEY);

            if (code.equals(CORRECT_CODE)) {
                setComplete(request);
            }

        } catch (ServiceException e) {
            Logger.getLogger(getClass()).error(e.getMessage());
            response.setStatus(500);
        }
    }

}
