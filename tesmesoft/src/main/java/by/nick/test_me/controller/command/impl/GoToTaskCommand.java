package by.nick.test_me.controller.command.impl;

import by.nick.test_me.controller.command.Command;
import by.nick.test_me.controller.util.KeyHolder;
import by.nick.test_me.entity.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToTaskCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Task task= (Task) request.getSession(true).getAttribute(KeyHolder.TASK_KEY);

        if (task != null){

            RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/"+task.getPage());
            dispatcher.forward(request,response);
        } else {
            response.sendRedirect(KeyHolder.WELCOME_PATH);
        }
    }
}
