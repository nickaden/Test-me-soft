package by.nick.test_me.controller.command.impl;

import by.nick.test_me.entity.User;
import by.nick.test_me.exception.ServiceException;
import by.nick.test_me.service.ServiceFactory;
import by.nick.test_me.service.UserService;
import by.nick.test_me.controller.command.Command;
import by.nick.test_me.controller.util.KeyHolder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInCommand implements Command {

    private static final String ERROR_REFER="/sign_in_error";
    private static final String SUCCESS="success";
    private static final String FAILURE="failure";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            ServiceFactory factory=ServiceFactory.getInstance();
            UserService service=factory.getUserService();

            User user=service.authorizeUser(request.getParameter(KeyHolder.LOGIN_KEY),request.getParameter(KeyHolder.PASSWORD_KEY));
            HttpSession session=request.getSession();
            if (user!=null){
                session.setAttribute(KeyHolder.USER_KEY,user);
                PrintWriter writer=response.getWriter();
                writer.write(SUCCESS);
            } else {
                PrintWriter writer=response.getWriter();
                writer.write(FAILURE);
            }

        } catch (ServiceException e) {
            Logger.getLogger(getClass()).error(e.getMessage());
        }
    }
}
