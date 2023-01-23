function sendSect(section) {
    var sect = document.createElement("input");
    sect.type = "hidden";
    sect.name = "section";
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