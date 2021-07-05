<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp" %>
<html lang="en">
<head>
    <title>Trang chủ</title>
    <tiles:insertAttribute name="head"/>
</head>
<body>

<div class="container">

    <header class="row">
        <h1 class="alert alert-success">ONLINE SHOPPING MALL</h1>
    </header>

    <nav class="row">
    	<tiles:insertAttribute name="menu"/>
    </nav>
    <div class="row">
        <article class="col-sm-9">
        	<tiles:insertAttribute name="body"/>
        </article>
        <aside class="col-sm-3">
        	<tiles:insertAttribute name="aside"/>
        </aside>
    </div>

    <footer>
        <p class="text-center" >&copy; 2020 All right</p>
    </footer>

</div>
