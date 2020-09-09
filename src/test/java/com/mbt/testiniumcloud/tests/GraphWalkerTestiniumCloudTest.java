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

    private static Log4jLoggerAdapter logger = (Log4jLoggerAdapter) LoggerFactory.getLogger(GraphWalkerTestiniumCloudTest.class);

    @Rule
    public TestWatcher testWatcher = new TestResultJunit();

    public GraphWalkerTestiniumCloudTest() {

    }

    @Test
    public void testiniumLoginWebSocketTest() throws IOException {

        Executor executor = new TestExecutor(AllScenarios.class, Dashboard.class, Login.class,
                ProjectDetailSuites.class, ProjectDetailSummary.class, Projects.class,
                ReportDetail.class, Reports.class, ScenarioCreateNewGroup.class,
                Create.class, CreatePlan.class, CreateProject.class, CreateScenario.class,
                PlanEdit.class, ProjectDetailProperties.class, ProjectDetailScenarios.class,
                ScenarioEdit.class, AllSuites.class);

        WebSocketServer server = new WebSocketServer(8887, executor.getMachine());
        server.start();

       setExcel(executor);
       result = executor.execute(true);
       errorControl();
    }

    @Test
    public void testiniumCloudAll() throws IOException {

        Executor executor = new TestExecutor(AllScenarios.class, Dashboard.class, Login.class,
                ProjectDetailSuites.class, ProjectDetailSummary.class, Projects.class,
                ReportDetail.class, Reports.class, ScenarioCreateNewGroup.class,
                Create.class, CreatePlan.class, CreateProject.class, CreateScenario.class,
                PlanEdit.class, ProjectDetailProperties.class, ProjectDetailScenarios.class,
                ScenarioEdit.class, AllSuites.class);

        setExcel(executor);
        result = executor.execute(true);
        errorControl();
    }

    @Test
    public void testiniumCloudAllss() throws IOException {

        Executor executor = new TestExecutor(AllScenarios.class, Dashboard.class, Login.class,
                ProjectDetailSuites.class, ProjectDetailSummary.class, Projects.class,
                ReportDetail.class, Reports.class, ScenarioCreateNewGroup.class,
                Create.class, CreatePlan.class, CreateProject.class, CreateScenario.class,
                PlanEdit.class, ProjectDetailProperties.class, ProjectDetailScenarios.class,
                ScenarioEdit.class, AllSuites.class);

        setExcel(executor);
        List<Context> contextList = executor.getMachine().getContexts();
        Observer observer = new GraphDenemeStreamObserverNewVersion2_1(Login.class, contextList,false,false);
        executor.getMachine().addObserver(observer);

        result = executor.execute(true);
        errorControl();
    }

    @Test
    public void testiniumCloudLoginWs() throws IOException {

        Executor executor = new TestExecutor(Login.class);
        setExcel(executor);
        WebSocketServer server = new WebSocketServer(8887, executor.getMachine());
        server.start();
        result = executor.execute(true);
        errorControl();
    }

    @Test
    public void testiniumCloudLogin() throws IOException {

        Executor executor = new TestExecutor(Login.class);
        setExcel(executor);
        result = executor.execute(true);
        errorControl();
    }

    @Test
    public void testiniumCloudDashboard() throws IOException {

        Executor executor = new TestExecutor(Login.class, Dashboard.class);
        setExcel(executor);
        result = executor.execute(true);
        errorControl();
    }

    @Test
    public void LoginToProjects() throws IOException {

        Executor executor = new TestExecutor(LoginToProjects.class, Projects.class
                , CreateProject.class, ProjectDetailSummary.class, ProjectDetailProperties.class
                , ProjectDetailScenarios.class, ProjectDetailSuites.class);
        setExcel(executor);
        result = executor.execute(true);
        errorControl();
    }

    @Test
    public void LoginToAllSuites() throws IOException {

        Executor executor = new TestExecutor(LoginToAllSuites.class, AllSuites.class
                , CreatePlan.class, PlanEdit.class);
        setExcel(executor);
        result = executor.execute(true);
        errorControl();
    }

    @Test
    public void LoginToAllScenarios() throws IOException {

        Executor executor = new TestExecutor(LoginToAllScenarios.class, AllScenarios.class
                , CreateScenario.class, ScenarioEdit.class, ScenarioCreateNewGroup.class);
        setExcel(executor);
        result = executor.execute(true);
        errorControl();
    }

}
