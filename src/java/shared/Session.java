/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Amer Delic
 */

public class Session
{
    private HttpServletRequest _request;
    
    public Session(HttpServletRequest request)
    {
        _request = request;
    }
    
    public void addToSession(String name, Object sessionObject)
    {
        Object oldSessionObject = _request.getSession().getAttribute(name);
        
        if(oldSessionObject != null)
        {
            sessionObject = oldSessionObject;
        }
        
        _request.getSession().setAttribute(name, sessionObject);
    }

    public void MapDataFromRequest(Object data)
    {
        try {
            org.apache.commons.beanutils.BeanUtils.
                    populate(data, _request.getParameterMap());
        }
        catch (IllegalAccessException iae) {
            System.err.println("Populate - Illegal Access." + iae);
        }
        catch (InvocationTargetException ite) {
            System.err.println("Populate - Invocation Target."+ ite);
        }
    }
}
