<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:body>

        <form action="${pageContext.request.contextPath}/ServletBuy" method="get">

        <form action="ServletBuy" method="get">

            <details class="kortinfo" style="cursor: pointer">
                <summary class="infosum" style="list-style-type: none; border: 1px solid black; padding: 10px;">Betal
                    med kort
                </summary>
                <div class="infobox" style="border: 1px solid black; padding: 10px;">
                    <input placeholder="Kortnummer" type="text"><br><br>
                    <input placeholder="Sikkerhedskode" type="text"><br><br>
                    <input type="date"> <br> <br>
                    <button type="submit">Køb</button>
                </div>
            </details>
        </form>


        <form action="ServletToBuypage" method="post">
            <details class="walletinfo" style="cursor: pointer">
                <summary class="infosum" style="list-style-type: none; border: 1px solid black; padding: 10px;">Betal
                    med din wallet
                </summary>
                <div class="infobox" style="border: 1px solid black; padding: 10px;">
                    <label class="saldolabel"> Din saldo: ${sessionScope.userSaldo}</label> <br> <br>
                    <button type="submit">Køb</button>
                </div>

            </details>
        </form>
    </jsp:body>
</t:pagetemplate>