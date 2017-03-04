<%-- 
    Document   : RegistroUsuario
    Created on : 26-feb-2017, 16:37:53
    Author     : User
--%>
<%@page import="java.sql.Date"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/jquery.min.js"></script>
    
    <script>
    $(document).ready(function() {
		$('#submit').click(function(event) {
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post( {
				
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
        
        
            </script>
            </head>
    <body>
        <h1>  NUEVO REGISTRO</h1>
        <form id="EnviarRegistro" action="RegistroUsuario" method="post">
        
    <center>
        <table align="center">
            <tr>
                
          
                <td> Nombre(s):</td>    
                <td> <input type="text" name="nombre"></td>
            </tr>
            
            <tr>
                <td> ID Usuario:</td>    
                <td> <input type="text" name="id_usuar"></td>
            </tr>
            
             <tr>
                <td> Password:</td>    
                <td> <input type="text" name="password:"></td>
            </tr>
            
              <tr>
                <td> Alias:</td>    
                <td> <input type="text" name="alias"></td>
            </tr>
             <tr>
                <td> Estado:</td>    
                <td> <input type="text" name="estado"></td>
            </tr>
            
            <tr>
                <td> Email:</td>    
                <td> <input type="text" name="email"></td>
            </tr>
            
            
             <tr>
                <td> Teléfono:</td>    
                <td> <input type="text" name="telef"></td>
            </tr>
            
            
    

            <tr>
                <td></td>    
                <td> <input type="submit" id="submit" value="Guardar"></td>
            </tr>   
        </table>
        
       
        
        
    </center>
        </form>
      <div id="tabla"></div>  
    </body>
    
</html>
