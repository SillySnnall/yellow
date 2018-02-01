package com.yellow.apidoc

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

// 请求的接口
annotation class ApiInterfDoc(
        val interfUrl: String,// 接口地址
        val returnType: String,// 返回的数据格式(JSON/XML...)
        val requestType: String,// 请求方式(GET/POST...)
        val interfEnName: String,// 接口中英文名
        val interfZhName: String,// 接口中文名
        val doc: String// 接口说明
)

// 请求的参数
annotation class ApiRequestParamDoc(
        val paramName: String,// 参数名字
        val paramType: String,// 参数类型(String/int/double/List...)
        val isRequired: String,// 是否必填(是/否)
        val doc: String// 参数说明
)

// 返回的参数
annotation class ApiReturnParamDoc(
        val paramName: String,// 参数名字
        val paramType: String,// 参数类型(String/int/double/List...)
        val doc: String// 参数说明
)




