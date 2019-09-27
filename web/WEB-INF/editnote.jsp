<%-- 
    Document   : editnote
    Created on : Sep 20, 2019, 2:43:28 PM
    Author     : 794466
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note" method="post">
        Title: <input type="text" name="showTitle" size="15" value="${note.title}"><br>
        Contents: ​<input type="text" name="showContent" size="50" value="${note.content}" style="width: 210px;height:210px">
        <br>
         <input type="submit" value="Save">
        </form>
    </body>
</html>
