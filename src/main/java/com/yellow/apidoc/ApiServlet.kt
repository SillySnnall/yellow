package com.yellow.apidoc

import com.yellow.base.BaseServlet
import com.yellow.common.UrlInterf.API
import com.yellow.common.UrlInterf.SLASH
import com.yellow.utils.ResultUtil
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "ApiServlet", urlPatterns = [SLASH + API])
class ApiServlet : BaseServlet() {

    override fun doData(request: HttpServletRequest, response: HttpServletResponse) {
//        val interfName = request.getParameter(ApiCommon.interfName)
//        if (interfName == null) {
//            returnClient(ResultUtil.errorJson(ResultUtil.paramEmpty(ApiCommon.interfName)))
//            return
//        }
//        val apiData = ApiCommon.getApiData(interfName)
//        if (apiData != null) {
//            returnClient(ResultUtil.successJson(apiData))
//        } else {
//            returnClient(ResultUtil.errorJson("没有这个接口"))
//        }
    }
}
