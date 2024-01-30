<%@ page import="java.util.List" %>
<%@ page import="io.shraddha.service.paperservice" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>'To Review' Page</title>
    <!-- Add your styles and scripts if needed -->
</head>
<body>

<h2>List of Paper Titles</h2>

<ul>
    <c:forEach var="paperTitle" items="${getAllPapers}">
        <li>${papertitle}</li>
    </c:forEach>
</ul>

</body>
</html>
