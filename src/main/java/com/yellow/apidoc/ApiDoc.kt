package com.yellow.apidoc

// API列表
data class ApiList(
        val interfEnName: String = "",// 接口中英文名
        val interfZhName: String = "",// 接口中文名
        val interfUrl: String = "",// 接口地址
        val returnType: String = "",// 返回的数据格式(JSON/XML...)
        val requestType: String = "",// 请求方式(GET/POST...)
        val doc: String = ""// 接口说明
) {
    override fun toString(): String {
        return "{\"interfUrl\":\"$interfUrl\",\"returnType\":\"$returnType\",\"requestType\":\"$requestType\",\"interfEnName\":\"$interfEnName\",\"interfZhName\":\"$interfZhName\",\"doc\":\"$doc\"}"
    }

    override fun equals(other: Any?): Boolean {
        val apiList = other as ApiList
        return this.interfEnName == apiList.interfEnName
    }

    override fun hashCode(): Int {
        var result = interfUrl.hashCode()
        result = 31 * result + returnType.hashCode()
        result = 31 * result + requestType.hashCode()
        result = 31 * result + interfEnName.hashCode()
        result = 31 * result + interfZhName.hashCode()
        result = 31 * result + doc.hashCode()
        return result
    }
}


// 请求的参数
data class RequestParam(
        val paramName: String = "",// 参数名字
        val paramType: String = "",// 参数类型(String/int/double/List...)
        val isRequired: String = "",// 是否必填(是/否)
        val doc: String = ""// 参数说明
) {
    override fun toString(): String {
        return "{\"paramName\":\"$paramName\",\"paramType\":\"$paramType\",\"isRequired\":\"$isRequired\",\"doc\":\"$doc\"}"
    }
}

// 返回的参数
data class ReturnParam(
        val paramName: String = "",// 参数名字
        val paramType: String = "",// 参数类型(String/int/double/List...)
        val doc: String = ""// 参数说明
) {
    override fun toString(): String {
        return "{\"paramName\":\"$paramName\",\"paramType\":\"$paramType\",\"doc\":\"$doc\"}"
    }
}

// API
data class Api(
        var details: ApiList,
        var request: List<RequestParam>,
        var returns: List<ReturnParam>
) {
    override fun toString(): String {
        return "{\"details\":$details,\"request\":$request,\"returns\":$returns}"
    }
}