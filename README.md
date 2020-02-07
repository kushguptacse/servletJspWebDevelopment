# servletJspWebDevelopment
**1**.Contains example of dynamic web project using maven,java 8,apache tomcat 9.<br/>
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
**6** In java request.getSession() will give javax.servlet.http.HttpSession object and by using setAttribute we can set <key,value> pair into session.<br/>
key is String and value can be any Object type.<br/>
It is an in-memory java mapand in browser when we see cookie we only see session id and if we delete that cookie server will not be able to recognize <br/>
**7**. **Session timeout** -> can be set in web.xml using tag session-timeout under session-config tag. if we set 120 it means session will remain till 2 minute.
<br/> Zero value means session will never expire.<br/>
**8** **URL Re-Writing** -> it can be used if cookie is disabled in browser.if cookie is disabled then session id is send in request param<br/>
In java this can be done directly by using encode method. encode method append jsession id only if cookie is disabled.<br/>