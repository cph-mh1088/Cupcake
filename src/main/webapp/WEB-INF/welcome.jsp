<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <p>Du er logget ind!</p>

        <c:if test="${sessionScope.user != null}">
            <p>Du er logget ind med rollen "${sessionScope.user.role}".</p>
            <p>Klik her for at gå til forsiden</p>
            <form action="index.jsp">


                <input type="submit" class="loginknap" value="Gå til forsiden">
            </form>
        </c:if>


    </jsp:body>

</t:pagetemplate>