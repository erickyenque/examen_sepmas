<%-- 
    Document   : agregar
    Created on : 01-feb-2020, 15:23:18
    Author     : Ultimate
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Rol"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.RolDAO"%>
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
            <%
                RolDAO rolDao = new RolDAO();
                List<Rol> list = rolDao.listar();
                Iterator<Rol> iter = list.iterator();
                Rol rol = null;
            %>
            <div class="row">
                <div class="col"><h1>Agregar Usuario</h1></div>
            </div>
            <div class="row">
                <div class="col">
                    <form action="Controlador">
                        <label>Nombre:</label>
                        <input type="text" name="txtNombre" class="form-control"><br>
                        <label>Contraseña:</label>
                        <input type="text" name="txtPass" class="form-control"><br>
                        <label>Rol:</label>
                        <select name="selectRol" class="form-control">
                            <%

                                while(iter.hasNext()){
                                rol =   iter.next();
                            %>
                            <option value="<%= rol.getCodigo() %>"><%= rol.getTipo()%></option> 
                            <% } %>
                        </select>
                        <br>
                        <input class="btn btn-success" type="submit" name="accion" value="Agregar">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
