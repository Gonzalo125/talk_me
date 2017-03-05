<!DOCTYPE html>
<html>
<head>
	<title>Mensajeria</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<script src="js/jquery.min.js"></script>
	<script src="script.js"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> 
         <link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/estilo2.css">
	<link rel="stylesheet" type="text/css" href="css/estilo3.css">
        <script>
            $(document).ready(function () {
                    
                    var id = "8";

                    $.ajax({
                        type: "get",
                        url: 'datosUser',
                        contentType: 'application/json',
                        dataType:'json',
                        data: {
                            id_usuario :id,
                        },
                        success: function (data) {
                           $('div .perfil-info').val(data.nombre_usu);
                        }
                    })
                });
            
        </script>
</head>
<body>
	<div class="panel" id="portada-panel">

		<div class="pane panel-uno perfil-autor" id="PERFIL-AUTOR">
			<div style="width: 90%;height: 5%; padding: 14% 5% 6% 5%;background-color: #4188dc;color: white;">
				<div id="atras" style="width: 10%;height: 10%;float: left;margin-right: 2%" onclick="perfildesact('PERFIL-AUTOR', 'perfil-foto')">
					<img id="atras" src="img/atras.png"/>
				</div>
				<h2 style="float: left;font-size: 170%;"> Perfil</h2> 	
			</div>
			<div id="perfil-foto">
				<img src="img/foto.jpg" style="width: 100%;height: 100%">
			</div>
			
                       <div class="perfil-info"><!-- cuadro de contenido -->
                                <input type="text" id="texto-info-1" readonly /><!-- id de texto -->
                                <button id="enviaNombre-1" type="button" ondblclick="ponerReadOnly('texto-info-1')" onclick="quitarReadOnly('texto-info-1')" ></button><!-- boton UN dobleclic quita el modo lectura-->
                        </div>	
						<div class="perfil-info">
                                <input type="text" id="texto-info-2" readonly />
                                <button id="enviaNombre-2" type="button" ondblclick="ponerReadOnly('texto-info-2')" onclick="quitarReadOnly('texto-info-2')" ></button>
                        </div>	
						<div class="perfil-info">
                                <input type="text" id="texto-info-3" readonly="readonly"/>
                                <button id="enviaNombre-3" type="button" ondblclick="ponerReadOnly('texto-info-3')" onclick="quitarReadOnly('texto-info-3')" ></button>
                        </div>	
						<div class="perfil-info">
                                <input type="text" id="texto-info-4" readonly="readonly"/>
                                <button id="enviaNombre-4" type="button" ondblclick="ponerReadOnly('texto-info-4')" onclick="quitarReadOnly	('texto-info-4')" ></button>
                        </div>	
						<div class="perfil-info">
                                <input type="text" id="texto-info-5" readonly="readonly"/>
                                <button id="enviaNombre-5" type="button" ondblclick="ponerReadOnly('texto-info-5')" onclick="quitarReadOnly	('texto-info-5')" ></button>
                        </div>
                    
		</div>
		
		<div class="pane panel-uno nuevo-chat" id="nuevo-chat">
			<div style="width: 90%;height: 5%; padding: 14% 5% 6% 5%;background-color: #4188dc;color: white;">
				<div id="atras" style="width: 10%;height: 10%;float: left;margin-right: 2%" onclick="chatdesact('nuevo-chat')">
					<img id="atras" src="img/atras.png"/>
				</div>
				<h2 style="float: left;font-size: 170%;"> Nuevo Chat</h2> 	
			</div>
			<div class="contenido">
				<input type="text" placeholder="Buscar..." id="bchat" onkeyup="filterFunction('bchat','cc3')">
				<div id="cc3">
					<a href='javascript:void(0)'><img src='' class='foto'/><div class='persona'>Person 01</div></a>
				</div>
			</div>
		</div>

		<div class="pane panel-tres perfil-otro" id="PERFIL-OTRO">

			<div style="width: 90%;height: 5%; padding: 14% 5% 6% 5%;background-color: #4188dc;color: white;">
				<div id="atras" style="width: 10%;height: 10%;float: left;margin-right: 2%" onclick="perfildesact2('PERFIL-OTRO', 'perfil-foto2')">
					<img id="atras" src="img/atras.png"/>
				</div>
				<h2 style="float: left;font-size: 170%;"> Nombre del perfil</h2> 	
			</div>
			<div id="perfil-foto2">
				<img src="img/foto.jpg" style="width: 100%;height: 100%">
			</div>
			<div class="perfil-info">NOMBRE</div>	
			<div class="perfil-info">OTRO</div>	
			<div class="perfil-info">OTRO</div>	
		</div>

	</div>

	<div class="pane panel-uno" >
		<div class="panel-cabeza panel-lista-cabeza">
			<div class="panel-lista-user">
				<div id="avatar" class="avatar" onclick="perfilact('PERFIL-AUTOR', 'perfil-foto')" style="height: 40px; width: 40px; cursor: pointer">
					<img src="img/foto.jpg" alt="" class="foto"/>
				</div>
			</div>
			<div class="panel-lista-controles">
				<div class="menu-horizontal">
					<div class="menu-obj">
						<button onclick="MenuDesplegable('myDropdown')" class="icono" title="MENU" id="menu"></button>
					    <div id="myDropdown" class="dropdown-content" style="display: none;">
							<a href="javascript:void(0)">Configuracion</a>
							<a href="javascript:void(0)">Cambiar Foto</a>
							<a href="javascript:void(0)" onclick="chatact('nuevo-chat')">Crear Chat</a>
					    </div>
					</div>
					<div class="menu-obj">
						<button class="icono" title="Nuevo Chat"></button>
					</div>
				</div>
			</div>
		</div>

		<div class="tab">
		  <a href="javascript:void(0)" class="tablinks active" onclick="AbreLinks(event, 'CHATS')">CHATS</a>
		  <a href="javascript:void(0)" class="tablinks" onclick="AbreLinks(event, 'CONTACTOS')">CONTACTOS</a>
		</div>

		<div id="CHATS" class="tabcontent active">
			<div class="contenido">
				<input type="text" placeholder="Buscar..." id="myInput" onkeyup="filterFunction('myInput','cc')">
				<div id="cc">
					<a href='javascript:void(0)'><img src='' class='foto'/><div class='persona'>Persona 01</div></a>
				</div>
			</div>
		</div>

		<div id="CONTACTOS" class="tabcontent">
			<div class="contenido">
				<input type="text" placeholder="Buscar..." id="myInput2" onkeyup="filterFunction('myInput2','cc2')">
				<div id="cc2">
					<a href='javascript:void(0)'><img src='' class='foto'/><div class='persona'>Person 01</div></a>
				</div>
			</div>
		</div>
	</div>

	<div class="pane panel-dos" >
		<div class="FONDO-CHAT"></div>

		<div class='panel-cabeza panel-chat-cabeza'>
			<img src='img/foto2.jpg' class='foto'/>
			<div>Jennifer Love Hewitt</div>
			<div class='menu-obj'>
				<button onclick="perfilact2('PERFIL-OTRO','perfil-foto2')" class='icono' title='MENU' id='menu2'></button>
			</div>
		</div>

		<div class="panel-cuerpo panel-chat-titulo-contenedor">
			<div>
				<div class="pane-chat-msgs pane-chat-cuerpo">

					<div class="mensaje-lista" id="mensaje-lista">

						<div class="mensaje-amigo">
							<img src="img/foto2.jpg" alt="" class="foto">
							<div class="flecha-izquierda"></div>
							<div class="contenido">
								Jajaja que onda señor Rivas, como está?? <br />
								Yo estoy muy bien, cansada como siempre por la serie jeje :/
							</div>
							<div class="fecha">Enviado hace ocho horas</div>
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
						<input type='text' id="input" name='input' class="input" contenteditable="true" dir="auto" placeholder='Escribe un mensaje aquí' spellcheck="true" onkeydown='ingresartexto(event)'/>
					</div>

				</div>
			</div>
		</footer>
	</div>
</body>
</html>