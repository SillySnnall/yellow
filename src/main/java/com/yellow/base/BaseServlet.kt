package com.yellow.base

import com.yellow.common.Config
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


abstract class BaseServlet : HttpServlet() {

    var mRequest: HttpServletRequest? = null
    var mResponse: HttpServletResponse? = null

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        doGet(request, response)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        mRequest = request
        mResponse = response
        doData(request, response)
    }

    /**
     * 处理请求数据
     */
    abstract fun doData(request: HttpServletRequest, response: HttpServletResponse)

    /**
     * 返回数据给客户端
     */
    fun returnClient(data: Any) {
        mResponse!!.contentType = Config.CONTENT_TYPE
        mResponse!!.writer.println(data)
    }
}
