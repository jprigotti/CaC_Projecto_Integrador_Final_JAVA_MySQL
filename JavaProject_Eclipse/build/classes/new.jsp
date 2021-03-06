<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <!-- Link Fontawesome -->
    <script src="https://kit.fontawesome.com/628afeffd4.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="./new.css">

</head>

<body>

    <div class="empleadosContainer">

        <div class="mainTitle">
            <h2> Complete los datos del nuevo empleado </h2>
        </div>

        <div class="formContainer">


            <form action="EmpleadosController?action=new_mysql" method="POST" class="addEmpleado">
                <div class="containerForm">
                    <div class="inputAreaDNI">
                        <input type="text" class="input inputDNI" name="DNI" placeholder="Ingrese el DNI *">
                        <span class="inputError"></span>
                    </div>
                    <div class="inputAreaLastName">
                        <input type="text" class="input inputLastName" name="apellido"
                            placeholder="Ingrese el apellido *">
                        <span class="inputError"></span>
                    </div>
                    <div class="inputAreaFirstName">
                        <input type="text" class="input inputFirstName" name="nombre" placeholder="Ingrese el nombre *">
                        <span class="inputError"></span>
                    </div>

                    <div class="inputAreaNumeroDepartamento">
                        <select class="input inputNumeroDepartamento" name="numeroDepartamento">
                            <option value="null">Elija el departamento</option>
                            <option value="11">11</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">37</option>
                            <option value="77">77</option>
                        </select>
                        <span class="inputError"></span>
                    </div>

                    <div class="btnArea">
                        <input id="formSubmit" class="btnSolid" type="submit" value="Agregar">
                        <input id="formCancel" class="btnSolid" type="button" onclick="location.href='EmpleadosController';"  value="Cancelar">
                    </div>
                </div>
            </form>
        </div> <!-- closes form Container  -->
    </div> <!-- closes empleadosContainer -->


    <!-- Loading jQuery -->

    <!-- New JS -->

</body>

</html>