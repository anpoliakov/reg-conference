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