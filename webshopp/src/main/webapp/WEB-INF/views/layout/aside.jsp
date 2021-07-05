<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/common/taglib.jsp" %>
<c:set var="cart" value="${sessionScope['scopedTarget.sessionService']}"/>
<div class="panel panel-default">
	<div class="panel-heading">Giỏ hàng</div>
	<div class="panel-body">
		<img id="cart-img" src="/static/images/shoppingcartblack.png" class="col-sm-5" />
		<ul class="col-sm-7">
			<li><b id = "btn-count">${cart.count}</b> mặt hàng</li>
			<li>
				<b id="btn-amount">
					<f:formatNumber value="${cart.amount}"/>
				</b> USD
			</li>
			<li><a href="/cart/view">Xem giỏ hàng</a></li>
		</ul>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">Tìm kiếm</div>
	<div class="panel-body">
		<form action="/product/list-by-keywords" method="post">
			<input value="${param.keywords}" name="keywords" class="form-control" placeholder="Tên mặt hàng" />
		</form>
	</div>
</div>

<div class="panel panel-default" >
	<div class="panel-heading" >Danh mục hàng hóa</div>
	<div class="list-group">
	<c:forEach var="c" items="${category}">
		<a href="/product/list-category/${c.id}" class="list-group-item">${c.nameVN}</a>
	</c:forEach>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">Danh mục hàng hóa đặc biệt</div>
	<div class="list-group">
		<a href="#" class="list-group-item">Hàng mới</a> <a href="#"
			class="list-group-item">Hàng bán chạy</a> <a href="#"
			class="list-group-item">Yêu thích</a>
	</div>
</div>
<style id="cart-fly">
</style>