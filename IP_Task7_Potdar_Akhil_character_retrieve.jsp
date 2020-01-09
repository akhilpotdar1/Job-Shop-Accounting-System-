<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <%@page import="ip_task7_potdar_akhil.DataHandler"%>
        <%@page import="java.sql.ResultSet"%>
        <%
            // We instantiate the data handler here, and get all the movies from the database
            final DataHandler handler = new DataHandler();
            // Get the attribute values passed from the input form.
            String start = request.getParameter("start_range");
            String end = request.getParameter("end_range");

            /*
             * If the user hasn't filled out all the time, movie name and duration. This is very simple checking.
             */
            if (start.equals("") || end.equals(""))
            {
                response.sendRedirect("add_movie_form.jsp");
            } 
            else 
            {
                int start_1 = Integer.parseInt(start);
                int end_1 = Integer.parseInt(end);
                
	            final ResultSet movies = handler.customer_retrieve(start_1, end_1);

               
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
		                while(movies.next()) 
		                {
		                	// For each movie_night record returned...
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


                   <a href="get_all_customers.jsp">See all the customer present.</a>
                   <%
                }
        %>
          </table>
    </body>
</html>
