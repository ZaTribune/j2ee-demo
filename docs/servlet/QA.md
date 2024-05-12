1) What is difference between GenericServlet and HttpServlet?
   The GenericServlet is protocol independent whereas HttpServlet is HTTP protocol specific. HttpServlet provides additional functionalities such as state management etc.

2) What is servlet collaboration?
   When one servlet communicates to another servlet, it is known as servlet collaboration. 
   There are many ways for servlet collaboration:
   - `RequestDispatcher` interface
   - `sendRedirect()` method etc.

3) Can you call a jsp from the servlet?  
   Yes, one of the ways is `RequestDispatcher` interface for example:
   ```java
   RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");  
   rd.forward(request, response);  
   ```

4) Difference between forward() method and sendRedirect() method?

   | forward()                                   | sendRedirect()                                                       |
   |---------------------------------------------|----------------------------------------------------------------------|
   | sends the same request to another resource. | sends new request always because it uses the URL bar of the browser. |
   | works at server side.                       | works at client side.                                                |
   | works within the server only                | works within and outside the server                                  |

5) What is the difference between `ServletConfig` and `ServletContext`?  
   The container creates an object of `ServletConfig` for each servlet 
   whereas an object of `ServletContext` is created for each web application.

6) What is Session Tracking?  
   Session simply means a particular interval of time.  
   Session Tracking is a way to maintain the state of a webUser.  
   Http protocol is a stateless protocol -> Each time webUser requests to the server, 
   server treats the request as the new request. So we need to maintain the state
   of a webUser.  
   - Cookies
   - HttpSession
   - Hidden input fields
   - URL Rewriting

7) What is the difference between `Cookies` and `HttpSession`?  
   `Cookie` works at client side, whereas `HttpSession` works at server side.

8) What is filter?  
   A filter is an object invoked either at the preprocessing or postprocessing of a request.  
   It is pluggable.

9) How can we perform any action at the time of deploying the project?  
   By the help of `ServletContextListener` interface.  
   See: [DatabaseListener](../../src/main/java/com/tribune/j2ee/bookstore/db/DatabaseListener.java)

10) What is the disadvantage of cookies?  
    It will not work if cookie is disabled from the browser.

11) How can we upload the file to the server using servlet?  
    of the way is by `MultipartRequest` class provided by third party.

12) What is load-on-startup in servlet?  
    The `load-on-startup` element of servlet in `web.xml` is used to load 
    the servlet at the time of deploying the project or server start.  
    So it saves time for the response of the first request.
    Because by default, the servlet won't be loaded unless called for the first time.

13) What if we pass negative value in load-on-startup?  
    It will not affect the container, now servlet will be loaded at first request.

14) What are the annotations used in Servlet?  
    There are mainly `3` annotations used for the servlet.
    - `@WebServlet` : for servlet class.
    - `@WebListener` : for listener class.
    - `@WebFilter` : for filter class.
    
15) Which event is fired at the time of project deployment and un-deployment?  
    `ServletContextEvent`.

16) Which event is fired at the time of session creation or destroyed?  
    `HttpSessionEvent`.

17) Which event is fired at the time of setting, getting or removing attribute 
     from the application scope?  
    `ServletContextAttributeEvent`.

18) What is the use of `welcome-file-list`?
    It is used to specify the welcome file for the project.

19) What is the use of attributes in servlets?  
    Attribute is a map object that can be used to set, get or remove in request,
    session or application scope. 
    It is mainly used to share information between one servlet to another.

20) The life cycle of any `servlet` is managed by?  
    servlet container

21) Dynamic interception of requests and responses to transform the information is done by?  
    servlet filter

22) The include() method of `RequestDispatcher`?  
    includes resource of file like servlet, jsp or html

23) The tasks – authentication-blocking of requests, data compression, 
    logging and auditing – are which component's responsibility?   
    servlet filter

24) The init parameter name and value pairs that are defined in web.xml file are handled by?  
    ServletConfig object

25) What is the difference between Cookies and HttpSession?
    Cookie works at client side whereas HttpSession works at server side

26) A servlet maintains session in? 
    Servlet context — because it's information that could be shared by many servlets.

27) What's the difference between HttpServletRequest's `getParameter()` and `getAttribute()` methods?  
    - `getParameter()` returns http request parameters. These are passed from the client to the server.  
      For example, http://example.com/servlet?parameter=1. They can only return String.
    - `getAttribute()` is for server-side usage only — you fill the request with attributes that you can use within the same request.   
      For example, you set an attribute in a `Servlet` and read it from a `JSP`. These can be used for any object, not just string.
28) What are the two methods of `RequestDispatcher` interface?  
    - `forward(ServletRequest request, ServletResponse response)`: 
       To forward a request from a servlet to another resource 
       (servlet, JSP file, or HTML file) on the server.
    - `include(ServletRequest request, ServletResponse response)`: 
       Includes the content of a resource (servlet, JSP page, or HTML file) in the response.

