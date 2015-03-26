<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%response.setStatus(200);%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>404 - Page not Found</title>
</head>

<body>
<h2>404 - Request resource was not found.</h2>
<p><a href="<c:url value="/"/>">return</a></p>
</body>
</html>