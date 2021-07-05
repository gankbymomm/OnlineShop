<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div>
	<table class="table">
		<thead>
			<tr>
				<th>Mã sản phẩm</th>
				<th>Tên sản phẩm</th>
				<th>Giảm giá</th>
				<th>Số lượng</th>
				<th>Giá bán</th>
				<th>Thành tiền</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${sessionScope['scopedTarget.sessionService'].items}">
				<tr data-id="${p.id}" data-unitPrice="${p.unitPrice}" data-discount="${p.discount}">
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.discount}</td>
					<td><input value="${p.quantity}" type="number" min="1" style="width: 40px"/></td>
					<td>${p.unitPrice}</td>
					<td id="amount">${p.quantity * p.unitPrice *(1 - p.discount)}</td>
					<td>
						<button class="btn btn-sm btn-danger btn-remove">
							<i class="glyphicon glyphicon-trash"></i>
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<button class="btn btn-sm btn-warning btn-clear">Xóa đơn hàng</button>
<button class="btn btn-sm btn-info">Tiếp tục</button>
<button class="btn btn-sm btn-success">Thanh toán</button>
<script>
	$(document).ready(function() {
		
		$("tr[data-id] input").on("input", function(){
			var id = $(this).closest("tr").attr("data-id");
			var price = $(this).closest("tr").attr("data-unitPrice");
			var discount = $(this).closest("tr").attr("data-discount");
			var qty = $(this).val();
			$.ajax({
				url: "/cart/update/"+id+"/"+qty,
				success: function(response){
					$('#btn-count').html(response[0]), 
					$('#btn-amount').html(response[1])
				}
			});
			var amount = qty*price*(1 - discount);
			$(this).closest("tr").find("#amount").html(amount);
		});
		
		$('.btn-clear').click(function() {
			$.ajax({
			url : "/cart/clear",
			success : function(response) {
				$('#btn-count').html(0), 
				$('#btn-amount').html(0),
				$("table>tbody").html("")
				}
			});
		});

		$('.btn-remove').click(function() {
			var id = $(this).closest("tr").attr('data-id');
			$.ajax({
				url: '/cart/remove/'+id,
				success: function(response){
					$('#btn-count').html(response[0]), 
					$('#btn-amount').html(response[1])
				}
			});
			$(this).closest("tr").remove();
		});
	});
</script>