package com.yellow.apidoc

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

// 请求的接口
annotation class ApiInterfDoc(
        val doc: String// 接口说明
)

// 请求的参数
annotation class ApiRequestDoc(
        val requiredIs: String,// 是否必填(是/否)
        val doc: String// 参数说明
)

// 返回的参数
annotation class ApiReturnDoc(
        val doc: String// 参数说明
)




