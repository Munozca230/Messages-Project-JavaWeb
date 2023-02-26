<%@page import="com.mycompany.messages.MessageDao"%>
<%@page import="com.mycompany.messages.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            Message message = new Message(Integer.valueOf(id));
            MessageDao messageDao = new MessageDao();
            messageDao.delete(message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        %>
    </body>
</html>
