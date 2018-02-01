$(document).ready(function () {
    $(".ul_li").append("<li class=\"active\"><a href=\"#\">Export</a></li>");
});

// 首次数据请求
$.get("http://localhost:8080/registered", {name: "John", time: "2pm"},
    function (data) {
        alert("Data Loaded: " + data);
    });

