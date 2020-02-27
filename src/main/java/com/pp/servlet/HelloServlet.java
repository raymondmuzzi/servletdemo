package com.pp.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The demo of servlet
 * <p>
 * <p>
 * When input the url e.g. http://locahost:8080/aaa
 * <p>
 * 1) Should find whether there is static resource in the server
 * 2) If static resource absent, will find the dynamic resource instead
 * <p>
 * The life circle of servlet:
 * Servlet is running on the tomcat server, the tomcat is the servlet container.
 * The servlet is created by the server.
 * <p>
 * 1) Create a servlet object
 * 2) Call the init()
 * 3) Call the service(), the service method will process the request from client, which is the business handling
 * 4) If the init() and service() method was called at once,
 * the later request will not call these two methods
 * 5) When the project uninstalled from the server, the destroy() method will be called
 * <p>
 * Notice: servlet is singleton, which means that the servlet object
 * only be created once during the web server running period. But the
 * servlet will be shared by multi-thread. The member variables are not
 * thread-safe, so we can't define a member variable in the servlet.If
 * we want to define the thread level variables, we can use the ThreadLocal{@link ThreadLocal}.
 *
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("This is the constructor()");
    }

    /**
     * The init method
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("This is init() method");
    }

    /**
     * Return the servlet config info
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("This is getServletConfig() method");
        return null;
    }

    /**
     * The real method to handle request
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("I'm the first servlet");

        PrintWriter writer = servletResponse.getWriter();
        writer.write("Hello world");

    }

    /**
     * Get the servlet info
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        System.out.println("This is getServletInfo() method");
        return null;
    }

    /**
     * The destroy method
     */
    @Override
    public void destroy() {
        System.out.println("This is destroy() method");
    }
}
