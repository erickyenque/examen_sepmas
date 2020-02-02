<%-- 
    Document   : editar
    Created on : 01-feb-2020, 15:22:59
    Author     : Ultimate
--%>

<%@page import="Modelo.Rol"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
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
                UsuarioDAO dao = new UsuarioDAO();
                int codigo = Integer.parseInt((String)request.getAttribute("codigoUsu"));
                Usuario u = dao.list(codigo);
                
                RolDAO rolDao = new RolDAO();
                List<Rol> list = rolDao.listar();
                Iterator<Rol> iter = list.iterator();
                Rol rol = null;
            %>
            <div class="row">
                <div class="col"><h1>Modificar Usuario</h1></div>
            </div>
            <div class="row">
                <div class="col">
                    <form action="Controlador">
                        <label>Nombre:</label>
                        <input type="text" name="txtNombre" value="<%= u.getNombre()%>" class="form-control"><br>
                        <label>Contraseña:</label>
                        <input type="text" name="txtPass" value="<%= u.getPass()%>" class="form-control"><br>
                        Rol<br>
                        <select name="selectRol" class="form-control">
                            <%
                                while(iter.hasNext()){
                                rol =   iter.next();
                                String selected = "";
                                    if(u.getRol().equalsIgnoreCase(rol.getTipo())){
                                        selected = "selected";
                                    }
                            %>
                            <option value="<%= rol.getCodigo() %>" <%= selected %>><%= rol.getTipo()%></option> 
                            <% } %>
                        </select><br>
                        <input type="hidden" name="txtCodigo" value="<%= u.getCodigo()%>">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success"><br><br>
                        <a href="Controlador?accion=listar">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
