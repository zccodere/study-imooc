var tableid="";

$(document).ready(function(){

	initTable();
    
	checkTable();
	
    // 查询按钮
    $('#btn_query').click(function(){
    	dataSearch();
    });
    // 重置按钮
    $('#btn_reset').click(function(){
    	$('#keywords').val(' ');
    });
    
    // 新增按钮
    $('#btn_add').click(function(){
    	cleareditmodal();
    	$('#edit_modal').modal('show');
    });
    // 修改按钮
    $('#btn_edit').click(function(){
    	cleareditmodal();
    	var datas = $('#table_data').bootstrapTable('getSelections');
    	console.log(datas.length);
    	if( datas.length == 0 ){
    		showinfo('请选择您要修改的记录');
    		return;
    	}
    	if( datas.length > 1){
    		showinfo('修改功能不支持批量操作');
    		return;
    	}
    	$('#edit_modal_id').val(datas[0]._id);
    	$('#edit_modal_name').val(datas[0]._name);
    	$('#edit_modal_address').val(datas[0]._address);
    	$('#edit_modal').modal('show');
    });
    // 删除按钮
    $('#btn_delete').click(function(){
    	
    	var datas = $('#table_data').bootstrapTable('getSelections');
    	console.log(datas.length);
    	if( datas.length == 0 ){
    		showinfo('请选择您要修改的记录');
    		return;
    	}
    	if( datas.length > 1){
    		showinfo('修改功能不支持批量操作');
    		return;
    	}
    	var ids = datas[0]._id;
    	datadelete(ids);
    	$('#table_data').bootstrapTable('removeByUniqueId',ids);
    });
	// 地图编辑-确定按钮
    $('#table_modal_save').click(function(){
    	getTableInfo();
    });
    // 数据编辑-确定按钮
    $('#edit_modal_save').click(function(){
    	var id= $('#edit_modal_id').val();
    	var name = $('#edit_modal_name').val();
    	var address = $('#edit_modal_address').val();
    	if(!name){
    		showinfo('请输入名称');
    		return;
    	}
    	if(!address){
    		showinfo('请输入地址');
    		return;
    	}
    	if(!id){
    		datacreate();// 新增
    	}else{
    		dataupdate();// 修改
    	}
    	$('#edit_modal').modal('hide');
    });
});
function cleareditmodal(){
	$('#edit_modal_id').val('');
	$('#edit_modal_name').val('');
	$('#edit_modal_address').val('');
}

function showinfo(info){
	$('#info_modal').modal('show');
	$('#info_modal_span').html(info);
	setTimeout(function(){$("#info_modal").modal("hide")},1500);
}

function datacreate(){
	var request_data = {
		"tableid":tableid,
		"name":$('#edit_modal_name').val(),
		"address":$('#edit_modal_address').val()
	}
	console.log(request_data);
	var request_url = "/datacreate";
	$.ajax({
		type: "post",
		url: request_url,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		async: true,
		data: request_data,
		crossDomain: true == !(document.all),
		success: function(data) {
			if ("1" == data.status) {
				dataSearch();
			} else {
				showinfo(data.info);
			}
		},
		error: function() {
			showinfo("数据创建Ajax请求失败!");
		}
	});
}

function dataupdate(){
	var request_data = {
		"tableid":tableid,
		"id":$('#edit_modal_id').val(),
		"name":$('#edit_modal_name').val(),
		"address":$('#edit_modal_address').val(),
	};
	var request_url = "/dataupdate";
	$.ajax({
		type: "post",
		url: request_url,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		async: true,
		data: request_data,
		crossDomain: true == !(document.all),
		success: function(data) {
			if ("1" == data.status) {
				dataSearch();
			} else {
				showinfo(data.info);
			}
		},
		error: function() {
			showinfo("数据修改Ajax请求失败!");
		}
	});
}

function datadelete(ids){
	var request_data = {
		"tableid":tableid,
		"ids":ids
	};
	var request_url = "/datadelete";
	$.ajax({
		type: "post",
		url: request_url,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		async: true,
		data: request_data,
		crossDomain: true == !(document.all),
		success: function(data) {
			if ("1" == data.status) {
				
			} else {
				showinfo(data.info);
			}
		},
		error: function() {
			showinfo("数据删除Ajax请求失败!");
		}
	});
}

/**
 * 地图编辑
 */
function getTableInfo(){
	var table_name = $('#table_modal_name').val();
	if(!table_name){
		showinfo("请输入地图名称");
		return;
	}
	var request_data = {
		"name":table_name,
	};
	var request_url = "/tablecreate";
	$.ajax({
		type: "post",
		url: request_url,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		async: true,
		data: request_data,
		dataType: "json",
		crossDomain: true == !(document.all),
		success: function(data) {
			if ("1" == data.status) {
				tableid = data.tableid;
				$('#table_span_id').attr('no',tableid);
				$('#table_span_id').html(table_name);
				$('#table_modal').modal('hide');
			} else {
				showinfo(data.info);
			}
		},
		error: function() {
			showinfo("地图名称Ajax请求失败!");
		}
	});
}

function checkTable(){
	var table_id = $('#table_span_id').attr('no');
	if(!table_id){
		console.log("tableid为空");
		$('#table_modal').modal('show');
	}else{
		tableid = table_id;
		console.log("tableid为："+table_id);
		dataSearch();
	}
}

/**
 * 数据查询
 */
function dataSearch(){
	var keywords = $('#keywords').val();
	if(!keywords){
		keywords = " ";
	}
	var request_data = {
			"tableid":tableid,
			"keywords":keywords
		}
		console.log(request_data);
		var request_url = "/datasearch";
		$.ajax({
			type: "post",
			url: request_url,
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			async: true,
			data: request_data,
			crossDomain: true == !(document.all),
			success: function(data) {
				if ("1" == data.status) {
					console.log(data);
					$('#table_data').bootstrapTable('load', data.datas);
//					tableid = data.tableid;
//					$('#table_span_id').attr('no',tableid);
//					$('#table_span_id').html(table_name);
//					$('#table_modal').modal('hide');
				} else {
					showinfo(data.info);
				}
			},
			error: function() {
				showinfo("数据加载Ajax请求失败!");
			}
		});
}
/**
 * 初始化表格
 */
function initTable() {
	$('#table_data').bootstrapTable({
        toolbar: '#toolbar',                //工具按钮用哪个容器
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [5, 10, 25, 50, 100],        //可供选择的每页的行数（*）
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        clickToSelect: true,                //是否启用点击选中行
        uniqueId: "_id",                     //每一行的唯一标识，一般为主键列
        columns: [{
            checkbox: true
        }, {
            field: '_id',
            title: 'ID'
        }, {
            field: '_name',
            title: '名称'
        }, {
            field: '_address',
            title: '地址'
        }, {
            field: '_province',
            title: '省市'
        }, {
            field: '_city',
            title: '城市'
        }, {
            field: '_district',
            title: '地区'
        }, {
            field: '_location',
            title: '坐标'
        }, {
            field: '_createtime',
            title: '创建时间'
        },{
            field: '_updatetime',
            title: '上一次修改时间'
        }]
    });
}