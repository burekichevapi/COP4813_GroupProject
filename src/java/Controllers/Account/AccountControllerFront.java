/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amer Delic
 */

@WebServlet(urlPatterns ="/AccountControllerFront",
initParams ={ @WebInitParam(name = "createTables", value = "true")})

public class AccountControllerFront extends HttpServlet
{
    public void init() throws ServletException
    {
        AccountController.initHibernate(this);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        new AccountController(this, request, response).doGet();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        new AccountController(this, request, response).doPost();
    }
}
