# servletJspWebDevelopment
app url - http://localhost:8080/MavenWebApp/ <br/>
**1**.Contains example of dynamic web project using maven,java 8,apache tomcat 9. Here framework like Spring,Strut,JSF is not used<br/>
**2**.Servlet is added to return dynamic html.<br/>
**3**.As a good practice return redirect url from post method.<br/>
by this way after receiving response user cannot resbmit the form by refreshing browser refresh button.<br/>
**4**. __Cookie__ are created by server if in request it did not receive any from client request and after that it is exchanged b/w server-client in each request. in thi way user can be identified.<br/>
Cookie can store text data only. and mostly browser allows max 4kb size for cookie.it is stored in client harddisk.the server uses Set-Cookie HTTP-header in the response to set a cookie<br/>
**5**.**Session** flow -
**5.1** Session are maintained on server side.<br/>
User send request via browser to server to add item to cart. <br/>
Since this is the first request server creates sessionid(unique identifier to identify client) and store it in database with cart details and also create cookie with passing this sessionid only in the response header back to browser.<br/>
**5.2** Browser display the html page and store the cookie in client machine.<br/>
**5.3** Now after searching another product. user again wants to add one more product to cart.<br/> 
**5.4** So,new request is send to server to add product2 to cart and along with request cookie is also send.<br/>
**5.5** On recieving request server read the session id from cookie and enquire db to get cart details and update cart with new product. and send the response with cookie back to browser.<br/>
**6** In java request.getSession() will give **javax.servlet.http.HttpSession** object and by using setAttribute we can set <key,value> pair into session.<br/>
key is String and value can be any Object type.<br/>
It is an in-memory java mapand in browser when we see cookie we only see session id and if we delete that cookie server will not be able to recognize <br/>
**7**. **Session timeout** -> can be set in web.xml using tag session-timeout under session-config tag. if we set 120 it means session will remain till 2 minute.
<br/> Zero value means session will never expire.<br/>
**8** **URL Re-Writing** -> it can be used if cookie is disabled in browser.if cookie is disabled then session id is send in request param<br/>
In java this can be done directly by using encode method. encode method append jsession id only if cookie is disabled.<br/>
**9** We can use Security provided by Servlet. for that steps are - <br/>
**9.1** First create role and add user to role in your tomcat-users.xml. (role should match as specified in web.xml) <br/>
**9.2** In application web.xml add security-constraints and add auth-method as FORM inside login-config. <br/>
**9.3** Create login page which has form action - j_security_check and j_username and j_password for input's<br/>
**9.4** Now run the application and if we try to access restricted resource we got redirected to login page <br/>
There we need to provide correct username and password mentioned in tomcat-users.xml <br/>
**10** To get logged-in user name use. httpRequestObj.getUserPrincipal().getName() method<br/>
**11** In this example H2-database is used as for it no new installation required. H2 databse is used in embedded mode.<br/>
**12** DB file named restaurant will get created inside users folder e.g. - C:\Users\g521885\restaurant.mv<br/>
**13** **ServletFilter**  are used to intercept servlet request. Inside doFilter we can perform - logging,can modify request param or perform validation of request.<br/>
just add **javax.servlet.annotation @WebFilter**  provide servlet url list to which we want to apply this filter and implement **javax.servlet.Filter**<br/>
**14** **HttpServletRequestWrapper** class can be extended to overrite ServletRequest methods like getParameter. this is example of **decorator design pattern**.<br/>
**15** **JSP - Java Server Pages** is a page that has java code inside html.So, it will be easier to create page.<br/>
JSP is first translated to servlet and after that servlet is compiled and then html is returned. **Scriptlet** are used to embed java in html<br/>
**16** In JSP everything we write will go inside service method of servlet. but we want import to be at the top of java class.so, we cannot write it inside <% tag. so,for that we will page directive which will tell compiler that these lines go at the top and not part of servlet. e.g.  - **<%@ page import = "java.util.Date" %>** <br/>
**17** **<%= %>** is used to display expression which result in some value.<br/>
**18** It is still tough to call java code inside jsp to loop over collection or call api. so, to make it more html freindly **jstl tags** are introduced. which looks like html tag but internally when compiled it get converted into some java code.<br/>
**19** There is one tag lib provided by sun which contain all general purpose tags we needed **<%@ taglib uri="name_of_tag_lib" prefix="local_name_by_which_we_refer_in_local" %>** <br/> To use it we need to add dependency in pom first.<br/>
**20** Similarly we can use formatting jstl library also which contains formatDate and formatNumber method. where core library contains core tags like foreach,if.<br/>
**21** **AJAX -Asynchronus javascript and xml** is a way by which request is send via java script fucntion to servlet and  servlet return response html or json back and then java script update the specific section of page.<br/>ThankYou.jsp has example of such flow<br/>
