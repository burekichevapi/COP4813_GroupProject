package Controllers.Post;

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
import Domain.*;
import repository.PostRepository;

import shared.Router;
import Domain.Post;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class PostControllerHelper {

    private HttpServlet servlet_;
    private HttpServletRequest request_;
    private HttpServletResponse response_;
    private Session session_;
    private Router<PostControllerHelper> router_;
    private Post post_;
    private Account account_;
    private Complaint complaint_;
    private PostRepository postRepository_;

    PostControllerHelper(HttpServlet servlet, HttpServletRequest request,
            HttpServletResponse response) {
        this.servlet_ = servlet;
        this.request_ = request;
        this.response_ = response;
        this.router_ = new Router<PostControllerHelper>(request_);
        this.post_ = new Post();
        this.session_ = new Session(request_);
        this.postRepository_ = new PostRepository();
        this.account_ = new Account();
        this.complaint_ = new Complaint();
    }

    static void initHibernate(HttpServlet servlet) {
        Boolean createTables = Boolean.parseBoolean(servlet.getInitParameter("createTables"));

        if (createTables) {
            repository.HibernateHelper.createTable(Domain.Post.class);
        }
        repository.HibernateHelper.initSessionFactory(Domain.Post.class);
    }

    public void doGet()
            throws IOException, ServletException {
            
        //session_.addToSession("post", post_);
        //session_.MapDataFromRequest(this.postRepository_);
        //Mapper.MapDataFromRequest(this.account_, request_);
        account_ = (Account) request_.getSession().getAttribute("user");

        String address = "post.jsp";

        if (request_.getParameter("postButton") != null) {
            complaint_ = (Complaint)request_.getSession().getAttribute("complaint");
            Date date_ = new Date();
            post_.setPostBody(request_.getParameter("postBody"));
            post_.setDate(date_);
            post_.setComplaintId(complaint_.getComplaintId());
            post_.setUser(account_.getUserName());
            postRepository_.newPost(post_);
            address = "thread.jsp";

        } 
        else if(request_.getParameter("newPostButton") != null) {
            address = "post.jsp";
        }
        
        else if (request_.getParameter("showPosts") != null) {
           
            List<Post> posts = new ArrayList<>();
            //complaint_ = (Complaint) request_.getSession().getAttribute("complaint");
            posts = postRepository_.getPostsByThread(complaint_.getComplaintId());
            session_.addToSession("postList", posts);
            address = "thread.jsp";
        } 
        
        else {
            address = "index.jsp";
        }


        RequestDispatcher dispatcher = request_.getRequestDispatcher(address);
        dispatcher.forward(request_, response_);
    }

    public void doPost()
            throws ServletException, IOException {

        String page = router_.RouteDestinationPageFor(this);

        session_.addToSession("post", post_);

        request_.getRequestDispatcher(page).forward(request_, response_);
    }
}
