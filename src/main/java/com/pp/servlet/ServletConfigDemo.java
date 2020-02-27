package com.pp.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * ServletConfig: A servlet configuration object used by a servlet container
 * to pass information to a servlet during initialization.
 */
public class ServletConfigDemo implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
