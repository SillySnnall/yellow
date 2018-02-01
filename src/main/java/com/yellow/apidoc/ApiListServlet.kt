package com.yellow.apidoc

import com.yellow.apidoc.ApiCommon.getApiListData
import com.yellow.base.BaseServlet
import com.yellow.common.Config
import com.yellow.common.UrlInterf.API_LIST
import com.yellow.common.UrlInterf.SLASH
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "ApiListServlet", urlPatterns = [SLASH + API_LIST])
class ApiListServlet : BaseServlet() {
    override fun doData(request: HttpServletRequest, response: HttpServletResponse) {
        returnClient(ApiCommon.getApiListData())
    }
}
