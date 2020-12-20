let agregar = document.querySelector('.agregar');
let volver = document.querySelector('.volver');

agregar.addEventListener('click', (e) => {
	e.preventDefault();

	let info = new FormData();
  info.append("tituloN", document.getElementById("tituloN").value);
  info.append("infoN", document.getElementById("infoN").value);

	let object = {};
  
    info.forEach(function(value, key){
        object[key] = value;
    });

  	let json = JSON.stringify(object);

  	fetch("/noticia", {
  		method: 'POST',
  		body: json
  	})
  	.then((response) => {
  		if(response.ok) {
  		  window.location = "/noticias/noticias.html";
  		}
  	});
});

volver.addEventListener('click', (e) => {
  window.location = "/noticias/noticias.html";
});
