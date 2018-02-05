package com.yellow.servlet

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.internal.Primitives
import com.yellow.apidoc.ApiInterfDoc
import com.yellow.base.BaseServlet
import com.yellow.common.Config
import com.yellow.common.Config.REQUEST_POST
import com.yellow.common.Config.RETURN_JSON
import com.yellow.common.UrlInterf.API
import com.yellow.common.UrlInterf.API_LIST
import com.yellow.common.UrlInterf.REGISTERED
import com.yellow.common.UrlInterf.SLASH
import com.yellow.common.UrlInterf.URL
import com.yellow.dao.ApiListDao
import com.yellow.requestp.RegisteredP
import com.yellow.utils.ResultUtil
import com.yellow.utils.Util
import java.lang.reflect.Type
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "ApiList", urlPatterns = [SLASH + API_LIST])
class ApiList : BaseServlet() {

    override fun doData(request: HttpServletRequest, response: HttpServletResponse) {
        returnClient(ResultUtil.successJson(ApiListDao.loadAllList()))
    }
}
