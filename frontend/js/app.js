document.addEventListener('DOMContentLoaded', function() {
document.getElementById('listarTodo').addEventListener('click', function(event) {
    event.preventDefault(); // Evita que la página se recargue

   /* var titulo = document.getElementById('titulo').value;
    var autor = document.getElementById('autor').value;
    var idioma = document.getElementById('idioma').value;
    var genero = document.getElementById('genero').value;

    // Construye la URL de la API con los parámetros de búsqueda
    var url = 'https://gutendex.com/books?';
    if (titulo) url += 'title=' + titulo + '&';
    if (autor) url += 'author=' + autor + '&';
    if (idioma) url += 'languages=' + idioma;
    if (genero) url += 'genre=' + genero;

    */
    // Realiza una solicitud GET al servidor para obtener la contraseña
    /*fetch('http://localhost:8080/getPassword', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })

        .then(response => response.json())
        .then(data => {
            const password = data.password;
            // Ahora puedes usar la contraseña para hacer otra solicitud o lo que necesites hacer con ella
        })
        .catch((error) => {
            console.error('Error:', error);
        });
*/


    // Realiza una solicitud GET al servidor
    fetch('http://localhost:8080/libros', {
        headers: {
            'Authorization': 'Basic ' + btoa('user:Nastya')
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('la respuesta no es correcta' + response.status);
            }
            return response.text();
        })
        .then(data => {
            if (data) {
                return JSON.parse(data);
            } else {
                return {};
            }
        })
        .then(libros => {
            var librosDiv = document.getElementById('resultados');
            libros.forEach(libro => {
                var libroDiv = document.createElement('div');
                var titulo = document.createElement('h2');
                var autor = document.createElement('p');
                var idioma = document.createElement('p');
                var descargas = document.createElement('p');

                titulo.textContent = libro.title;
                autor.textContent = 'Autor: ' + libro.authors[0].name;
                idioma.textContent = 'Idioma: ' + libro.languages[0];
                descargas.textContent = 'Descargas: ' + libro.download_count;

                libroDiv.appendChild(titulo);
                libroDiv.appendChild(autor);
                libroDiv.appendChild(idioma);
                libroDiv.appendChild(descargas);

                librosDiv.appendChild(libroDiv);
            });
        })
        .catch(error => {
            // Muestra un mensaje de error
            console.error('Error:', error);
        });
});
});