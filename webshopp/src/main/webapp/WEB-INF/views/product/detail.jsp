<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="row">
	<div class="col-sm-5 text-center">
		<img class="img-detail" src="/static/images/images3.jpg">
	</div>
	<div class="col-sm-7">
		<ul>
			<li>Name : ${product.name}</li>
			<li>Price : <f:formatNumber type="currency" value="${product.unitPrice}"/></li>
			<li>Discount : <f:formatNumber type="percent" maxIntegerDigits="3" value="${product.discount}" /></li>
			<li>Quantity : ${product.quantity}</li>
			<li>View Count : ${product.viewCount}</li>
			<li>Available : ${product.available?'Yes':'No'}</li>
			<li>Special : ${product.special?'Yes':'No' }</li>
		</ul>
	</div>
</div>
<div>
	${product.description}
</div>
<h3>Hàng cùng loại</h3>
<c:forEach var="list" items="${list}">
	<a href="/product/detail/${list.id}">
	<img class="thumb-detail" src="/static/images/images6.jpg" />
	</a>
</c:forEach> 