<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Customer Retrieval from Range</title>
    </head>
    <body>
        <h2>Customer Retrieval from Range</h2>
        <!--
            Form for collecting user input for the new movie_night record.
            Upon form submission, add_movie.jsp file will be invoked.
        -->
        <form action="character_retrieve.jsp">
            <!-- The form organized in an HTML table for better clarity. -->
            <table border=1>
                <tr>
                    <th colspan="2">Enter the Category Range:</th>
                </tr>
                <tr>
                    <td>Customer Range Start:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=start_range>
                    </div></td>
                </tr>
                <tr>
                    <td>Customer Range End:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=end_range>
                    </div></td>
                </tr>
                <tr>
                    <td><div style="text-align: center;">
                    <input type=reset value=Clear>
                    </div></td>
                    <td><div style="text-align: center;">
                    <input type=submit value=Submit>
                    </div></td></tr>
                
            </table>
        </form>
    </body>
</html>
