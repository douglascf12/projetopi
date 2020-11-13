<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venda</title>
    </head>
    <div class="container">
        <div class="card mt-3 w-100">
            <div class="card-header text-center">
                <b>Dados da Filial</b>
            </div>
            
            <div class="card-body float-left w-100">
                <form action="VendaPesquisarFilial" method="GET" class="form-inline">
                    <div class="col-12 form-group mb-2">
                        <label type="text" class="input-group-text">C�digo</label>
                        <input type="hidden" name="cpf" value="${cpf}"/>
                        <input type="search" name="codigoFilial" size="5" value="${filial.codigo}" class="form-control"/>
                        <button type="submit" class="btn btn-primary">&#128269;</button><br/>
                    </div>
                    <div class="col-12 form-group mb-2">
                        <label>Nome da Filial</label>
                        <input name="nome" value="${filial.nome}" class="form-control"/><br/>
                    </div>
                </form>
                <form action="VendaGerarPedido" method="POST" class="form-inline">
                    <input type="hidden" name="cpf" value="${cpf}"/>
                    <input type="hidden" name="codigoFilial" value="${filial.codigo}"/>
                    <button type="submit" class="btn btn-primary">Pr�ximo</button>
                </form>
            </div>
        </div>
    </div>