/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.daos;


import fu.ex.dbhelper.DBUils;
import fu.ex.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;


/**
 *
 * @author ADMIN
 */
public class ProductDAO {
    
    public ArrayList<Product> getAllProducts() throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql ="SELECT * FROM Products";
        
        ArrayList<Product> lst = new ArrayList<>();
        
        try {
            con = DBUils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                
                rs = pstm.executeQuery();
                
                while(rs.next()){
                    String id = rs.getString("ProductId");
                    String name = rs.getString("ProductName");
                    String description = rs.getString("ProductDescription");
                    int quanlity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String url = rs.getString("ImageUrl");
                    
                    Product p = new Product(id, name, description, quanlity, price, url);
                    
                    lst.add(p);
                }
            }
        } finally{
            if(rs != null)
                rs.close();
            if(pstm != null)
                pstm.close();
            if(con != null)
                con.close();
        }
        return lst;
    }
    
    public Product getProductByID(String pid)throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null; 
        String sql ="SELECT * FROM Products WHERE ProductId = ? ";
        try {
            con = DBUils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, pid);
                rs = pstm.executeQuery();
                
                if(rs.next()){
                    String id = rs.getString("ProductId");
                    String name = rs.getString("ProductName");
                    String description = rs.getString("ProductDescription");
                    int quanlity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String url = rs.getString("ImageUrl");
                    
                    Product p = new Product(id, name, description, quanlity, price, url);
                    
                    return p;
                }
            }
        } finally{
            if(rs != null)
                rs.close();
            if(pstm != null)
                pstm.close();
            if(con != null)
                con.close();
        }
        return null;
    }
    
    public boolean deleteProduct(String id)throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        String sql ="DELETE FROM Products WHERE ProductId = ? ";

        try {
            con = DBUils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, id);
                
                pstm.executeUpdate();
                return true;
            }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            if(pstm != null)
                pstm.close();
            if(con != null)
                con.close();
        }
        return false;
    }
    
    public boolean createProduct(Product pd)throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        String sql ="INSERT INTO Products(ProductId, ProductName, ProductDescription, Quantity, Price, ImageUrl) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            con = DBUils.makeConnection();
            
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, pd.getId());
                pstm.setString(2, pd.getName());
                pstm.setString(3, pd.getDescription());
                pstm.setInt(4, pd.getQuanlity());
                pstm.setDouble(5, pd.getPrice());
                pstm.setString(6, pd.getImgURL());
                
                pstm.executeUpdate();   
                return true;
                }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            if(pstm != null)
                pstm.close();
            if(con != null)
                con.close();
        }
        return false;
    }
    
    public boolean updateProduct(Product pd)throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        String sql ="UPDATE Products "
                  + "SET ProductName = ?, ProductDescription = ?, Quantity = ?, Price = ?, ImageUrl = ? "
                  + "WHERE ProductId = ?";
        
        try {
            con = DBUils.makeConnection();
            
            if(con != null){
                pstm = con.prepareStatement(sql);
                
                pstm.setString(1, pd.getName());
                pstm.setString(2, pd.getDescription());
                pstm.setInt(3, pd.getQuanlity());
                pstm.setDouble(4, pd.getPrice());
                pstm.setString(5, pd.getImgURL());
                pstm.setString(6, pd.getId());
                
                pstm.executeUpdate();   
                return true;
                }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            if(pstm != null)
                pstm.close();
            if(con != null)
                con.close();
        }
        return false;
    }
}
