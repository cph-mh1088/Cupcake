<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<!-- Bootstrap tag - allows us to use bootstrop -->



<t:pagetemplate>

    <jsp:attribute name="header">
         Velkommen ${sessionScope.user.username}

    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <!-- tværgående rækker hen over siden -->
            <div class="row">
                <!-- sidens kolonner. 6 angiver at kolonnen skal fylde 6 ud af 12 felter -->
                <div class="col-12">
                    <h2>Ordrer</h2>
                    <div class="dropdown">
                        <select name="ordre" id="ordre">
                            <option value="Vælg top">Vælg ordre</option>
                            <c:forEach var="item" items="${sessionScope.ordreindhold}">
                                <option value="${item.brugernavn}">Brugernavn: ${item.brugernavn}, ordreID: ${item.ordreId}, Dato: ${item.dato} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <!-- bootstrap JS tags -->


        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h2>Her kan du indsætte et beløb</h2>
                    <form class="loginbuttons" method="post" action="ServletLogincondition" >
                        <label for="beløb">Beløb:</label>
                        <input type="number" id="beløb" name="belob"/>

                        <label for="brugernavn">Brugernavn: </label>
                        <input type="text" id="brugernavn" name="brugernavn"/>

                        <button class="loginknap" type="submit">Indsæt beløb</button>
                    </form>
                </div>
        </div>
        </div>
    </jsp:body>

</t:pagetemplate>