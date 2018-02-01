package com.yellow.returnp

import com.yellow.apidoc.ApiReturnParamDoc
import com.yellow.common.Config

object RegisteredR {

    @ApiReturnParamDoc(USERNAME, Config.PARAM_STRING, "a哈哈")
    const val USERNAME = "xcxcxcx"

    @ApiReturnParamDoc(PASSWORD, Config.PARAM_STRING, "嘻嘻嘻")
    const val PASSWORD = "7878"
}