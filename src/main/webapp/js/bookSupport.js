// this is the id of the form
$("#bookAddFormID").submit(function (e) {

    e.preventDefault(); // avoid to execute the actual submit of the form.

    var form = $(this);
    var url = form.attr('action');

    $.ajax({
        type: "POST",
        url: url,
        timeout: 25000,
        data: form.serialize(), // serializes the form's elements.
        complete: function (data) {
            processAllBooks();
        }
    });
});

function deleteRecord(element) {
    let bookIdTag=element.parentNode.parentNode.querySelector("input[name='bookIdName']");
    $.ajax({
        type: "DELETE",
        url: "/api/bookService/deleteBook?idToDelete="+bookIdTag.value,
        timeout: 25000,
        complete: function (data) {
            processAllBooks();
        }
    });
}

function processAllBooks() {
    $.ajax({
        type: "GET",
        url: "/api/bookService/getAllBook",
        timeout: 25000,
        success: function (data) {
            accommodateBookTable(data)
        }
    });
}

function accommodateBookTable(data) {
    console.log(" all data=" + data);
    let bookTableBody = document.getElementById("bookOverviewTBody");
    bookTableBody.textContent = "";
    for (let i=0;i<data.content.length;i++) {
        let book =data.content[i]
        let tr = document.createElement("tr");
        let inputIDBook = document.createElement("input");
        inputIDBook.type='HIDDEN';
        inputIDBook.value=book.id;
        inputIDBook.name="bookIdName";
        inputIDBook.id="bookID_"+book.id;
        let tdPages = document.createElement("td");
        tdPages.innerText=book.pages;
        let tdName = document.createElement("td");
        let btnInTD = document.createElement("td");
        btnInTD.innerHTML="<button onclick=\"deleteRecord(this)\">smaz</button>";
        tdName.innerText=book.name;
        tr.appendChild(inputIDBook);
        tr.appendChild(tdPages);
        tr.appendChild(tdName);
        tr.appendChild(btnInTD);
        bookTableBody.appendChild(tr);
    }
}

