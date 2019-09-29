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
public class Session<C>
{

    public static enum State
    {
        READ, IGNORE
    }

    private HttpServletRequest _request;

    public Session(HttpServletRequest request)
    {
        _request = request;
    }

    public boolean sessionObjectExisits(String sessionObjectName)
    {
        return _request.getSession().getAttribute(sessionObjectName) != null;
    }

    public <C> C getSessionData(State state, C sessionObject, String sessionObjectName)
    {
        C data = null;

        if (state == State.READ) {
            if (sessionObjectExisits(sessionObjectName)) {
                data = copyDataFromSession(sessionObject, sessionObject.getClass());
            }
        }

        return data;
    }

    public <C> C copyDataFromSession(C sessionObject, Class sessionControllerclazz)
    {
        if (sessionObject.getClass() == sessionControllerclazz) {
            return ((C) sessionObject);
        }

        return null;
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
