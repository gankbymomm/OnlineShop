<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<h2>Đăng nhập</h2>
<c:if test="${not empty message}">
	<div class="alert alert-${alert}">
		${message}
	</div>
</c:if>
<form action="/account/login" method="post">
	<div class="form-group">
		<label>Tên đăng nhập</label>
		<input name="id" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Mật khẩu</label>
		<input name="password" type="password" class="form-control"/>
	</div>
	<label>
		<input type="checkbox" name="rm">Nhớ tài khoản
	</label>
	<button type="submit">Đăng nhập</button>
</form>