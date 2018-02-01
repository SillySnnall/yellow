package com.yellow.requestp

import com.yellow.apidoc.ApiRequestParamDoc
import com.yellow.common.Config

object RegisteredP {

    @ApiRequestParamDoc(USERNAME, Config.PARAM_STRING, "是", "帐号")
    const val USERNAME = "username"

    @ApiRequestParamDoc(PASSWORD, Config.PARAM_STRING, "是", "密码")
    const val PASSWORD = "password"

    @ApiRequestParamDoc(ALIAS, Config.PARAM_STRING, "是", "别名")
    const val ALIAS = "alias"

}