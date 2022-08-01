<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Ninja Gold Game</title>
            <link rel="stylesheet" type="text/css" href="/css/style.css">
        </head>

        <body>
            <div class="warbber">
                <div class="yourgold">
                    <h1>Your Gold: </h1>
                    <div class="counter" name="gold">
                        <c:out value="${gold}" />
                    </div>
                    <p> <a href="/playagain" class="button">Play Again?</a> </p>
                </div>

                <div class="main">
                    <div class="finder">
                        <h3>Farm</h3>
                        <p>(earns 10-20 gold)</p>
                        <form action="/findgold" method="post">
                            <input type="hidden" name="location" value="farm">
                            <input type="submit" value="Find Gold!" class="button">
                        </form>
                    </div>
                    <div class="finder">
                        <h3>Cave</h3>
                        <p>(earns 5-10 gold)</p>
                        <form action="/findgold" method="post">
                            <input type="hidden" name="location" value="cave">
                            <input type="submit" value="Find Gold!" class="button">
                        </form>
                    </div>
                    <div class="finder">
                        <h3>House</h3>
                        <p>(earns 2-5 gold)</p>
                        <form action="/findgold" method="post">
                            <input type="hidden" name="location" value="house">
                            <input type="submit" value="Find Gold!" class="button">
                        </form>
                    </div>

                    <div class="finder">
                        <h3>Casino!</h3>
                        <p>(earns/takes 0-50 gold)</p>
                        <form action="/findgold" method="post">
                            <input type="hidden" name="location" value="casino">
                            <input type="submit" value="Find Gold!" class="button">
                        </form>
                    </div>

                </div>
                <div class="activites">
                    <h2>Activites:</h2>
                    <div class="activitesbox">

                        <c:forEach items="${messages}" var="message">
                            <p>
                                <c:out value="${message}"/>
                            </p>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </body>

        </html>