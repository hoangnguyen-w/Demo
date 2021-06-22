<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fu.ex.entities.Product" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of products</title>
    </head>
    <body>
        <h2>List of products</h2>
        <a href="productManagementServlet?action=addform">Add new Product</a><br><br>
            <table width="600px" border="1px solid">
                <tr>
                    <th>Product ID </th> <th>Name </th> <th>Description </th> 
                    <th>Quantity </th> <th>Price </th> <th>Image URL </th> <th> </th><th> </th>
                </tr>
                <% ArrayList<Product> ldt = new ArrayList<Product>();
                
                   ldt = (ArrayList<Product>) request.getAttribute("data");
                   for(Product dt: ldt){
                %>
                    <tr>
                        <td><%= dt.getId() %></td>
                        <td><%= dt.getName() %></td>
                        <td><%= dt.getDescription() %></td>
                        <td><%= dt.getQuanlity() %></td>
                        <td><%= dt.getPrice() %></td>
                        <td><%= dt.getImgURL() %></td>
                        <td><a href="ProductManagementServlet?action=updateform&pid=<%= dt.getId()%>"> Edit </a></td>
                        <td><a href="ProductManagementServlet?action=delete&pid=<%= dt.getId()%>"> Delete </a></td>
                    </tr>
                <% 
                    {
                %>
            </table>
        
    </body>
</html>
