package manejousuarios.datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import manejousuarios.domain.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author darkarmy
 */
public class UsuariosJDBC {
    private Connection userCon;
    private final String SQL_INSERT = "insert into usuario(usuario, password) values (?, ?)";
    private final String SQL_UPDATE = "update usuario set usuario = ?, password = ? where id = ?";
    private final String SQL_DELETE = "delete from usuario where id_usuario = ?";
    private final String SQL_SELECT = "select * from usuario";
    
    public UsuariosJDBC(){}
    public UsuariosJDBC(Connection c){
        this.userCon = c;
    }
    
    public int insert(String usuario, String password){
        int rows = 0;
        PreparedStatement stmt = null;
        try{
            stmt = userCon.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario);
            stmt.setString(2, password);
            rows = stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
        }
        
        
        return rows;
    }
    


    public int update(int id_usuario, String usuario, String password){
        int rows = 0;
         PreparedStatement stmt = null;
         try{
             stmt = userCon.prepareStatement(SQL_UPDATE);
             stmt.setString(1, usuario);
             stmt.setString(2, password);
             stmt.setInt(3, id_usuario);
             rows = stmt.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
         }finally{
             Conexion.close(stmt);
         }

        return rows;

    }
    
    public int delete(int id){
        int rows = 0;
        PreparedStatement stmt = null;
        try{
            stmt = userCon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
        }
        
        return rows;
    }
    
    public List<Usuario> select(){
        List<Usuario> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = userCon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            Usuario usuario = new Usuario();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId_usuario(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                lista.add(usuario);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return lista;
    }

}
