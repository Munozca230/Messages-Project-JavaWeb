<%-- Document : index Created on : Feb 21, 2023, 10:47:49 AM Author : migue --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
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
                        <label class="title-label">Create your message</label>
                    </div>
                    <form action="index.jsp" method="post">
                        <div class="mb-3">
                            <label class="form-label">Your nickname</label>
                            <input type="text" class="form-control" name="nickname" placeholder="JuanGamer77">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Your message</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1"
                                placeholder="Write your message..." name="message" rows="3"></textarea>
                        </div>
                        <div class="div-button">
                            <button type="submit" class="btn btn-primary">Send</button>
                        </div>
                    </form>
                </div>
                <%
                    String nickname = request.getParameter("nickname");
                    String message = request.getParameter("message");
                %>
            </section>
            <section class="sec-message2">
                <div class="div-messages">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Munozca230</h5>
                            <p class="card-text">Hey, here's an example message so I can fill some spaces arround here
                                ;)</p>
                            <p class="blockquote-footer"><cite>02/22/2023 8:21</cite></p>
                            <a href="#" class="card-link">Edit</a>
                            <a href="#" class="card-link">Delete</a>
                        </div>
                    </div>
                </div>
            </section>
        </body>

        </html>