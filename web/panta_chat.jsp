<%-- 
    Document   : panta_chat
    Created on : 03-mar-2017, 18:33:56
    Author     : User
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Mensajeria</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<script src="js/jquery.min.js"></script>
	<script src="script.js"></script>
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/estilo2.css">
	<link rel="stylesheet" type="text/css" href="css/estilo3.css">
</head>
<body>
	<div class="panel" id="portada-panel">

		<div class="pane panel-uno perfil-autor" id="PERFIL-AUTOR">
			<div style="width: 90%;height: 5%; padding: 14% 5% 6% 5%;background-color: #4188dc;color: white;">
				<div id="atras" style="width: 10%;height: 10%;float: left;margin-right: 2%" onclick="perfildesact()">
					<img id="atras" src="img/atras.png"/>
				</div>
				<h2 style="float: left;font-size: 170%;"> Perfil</h2> 	
			</div>
			<div id="perfil-foto">
				<img src="img/foto.jpg" style="width: 100%;height: 100%">
			</div>
                    <form action="Actualizar_user.java" method="post">
                        <input name="perfil-info" id="perfil-info" />
                        <button type="submit">Enviar</button>
                    </form>   
		</div>

		<span class="pane panel-dos" style="display: none; z-index: 99999">CHATS</span>
		<span class="pane panel-tres" style="display: none; z-index: 99999">PERFIL</span>
	</div>

	<div class="pane panel-uno" >
		<header class="panel-cabeza panel-lista-cabeza">
			<div class="panel-lista-user">
				<div id="avatar" class="avatar" onclick="perfilact()" style="height: 40px; width: 40px; cursor: pointer">
					<img src="img/foto.jpg" alt="" class="foto">
				</div>
			</div>
			<div class="panel-lista-controles">
				<div class="menu-horizontal">
					<div class="menu-obj">
						<button onclick="MenuDesplegable()" class="icono" title="MENU" id="menu"></button>
					    <div id="myDropdown" class="dropdown-content" style="visibility: hidden;display: block;">
							<a href="#home">Configuracion</a>
							<a href="#about">Cambiar Foto</a>
					    </div>
					</div>
					<div class="menu-obj">
						<button class="icono" title="Nuevo Chat"></button>
					</div>
				</div>
			</div>
		</header>

		<div class="tab">
		  <a href="javascript:void(0)" class="tablinks active" onclick="AbreLinks(event, 'CHATS')">CHATS</a>
		  <a href="javascript:void(0)" class="tablinks" onclick="AbreLinks(event, 'CONTACTOS')">CONTACTOS</a>
		</div>

		<div id="CHATS" class="tabcontent active">
			<div class="contenido">
			<input type="text" placeholder="Buscar..." id="myInput" onkeyup="filterFunction('myInput','cc')">
				<div id="cc">
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 01</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 02</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 03</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 04</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 05</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 06</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 07</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 08</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 09</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Persona 10</div></a>
				</div>
			</div>
		</div>

		<div id="CONTACTOS" class="tabcontent">
			<div class="contenido">
			<input type="text" placeholder="Buscar..." id="myInput2" onkeyup="filterFunction('myInput2','cc2')">
				<div id="cc2">
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 01</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 02</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 03</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 04</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 05</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 06</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 07</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 08</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 09</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 10</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 11</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 12</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 13</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 14</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 15</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 16</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 17</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 18</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 19</div></a>
					<a href='javascript:void(0)'><img src='' class='foto'><div class='persona'>Person 20</div></a>
				</div>
			</div>
		</div>
	</div>

	<div class="pane panel-dos" >
		<div class="FONDO-CHAT"></div>

		<header class="panel-cabeza panel-chat-cabeza">
			<img src="img/foto2.jpg" alt="" class="foto">
			<div>Jennifer Love Hewitt (Activo ahora...)</div>
		</header>

		<div class="panel-cuerpo panel-chat-titulo-contenedor">
			<div>
				<div class="pane-chat-msgs pane-chat-cuerpo">

					<div class="mensaje-lista" id="mensaje-lista">

						<div class="mensaje-autor">
							<div class="contenido">
								Hola mi Jenny!!! Cómo estás??
							</div>
							<div class="flecha-derecha"></div>
							<img src="img/foto.jpg" alt="" class="foto">
							<div class="fecha">Enviado hace ocho horas</div>
						</div>

						<div class="mensaje-amigo">
							<img src="img/foto2.jpg" alt="" class="foto">
							<div class="flecha-izquierda"></div>
							<div class="contenido">
								Jajaja que onda señor Rivas, como está?? <br />
								Yo estoy muy bien, cansada como siempre por la serie jeje :/
							</div>
							<div class="fecha">Enviado hace ocho horas</div>
						</div>

						<div class="mensaje-autor">
							<div class="contenido">
								Hola ??
							</div>
							<div class="flecha-derecha"></div>
							<img src="img/foto.jpg" alt="" class="foto">
							<div class="fecha">Enviado hace 6 horas</div>
						</div>

						<div class="mensaje-amigo">
							<img src="img/foto2.jpg" alt="" class="foto">
							<div class="flecha-izquierda"></div>
							<div class="contenido">
								zzzzzZZZZZZ <br />
								jeje
							</div>
							<div class="fecha">Enviado hace tres minutos</div>
						</div>

						<div class="mensaje-amigo">
							<img src="img/foto2.jpg" alt="" class="foto">
							<div class="flecha-izquierda"></div>
							<div class="contenido">
								Jajaja es que me quede dormido viendo la serie :P <br />	
							</div>
							<div class="fecha">Enviado hace tres minutos</div>
						</div>

					</div>

				</div>
			</div>
		</div>

		<footer tabindex="-1" class="panel-footer pane-chat-footer">
			
			<div class="block-compose">
				<button class="icono btn-emoji"></button>
				<div tabindex="-1" class="input-container">
					<div tabindex="-1" class="input-emoji" id="input-emoji">
						<input type='text' id="input" class="input" contenteditable="true" dir="auto" placeholder='Escribe un mensaje aquí' spellcheck="true" onkeydown='ingresartexto(event)'/>
					</div>

				</div>
			</div>
		</footer>
	</div>
</body>
</html>
