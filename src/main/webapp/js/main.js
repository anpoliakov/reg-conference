//Если пользователь вошёл в свой кабинет - добавляем чек-боксы (для информирования об выбранном удалении)
document.addEventListener('DOMContentLoaded', function() {
    const HOME_PAGE = '/home.jsp';
    var path = window.location.pathname;
    var page = path.substr(path.lastIndexOf('/'));
    if (page === HOME_PAGE) {
        addCheckBox();
    }
});

function addCheckBox() {
    var rows = document.querySelectorAll("tr");

    for (let i = 1; i < rows.length; i++) {
        let idConf = rows[i].firstElementChild.firstChild.nodeValue;
        let td = createCell(idConf);
        rows[i].insertAdjacentElement("beforeend", td);
    }
}

function createCell(idConf){
    var td = document.createElement("td");
    var input = document.createElement("input");

    input.name = "idConf";
    input.type = "checkbox";
    input.value = idConf;

    td.append(input);
    return td;
}

function sendData(section) {
    var sect = document.createElement("input");
    sect.name = "section";
    sect.type = "hidden";
    sect.value = section;

    var form = document.createElement("form");
    form.method = "post";
    form.action = "/reg-conferences/conf";
    form.style = "none";

    form.appendChild(sect);
    document.body.append(form);
    form.submit();
}

function getConf(id){
    var input = document.createElement("input");
    input.type = "hidden";
    input.name = "idConf";
    input.value = id;

    var form = document.createElement("form");
    form.action = "/reg-conferences/fillConf";
    form.method = "post";
    form.style = "none";

    form.appendChild(input);
    document.body.append(form);

    form.submit();
}

function addEvent() {
    var event = document.getElementById('event')
    var addConfForm = document.getElementById('addConf');
    var newEvent = event.cloneNode(true);
    var childs = newEvent.children;
    childs[0].value = "";
    childs[1].value = "";

    var button = createButton();
    newEvent.append(button);
    addConfForm.append(newEvent);
}

function createButton() {
    var input = document.createElement("input");
    input.type = "button";
    input.value = "Delete";
    input.onclick = deleteEvent;
    return input;
}

function deleteEvent(event) {
    var item = event.target.parentElement;
    item.remove();
}
