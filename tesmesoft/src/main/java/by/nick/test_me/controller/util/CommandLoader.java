package by.nick.test_me.controller.util;

import by.nick.test_me.controller.command.Command;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class CommandLoader {

    private static CommandLoader ourInstance = new CommandLoader();
    private static final String COMMANDS_SOURCE_PATH="commands.xml";

    public static CommandLoader getInstance() {
        return ourInstance;
    }

    private CommandLoader() {
    }


    public Map<String,Command> getCommands(){

        Map<String,Command> map=new HashMap<>();

        try {

            DOMParser parser=new DOMParser();
            URL classpathResource = Thread.currentThread().getContextClassLoader().getResource(COMMANDS_SOURCE_PATH);
            parser.parse(classpathResource.getPath());

            Document document=parser.getDocument();
            Element root=document.getDocumentElement();
            NodeList elements=root.getElementsByTagName("command");

            for (int i=0; i<elements.getLength(); i++){

                Element element=(Element) elements.item(i);

                Element actionName =(Element) element.getElementsByTagName("action-name").item(0);
                Element actionClass = (Element) element.getElementsByTagName("command-class").item(0);
                Command command=(Command) Class.forName(actionClass.getTextContent()).getConstructor().newInstance();

                map.put(actionName.getTextContent(),command);
            }

        } catch (SAXException | IOException | IllegalAccessException | ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return map;
    }
}
