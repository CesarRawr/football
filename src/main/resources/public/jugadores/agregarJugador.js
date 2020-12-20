let agregar = document.querySelector('.agregar');
let volver = document.querySelector('.volver');

agregar.addEventListener('click', (e) => {
	e.preventDefault();

	let info = new FormData();
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

  	fetch("/jugador", {
  		method: 'POST',
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