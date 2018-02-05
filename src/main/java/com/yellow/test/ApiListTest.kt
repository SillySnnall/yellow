package com.yellow.test

import com.yellow.apidoc.ApiInterfDoc
import com.yellow.base.BaseServlet
import com.yellow.common.Config.REQUEST_POST
import com.yellow.common.Config.RETURN_JSON
import com.yellow.common.UrlInterf.SLASH
import com.yellow.common.UrlInterf.URL
import com.yellow.servlet.Registered
import com.yellow.table.ApiList
import com.yellow.table.User
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
class ApiListTest {

    /**
     * 修改 INTERF 对应接口名，直接运行 addApi() 方法添加 API 到数据库
     */

    private val INTERF = "Registered"//

    /**
     * 添加接口数据
     */
    @Test
    fun addApi() {
        val list = session!!.createCriteria(ApiList::class.java).add(Restrictions.eq("interfName", INTERF.toLowerCase())).list()
        if (list.size != 0) {
            throw Exception("API已存在")
        }
        val apiList = ApiList()
        apiList.interfUrl = URL + SLASH + INTERF.toLowerCase()
        apiList.returnType = RETURN_JSON
        apiList.requestType = REQUEST_POST
        apiList.interfName = INTERF.toLowerCase()
        apiList.doc = (Class.forName("com.yellow.servlet.$INTERF").annotations[0] as ApiInterfDoc).doc// 注解获取
        apiList.createTime = Date().time
        session!!.save(apiList)//保存对象进入数据库
        Util.sys("API 添加成功")
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