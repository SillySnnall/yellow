$(document).ready(function () {
    $(".ul_li").append("<li class=\"active\"><a href=\"#\">Export</a></li>");
});

// 首次数据请求
$.get("http://localhost:8080/apilist",
    function (data) {
        let parse = JSON.parse(data).result;
        for (let i = 0; i < parse.length; i++) {
            $(".ul_li").append("<li class=\"active\"><a href=\"#\">" + parse[i].interfName + "</a></li>");
        }
    });

