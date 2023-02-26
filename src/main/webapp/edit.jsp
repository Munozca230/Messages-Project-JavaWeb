<%-- 
    Document   : edit
    Created on : Feb 24, 2023, 12:44:41 PM
    Author     : migue
--%>

<%@page import="com.mycompany.messages.Message"%>
<%@page import="com.mycompany.messages.MessageDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Message</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
              crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Signika+Negative:wght@300;400;500;700&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <section class="sec-message">
            <div class="div-message">
                <div class="div-title-message">
                    <img class="image-top" src="img/Sent Message.svg" alt="">
                    <label class="title-label">Edit your message</label>
                </div>
                <form action="edit.jsp" method="POST">
                    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
                    <div class="mb-3">
                        <label class="form-label">Your nickname</label>
                        <input type="text" class="form-control" name="nickname" required 
                               value="<%=request.getParameter("message")%>">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Your message</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" name="message" rows="3" required><%=request.getParameter("message")%></textarea>
                    </div>
                    <div class="div-button">
                        <a href="index.jsp" type="submit" class="btn btn-danger">Return</a>
                        <button type="submit" class="btn btn-primary" name="save">Save Changes</button>
                        <div id="message">Saved!</div>

                    </div>
                </form>
            </div>
        </section>
        <%
            MessageDao messageDao = new MessageDao();
            String ms = request.getParameter("message");
            String nn = request.getParameter("nickname");
            String save = request.getParameter("save");
            String id = request.getParameter("id");

            if (save != null) {
                Message message = new Message(Integer.parseInt(id.trim()), ms, nn);
                messageDao.update(message);
                request.setAttribute("nice", true);
            }
        %>
        <script>
            let mensaje = document.getElementById("message");
            <% if (request.getAttribute("nice") != null && (Boolean) request.getAttribute("nice")) { %>
            mensaje.style.display = "block";
            <% }%>
        </script>
    </body>
</html>
