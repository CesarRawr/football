let agregar = document.querySelector('.agregar');
let volver = document.querySelector('.volver');

agregar.addEventListener('click', (e) => {
	e.preventDefault();

	let data = new FormData();
	data.append("equipoL", document.getElementById('equipoL').value);
	data.append("equipoV", document.getElementById('equipoV').value);
	data.append("fechaP", document.getElementById('fechaP').value);
	data.append("horaP", document.getElementById('horaP').value);

	let object = {};
  
    data.forEach(function(value, key){
        object[key] = value;
    });

  	let json = JSON.stringify(object);

  	fetch("/partido", {
  		method: 'POST',
  		body: json
  	})
  	.then((response) => {
  		if(response.ok) {
  			window.location = "/partidos/partidos.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
	window.location = "/partidos/partidos.html";
});