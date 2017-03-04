<%-- 
    Document   : Login
    Created on : 26-feb-2017, 16:37:35
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
 </head>   
       
    <body>
     <h1>Login</h1>
     <form id="form1" name="form1" method="post" action="LoginConexion">
       <p>USUARIO:
         <input type="text" name="email" id="email">
              </p>
        <p> PASWORD:
          <input type="text" name="clave" id="clave">
              </p>
              <p>
       <input type="submit" name="ingresar" id="ingresar" value="Ingresar">
              </p>    
        </form>
                  
    </body>
</html>
