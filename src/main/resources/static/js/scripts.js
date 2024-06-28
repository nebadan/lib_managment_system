document.addEventListener("DOMContentLoaded", function () {
  const bookForm = document.getElementById("book-form");
  const bookList = document.getElementById("book-list");

  function fetchBooks() {
    fetch("/books")
      .then((response) => response.json())
      .then((books) => {
        bookList.innerHTML = "";
        const table = document.createElement("table");
        const tableHead = document.createElement("thead");
        const tableRow = document.createElement("tr");
        const titleCol = document.createElement("th");
        const authorCol = document.createElement("th");
        const isbnCol = document.createElement("th");

        titleCol.textContent = "Title";
        authorCol.textContent = "Author";
        isbnCol.textContent = "ISBN";

        tableRow.appendChild(titleCol);
        tableRow.appendChild(authorCol);
        tableRow.appendChild(isbnCol);
        tableHead.appendChild(tableRow);
        table.appendChild(tableHead);

        const tableBody = document.createElement("tbody");
        books.forEach((book) => {
          const row = document.createElement("tr");
          const titleCell = document.createElement("td");
          const authorCell = document.createElement("td");
          const isbnCell = document.createElement("td");
          const editCell = document.createElement("td");
          const deleteCell = document.createElement("td");

          titleCell.textContent = book.title;
          authorCell.textContent = book.author;
          isbnCell.textContent = book.isbn;

          const editButton = document.createElement("button");
          editButton.textContent = "Edit";
          editButton.classList.add("edit-button");
          editButton.addEventListener("click", () => editBook(book.id));

          const deleteButton = document.createElement("button");
          deleteButton.textContent = "Delete";
          deleteButton.classList.add("delete-button");
          deleteButton.addEventListener("click", () => deleteBook(book.id));

          editCell.appendChild(editButton);
          deleteCell.appendChild(deleteButton);

          row.appendChild(titleCell);
          row.appendChild(authorCell);
          row.appendChild(isbnCell);
          row.appendChild(editCell);
          row.appendChild(deleteCell);

          tableBody.appendChild(row);
        });

        table.appendChild(tableBody);
        bookList.appendChild(table);
        bookList.appendChild(div);
      });
  }

  bookForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const bookId = document.getElementById("book-id").value;
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const isbn = document.getElementById("isbn").value;

    const book = { title, author, isbn };

    if (bookId) {
      fetch(`/books/${bookId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(book),
      }).then(() => {
        fetchBooks();
        bookForm.reset();
      });
    } else {
      fetch("/books", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(book),
      }).then(() => {
        fetchBooks();
        bookForm.reset();
      });
    }
  });

  window.editBook = function (id) {
    fetch(`/books/${id}`)
      .then((response) => response.json())
      .then((book) => {
        document.getElementById("book-id").value = book.id;
        document.getElementById("title").value = book.title;
        document.getElementById("author").value = book.author;
        document.getElementById("isbn").value = book.isbn;
      });
  };

  window.deleteBook = function (id) {
    fetch(`/books/${id}`, { method: "DELETE" }).then(() => fetchBooks());
  };

  fetchBooks();
});
