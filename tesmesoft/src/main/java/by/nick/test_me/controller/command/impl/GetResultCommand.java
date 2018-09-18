package by.nick.test_me.controller.command.impl;

import by.nick.test_me.controller.command.Command;
import by.nick.test_me.controller.util.KeyHolder;
import by.nick.test_me.entity.User;
import by.nick.test_me.exception.ServiceException;
import by.nick.test_me.service.ServiceFactory;
import by.nick.test_me.service.TaskService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class GetResultCommand implements Command {

    private static final String RESULT_PAGE = "user_result.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user= (User) request.getSession().getAttribute(KeyHolder.USER_KEY);

        TaskService taskService=ServiceFactory.getInstance().getTaskService();

        try {
            Map<String,Integer> taskResults=taskService.getTaskResults(user);

            request.setAttribute("result",taskResults);
            RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/"+RESULT_PAGE);
            dispatcher.forward(request,response);

        } catch (ServiceException e) {
            Logger.getLogger(getClass()).error(e.getMessage());
        }
    }
}
