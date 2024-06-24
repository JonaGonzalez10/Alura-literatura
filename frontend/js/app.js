document.getElementById('btnbuscarPorIdioma').addEventListener('click', function(event) {
    event.preventDefault(); // Evita que la página se recargue

    var titulo = document.getElementById('titulo').value;
    var autor = document.getElementById('autor').value;
    var idioma = document.getElementById('idioma').value;
    var genero = document.getElementById('genero').value;

    // Construye la URL de la API con los parámetros de búsqueda
    var url = 'https://gutendex.com/books?';
    if (titulo) url += 'title=' + titulo + '&';
    if (autor) url += 'author=' + autor + '&';
    if (idioma) url += 'languages=' + idioma;
    if (genero) url += 'genre=' + genero;

    // Realiza una solicitud GET al servidor
    fetch(url)
        .then(response => response.json())
        .then(data => {
            var resultadosDiv = document.getElementById('resultados'); // Asegúrate de tener un div con id 'resultados' en tu HTML
            resultadosDiv.innerHTML = ''; // Limpia el div antes de agregar nuevos datos
            data.forEach(libro => {
                var libroDiv = document.createElement('div');
                var titulo = document.createElement('h2');
                var autor = document.createElement('p');
                var idioma = document.createElement('p');
                var descargas = document.createElement('p');

                titulo.textContent = libro.Titulo;
                autor.textContent = 'Autor: ' + libro.authors[0].name;
                idioma.textContent = 'Idioma: ' + libro.languages[0];
                descargas.textContent = 'Descargas: ' + libro.download_count;

                libroDiv.appendChild(titulo);
                libroDiv.appendChild(autor);
                libroDiv.appendChild(idioma);
                libroDiv.appendChild(descargas);

                resultadosDiv.appendChild(libroDiv);

            });
        })
        .catch(error => {
            // Aquí puedes manejar cualquier error que ocurra durante la solicitud
            console.error('Error:', error);
        });
});
