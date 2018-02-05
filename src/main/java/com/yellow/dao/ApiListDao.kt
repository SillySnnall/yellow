package com.yellow.dao

import com.yellow.base.BaseDao
import com.yellow.table.ApiList
import com.yellow.table.ApiRequest
import org.hibernate.criterion.Restrictions

object ApiListDao : BaseDao() {

    /**
     * 查询全部列表
     */
    fun loadAllList(): String {
        try {
            init()
            val apiList = arrayListOf<String>()
            val lists = session!!.createCriteria(ApiList::class.java).list() as List<ApiList>//创建Criteria对象，此方法需要给出实体类名称
            lists.mapTo(apiList) { it.toApi() }
            destory()
            return apiList.toString()
        } catch (e: Exception) {
            System.out.println("没有数据")
        }
        return ""
    }

    /**
     * 查询单个
     */
    fun loadApi(interfName: String): String {
        try {
            ApiRequestDao.init()
            val apiList = arrayListOf<String>()
            val criteria = ApiRequestDao.session!!.createCriteria(ApiList::class.java)//创建Criteria对象，此方法需要给出实体类名称
            val lists = criteria?.add(Restrictions.eq("interfName", interfName))?.list() as List<ApiList>
            lists.mapTo(apiList) { it.toApi() }
            ApiRequestDao.destory()
            return apiList.toString()
        } catch (e: Exception) {
            System.out.println("没有数据")
        }
        return ""
    }
}