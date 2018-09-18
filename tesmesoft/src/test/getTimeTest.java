import by.nick.test_me.dao.DAOFactory;
import by.nick.test_me.dao.TaskDAO;
import by.nick.test_me.entity.Task;
import by.nick.test_me.entity.TimeCountPoint;
import by.nick.test_me.exception.DAOException;
import by.nick.test_me.exception.ServiceException;
import by.nick.test_me.service.ServiceFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class getTimeTest {

    private Task task;
    private TaskDAO taskDAO;

    @Before
    public void before(){
        task=new Task();
        task.setId(2);
        taskDAO=DAOFactory.getInstance().getTaskDAO();
    }

    @Test
    public void test(){
//        try {
//            //float f=taskDAO.getAverageTime(task);
//           // assertEquals(f,0);
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testService(){
        try {
            List<TimeCountPoint> points=ServiceFactory.getInstance().getTaskService().getTimeCountPoints();
            points.size();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
