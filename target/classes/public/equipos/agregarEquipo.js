let agregar = document.querySelector('.agregar');
let volver = document.querySelector('.volver');

agregar.addEventListener('click', (e) => {
	e.preventDefault();

	let data = new FormData();
	data.append("nmEquipo", document.getElementById('nmEquipo').value);
	data.append("slogan", document.getElementById('slogan').value);
	data.append("dt", document.getElementById('dt').value);
	data.append("torneo", document.getElementById('torneo').value);

	let object = {};
  
    data.forEach(function(value, key){
        object[key] = value;
    });

  	let json = JSON.stringify(object);

  	fetch("/equipo", {
  		method: 'POST',
  		body: json
  	})
  	.then((response) => {
  		if(response.ok) {
  			window.location = "/equipos/equipos.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
	window.location = "/equipos/equipos.html";
});