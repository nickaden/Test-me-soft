package by.nick.test_me.controller.command.impl;

import by.nick.test_me.entity.User;
import by.nick.test_me.exception.ServiceException;
import by.nick.test_me.service.ServiceFactory;
import by.nick.test_me.service.UserService;
import by.nick.test_me.controller.command.Command;
import by.nick.test_me.controller.util.KeyHolder;
import by.nick.test_me.controller.util.ReferenceEditor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AddUserCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService service = factory.getUserService();


        User user = new User();
        user.setLogin(request.getParameter(KeyHolder.LOGIN_KEY));
        user.setPassword(request.getParameter(KeyHolder.PASSWORD_KEY));
        user.setName(request.getParameter(KeyHolder.NAME_KEY));
        user.setSurname(request.getParameter(KeyHolder.SURNAME_KEY));
        user.setRole(User.Role.valueOf(request.getParameter(KeyHolder.ROLE_KEY)));


        try {

            int userID=service.addUser(user);

        } catch (ServiceException e) {
            Logger logger= Logger.getRootLogger();
            logger.error(e.getMessage());

        } finally {
            response.sendRedirect(ReferenceEditor.getReference(request));
        }


    }
}
