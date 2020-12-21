let agregar = document.querySelector('.agregar');
let volver = document.querySelector('.volver');

agregar.addEventListener('click', (e) => {
	e.preventDefault();

	let data = new FormData();
	data.append("tipoTorneo", document.getElementById('tipoTorneo').value);
	data.append("nmTorneo", document.getElementById('nmTorneo').value);

	let object = {};
  
    data.forEach(function(value, key){
        object[key] = value;
    });

  	let json = JSON.stringify(object);

  	fetch("/torneo", {
  		method: 'POST',
  		body: json
  	})
  	.then((response) => {
  		if(response.ok) {
  			window.location = "/torneos/torneos.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
	window.location = "/torneos/torneos.html";
});