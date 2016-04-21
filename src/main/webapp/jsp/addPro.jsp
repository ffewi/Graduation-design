<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 添加弹框  -->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin: 0">
		<div class="modal-content">
		<form role="form" action="adminaddPro" method="post">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">添加专业</h4>
			</div>
			
			<div class="modal-body">
				<!-- 内容部分 -->
				
				
					<div class="row input-group col-sm-6"
						style="margin-top: 5px; margin-left: 50px">
						<span class="input-group-addon" style="width: 80px">专业ID</span> <input
							style="width: 180px" type="text" readonly="readonly"
							name="proForm.professionNo" class="form-control"
							placeholder="专业编号 你不需要填的，自动生成">
					</div>
					<div class="row input-group col-sm-6"
						style="margin-top: 20px; margin-left: 50px">
						<span class="input-group-addon" style="width: 80px">专业名称</span> <input
							style="width: 180px" type="text" name="proForm.professionName"
							class="form-control" placeholder="专业名称">
					</div>
					<div class="row input-group col-sm-6"
						style="margin-top: 20px; margin-left: 50px">
						<span class="input-group-addon" style="width: 80px">院系名称</span>
						<div class="form-group" style="width: 180px">
							<select name="proForm.selectArr" class="form-control">
								<s:iterator id="list" value="list">
									<option value="<s:property value="deptNo"/>"><s:property
											value="deptNo" />
										<s:property value="deptName" /></option>
								</s:iterator>

							</select>
						</div>
					</div>
			</div>
			<!-- 内容结束 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary  form-group">提交更改</button>
				
			</div>
			
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->