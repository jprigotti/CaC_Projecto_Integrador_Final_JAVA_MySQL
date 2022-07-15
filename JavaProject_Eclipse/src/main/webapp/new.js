/**
 * 
 */// CODIGO PARA EL FORM DE CONTACTO
$('form.addEmpleado').submit(function (evento) {

    evento.preventDefault();  // avoid to execute the actual submit of the form.
    if (inputCheck()) {

        let form = document.querySelector(".addEmpleado");
        form.submit;

    }
});

$('#formCancel').click(function(){
    $('.addEmpleado')[0].reset();
});


//Function inputCheck, receives the form and returns True ok False error
function inputCheck() {

    let arrayCheck = []; // este array contiene los valores de cada input y del textarea
    let status;

    arrayCheck[0] = checkDNI();
    arrayCheck[1] = checkApellido();
    arrayCheck[2] = checkNombre();
    arrayCheck[3] = checkNumeroDepartamento();

    if (arrayCheck.some((item) => item == false)) {  // pregunto si hay algun campo false
        console.log("complete fields");
        return false;
    } else {
        return true;

    }
}

function checkDNI() {
    let contactForm = document.querySelector(".addEmpleado");
    if (Number(contactForm[0].value)) {
        document.querySelector(`.${contactForm[0].className.slice(6, contactForm[0].className.length)}`).style.border = "none"; //vuelvo a poner border red
        document.querySelector(`.inputAreaDNI .inputError`).textContent = "";
        return true;
    } else {
        document.querySelector(`.${contactForm[0].className.slice(6, contactForm[0].className.length)}`).style.border = "1px solid red"; //vuelvo a poner border red
        document.querySelector(`.inputAreaDNI .inputError`).textContent = "Debe ingresar DNI valido";
        return false;
    }
}

function checkApellido() {
    let contactForm = document.querySelector(".addEmpleado");
    if (contactForm[1].value!="") {
        document.querySelector(`.${contactForm[1].className.slice(6, contactForm[1].className.length)}`).style.border = "none"; //vuelvo a poner border red
        document.querySelector(`.inputAreaLastName .inputError`).textContent = "";
        return true;
    } else {
        document.querySelector(`.${contactForm[1].className.slice(6, contactForm[1].className.length)}`).style.border = "1px solid red"; //vuelvo a poner border red
        document.querySelector(`.inputAreaLastName .inputError`).textContent = "Debe ingresar un apellido";
        return false;
    }

}

function checkNombre() {
    let contactForm = document.querySelector(".addEmpleado");
    if (contactForm[2].value!="") {
        document.querySelector(`.${contactForm[2].className.slice(6, contactForm[2].className.length)}`).style.border = "none"; //vuelvo a poner border red
        document.querySelector(`.inputAreaFirstName .inputError`).textContent = "";
        return true;
    } else {
        document.querySelector(`.${contactForm[2].className.slice(6, contactForm[2].className.length)}`).style.border = "1px solid red"; //vuelvo a poner border red
        document.querySelector(`.inputAreaFirstName .inputError`).textContent = "Debe ingresar un nombre";
        return false;
    }
}

function checkNumeroDepartamento() {
    let contactForm = document.querySelector(".addEmpleado");
    if (contactForm[3].value!="null") {
        document.querySelector(`.${contactForm[3].className.slice(6, contactForm[3].className.length)}`).style.border = "none"; //vuelvo a poner border red
        document.querySelector(`.inputAreaNumeroDepartamento .inputError`).textContent = "";
        return true;
    } else {
        document.querySelector(`.${contactForm[3].className.slice(6, contactForm[3].className.length)}`).style.border = "1px solid red"; //vuelvo a poner border red
        document.querySelector(`.inputAreaNumeroDepartamento .inputError`).textContent = "Debe seleccionar un departamento";
        return false;
    }
}
