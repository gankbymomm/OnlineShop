<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<cr:forEach var="l" items="${list}">
	<div class="col-sm-4">
		<div class="thumbnail">
			<a href="/product/detail/${l.id}"> 
				<img class="product" src="/static/images/images5.jpg">
			</a>
			<div class="caption">
				<p>${l.name}</p>
				<div class="pull-right" data-id=${l.id }>
					<button class="btn btn-sm btn-success btn-open-dialog">
						<i class="glyphicon glyphicon-envelope" data-toggle="modal" data-target="#myModal"></i>
					</button>
					<button class="btn btn-sm btn-warning btn-star">
						<i class="glyphicon glyphicon-star"></i>
					</button>
					<button class="btn btn-sm btn-danger">
						<i class="glyphicon glyphicon-shopping-cart btn-add-to-cart"></i>
					</button>
				</div>
				<div>
					<span style="color: red;">${l.unitPrice * (1 - l.discount)}</span>
					<span style="text-decoration: line-through; ">${l.unitPrice}</span>
				</div>
			</div>
		</div>
	</div>
</cr:forEach>
<jsp:include page="dialog.jsp"/>
<script>
	$(document).ready(function(){
		
		$('.btn-add-to-cart').click(function(){
			var id = $(this).closest('div').attr('data-id');
			$.ajax({
				url: "/cart/add/"+id,
				success: function(response){
					$('#btn-count').html(response[0]),
					$('#btn-amount').html(response[1])
				}, 
				error: function(response){
					alert("Loi he thong")
				}
			});
			var img = $(this).closest(".thumbnail").find("a>img");
			var cart = '.cart-fly{background-image: url("'+img.attr("src")+'");background-size: 100% 100%;}';
			$('style#cart-fly').html(cart);
			$(".product").transfer({
				to: $("#cart-img"),
				className: "cart-fly",
				duration: 1000
			});
		});
		
		$('.btn-star').click(function(){
			var id = $(this).closest('div').attr('data-id');
			$.ajax({
				url: "/product/favorite/"+id,
				success: function(response){
					if (response) {
						alert("Thêm thành công")
					} else {
						alert("Đã tồn tại")
					}
				}
			})
		})
		$('.btn-open-dialog').click(function(){
			var id = $(this).closest('div').attr('data-id');
			$('#myModal #id').val(id);
		})
		$('.btn-send').click(function(){
			 var form = {
			id: $("#id").val(),
			from: $("#from").val(),
			to: $("#to").val(),
			body:  $("#body").val()
			}
			 $.ajax({
				url: "/product/mail",
				data: form,
				success: function(response){
					$('[data-dismiss]').click();
					alert("Gửi thành công")	
				},
				error: function(){
					alert("Lỗi hệ thống")
				}
			})
		})
	});
</script>