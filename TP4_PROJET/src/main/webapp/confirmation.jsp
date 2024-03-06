<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Confirmation Ajout Projet</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout Projet
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" name="idProjet" class="form-control" value="${projet.idProjet }"/>
                    
                    <label class="control-label">Nom Projet :</label>
                    <input type="text" name="nomProjet" class="form-control" value="${projet.nomProjet }"/>
                </div>
                
                <div class="control-label">
                    <label class="control-label">Cout :</label>
                    <input type="text" name="cout" class="form-control" value="${projet.cout}"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
