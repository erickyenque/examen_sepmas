<%-- 
    Document   : index
    Created on : 01-feb-2020, 15:19:14
    Author     : Ultimate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Examen Sepmas</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col" style="width: 350px; margin: auto; margin-top: 100px; background: #01c4a4; padding: 30px; border-radius: 10px;">
                    <form action="Controlador" style="text-align: center">
                        <img src="./img/user.png" class="rounded" style="width: 100px;">
                        <h2>Examen Sepmas</h2>
                        <label>Nombre:</label>
                        <input type="text" name="txtNombre" class="form-control"><br>
                        <label>Contraseña:</label>
                        <input type="text" name="txtPass" class="form-control"><br>
                        <input class="btn btn-danger" type="submit" name="accion" value="Verificar">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
