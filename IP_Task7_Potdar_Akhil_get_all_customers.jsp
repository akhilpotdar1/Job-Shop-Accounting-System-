<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>Customers</title>
    </head>
    <body>
    	<h2>Customer Table </h2>
        <%@page import="ip_task7_potdar_akhil.DataHandler"%>
        <%@page import="java.sql.ResultSet"%>
        <%
            // We instantiate the data handler here, and get all the movies from the database
            final DataHandler handler = new DataHandler();
            final ResultSet movies = handler.displayall();
        %>

        <!-- The table for displaying all the movie records -->
        <table cellspacing="2" cellpadding="2" border="1">
            <tr> <!-- The table headers row -->
              <td align="center">
                <h4>Name</h4>
              </td>
              <td align="center">
                <h4>Address</h4>
              </td>
              <td align="center">
                <h4>Category</h4>
              </td>
            </tr>

            <%
                while(movies.next()) { // For each movie_night record returned...
                    // Extract the attribute values for every row returned
                    final String name = movies.getString("Name");
                    final String add = movies.getString("Address");
                    final int cat = movies.getInt("Category");

                    out.println("<tr>"); // Start printing out the new table row
                    out.println( // Print each attribute value
                         "<td align=\"center\">" + name +
                         "</td><td align=\"center\"> " + add + 
                         "</td><td align=\"center\"> " + cat + "</td>");
                    out.println("</tr>");
               }
            %>
            </table>
            <ul>
            <a href="add_customer_info.jsp">Insert a new customer.</a>
            </ul>
            <ul>
            <a href="insert_range.jsp">Retrieve customer in a categorical range.</a>
            </ul>
          
    </body>
</html>
