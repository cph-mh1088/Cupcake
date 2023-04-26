<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Signup
    </jsp:attribute>


    <jsp:body>

        <h2>Du kan registrere dig her (please ik' vælg admin)</h2>
        <div class="loginbuttons">
            <form action="${pageContext.request.contextPath}/ServletCreateUser" method="post">
                <label for="brugernavn">Brugernavn: </label>
                <input type="text" id="brugernavn" name="brugernavn"/>

                <label for="kodeord">Adgangskode: </label>
                <input type="password" id="kodeord" name="kodeord"/>

                <label for="rolle">Rolle: </label>
                <input type="text" id="rolle" name="rolle"/>

                <input class="signupknap" type="submit" value="Opret bruger"/>

            </form>
            <form action="index.jsp">


                <input class="signupknap signup-tilbage" type="submit" value="Tilbage til forsiden">
            </form>
        </div>
    </jsp:body>
</t:pagetemplate>