
<%-- check for login, if user is signed in continue else redirect to signup.jsp--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize var="loggedIn" access="isAuthenticated()" />
<%@ include file="header.html" %>
<c:choose>
    <c:when test="${loggedIn}">
        You are logged in
        <p>Guru Web:
            <security:authentication property="userName" /> as <security:authentication
                    property="principal.authorities" />
        </p>
    </c:when>
    <c:otherwise>
      <%  response.sendRedirect("/open/signup"); %>
    </c:otherwise>
</c:choose>

<security:authorize access="hasRole('ANONYMOUS')">
    This will be only visible to anonymous
</security:authorize>

<security:authorize access="hasRole('USER')">
    This will be only visible to user
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    This will be only visible to admin
</security:authorize>

<%@ include file="footer.html" %>
