<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<!-- Bootstrap tag - allows us to use bootstrop -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<t:pagetemplate>

    <jsp:attribute name="header">
         Velkommen ${sessionScope.user.username}
    </jsp:attribute>

    <jsp:body>

        <div class="container userinfo">

            <div class="account">
                <h2>Kontooplysninger</h2>
            </div>

            <div class="orders">
                <h2>Ordrehistorik</h2>
                <div class="dropdown">
                    <select name="ordre" id="ordre">
                        <option value="Vælg top">Vælg ordre</option>
                        <c:forEach var="item" items="${sessionScope.ordreindhold}">
                            <c:if test="${item.brugernavn eq sessionScope.user.username}">
                                <option value="${item.brugernavn}">Brugernavn: ${item.brugernavn},
                                    ordreID: ${item.ordreId}, Dato: ${item.dato} </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="nej">
            <form action="index">
                <input class="back-btn" type="submit" value="Tilbage til forsiden">
            </form>
        </div>


    </jsp:body>

</t:pagetemplate>