<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste Utilisateurs</title>
	</head>
	<body>
		<c:if test="${utilisateurs != null }">
			<div class="card-body">
                <table class="table table-bordered">
                    <tr>
                        <th scope="col">IdUtilisateur</th>
                        <th scope="col">Prenom</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Email</th>
                        <th scope="col">Action</th>
                    </tr>
                    <c:forEach items="${utilisateurs}" var="user">
                        <tr>
                            <td><c:out value="${user.idUser}" /></td>
                            <td><c:out value="${user.nom}" /></td>
                            <td><c:out value="${user.prenom}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td>
                                <!-- <a href="< c:out value='$ {base_url}Utilisateur/edit/$ {user.idUser}' />" >Edit</a>-->
                                Edit
                            </td>
                        </tr>
                    </c:forEach>
                </table>
           	</div>
		</c:if>
		
		<a href="Utilisateur">Liste Utilisateurs</a>
		
	</body>
</html>