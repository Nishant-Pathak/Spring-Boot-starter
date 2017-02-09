<%@ include file="header.html" %>

<form action="${pageContext.request.contextPath}/api/user/" method="post">
    First name:<br>
    <input type="text" name="roles" value="Mickey">
    <br>
    Last name:<br>
    <input type="text" name="email" value="Mouse">
    <br><br>
    <input type="submit" value="Submit">
</form>

<%@ include file="footer.html" %>
