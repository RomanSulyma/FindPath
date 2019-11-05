package Console;

import Console.controller.Controller;
import org.junit.Assert;
import org.junit.Test;

public class AppTest 
{
    //Test for the finished application
    @Test
    public void shouldFindOptimalWay()
    {
        Controller.config();
        Assert.assertEquals("d,d,d,d,d,d,d,d,d,d,d,d,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,u,u,u,u,r,r,d,d,d,d,r, ", Controller.solveForTest());
    }
}
