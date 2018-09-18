import by.nick.test_me.dao.DAOFactory;
import by.nick.test_me.dao.TaskDAO;
import by.nick.test_me.entity.Task;
import by.nick.test_me.entity.TaskMarkPoint;
import by.nick.test_me.exception.DAOException;
import by.nick.test_me.exception.ServiceException;
import by.nick.test_me.service.ServiceFactory;
import by.nick.test_me.service.TaskService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GetMarkTest {

    TaskService taskService;
    TaskDAO taskDAO;
    Task task=new Task();

    @Before
    public void before(){
        taskService=ServiceFactory.getInstance().getTaskService();
        taskDAO=DAOFactory.getInstance().getTaskDAO();
    }

    @Test
    public void test(){
        task.setId(2);
        try {
            float avg=taskDAO.getAverageMark(task);
            avg=avg;
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testService(){
        try {
            List<TaskMarkPoint> poins=taskService.getTaskMarkPoints();
            poins.size();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
