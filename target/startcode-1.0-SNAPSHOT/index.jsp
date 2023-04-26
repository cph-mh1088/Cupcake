<%@ page import="dat.backend.model.persistence.TopCakeFacade" %>
<%@ page import="dat.backend.model.entities.TopCake" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="dat.backend.model.persistence.BottomCakeFacade" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <div>
            <h1 class="designtext">
                Design din egen Cupcake
            </h1>
        </div>


        <form action="ServletTilføjTilKurv" method="get">

            <select name="bottom" id="bottom">
                <option value="Vælg bund">Vælg bund</option>
                <c:forEach var="item" items="${sessionScope.bottomliste}">
                    <option value="${item.navn}">${item.navn}</option>
                </c:forEach>
            </select>

            <select name="top" id="top">
                <option value="Vælg top">Vælg top</option>
                <c:forEach var="item" items="${sessionScope.topliste}">
                    <option value="${item.navn}">${item.navn}</option>
                </c:forEach>
            </select>

            <select name="antal" id="antal">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>

            <c:if test="${sessionScope.user != null}">
                <form action="ServletTilføjTilKurv">
                    <input type="submit" id="tilføj" name="tilføj" placeholder="Tilføj" value="Læg i kurv"><br>
                </form>
            </c:if>
        </form>


        <c:if test="${sessionScope.user == null}">
            <p>Login for at tilføje til kurv!</p>
        </c:if>

        <img class="cupcake-bottom-picture"
             src="${pageContext.request.contextPath}/images/Cupcake-Transparent-Background-2.png" alt=""/>
    </jsp:body>

</t:pagetemplate>