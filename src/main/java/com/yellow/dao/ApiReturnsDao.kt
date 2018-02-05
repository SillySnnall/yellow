package com.yellow.dao

import com.yellow.base.BaseDao
import com.yellow.table.ApiList
import com.yellow.table.ApiRequest
import com.yellow.table.ApiReturns
import org.hibernate.criterion.Restrictions

object ApiReturnsDao : BaseDao() {

    /**
     * 查询指定接口返回的参数
     */
    fun loadApi(interfName: String): String {
        try {
            init()
            val apiList = arrayListOf<String>()
            val criteria = session!!.createCriteria(ApiReturns::class.java)//创建Criteria对象，此方法需要给出实体类名称
            val lists = criteria?.add(Restrictions.eq("interfName", interfName))?.list() as List<ApiReturns>
            lists.mapTo(apiList) { it.toApi() }
            destory()
            return apiList.toString()
        } catch (e: Exception) {
            System.out.println("没有数据")
        }
        return ""
    }
}