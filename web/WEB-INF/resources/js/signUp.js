$(function(){
    $("#username").blur(function(e){
        var username = $("#username").val();

        var user = {};

        user.username = username;

        $.ajax({
            type:"POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:"/signUp/validate",
            data: $.toJSON(user),
            dataType:"json",
            success:function(msg){
                if(msg.result){
                    $("#validateUserName").removeClass().addClass("text-danger").text("用户名已被注册，请更换一个用户名");
                }else{
                    $("#validateUserName").removeClass().addClass("text-success").text("用户名可以使用");
                }
            }
        });

    });
});