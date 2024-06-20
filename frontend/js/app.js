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
            data.forEach(Libro => {
                var libroDiv = document.createElement('div');
                libroDiv.textContent = libro.title + ' por ' + libro.authors[0].name; // Asegúrate de que los nombres de las propiedades coincidan con los de tu objeto libro
                resultadosDiv.appendChild(libroDiv);
            });
        })
        .catch(error => {
            // Aquí puedes manejar cualquier error que ocurra durante la solicitud
            console.error('Error:', error);
        });
});
