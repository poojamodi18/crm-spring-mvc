<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Table</h2>
		</div>
		<div id="container">
			<div id="content">
			
			
				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />
					
					
				<form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />

					<input type="submit" value="Search" class="add-button" />
				</form:form>
				
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>

					<c:forEach var="custom" items="${customers}">
						<tr>

							<c:url var="updateLink" value="/customer/showFromForUpdate">
								<c:param name="customerId" value="${custom.id}"></c:param>
							</c:url>
							<c:url var="deleteLink" value="/customer/delete">
								<c:param name="customerId" value="${custom.id}"></c:param>
							</c:url>
							<td>${custom.firstName}</td>
							<td>${custom.lastName}</td>
							<td>${custom.email}</td>
							<td><a href="${updateLink} ">Update</a> | <a
								href="${deleteLink}"
								onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>

</body>
</html>