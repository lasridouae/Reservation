<%--
  Created by IntelliJ IDEA.
  User: Dlas
  Date: 10/03/2021
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<body onload='document.loginForm.username.focus();'>
<h3>Login in</h3>

<c:if test="${not empty error}"><div>${error}</div></c:if>
<c:if test="${not empty message}"><div>${message}</div></c:if>

<form name='login' action="<c:url value='/loginPage' />" method='POST'>
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>

