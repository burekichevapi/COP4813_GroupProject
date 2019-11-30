package Controllers.Complaint;

import Domain.Account;
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
import Domain.Complaint;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import repository.ComplaintRepository;

public class ComplaintControllerHelper {

    private HttpServlet servlet_;
    private HttpServletRequest request_;
    private HttpServletResponse response_;
    private Session session_;
    private Router<ComplaintControllerHelper> router_;
    private Complaint complaint_;
    private ComplaintRepository complaintRepository_;
    private Account account_;

    ComplaintControllerHelper(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response) {
        this.servlet_ = servlet;
        this.request_ = request;
        this.response_ = response;
        this.router_ = new Router<ComplaintControllerHelper>(request_);
        this.complaint_ = new Complaint();
        this.session_ = new Session(request_);
        this.complaintRepository_ = new ComplaintRepository();
        this.account_ =  new Account();
        
        session_.addToSession("user", account_);
    }

    static void initHibernate(HttpServlet servlet) {
        Boolean createTables = Boolean.parseBoolean(servlet.getInitParameter("createTables"));

        if (createTables) {
            repository.HibernateHelper.createTable(Domain.Complaint.class);
        }
        repository.HibernateHelper.initSessionFactory(Domain.Complaint.class);
    }

    public void doGet()
            throws IOException, ServletException {

        session_.addToSession("complaint", complaint_);
        session_.MapDataFromRequest(this.complaint_);
        Mapper.MapDataFromRequest(this.account_, request_);
        account_ = (Account)request_.getSession().getAttribute("user");

        String address = "index.jsp";

        if (request_.getParameter("newThreadButton") != null) {
            Date date_ = new Date();
            complaint_.setComplaintTitle(request_.getParameter("complaintTitle"));
            complaint_.setAccount("testUser");
            complaint_.setDate(date_);
            complaintRepository_.addThread(complaint_);

            String page = router_.RouteDestinationPageFor(this);
        }
        else {
            address = "index.jsp";
        }

        //request_.getRequestDispatcher(page).forward(request_, response_);
        RequestDispatcher dispatcher = request_.getRequestDispatcher(address);
        dispatcher.forward(request_, response_);
    }

    public void doPost()
            throws ServletException, IOException {

        String page = router_.RouteDestinationPageFor(this);

        session_.addToSession("complaint", complaint_);

        request_.getRequestDispatcher(page).forward(request_, response_);
    }
}
