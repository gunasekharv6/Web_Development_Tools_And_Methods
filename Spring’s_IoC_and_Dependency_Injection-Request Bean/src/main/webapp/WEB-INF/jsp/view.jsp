<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        Info: ${requestScope.utility.getInfo()}
        <br/>
        Scope from Context: ${utility}
    </body>
</html>
