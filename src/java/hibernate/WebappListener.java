/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//Listens to the lifecycle of a web app.
//Can detect when context (web app) is initialized and destroyed
//Can initialize logger from contextInitialized() instead of servlet
//Must register Listner with TomCat via WebXML

@WebListener
public class WebappListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)
  {}

  public void contextDestroyed(ServletContextEvent sce)
  {
    try 
    {
      Enumeration<Driver> enumer = DriverManager.getDrivers();
      
      while (enumer.hasMoreElements()) 
      {
	System.out.println("Forms: deregisterd driver");
        DriverManager.deregisterDriver(enumer.nextElement()); //closes all drviers
      }
    } 
    catch (java.sql.SQLException se) 
    {
      se.printStackTrace();
    }
    
    hibernate.HibernateHelper.closeFactory(); //kills hibernate; called when all servlets close.
  }
}

