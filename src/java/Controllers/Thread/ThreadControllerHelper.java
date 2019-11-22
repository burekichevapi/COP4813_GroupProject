package Controllers.Thread;

import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import repository.HibernateHelper;
import shared.Session;
import shared.DestinationPage;
import shared.FormError;
import shared.Mapper;

import shared.Router;
import Domain.Thread;
import java.io.IOException;

public class ThreadControllerHelper {

    private HttpServlet servlet_;
    private HttpServletRequest request_;
    private HttpServletResponse response_;
    private Session session_;
    private Router<ThreadControllerHelper> router_;
    private Thread thread_;

    ThreadControllerHelper(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response) {
        this.servlet_ = servlet;
        this.request_ = request;
        this.response_ = response;
        this.router_ = new Router<ThreadControllerHelper> (request_);
        this.thread_ = new Thread();
        this.session_ = new Session(request_);
    }

    static void initHibernate(HttpServlet servlet) {
        Boolean createTables = Boolean.parseBoolean(servlet.getInitParameter("createTables"));

        if (createTables) {
            repository.HibernateHelper.createTable(Domain.Thread.class);
        }
        repository.HibernateHelper.initSessionFactory(Domain.Thread.class);
    }

    public void doGet()
            throws IOException, ServletException {

        session_.addToSession("thread", thread_);

        String page = router_.RouteDestinationPageFor(this);

        request_.getRequestDispatcher(page).forward(request_, response_);
    }

    public void doPost()
            throws ServletException, IOException {

        String page = router_.RouteDestinationPageFor(this);

        session_.addToSession("thread", thread_);

        request_.getRequestDispatcher(page).forward(request_, response_);
    }
}
