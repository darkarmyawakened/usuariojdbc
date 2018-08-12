/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejousuarios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manejousuarios.datos.Conexion;
import manejousuarios.datos.UsuariosJDBC;
import manejousuarios.domain.Usuario;

/**
 *
 * @author darkarmy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuariosJDBC jdbc =  null;
        try{
         jdbc = new UsuariosJDBC(Conexion.getConnection());
        }catch(SQLException e){
            e.printStackTrace();
        }
        int i = 0;
//         i = jdbc.insert("Jason", "qwerty");
        List<Usuario> lista = new ArrayList<>();
        lista = jdbc.select();
        for(Usuario u : lista){
            System.out.println("Usuario: "+u.getUsuario());
            System.out.println("Password: "+u.getPassword());
            System.out.println(" ");
        }
    }
    
}
