/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordermanagement;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SAMADHI WEERASINGHA 
 */
public class mydb {
    
    public static Connection Connect()
            {
    
    Connection conn = null;
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ordermanagement", "root", "");
    } catch(Exception e){
       System.out.println(e);
    }  
        return conn;

}
}