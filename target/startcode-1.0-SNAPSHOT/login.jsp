<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>


    <jsp:body>

        <h3>Du kan logge ind her</h3>
        <div class="loginbuttons">
            <form action="login" method="post">
                <label for="username">Brugernavn: </label>
                <input type="text" id="username" name="username"/>
                <label for="password">Adgangskode: </label>
                <input type="password" id="password" name="password"/>
                <input class="loginknap" type="submit" value="Log ind"/>

            </form>
            <form action="index.jsp">


                <input class="loginknap tilbage" type="submit" value="Tilbage til forsiden">
            </form>
        </div>
    </jsp:body>
</t:pagetemplate>