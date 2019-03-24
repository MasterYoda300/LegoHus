

<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is your house</h1>
        <% Order Order = (Order)request.getAttribute("Order"); %>
        <p><%=Order.getTotalBrick()%></p>
    </body>
</html>
