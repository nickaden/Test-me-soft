package by.nick.test_me.controller.command.impl;

import by.nick.test_me.controller.command.Command;
import by.nick.test_me.entity.TaskMarkPoint;
import by.nick.test_me.exception.ServiceException;
import by.nick.test_me.service.ServiceFactory;
import by.nick.test_me.service.TaskService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetTaskMarkPointsCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TaskService taskService=ServiceFactory.getInstance().getTaskService();

        try{

            List<TaskMarkPoint> points=taskService.getTaskMarkPoints();
            Gson gson=new Gson();
            String json=gson.toJson(points);

            PrintWriter writer=response.getWriter();
            writer.write(json);

        } catch (ServiceException e) {
            Logger.getLogger(getClass()).error(e.getMessage());
        }

    }
}
