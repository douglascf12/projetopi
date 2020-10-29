<%-- 
    Document   : index
    Created on : 19/10/2020, 15:24:19
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <%@include file="header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Menu</h1>
        <a href="ListaCliente">Lista Clientes</a><br/>
        <a href="cadastrarCliente.jsp">Cadastrar Clientes</a><br/>
        <a href="listaProduto">Listar Produtos</a><br/>
        <a href="cadastrarProduto.jsp">Cadastrar Produtos</a><br>
        <a href="ListarVendas">Listar Vendas</a><br>
        <a href="VendaServlet">Venda</a><br>
        <a href="ListarFuncionario">Lista Funcionários</a><br/>
        <a href="cadastrarFuncionario.jsp">Cadastrar Funcionários</a><br/>
        <a href="ListarFilial">Lista Filiais</a><br/>
        <a href="cadastrarFilial.jsp">Cadastrar Filial</a><br/>
    </body>
</html>

