/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa01cc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Programa01CC {

    public static void main(String[] args) {
        Connection con=null;
        Statement st=null;
        try {
            String url="jdbc:postgresql://localhost:7000/ejemplo";
            String usr="postgres";
            String pwd="postgres";
            String sql="insert into ejemplo (clave,nombre, direccion,telefono) values "
                    + " ('01','Gabriel','Av. 1','7777')";
            
            con=DriverManager.getConnection(url,usr,pwd);
            Logger.getLogger(Programa01CC.class.getName()).log(Level.INFO,"Se conecto... ");
            
            st=con.createStatement();
            boolean res= st.execute(sql);
            if (res)
                Logger.getLogger(Programa01CC.class.getName()).log(Level.INFO,"Se Guardo... ");
            else
                Logger.getLogger(Programa01CC.class.getName()).log(Level.INFO,"No se Guardo ... ");

            
        } catch (SQLException ex) {
            Logger.getLogger(Programa01CC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            try {
                if (st!=null)
                    st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Programa01CC.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con!=null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Programa01CC.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
}
