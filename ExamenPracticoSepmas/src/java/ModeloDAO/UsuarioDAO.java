/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.CRUDUsuario;

/**
 *
 * @author Ultimate
 */
public class UsuarioDAO implements CRUDUsuario{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u = new Usuario();

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from usuario u inner join roles r on u.ROL_Codigo = r.ROL_Codigo";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setCodigo(rs.getInt("USU_Codigo"));
                usu.setNombre(rs.getString("USU_Nombre"));
                usu.setPass(rs.getString("USU_Pass"));
                usu.setRol(rs.getString("ROL_Tipo"));
                list.add(usu);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Modelo.Usuario list(int codigo) {
        String sql = "select * from usuario u inner join roles r on u.ROL_Codigo = r.ROL_Codigo where USU_Codigo = " + codigo;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                u.setCodigo(rs.getInt("USU_Codigo"));
                u.setNombre(rs.getString("USU_Nombre"));
                u.setPass(rs.getString("USU_Pass"));
                u.setRol(rs.getString("ROL_Tipo"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return u;
    }

    @Override
    public boolean agregar(Modelo.Usuario usuario) {
        String sql = "insert into usuario (USU_Codigo, USU_Nombre, USU_Pass, ROL_Codigo) values(default, '" + usuario.getNombre() + "','" + usuario.getPass() + "'," + usuario.getRol() + ")";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean editar(Modelo.Usuario usuario) {
        String sql = "update usuario set USU_Nombre = '" + usuario.getNombre() + "', USU_Pass = '" + usuario.getPass() + "', ROL_Codigo = " + usuario.getRol() + " where USU_Codigo = " + usuario.getCodigo();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;    
    }

    @Override
    public boolean eliminar(int codigo) {
        String sql = "delete from usuario where USU_Codigo = " + codigo;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false; 
    }

    @Override
    public int verificar(Usuario usuario) {
        int r = 0;
        String sql = "select * from usuario where USU_Nombre = '" + usuario.getNombre() + "' and USU_Pass = '" + usuario.getPass() + "'";
         try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                r = r + 1;
                u.setNombre(rs.getString("USU_Nombre"));
                u.setPass(rs.getString("USU_Pass"));
            }
            if(r == 1){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e){
            return 0;
        } 
    }
    
}
