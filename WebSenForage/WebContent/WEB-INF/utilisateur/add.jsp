<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"></jsp:include>

<!-- Content Row -->

<div class="row">

    <!-- Area Chart -->
    <div class="col-xl-8 col-lg-7">
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Liste des utilisateurs</h6>
            </div>
            <!-- Card Body -->
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
        </div>
    </div>

    <!-- Pie Chart -->
    <div class="col-xl-4 col-lg-5">
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Ajout Utilisateur</h6>
            </div>
            <!-- Card Body -->
            <div class="card-body">
                <c:if test="${resultat == 1}">
                    <div id="message" class="alert alert-success">Utilisateur ajoute avec succes</div>
                </c:if>
                <form method="post" action="Utilisateur">
                    <div class="form-group">
                        <label>Identifiant utilisateur</label>
                        <input class="form-control" type="text" name="idUser" />
                    </div>
                    <div class="form-group">
                        <label>Nom</label>
                        <input class="form-control" type="text" name="nom" />
                    </div>
                    <div class="form-group">
                        <label>Prenom</label>
                        <input class="form-control" type="text" name="prenom" />
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" type="email" name="email" />
                    </div>
                    <div class="form-group">
                        <label>Mot de passe</label>
                        <input class="form-control" type="password" name="password" />
                    </div>
                    <div>
                        <input class="btn btn-success" type="submit" value="Envoyer"/>
                        <input class="btn btn-danger" type="reset" value="Annuler"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>