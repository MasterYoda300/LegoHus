<%-- 
    Document   : ViewOrder
    Created on : 25-03-2019, 07:37:53
    Author     : artin
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of orders</h1>
        
        <%
            List<Order> orders = (List) session.getAttribute("Order");
        %> 
        <hr>
          
        
    </body>
</html>
