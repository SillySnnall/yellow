package com.yellow.dao

import com.yellow.base.BaseDao
import com.yellow.table.ApiRequest
import org.hibernate.criterion.Restrictions

object ApiRequestDao : BaseDao() {

    /**
     * 查询指定接口的请求参数
     */
    fun loadApi(interfName: String): String {
        try {
            init()
            val apiList = arrayListOf<String>()
            val criteria = session!!.createCriteria(ApiRequest::class.java)//创建Criteria对象，此方法需要给出实体类名称
            val lists = criteria?.add(Restrictions.eq("interfName", interfName))?.list() as List<ApiRequest>
            lists.mapTo(apiList) { it.toApi() }
            destory()
            return apiList.toString()
        } catch (e: Exception) {
            System.out.println("没有数据")
        }
        return ""
    }
}