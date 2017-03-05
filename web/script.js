function perfilact(autor, foto) {
    autor = document.getElementById(autor);
    foto = document.getElementById(foto);
    autor.classList.toggle("extra");
    foto.style.transition= '0.5s .6s ease-out';
    foto.style.top = '20%';
    foto.style.left = '30%';
    foto.style.height = "160px";
    foto.style.width = "40%";

}
function perfildesact(autor, foto) {
    autor = document.getElementById(autor);
    foto = document.getElementById(foto);
    autor.style.transition= '.3s ease-out';
    autor.classList.toggle("extra");
    foto.style.top = '30%';
    foto.style.left = '50%';
    foto.style.width = "0";
    foto.style.height = "0";
    foto.style.transition= '0s .6s ease-out';
}
function perfilact2(autor, foto) {
    autor = document.getElementById(autor);
    foto = document.getElementById(foto);
    autor.classList.toggle("extra");
    foto.style.transition= '0.5s .6s ease-out';
    foto.style.top = '20%';
    foto.style.left = '30%';
    foto.style.height = "160px";
    foto.style.width = "40%";

}
function perfildesact2(autor, foto) {
    autor = document.getElementById(autor);
    foto = document.getElementById(foto);
    autor.style.transition= '.3s ease-out';
    autor.classList.toggle("extra");
    foto.style.top = '30%';
    foto.style.left = '50%';
    foto.style.width = "0";
    foto.style.height = "0";
    foto.style.transition= '0s .6s ease-out';
}

function chatact(chat) {
    chatt = document.getElementById(chat);
    chatt.classList.toggle("extra");

}
function chatdesact(chat) {
    chatt = document.getElementById(chat);
    chatt.style.transition= '.3s ease-out';
    chatt.classList.toggle("extra");
}


function ingresartexto(event) {
    var time = document.lastModified;
    var mensajeN = document.getElementById('mensaje-lista');
    var texto = document.getElementById('input');

    var texenv = texto.value;

    var ae = '<div class="contenido">' + texenv + '</div>';
    var ei = '<div class="flecha-derecha"></div>';
    var io = '<img src="img\/foto.jpg" alt="" class="foto">';
    var ou ='<div class="fecha">' + time + '</div>';

    var textoall = '<div class="mensaje-autor">' + ae + ei + io + ou + '</div>';

    var keyCode = event.keyCode || event.which;
    var boton = {enter: 13};
    switch (keyCode) {
        case boton.enter:
            if (!texto.value == '') {
                texto.value = '';
                mensajeN.innerHTML += textoall;
                scrollbajo();
            }else {
                scrollbajo();
            }
        break;
    }

}

function filterFunction(uno,dos) {
    poner = document.getElementById(uno);
    orden = poner.value.toUpperCase();
    div = document.getElementById(dos);
    a = div.getElementsByTagName("a");

    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(orden) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    };
}

function AbreLinks(evt, Nombre) {
    // Declara todas las variables
    var i, tabcontent, tablinks;

    // Obtener todos los elementos con class = "tabcontent" y los oculta
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Obtener todos los elementos con class = "tablinks" y eliminar la clase "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Mostrar la pestaña actual y agregar una clase "active" al enlace que abrió la pestaña
    document.getElementById(Nombre).style.display = "flex";
    evt.currentTarget.className += " active";
}


function MenuDesplegable(evento) {
    document.getElementById(evento).classList.toggle("show");
}

window.onclick = function(event) {
    if (!event.target.matches('#menu')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        };
    };
}

window.addEventListener('load',scrollbajo,false);

function scrollbajo() {
    mensajelista = document.getElementById('mensaje-lista');

    mensajelista.scrollTop = 2000;
}


function ponerReadOnly(id) {
    // Ponemos el atributo de solo lectura
    $("#"+id).attr("readonly","readonly");
    // Ponemos una clase para cambiar el color del texto y mostrar que
    // esta deshabilitado
    $("#"+id).addClass("readOnly");
}

function quitarReadOnly(id) {
    // Eliminamos el atributo de solo lectura
    $("#"+id).removeAttr("readonly");
    // Eliminamos la clase que hace que cambie el color
    $("#"+id).removeClass("readOnly");
}
