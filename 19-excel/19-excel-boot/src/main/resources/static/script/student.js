$(function() {

	/**
	 *	初始化数据表格  
	 */
	$('#t_student')
		.datagrid(
			{
				idField : 'id',
				title : '数据列表',
				fit : true,
				height : 450,
				url : '/student/list',
				fitColumns : true,
				striped : true, //隔行变色特性 
				loadMsg : '数据正在加载,请耐心的等待...',
				rownumbers : true,
				frozenColumns : [ [ //冻结列特性 ,不要与fitColumns 特性一起使用 
				{
					field : 'ck',
					width : 50,
					checkbox : true
				} ] ],
				columns : [ [ {
					field : 'sid',
					title : 'Student id',
					hidden : true
				}, {
					field : 'stunum',
					title : '编号',
					width : 100,
					sortable : true
				}, {
					field : 'stuname',
					title : '姓名',
					width : 100,
					sortable : true
				}, {
					field : 'stuage',
					title : '年龄',
					width : 100
				}, {
					field : 'stusex',
					title : '性别',
					width : 100
				}, {
					field : 'stubirthday',
					title : '出生日期',
					width : 100
				}, {
					field : 'stuhobby',
					title : '爱好',
					width : 100
				} ] ],
				pagination : true,
				pageSize : 10,
				pageList : [ 5, 10, 15, 20, 50 ],
				toolbar : [ {
					text : '导出excel',
					iconCls : 'icon-save',
					handler : function() {
						//获取后台传递参数 className  methodName
						var className = $('#t_student').datagrid(
								'getData').className;
						var methodName = $('#t_student').datagrid(
								'getData').methodName;

						//获取表头信息
						var header = $('#t_student')
								.datagrid('options').columns[0];
						var fields = "";
						var titles = "";
						for (var i = 0; i < header.length; i++) {
							var field = header[i].field;
							var title = header[i].title;
							var hiddenFlag = header[i].hidden;
							if (!hiddenFlag) {
								var dh = i == (header.length - 1) ? ""
										: ",";
								fields = fields + field + dh;
								titles = titles + title + dh;
							}
						}
						//向后台发送请求  
						var form = $("<form>");//定义一个form表单
						form.attr('style', 'display:none');
						form.attr('target', '');
						form.attr('method', 'post');
						form.attr('action', '/student/export');
						//添加input
						var input1 = $("<input>");
						input1.attr('type', 'hidden');
						input1.attr('name', 'fields');
						input1.attr('value', fields);

						var input2 = $("<input>");
						input2.attr('type', 'hidden');
						input2.attr('name', 'titles');
						input2.attr('value', titles);

						var input3 = $("<input>");
						input3.attr('type', 'hidden');
						input3.attr('name', 'className');
						input3.attr('value', className);

						var input4 = $("<input>");
						input4.attr('type', 'hidden');
						input4.attr('name', 'methodName');
						input4.attr('value', methodName);

						//将表单放到body中
						$('body').append(form);
						form.append(input1);
						form.append(input2);
						form.append(input3);
						form.append(input4);
						form.submit();//提交表单

					}
				} ]

			});
});