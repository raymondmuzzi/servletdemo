package com.pp.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * ServletConfig: A servlet configuration object used by a servlet container
 * to pass information to a servlet during initialization.
 *
 * One servlet class corresponds to one servlet config
 */
public class ServletConfigDemo implements Servlet {

    /** Get the servlet config from init method */
    private ServletConfig servletConfig;

    /**
     * From the doc, the config was passed from server during init period
     *
     * @param config
     */
    @Override
    public void init(ServletConfig config) {
        // Set the member variable, the config is passed from server side
        this.servletConfig = servletConfig;

        // The main methods of ServletConfig

        // 1.Get the servlet's name, refers to <servlet-name> tag in web.xml file
        System.out.println("ServletName:"+config.getServletName());

        // 2.Get the servlet's init param, refers to the <init-param> tag in web.xml file
        System.out.println("InitParam:"+config.getInitParameter("name"));

        // 3.Get the servlet context object, which represents the web application info
        // The servlet context covers the whole web application, so it can be shared by the whole application
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);

        // Set the attribute to the servlet context
        // Notice: The init param can not be set after the container initialization
        servletContext.setAttribute("attr","attrValue");

        // Overall: One servlet corresponds to one servlet config;
        // And one web application corresponds to one servlet context
    }

    /**
     * Get the servlet config
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    /**
     * Return the description of the servlet
     * The info can be defined by you.
     * Not used so often!
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "I'm servlet";
    }

    @Override
    public void destroy() {

    }
}
