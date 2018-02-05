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
import com.yellow.dao.ApiRequestDao
import com.yellow.dao.ApiReturnsDao
import com.yellow.requestp.ApiP
import com.yellow.requestp.ApiP.INTERF_NAME
import com.yellow.requestp.RegisteredP
import com.yellow.utils.ResultUtil
import com.yellow.utils.Util
import java.lang.reflect.Type
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "Api", urlPatterns = [SLASH + API])
class Api : BaseServlet() {

    override fun doData(request: HttpServletRequest, response: HttpServletResponse) {
        val interfName = request.getParameter(ApiP.INTERF_NAME)
        if (interfName == null) {
            returnClient(ResultUtil.errorJson(ResultUtil.paramEmpty(ApiP.INTERF_NAME)))
            return
        }
        val combination = "{\"interf\":${ApiListDao.loadApi(interfName)},\"request\":${ApiRequestDao.loadApi(interfName)},\"return\":${ApiReturnsDao.loadApi(interfName)}}"
        returnClient(ResultUtil.successJson(combination))
    }
}
