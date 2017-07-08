window.onload = function(){
    var ctx = $("#ctx").val();
    
    $('#menu_id').tree({
    	data:menu,
        onClick: function(node){
            if($('#tab').tabs('exists',node.text)){
                $('#tab').tabs('select',node.text);
            }else{
                $('#tab').tabs('add',{    
                    title:node.text,    
                    content:'<iframe src="'+node.id+'" height="100%" width="100%" frameborder="0"></iframe>', 
                    closable:true,
                });
            }
        }
    });
    
    $('#tt').tree({
        url:'tree_data.json'
    });
}

var menu = [{
		"id":"upload",
		"text":"数据导入"
    },{
    	"id":"student",
        "text":"学生信息"
    }]