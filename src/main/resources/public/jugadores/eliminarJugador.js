let eliminar = document.querySelector('.eliminar');
let volver = document.querySelector('.volver');

eliminar.addEventListener('click', (e) => {
	e.preventDefault();

    let id = document.getElementById('idJugador').value;

  	fetch(`/jugador/${id}`, {
  		method: 'DELETE'
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