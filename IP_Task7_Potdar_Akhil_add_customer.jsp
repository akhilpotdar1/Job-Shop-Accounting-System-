<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Result</title>
</head>
    <body>
    <%@page import="ip_task7_potdar_akhil.DataHandler"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.Array"%>
    <%
    // The handler is the one in charge of establishing the connection.
    DataHandler handler = new DataHandler();

    // Get the attribute values passed from the input form.
    String name = request.getParameter("Name");
    String add = request.getParameter("Address");
    String cat = request.getParameter("Category");
    

    /*
     * If the user hasn't filled out all the time, movie name and duration. This is very simple checking.
     */
    if (name.equals("") || add.equals("") || cat.equals("")){
        response.sendRedirect("add_customer_info.jsp");
    } else {
        int category = Integer.parseInt(cat);

        // Now perform the query with the data from the form.
        boolean success = handler.customer_entry(name, add,category);
        if (!success) { // Something went wrong
            %>
                <h2>There was a problem inserting the course</h2>
            <%
        } else { // Confirm success to the user
            %>
            <h2>The New Customer Information:</h2>

            <ul>
                <li>Name: <%= name %></li>
                <li>Address: <%= add %></li>
                <li>Category: <%= category %></li>
            </ul>

            <h2>Was successfully inserted.</h2>

            <a href="get_all_customers.jsp">See all the customer present.</a>
            <%
        }
    }
    %>
    </body>
</html>
