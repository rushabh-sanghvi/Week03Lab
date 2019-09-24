<%-- 
    Document   : viewnote
    Created on : Sep 20, 2019, 2:42:58 PM
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
        <form action="note" method="get">
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h4>Title: ${note.title}</h4>
        <h4>Content: ${note.content}</h4>
        <a href="note?edit"> Edit</a>
        </form>
    </body>
</html>