package com.yellow.utils

import com.yellow.apidoc.ApiCommon

object ResultUtil {

    const val PARAM_ERROR = 400
    const val PARAM_SUCCESS = 200
    const val SUCCESS = "success"

    /**
     * 正确的json返回
     */
    fun successJson(result: Any): String {
        return jsonFormat(ResultUtil.PARAM_SUCCESS, ResultUtil.SUCCESS, result)
    }

    /**
     * 错误的json返回
     */
    fun errorJson(errorMsg: String): String {
        return jsonFormat(ResultUtil.PARAM_ERROR, errorMsg, "{}")
    }

    /**
     * 返回的数据格式化
     */
    private fun jsonFormat(retCode: Int, msg: String, result: Any): String {
        return "{\"retCode\":$retCode,\"msg\":\"$msg\",\"result\":$result}"
    }

    /**
     * 参数为空
     */
    fun paramEmpty(param: String): String {
        return "缺少参数:$param"
    }

    /**
     * 参数错误
     */
    fun paramError(param: String): String {
        return "参数错误:$param"
    }
}