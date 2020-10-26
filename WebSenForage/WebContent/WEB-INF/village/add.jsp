<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"></jsp:include>

<!-- Content Row -->

<div class="row">

    <!-- Area Chart -->
    <div class="col-xl-8 col-lg-7">
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Liste des villages</h6>
            </div>
            <!-- Card Body -->
            <div class="card-body">
                <table class="table table-bordered">
                    <tr>
                        <!-- <th scope="col">#</th>-->
                        <th scope="col">Identifiant Village</th>
                        <th scope="col"> Nom Village</th>
                        <th scope="col">Responsable</th>
                        <th scope="col">Action</th>
                    </tr>

                    <c:forEach items="${villages}" var="village">
                        <tr>
                            <!-- <th scope="row">< c:out value="$ {numero}" /></th> -->
                            <td><c:out value="${village.idVillage}" /></td>
                            <td><c:out value="${village.nom}" /></td>
                            <td><c:out value="${village.utilisateur.prenom}" /></td>
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
                <h6 class="m-0 font-weight-bold text-primary">Ajout Village</h6>
            </div>
            <!-- Card Body -->
            <div class="card-body">
                <c:if test="${resultat == 1}">
                    <div id="message" class="alert alert-success">Village ajoute avec succes</div>
                </c:if>
                <form method="post" action="Village">
                    <div class="form-group">
                        <label>Identifiant village</label>
                        <input class="form-control" type="text" name="idVillage" />
                    </div>
                    <div class="form-group">
                        <label>Nom village</label>
                        <input class="form-control" type="text" name="nomVillage" />
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