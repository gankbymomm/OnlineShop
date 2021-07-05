<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Send email to your friend</h4>
      </div>
      <div class="modal-body">
      		<input type="hidden" id="id" />
	      <div class="form-group">
	      		<label>Mail người gửi</label>
	      		<input id="from" class="form-control"/>
	      </div>
	      	<div class="form-group">
	      		<label>Mail người nhận</label>
	      		<input id="to" class="form-control"/>
	      	</div>
	      	<div class="form-group">
	      		<label>Đánh giá</label>
	      		<textarea id="body" class="form-control"></textarea>
	      	</div>
      </div>
      <div class="modal-footer">
      	<button class="btn btn-default btn-send" >Send</button>
        <button class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>