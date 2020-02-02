/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDRol;
import Modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ultimate
 */
public class RolDAO implements CRUDRol{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
        ArrayList<Rol> list = new ArrayList<>();
        String sql = "select * from roles";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Rol rol = new Rol();
                rol.setCodigo(rs.getInt("ROL_Codigo"));
                rol.setTipo(rs.getString("ROL_Tipo"));
                list.add(rol);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}
