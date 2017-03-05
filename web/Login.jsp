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
        
         <script src="http://code.jquery.com/jquery-latest.js">
        </script>
        <script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			var email = $('#email').val();
			var clave = $('#clave').val();
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post('LoginConexion.do', {
				nombre : email,
				apellido: clave
			}, function(responseText) {
			 	// $('#tabla').html(responseText);
			});
		});
	});
</script>
 </head>   
       
    <body>
     <h1>Login</h1>
     <form id="form1">
       <p>USUARIO:
         <input type="text" name="email" id="email">
              </p>
        <p> PASWORD:
          <input type="password" name="clave" id="clave">
              </p>
              <p>
       <input type="submit" name="ingresar" id="ingresar" value="Ingresar">
              </p>    
        </form>
                  
    </body>
</html>
