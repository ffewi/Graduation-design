<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 添加弹框  -->
<!-- 模态框（Modal） -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">标题</h4>
			</div>
			<div class="modal-body">
				<h1>主体内容</h1>



				<div class="input-group col-sm-6 col-sm-offset-3"
					style="padding-top: 30px;">
					<span class="input-group-addon" style="width: 100px"
						id="basic-addon1">password1</span> <input type="text"
						class="form-control " placeholder="Username"
						aria-describedby="basic-addon1">
				</div>
				<div class="input-group col-sm-6 col-sm-offset-3"
					style="padding-top: 30px;">
					<span class="input-group-addon" style="width: 100px"
						id="basic-addon1">password2</span> <input type="text"
						class="form-control " placeholder="Username"
						aria-describedby="basic-addon1">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<!-- 添加弹框需要的风格与样式，远程引入 -->
<script src="http://cdn.gbtags.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.gbtags.com/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script
	src="http://cdn.gbtags.com/twitter-bootstrap/3.2.0/js/bootstrap.js"></script>
