document.addEventListener('DOMContentLoaded', function () {
    const bookForm = document.getElementById('book-form');
    const bookList = document.getElementById('book-list');

    function fetchBooks() {
        fetch('/books')
            .then(response => response.json())
            .then(books => {
                bookList.innerHTML = '';
                books.forEach(book => {
                    const div = document.createElement('div');
                    div.innerHTML = `
                        ${book.title} by ${book.author} (ISBN: ${book.isbn})
                        <button onclick="editBook(${book.id})">Edit</button>
                        <button onclick="deleteBook(${book.id})">Delete</button>
                    `;
                    bookList.appendChild(div);
                });
            });
    }

    bookForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const bookId = document.getElementById('book-id').value;
        const title = document.getElementById('title').value;
        const author = document.getElementById('author').value;
        const isbn = document.getElementById('isbn').value;

        const book = {title, author, isbn};

        if (bookId) {
            fetch(`/books/${bookId}`, {
                method: 'PUT',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(book)
            }).then(() => {
                fetchBooks();
                bookForm.reset();
            });
        } else {
            fetch('/books', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(book)
            }).then(() => {
                fetchBooks();
                bookForm.reset();
            });
        }
    });

    window.editBook = function (id) {
        fetch(`/books/${id}`)
            .then(response => response.json())
            .then(book => {
                document.getElementById('book-id').value = book.id;
                document.getElementById('title').value = book.title;
                document.getElementById('author').value = book.author;
                document.getElementById('isbn').value = book.isbn;
            });
    }

    window.deleteBook = function (id) {
        fetch(`/books/${id}`, {method: 'DELETE'})
            .then(() => fetchBooks());
    }

    fetchBooks();
});
