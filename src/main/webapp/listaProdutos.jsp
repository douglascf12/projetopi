<%-- 
    Document   : listaProdutos
    Created on : 19/10/2020, 15:25:20
    Author     : User
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>

        <script lang="text/javascript">

            function mostrarModalExclusao(preco, descricao, qtd_estoque, nome_produto) {
//                $("#cod_produto").val(cod_produto);
                $("#preco").val(preco);
                $("#descricao").html(descricao);
                $("#qtd_estoque").val(qtd_estoque);
                $("#nome_produto").html(nome_produto);
                $('#modalExclusao').modal('show');
            }

            function excluirProduto() {
                var nome_produto = $("#nome_produto").html();
                $.get("ExcluirProduto?nome_produto=" + nome_produto, function (resposta) {
                    $('#modalExclusao').modal('hide')
                    if (resposta === "true") {
                        console.log("Funfou!");
                    } else {
                        console.log("Ops!");
                    }
                    window.location.reload();
                });
            }
        </script>
    </head>
    <body class="container">
        <h1>Lista de Produtos</h1>
        <table class="table">
            <thead>
            <th>Codigo</th>
            <th>preco</th>
            <th>Descricao</th>
            <th>Quantidade</th>
            <th>Nome</th>
        </thead>
        <tbody> 
            <c:forEach var="produto" items="${listaProdutos}">
                <tr>
                    <td>${produto.cod_produto}</td>
                    <td>${produto.preco}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.qtd_estoque}</td>
                    <td>${produto.nome_produto}</td>
                    <td><a href="AlterarProduto?cod_produto=${produto.cod_produto}">Alterar</a></td>
                    <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${produto.cod_produto}, '${produto.nome_produto}')">Excluir</button></td>
                </tr>
            </c:forEach>

        </tbody>

    </table>
</body>
</html>
<div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Confirmar exclusão do Produto  <label id="nome_produto"></label> ?
                <input id="nome_produto" hidden="true" />

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="excluirProduto()">Confirmar</button>
            </div>
        </div>
    </div>
</div>
<br/>
<a href="index.jsp">Voltar</a>

