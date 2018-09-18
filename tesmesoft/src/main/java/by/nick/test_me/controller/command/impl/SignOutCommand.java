package by.nick.test_me.controller.command.impl;

import by.nick.test_me.controller.command.Command;
import by.nick.test_me.controller.util.KeyHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutCommand implements Command {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(true);
        session.removeAttribute(KeyHolder.USER_KEY);
        response.sendRedirect(KeyHolder.WELCOME_PATH);

    }
}
