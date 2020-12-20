let actualizar = document.querySelector('.actualizar');
let volver = document.querySelector('.volver');

actualizar.addEventListener('click', (e) => {

	  e.preventDefault();

    let info = new FormData();
    info.append("id", document.getElementById("idJugador").value);
    info.append("nombre", document.getElementById("nmJugador").value);
    info.append("fecha", document.getElementById("fechaNacim").value);
    info.append("numero", document.getElementById("numeroJug").value);
    info.append("equipo", document.getElementById("Equipo").value);    
    info.append("torneo", document.getElementById("Torneo").value);

    let object = {};

    info.forEach(function(value, key){
        object[key] = value;
    });

    let json = JSON.stringify(object);

  	fetch('/jugador', {
  		method: 'PUT',
      body: json
  	})
  	.then((response) => {
  		if(response.ok) {
  			window.location = "/jugadores/jugadores.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
	window.location = "/jugadores/jugadores.html";
});