function showView() {
		$('#myModal').css({
			position : "absolute",
			'top' : 30,
			'left' : 0
		})
		$('#myModal').modal({

			keyboard : true
		})
	}
	//密码修改前端验证
	function changePass() {
		var pass1 = $('input[id=pass1]').val();
		var pass2 = $('input[id=pass2]').val();
		if (pass1.length < 6 || pass2.length < 6) {
			if (pass1 == '' || pass2 == '') {
				alert("输入不能为空！");
				return false;
			} else {
				alert("长度至少为：6位数")
				return false;
			}
		} else if (pass1 != pass2) {
			alert("两次输入不一致！");
			return false;
		}
		return true;
	}
	function getTeaClass(t) {
		//alert(t.innerHTML);
		var se = document.getElementById("selectClass");
		if (se.options[0].value == 0) {
			se.options[0].remove()
		}
		var operator = document.getElementById("selectOperater");
		//alert(operator.options[0].value);
		operator.options[0].selected = true;
		//开始ajax添加课程内容下拉
		var className = t.value;
		var teacherNo = document.getElementById("teaId").innerText;
		//alert(className+"工号："+teacherNo);
		var url = "teacherajaxClassNameChange.action";
		var param = {
			'tauForm.className' : className,
			'tauForm.teacherNo' : teacherNo
		};
		$.post(url, param, callbackGetCourse);
	}
	function callbackGetCourse(result, textStatus) {
		if (textStatus == 'success') {
			if (result != null) {
				var json = eval("(" + result + ")");
				var op = $('#selectCourse');
				//alert(op);
				op.empty();
				for (var v1 = 0; v1 < json.length; v1++) {
					//alert(json[v1].courseNo+":"+json[v1].courseName);
					var courseNo = json[v1].courseNo;
					var courseName = json[v1].courseName;
					//alert(courseNo +": "+courseName);
					op.append("<option value='"+courseNo+"'>" + courseName
							+ "</option>")
				}
			}
		}
	}
	function getStuList() {
		//获取学生信息页面 ，并且判断后面的操作类型
		var operator = document.getElementById("selectOperater");
		//alert(operator.value);
		//值为:1 录入  2：修改  ajax
		var teacherNo = document.getElementById("teaId").innerText;
		var className = document.getElementById("selectClass").value;
		var courseNo = document.getElementById("selectCourse").value;
		var url1 = "teacherajaxStudentluru.action";
		var url2 = "teacherajaxStudentxiugai.action";
		//alert(className + ":" + teacherNo + "courseNo:" + courseNo);
		if (courseNo == -1) {
			alert("请选择课程！")
			return false;
		}
		var param = {
			'tauForm.className' : className,
			'tauForm.teacherNo' : teacherNo,
			'tauForm.courseNo' : courseNo

		};
		if (operator.value == 1) {
			//清除分页
			var divNext = document.getElementById("pageNext");
			divNext.innerHTML ="";
			//发送录入请求
			$.post(url1, param, callbackLuru);
		} else if (operator.value == 2) {
			//发送修改请求
			$.post(url2, param, callbackXiugai);
		} else {
			return false;
		}
	}
	function callbackLuru(result, textStatus) {
		if (textStatus == 'success') {
			//alert(result);
			if (result == '' || result == null) {
				var tb = document.getElementById("mytb1");
				//alert(tb.innerHTML);
				tb.innerHTML ="<tr><th colspan ='6'> <span style='color:red'>学生成绩以及全部录入完毕</span></th></tr>";
					
			}
			if (result != null) {
				//alert(result);mytb1
				var json = eval("(" + result + ")");
				var tb = document.getElementById("mytb1");
				//alert(tb.innerHTML);
				tb.innerHTML = "";
				for (var v1 = 0; v1 < json.length; v1++) {
					tb.innerHTML += "<tr>"
							+ "<th class='col-md-2'>" + json[v1].studentNo
							+ "</th>" + "<th class='hidden'>"
							+ json[v1].courseNo + "</th>"
							+ "<th class='col-md-2'>" + json[v1].studentName
							+ "</th>" + "<th class='col-md-2'>"
							+ json[v1].courseName + "</th>"
							+ "<th class='col-md-2'>"
							+ "<input name='pingshi' type='text' maxlength='3' style='width:60px' >"
							+ "</th>" + "<th class='col-md-2'>"
							+ "<input name='exam' type='text' style='width:60px' >" + "</th>"
							+ "<th class='col-md-2'>" + "<input class='btn btn-default' name='exam' type='button' value='确认' style='width:60px' onclick='hiButton(this);' >" + "</th>"
							+ "</tr>";
				}
			}
		}
	}
	function callbackXiugai(result, textStatus) {
			if (textStatus='success') {
				if (result!=null) {
					//alert(result);
					var json = eval("(" + result + ")");
					var tb = document.getElementById("mytb1");
					//alert(tb.innerHTML);
					//清除录入的页面效果
					tb.innerHTML = "";
					for (var v1 = 0; v1 < json.length; v1++) {
						tb.innerHTML += "<tr>"
								+ "<th class='col-md-2'>" + json[v1].studentNo
								+ "</th>" + "<th class='hidden'>"
								+ json[v1].courseNo + "</th>"
								+ "<th class='col-md-2'>" + json[v1].studentName
								+ "</th>" + "<th class='col-md-2'>"
								+ json[v1].courseName + "</th>"
								+ "<th class='col-md-2'>"
								+ "<input name='pingshi' type='text' maxlength='3' style='width:60px' value='"+json[v1].pingshiScore+"' >"
								+ "</th>" + "<th class='col-md-2'>"
								+ "<input name='exam' type='text' style='width:60px' value='"+json[v1].examScore+"' >" + "</th>"
								+ "<th class='col-md-2'>" + "<input class='btn btn-default' name='exam' type='button' value='修改' style='width:60px' onclick='xiugaiCJ(this);' >" + "</th>"
								+ "</tr>";
								// 
					}
					//加上分页
					var divNext = document.getElementById("pageNext");
					divNext.innerHTML ="";
					var pages = 0;
					if (json.length>0) {
						pages = json[0].pageNum;
						pages = pages / 8 == 0 ? pages / 8 : Math
								.ceil(pages / 8);
					}
					divNext.innerHTML+=
					"<ul class='pager'>"
					+"<li class='previous '><a href='javascript:void(0)'"
					+"onclick='nextPage(-1);'><span aria-hidden='true'>&larr;</span>"
					+"上一页</a></li>"
					+"<li class=' '><span aria-hidden='true'>"
					+"<span id='pageNo'>"+1+"</span>/"
					+"<span id='pageCount'>"+pages+"</span>页</span></li>"
					+"<li class='next'><a href='javascript:void(0)'"
					+"onclick='nextPage(1);'>下一页 <span aria-hidden='true'>&rarr;</span></a></li>"
					+"</ul>";
					
				}
			}
	}
	//点击 录入学生一个人的成绩
	function hiButton(b){
		//alert(b.value);
		//.style.visibility="visible";
		//获取表格中input的值
		//平时成绩
		var inputVal1 = b.parentNode.parentNode.cells[4].getElementsByTagName("INPUT")[0].value;
		//考试成绩
		var inputVal2 = b.parentNode.parentNode.cells[5].getElementsByTagName("INPUT")[0].value;
		
		//alert(b.parentNode.parentNode.cells[5].getElementsByTagName("INPUT")[0].value);
		if (inputVal1>=0&& !isNaN(inputVal1)&&inputVal2>=0&& !isNaN(inputVal2)
				&& inputVal1!='' && inputVal2!='') {
			if (inputVal1>30 || inputVal2>100) {
				alert("请输入正确的成绩范围：平时（0~30），考试（0~100）")
				return false;
			}
			//开始录入成绩
			var courseNo = b.parentNode.parentNode.cells[1].innerText;
			var studentNo = b.parentNode.parentNode.cells[0].innerText;
			var url = "teacherajaxStudentluruCJ.action";
			var param = {
				'tauForm.studentNo' : studentNo,
				'tauForm.courseNo' : courseNo,
				'tauForm.pingshiScore' : inputVal1,
				'tauForm.examScore' : inputVal2
			};
			//alert(studentNo+": "+courseNo+": "+inputVal1+": "+inputVal2);
			$.post(url, param, callbackLuruCJ);
			b.parentNode.parentNode.style.display="none";
		}else {
			alert("请输入成绩的正确格式");
			return false;
		}
		
	}
	//录入成绩 不需要callback
	function callbackLuruCJ(result, textStatus){
		
	}
	//下一页，上一页
	function nextPage(b) {
		
		var teacherNo = document.getElementById("teaId").innerText;
		var className = document.getElementById("selectClass").value;
		var courseNo = document.getElementById("selectCourse").value;
		var pageNo = document.getElementById("pageNo").innerText;
		var pageCount = document.getElementById("pageCount").innerText;
		//alert("nextPage"+teacherNo+" "+className+" "+courseNo+" "+pageNo+" "+pageCount);
		pageNo = parseInt(pageNo) + b;
		if (pageNo > pageCount) {
			pageNo = pageCount;
			return false;
		}
		if (pageNo <= 0) {
			pageNo = 1;
			return false;
		}
		document.getElementById("pageNo").innerText = pageNo;
		//alert(term+":"+stuNo+":"+pageNo);
		var url = "teacherajaxNextPage.action";
		var param = {
				'tauForm.className' : className,
				'tauForm.teacherNo' : teacherNo,
				'tauForm.courseNo' : courseNo,
				'tauForm.pageNo' : pageNo
		};
		//alert(className+":"+":"+teacherNo+":"+courseNo+":"+pageNo);
		$.post(url, param, callbackNext);

	} 
	//上一页下一页回调函数
	function callbackNext(result, textStatus){
		if (textStatus='success') {
			if (result!=null) {
				//alert(result);
				var json = eval("(" + result + ")");
				var tb = document.getElementById("mytb1");
				//alert(tb.innerHTML);
				//清除录入的页面效果
				tb.innerHTML = "";
				for (var v1 = 0; v1 < json.length; v1++) {
					tb.innerHTML += "<tr>"
							+ "<th class='col-md-2'>" + json[v1].studentNo
							+ "</th>" + "<th class='hidden'>"
							+ json[v1].courseNo + "</th>"
							+ "<th class='col-md-2'>" + json[v1].studentName
							+ "</th>" + "<th class='col-md-2'>"
							+ json[v1].courseName + "</th>"
							+ "<th class='col-md-2'>"
							+ "<input name='pingshi' type='text' maxlength='3' style='width:60px' value='"+json[v1].pingshiScore+"' >"
							+ "</th>" + "<th class='col-md-2'>"
							+ "<input name='exam' type='text' style='width:60px' value='"+json[v1].examScore+"' >" + "</th>"
							+ "<th class='col-md-2'>" + "<input class='btn btn-default' name='exam' type='button' value='修改' style='width:60px' onclick='xiugaiCJ(this)' >" + "</th>"
							+ "</tr>";
						
				}
			} 
		}
	} 
	//修改按钮事件
	function xiugaiCJ(xiugai){
		//alert("修改提交！");
		//获取表格中input的值
		//平时成绩
		var inputVal1 = xiugai.parentNode.parentNode.cells[4].getElementsByTagName("INPUT")[0].value;
		//考试成绩
		var inputVal2 = xiugai.parentNode.parentNode.cells[5].getElementsByTagName("INPUT")[0].value;
		
		//alert(b.parentNode.parentNode.cells[5].getElementsByTagName("INPUT")[0].value);
		if (inputVal1>=0&& !isNaN(inputVal1)&&inputVal2>=0&& !isNaN(inputVal2)
				&& inputVal1!='' && inputVal2!='') {
			if (inputVal1>30 || inputVal2>100) {
				alert("请输入正确的成绩范围：平时（0~30），考试（0~100）")
				return false;
			}
			//开始录入成绩
			var courseNo = xiugai.parentNode.parentNode.cells[1].innerText;
			var studentNo = xiugai.parentNode.parentNode.cells[0].innerText;
			var url = "teacherajaxStudentxiugaiCJ.action";
			var param = {
				'tauForm.studentNo' : studentNo,
				'tauForm.courseNo' : courseNo,
				'tauForm.pingshiScore' : inputVal1,
				'tauForm.examScore' : inputVal2
			};
			alert(studentNo+": "+courseNo+": "+inputVal1+": "+inputVal2);
			$.post(url, param);
			xiugai.parentNode.parentNode.style.display="none";
		}else {
			alert("请输入成绩的正确格式");
			return false;
		}
	}