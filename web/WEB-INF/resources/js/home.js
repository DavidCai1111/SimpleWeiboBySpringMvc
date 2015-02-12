$(function(){

    //微博列表淡入
    $(document).ready(function(){
        $("#weiboList").hide();
        $("#weiboList").fadeIn();
    });

    //下一页按钮
    $("#nextPage").click(function(e){
        var pageTo = parseInt($("#pageNow").text()) + 1;
        var totalPages = parseInt($("#totalPages"));

        if(pageTo > totalPages){
            pageTo = totalPages;
        }

        window.location.assign(window.location.href + "/home/" + pageTo);
    });

    //上一页按钮
    $("#previousPage").click(function(e){
        var pageTo = parseInt($("#pageNow").text()) - 1;

        if(pageTo <= 0){
            pageTo = 1;
        }

        window.location.assign(window.location.href + "/home/" + pageTo);
    });

});