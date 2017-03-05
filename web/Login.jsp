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

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js">
        </script>
        <script>
            $(document).ready(function () {
                $('#ingresar').click(function (event) {
                    var email = $('#email').val();
                    var clave = $('#clave').val();

                    $.ajax({
                        type: "post",
                        url: 'LoginConexion',
                        data: {
                            email: email,
                            clave: clave,
                        },
                        success: function (data, textStatus, jqXHR) {
                            data = data.replace(/\s+/, "");
                            if (data == "true") {
                                location.href = "/talk_me/panta_chat.jsp"
                            } else {
                                alert("datos incorrectos");
                            }
                        }
                    })
                });
            });
        </script>
    </head>   

    <body>
        <h1>Login</h1>
        <form id="for">
            <p>USUARIO:
                <input type="text"  id="email">
            </p>
            <p> PASWORD:
                <input type="password"  id="clave">
            </p>
            <p>
                <input type="button" id="ingresar" value="Ingresar">
            </p>    
        </form>

    </body>
</html>
