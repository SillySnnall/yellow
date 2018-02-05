package com.yellow.servlet

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.internal.Primitives
import com.yellow.apidoc.ApiInterfDoc
import com.yellow.base.BaseServlet
import com.yellow.common.Config
import com.yellow.common.Config.REQUEST_POST
import com.yellow.common.Config.RETURN_JSON
import com.yellow.common.UrlInterf.REGISTERED
import com.yellow.common.UrlInterf.SLASH
import com.yellow.common.UrlInterf.URL
import com.yellow.requestp.RegisteredP
import java.lang.reflect.Type
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@ApiInterfDoc("用户注册")
@WebServlet(name = "Registered", urlPatterns = [SLASH + REGISTERED])
class Registered : BaseServlet() {

    override fun doData(request: HttpServletRequest, response: HttpServletResponse) {
        response.writer.println("注册")
        val localHost = request.remoteAddr
        returnClient(localHost)
        Gson().fromJson("",Registered::class.java)
        // 用户名验证
        // 手机号验证
        // 密码验证
        verifyUser(request)

        // 验证码生成
        // 验证码发送
        // 验证码验证

        // 数据存储
    }

    /**
     * 校验用户信息
     */
    private fun verifyUser(request: HttpServletRequest) {
        request.getParameter(RegisteredP.USERNAME)
        request.getParameter(RegisteredP.PASSWORD)
        request.getParameter(RegisteredP.ALIAS)
    }
}
