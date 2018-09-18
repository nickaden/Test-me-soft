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
import java.time.LocalDate;


public class SignUpUserCommand implements Command {


    private static final String SIGN_UP_ERROR="error";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService service = factory.getUserService();

        User user = new User();
        user.setLogin(request.getParameter(KeyHolder.LOGIN_KEY));
        user.setPassword(request.getParameter(KeyHolder.PASSWORD_KEY));
        user.setName(request.getParameter(KeyHolder.NAME_KEY));
        user.setSurname(request.getParameter(KeyHolder.SURNAME_KEY));
        user.setGroup(request.getParameter(KeyHolder.GROUP_KEY));
        user.setRole(User.Role.USER);

        try {
            int userID = service.addUser(user);
            user.setId(userID);


            if (userID != -1) {
                HttpSession session = request.getSession(true);
                session.setAttribute(KeyHolder.USER_KEY, user);
            } else {
                PrintWriter writer=response.getWriter();
                writer.write(SIGN_UP_ERROR);
            }

        } catch (ServiceException e) {
            Logger.getLogger(getClass()).error(e.getMessage());
        }
    }
}
