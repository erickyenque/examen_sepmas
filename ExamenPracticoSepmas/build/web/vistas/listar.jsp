<%-- 
    Document   : listar
    Created on : 01-feb-2020, 15:22:44
    Author     : Ultimate
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="Modelo.Usuario"%>
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
                <div class="col"><h1>Usuarios</h1></div>
            </div>
            <div class="row">
                <div class="col"><a class="btn btn-primary" href="Controlador?accion=add">Agregar Nuevo</a></div>
            </div><br>
            <div class="row">
                <div class="col">
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col" class="text-center">Codigo</th>
                                <th scope="col" class="text-center">Usuario</th>
                                <th scope="col" class="text-center">Contraseña</th>
                                <th scope="col" class="text-center">Rol</th>
                                <th scope="col" class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <%
                            UsuarioDAO dao = new UsuarioDAO();
                            List<Usuario> list = dao.listar();
                            Iterator<Usuario> iter = list.iterator();
                            Usuario usu = null;
                            while(iter.hasNext()){
                                usu =   iter.next();

                        %>
                        <tbody>
                            <tr>
                                <th scope="row" class="text-center"><%= usu.getCodigo()%></th>
                                <td class="text-center"><%= usu.getNombre()%></td>
                                <td class="text-center"><%= usu.getPass()%></td>
                                <td class="text-center"><%= usu.getRol() %></td>
                                <td class="text-center">
                                    <a class="btn btn-warning" href="Controlador?accion=editar&codigo=<%= usu.getCodigo()%>">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?accion=eliminar&codigo=<%= usu.getCodigo()%>">Eliminar</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div> 
            </div>
            <div class="row">
                <div class="col"><a class="btn btn-info" href="Controlador?accion=salir">Salir</a></div>
            </div><br>
        </div>
    </body>
</html>
