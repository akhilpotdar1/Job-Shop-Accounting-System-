<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Customer Entry</title>
    </head>
    <body>
        <h2>Customer Entry</h2>
        <!--
            Form for collecting user input for the new movie_night record.
            Upon form submission, add_movie.jsp file will be invoked.
        -->
        <form action="add_customer.jsp">
            <!-- The form organized in an HTML table for better clarity. -->
            <table border=1>
                <tr>
                    <th colspan="2">Enter the Customer Information:</th>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=Name>
                    </div></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=Address>
                    </div></td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=Category>
                    </div></td>
                </tr>
                <tr>
                    <td><div style="text-align: center;">
                    <input type=reset value=Clear>
                    </div></td>
                    <td><div style="text-align: center;">
                    <input type=submit value=Insert>
                    </div></td></tr>
                
            </table>
        </form>
    </body>
</html>
