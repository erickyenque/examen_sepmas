/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    String login = "index.jsp";
    
    Usuario u = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso = listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;            
        }else if(action.equalsIgnoreCase("Agregar")){
            String nombre = request.getParameter("txtNombre");
            String pass = request.getParameter("txtPass");
            String rol = request.getParameter("selectRol");
            
            u.setNombre(nombre);
            u.setPass(pass);
            u.setRol(rol);
            
            dao.agregar(u);
            acceso = listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("codigoUsu", (String)request.getParameter("codigo"));
            acceso = edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            int codigo = Integer.parseInt((String)request.getParameter("txtCodigo"));
            String nombre = request.getParameter("txtNombre");
            String pass = request.getParameter("txtPass");
            String rol = request.getParameter("selectRol");
            
            u.setCodigo(codigo);
            u.setNombre(nombre);
            u.setPass(pass);
            u.setRol(rol);
            
            dao.editar(u);
            acceso = listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            int codigo = Integer.parseInt((String)request.getParameter("codigo"));
            u.setCodigo(codigo);
            
            dao.eliminar(codigo);
            acceso = listar;
        }else if(action.equalsIgnoreCase("Verificar")){
            String nombre = request.getParameter("txtNombre");
            String pass = request.getParameter("txtPass");
            
            u.setNombre(nombre);
            u.setPass(pass);
            if(dao.verificar(u) == 1){
                acceso = listar;
            }else{
                acceso = login;
            }
        }
        else if(action.equalsIgnoreCase("salir")){
            acceso = login;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
