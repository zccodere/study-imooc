/**
 * 登录js
 */
$(function(){
    var ctx = $("#ctx").val();
    $("#login_button").click(function(){
        login();
    });
});

function login(){
    // 获取登录信息
    var username=$("#username_input").val();
    var password=$("#password_input").val();
    var path=$("#path_input").val();
    var gotoUrl=$("#gotoUrl_input").val();
    
    var requesturl="/a/doLogin";
    $.ajax({
        type:"POST",
        async:false,//发送同步请求
        url:requesturl,
        data:"username="+username+"&password="+password,
        success:function(result){
            // 登录失败
            if(result.respCode != 200 ){
                alert(result.respMsg);
                return;
            }
            // 登录成功
            var targetCookies = result.respArgs.targetCookies;
            
            // 向服务器发出添加cookie请求
            $.each(targetCookies,function(i,targetCookie){
                var targetUrl = targetCookie.targetUrl;
                var cookieName = targetCookie.cookieName;
                var cookieValue = targetCookie.cookieValue;
                creat(targetUrl,cookieName,cookieValue);
            });
        }
    });
    // 跳转到目标页
    window.location.href=gotoUrl;
}
/** js利用iframe实现跨域添加cookie */
function creat(targetUrl,cookieName,cookieValue){
    var iframe = document.createElement('iframe'); 
    var targetSrc = targetUrl+"?"+"cookieName="+cookieName+"&cookieValue="+cookieValue;
    iframe.src=targetSrc;
    document.body.appendChild(iframe);
}