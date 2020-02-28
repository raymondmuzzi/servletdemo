package com.pp.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is a http servlet
 * <p>
 * To handle the http request's servlet.
 */
public class MyHttpServlet extends HttpServlet {
    public MyHttpServlet() {
        System.out.println("This is constructor");
    }

    /**
     * Usually put the business code in the doPost method
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.Response the string to the client side
        // PrintWriter printWriter = response.getWriter();
        // printWriter.write("Hello HttpServlet...");

        // 2.Redirect to another page or other resource
        // Redirect: the server instructs the browser to visit other resource
        // If call the sendRedirect, the former request has accomplished,
        // then a new request has been send to visit other resource
        // We can see from chrome's f12, there're 2 requests totally.
        // The original request's return code is 302 and the target resource's return code is 304
        // response.sendRedirect("success.html");

        // 3.HttpServletRequest represents the client sends to the server's request info
        // HttpServletRequest contains the first line of the request
        // and the request head and the request body

        // HttpServletRequest could get the parameter from the request.
        // GET: the parameter from url
        // POST: the parameter from request body
        // request.getParameter() method could get the parameter regardless the request method
        // which means the GET POST DELETE PUT methods' parameter could be obtained via this method
        // String username = request.getParameter("username");
        // System.out.println(username);

        // If there are multi values in one parameter, we can use the getParameterValues() method
        // to get the values array
        // String[] parameterValues = request.getParameterValues("hobbies");
        // for (String parameterValue : parameterValues) {
        //     System.out.println(parameterValue);
        // }

        // Get the request head's info
        // String accept = request.getHeader("Accept");
        // System.out.println("accept header:" + accept);

        // Forward to the page or resources
        // Different from the redirect, there is only one request when forwards
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("forwardpage.html");
        requestDispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Usually, when GET request comes call the doPost method
        doPost(request, response);
    }
}