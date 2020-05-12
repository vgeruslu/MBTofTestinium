package com.mbt.testiniumcloud.tests;

import com.mbt.testiniumcloud.driver.DriverCreater;
import com.mbt.testiniumcloud.modelImplementation.*;
import com.mbt.testiniumcloud.observes.GraphDenemeStreamObserverNewVersion2_1;
import org.graphwalker.core.event.Observer;
import org.graphwalker.core.machine.Context;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.websocket.WebSocketServer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import java.io.IOException;
import java.util.List;

public class GraphWalkerTestiniumCloudTest extends DriverCreater {

    /**
    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        System.setProperty("currenttime", dateFormat.format(new Date()));
    }
     */
    //private static final Logger logger = LoggerFactory.getLogger(GraphWalkerTestiniumTest.class);
    private static Log4jLoggerAdapter logger = (Log4jLoggerAdapter) LoggerFactory.getLogger(GraphWalkerTestiniumCloudTest.class);

    @Rule
    public TestWatcher testWatcher = new TestResultJunit();

    public GraphWalkerTestiniumCloudTest() {

        //PropertyConfigurator.configure(GraphWalkerTestiniumTest.class.getClassLoader().getResource("log4j.properties"));
        /**
        Logger.getRootLogger().setLevel(Level.OFF);
        Logger.getLogger(GraphWalkerTestiniumCloudTest.class).setLevel(Level.ALL);
        Logger.getLogger(DriverCreater.class).setLevel(Level.ALL);
        Logger.getLogger(TestResultJunit.class).setLevel(Level.ALL);
         */
    }

    @Test
    public void testiniumLoginWebSocketTest() throws IOException {

        Executor executor = new TestExecutor(TestiniumCloudAllScenarios.class, TestiniumCloudDashboard.class, TestiniumCloudLogin.class,
                TestiniumCloudProjectDetailSuites.class, TestiniumCloudProjectDetailSummary.class, TestiniumCloudProjects.class,
                TestiniumCloudReportDetail.class, TestiniumCloudReports.class, TestiniumCloudScenarioCreateNewGroup.class,
                TestiniumCloudCreate.class, TestiniumCloudCreatePlan.class, TestiniumCloudCreateProject.class, TestiniumCloudCreateScenario.class,
                TestiniumCloudPlanEdit.class, TestiniumCloudProjectDetailProperties.class, TestiniumCloudProjectDetailScenarios.class,
                TestiniumCloudScenarioEdit.class, TestiniumCloudAllSuites.class);

        WebSocketServer server = new WebSocketServer(8887, executor.getMachine());
        server.start();

       result = executor.execute(true);
       setInfo(executor);
       errorControl();
    }

    @Test
    public void testiniumCloudAll() throws IOException {

        Executor executor = new TestExecutor(TestiniumCloudAllScenarios.class, TestiniumCloudDashboard.class, TestiniumCloudLogin.class,
                TestiniumCloudProjectDetailSuites.class, TestiniumCloudProjectDetailSummary.class, TestiniumCloudProjects.class,
                TestiniumCloudReportDetail.class, TestiniumCloudReports.class, TestiniumCloudScenarioCreateNewGroup.class,
                TestiniumCloudCreate.class, TestiniumCloudCreatePlan.class, TestiniumCloudCreateProject.class, TestiniumCloudCreateScenario.class,
                TestiniumCloudPlanEdit.class, TestiniumCloudProjectDetailProperties.class, TestiniumCloudProjectDetailScenarios.class,
                TestiniumCloudScenarioEdit.class, TestiniumCloudAllSuites.class);

        result = executor.execute(true);
        setInfo(executor);
        errorControl();
    }

    @Test
    public void testiniumCloudAllss() throws IOException {

        Executor executor = new TestExecutor(TestiniumCloudAllScenarios.class, TestiniumCloudDashboard.class, TestiniumCloudLogin.class,
                TestiniumCloudProjectDetailSuites.class, TestiniumCloudProjectDetailSummary.class, TestiniumCloudProjects.class,
                TestiniumCloudReportDetail.class, TestiniumCloudReports.class, TestiniumCloudScenarioCreateNewGroup.class,
                TestiniumCloudCreate.class, TestiniumCloudCreatePlan.class, TestiniumCloudCreateProject.class, TestiniumCloudCreateScenario.class,
                TestiniumCloudPlanEdit.class, TestiniumCloudProjectDetailProperties.class, TestiniumCloudProjectDetailScenarios.class,
                TestiniumCloudScenarioEdit.class, TestiniumCloudAllSuites.class);

        List<Context> contextList = executor.getMachine().getContexts();
        Observer observer = new GraphDenemeStreamObserverNewVersion2_1(TestiniumCloudLogin.class, contextList,false,false);
        executor.getMachine().addObserver(observer);

        result = executor.execute(true);

        setInfo(executor);
        errorControl();
    }

    @Test
    public void testiniumCloudLoginWs() throws IOException {

        Executor executor = new TestExecutor(TestiniumCloudLogin.class);

        WebSocketServer server = new WebSocketServer(8887, executor.getMachine());
        server.start();
        result = executor.execute(true);
        setInfo(executor);
        errorControl();
    }

    @Test
    public void testiniumCloudLogin() throws IOException {

        Executor executor = new TestExecutor(TestiniumCloudLogin.class);

        result = executor.execute(true);
        setInfo(executor);
        errorControl();
    }

    @Test
    public void testiniumCloudDashboard() throws IOException {

        Executor executor = new TestExecutor(TestiniumCloudLogin.class, TestiniumCloudDashboard.class);

        result = executor.execute(true);
        setInfo(executor);
        errorControl();
    }

}
