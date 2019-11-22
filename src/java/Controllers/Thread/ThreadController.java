
package Controllers.Thread;

import repository.HibernateHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns ="/Controller",
initParams ={ @WebInitParam(name = "createTables", value = "true")})

public class ThreadController extends HttpServlet {

    @Override
    public void init() {
        ThreadControllerHelper.initHibernate(this);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        ThreadControllerHelper helper =
                new ThreadControllerHelper(this, request, response);
        helper.doGet();
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        ThreadControllerHelper helper =
                new ThreadControllerHelper(this, request, response);
        helper.doPost();
    }
}
