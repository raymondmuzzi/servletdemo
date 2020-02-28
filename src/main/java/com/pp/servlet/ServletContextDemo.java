package com.pp.servlet;

import javax.servlet.*;

/**
 * There is one context per "web application"[which has a collection of servlet]
 * per Java Virtual Machine.
 * <p>
 * Defines a set of methods that a servlet uses to communicate with its
 * servlet container.
 * <p>
 * Because there is only one servlet context in one jvm, so in the distributed system
 * the servlet context can not be used as a location to share global information, use
 * database(or other external resource) instead.
 * <p>
 * The servlet context is maintained in the servlet config object
 * <p>
 * We can define the context init param in the web.xml, this config is shared by
 * the whole web application. But the init param can only be defined after the
 * server init. We can not re-modify the context param while the server is running.
 * The config should be config in the <context-param> tag.
 * And get the param via ServletContext.getInitParameter(String paramName)
 */
public class ServletContextDemo implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) {
        this.servletConfig = config;

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) {
        ServletContext servletContext = servletConfig.getServletContext();
        // Get the attribute from servlet context
        String value = (String) servletContext.getAttribute("attr");
        System.out.println(value);
        String root = servletContext.getInitParameter("root");
        System.out.println(root);

        // Get the context path of the web app
        System.out.println(servletContext.getContextPath());

        // Get the real path of resource by virtual path
        // This method often used in the file upload and download
        System.out.println(servletContext.getRealPath("/index.jsp"));

        // Can be used in the domain object to share data


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
