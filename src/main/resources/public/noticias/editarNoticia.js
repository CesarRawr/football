let actualizar = document.querySelector('.actualizar');
let volver = document.querySelector('.volver');

actualizar.addEventListener('click', (e) => {

	  e.preventDefault();

    let info = new FormData();
    info.append("idNoticia", document.getElementById("idNoticia").value);
    info.append("tituloN", document.getElementById("tituloN").value);
    info.append("infoN", document.getElementById("infoN").value);

    let object = {};

    info.forEach(function(value, key){
        object[key] = value;
    });

    let json = JSON.stringify(object);

  	fetch('/noticia', {
  		method: 'PUT',
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
