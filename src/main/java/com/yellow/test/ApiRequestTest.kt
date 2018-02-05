package com.yellow.test

import com.yellow.apidoc.ApiRequestDoc
import com.yellow.table.ApiList
import com.yellow.table.ApiRequest
import com.yellow.utils.Util
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.hibernate.criterion.Restrictions
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * 接口数据
 */
class ApiRequestTest {

    /**
     * 修改 INTERF 对应接口名，直接运行 addApiRequest() 方法添加 API 到数据库
     */

    private val INTERF = "Registered"//

    /**
     * 添加接口数据
     */
    @Test
    fun addApiRequest() {
        for ((key, value) in getRequest()) {
            val list = session!!.createCriteria(ApiRequest::class.java).add(Restrictions.eq("paramName", value.paramName)).list()
            if (list.size != 0) {
                Util.sys("${value.paramName} 参数已存在")
                continue
            }
            session!!.save(value)//保存对象进入数据库
            session!!.flush()
            session!!.evict(value)
            Util.sys("${value.paramName} 添加成功")
        }
    }

    /**
     * 获取字段信息
     */
    private fun getRequest(): MutableMap<String, ApiRequest> {
        val requestList = mutableMapOf<String, ApiRequest>()
        val clz = Class.forName("com.yellow.requestp.${INTERF}P")
        // 注解查找
        val methods = clz.declaredMethods
        for (method in methods) {
            val hasAnnotation = method.isAnnotationPresent(ApiRequestDoc::class.java)
            if (hasAnnotation) {
                val annotation = method.annotations[0] as ApiRequestDoc
                val apiRequest = ApiRequest()
                apiRequest.requiredIs = annotation.requiredIs
                apiRequest.doc = annotation.doc
                requestList[method.name.split("$")[0]] = apiRequest
            }
        }
        // 字段查找
        val field1 = clz.declaredFields
        for (aField1 in field1) {
            requestList[aField1.name]?.paramName = aField1.get(aField1.name) as String?
            requestList[aField1.name]?.paramType = if (aField1.type.name.lastIndexOf(".") != -1) aField1.type.name.substring(aField1.type.name.lastIndexOf(".") + 1) else aField1.type.name
            requestList[aField1.name]?.interfName = INTERF.toLowerCase()
            requestList[aField1.name]?.createTime = Date().time
        }
        return requestList
    }


//---------------------------------初始化和销毁----------------------------------------

    private var sessionFactory: SessionFactory? = null
    private var session: Session? = null
    private var transaction: Transaction? = null
    @Before
    fun init() {
        //创建配置对象
        val config = Configuration().configure()
        //创建服务注册对象
        val serviceRegistry = StandardServiceRegistryBuilder().configure().build()
        //创建会话工厂对象

        sessionFactory = config.buildSessionFactory(serviceRegistry)
        //创建会话对象
        session = sessionFactory!!.openSession()
        //开启事务
        transaction = session!!.beginTransaction()
    }

    @After
    fun destory() {
        //提交事务
        transaction!!.commit()
        //关闭session
        session!!.close()
        //关闭sessionFactory
        sessionFactory!!.close()
    }
}