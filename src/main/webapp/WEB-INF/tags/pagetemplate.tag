<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cupcake</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <!-- Required Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <!-- Required jQuery library -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

    <!-- Required Bootstrap JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
    <div class="hero-img">
        <a class="navbar-brand" href="index.jsp">
            <img src="${pageContext.request.contextPath}/images/screen.png" width="1000px" class="img-fluid"/>
        </a>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="container">

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- start of "admin" (shows the currently logged in users name) -->
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                <div class="navbar-nav" style="display: flex; align-items: flex-end;">
                    <a class="nav-item nav-link"
                       href="${pageContext.request.contextPath}/ServletLogincondition">${sessionScope.user.username}</a>
                    <!-- start of profile logo with dropdown menus that allows for login and logout -->
                    <div class="dropdown">
                        <button class="kurv dropdown-toggle" type="button" id="dropdownMenuButton1"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="${pageContext.request.contextPath}/images/profil.png" width="30" alt="Kurv">
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

                            <c:if test="${sessionScope.user != null}">
                            </c:if>

                            <c:if test="${sessionScope.user == null}">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/login.jsp">Log ind</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/createuser.jsp">Opret
                                    bruger</a>
                            </c:if>
                            <c:if test="${sessionScope.user != null}">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log ud</a>
                            </c:if>
                        </div>
                    </div>

                    <!-- start of shopping basket logo with drop down menus -->
                    <!--testing if a user exists, if so, show basket-->
                    <c:if test="${sessionScope.user != null}">

                    <div class="dropdown">
                        <button class="kurv dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="${pageContext.request.contextPath}/images/bag.png" width="30" alt="Kurv">
                        </button>

                        <div class="dropdown-menu dropdown-menu-right" id="basket-dropdown" aria-labelledby="dropdownMenuButton">
                            <c:forEach var="item" items="${sessionScope.kurvindhold}">
                                <form method="get" action="ServletRemoveFromBasket">
                                    <!-- Det som bliver sendt til servlet -->
                                    <input type="hidden" name="order" value="${item}"/>
                                    <!-- Det som bliver vist på knappen -->
                                    <a class="dropdown-item" href="#" onclick="this.parentNode.submit(); return false;">
                                        Bund: ${item.bottom} Top: ${item.top} Antal: ${item.amount}</a>
                                    <button type="submit" class="basket-button">Fjern</button>
                                </form>
                            </c:forEach>
                            <form action="ServletToBuypage" method="get">
                                <button type="submit" class="basket-button basket-button-buy">Køb</button>
                            </form>
                            </c:if>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        </div>
    </nav>
</header>

<div id="body" style="min-height: 400px;">

    <jsp:doBody/>
</div>


</div>


</body>
</html>