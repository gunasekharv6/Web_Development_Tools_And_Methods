<html>
    <head>
        <title>Add Movies to Database</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            table, th, td {
                border-collapse: collapse;
            }
            th, td {
                padding: 15px;
            }
        </style>
    </head>
    <body>
        <h1>Enter the following movie detail below:</h1>
        <form action="movie.htm" method="post">
            <input type="hidden" name="action" value="add"/>
            <table>
                <tr>
                    <td>Movie Title: </td>
                    <td><input type="text" name="title" id="title" title="Enter Movie Title"/></td>
                </tr>
                <tr>
                    <td>Lead Actor: </td>
                    <td><input type="text" name="actor" id="actor" title="Enter Lead Actor"/></td>
                </tr>
                <tr>
                    <td>Lead Actress </td>
                    <td><input type="text" name="actress" id="actress" title="Enter Lead Actress"/></td>
                </tr>
                <tr>
                    <td>Movie Genre: </td>
                    <td><input type="text" name="genre" id="genre" title="Enter Movie Genre"/></td>
                </tr>
                <tr>
                    <td>Movie Year: </td>
                    <td><input type="text" id="year" name="year"/></td>
                </tr>
                <tr>
                    <td><button type="submit" title="Click to Submit data" onclick=" return submitForm()">Add Movie</button></td>
                </tr>
            </table>
        </form>
        <br>
        <a href="./index.htm">">Click here to go back  to the main page</a>

        <script>
            function submitForm() {
                if (document.getElementById("title").value.length == 0)
                {
                    alert('Please enter Movie title');
                    return false;
                }else if(document.getElementById("actor").value.length == 0){
                    alert('Please enter Lead actor');
                    return false;
                }else if(document.getElementById("actress").value.length == 0){
                    alert('Please enter Lead actress');
                    return false;
                }else if(document.getElementById("genre").value.length == 0){
                    alert('Please enter Movie genre');
                    return false;
                }
                else if(document.getElementById("year").value.length == 0){
                    alert('Please enter Released year');
                    return false;
                }else{
                    return true;
                }
            }
        </script>
    </body>
</html>
