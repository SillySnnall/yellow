package com.yellow.test

import com.yellow.table.User
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import org.hibernate.criterion.Restrictions
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*
import javax.persistence.criteria.Root
import javax.persistence.criteria.CriteriaBuilder
import org.hibernate.Criteria
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import com.yellow.utils.Util


class UserTest {
    private var sessionFactory: SessionFactory? = null
    private var session: Session? = null
    private var transaction: Transaction? = null
    @Before
    fun init() {
        //创建配置对象
        val config = Configuration().configure()
        //创建服务注册对象
        val serviceRegistry = StandardServiceRegistryBuilder().configure().build()
//        val serviceRegistry = ServiceRegistryBuilder().applySettings(config.properties).buildServiceRegistry()
        //创建会话工厂对象
        sessionFactory = config.buildSessionFactory(serviceRegistry)
        //创建会话对象
        session = sessionFactory!!.openSession()
        //开启事务
        transaction = session!!.beginTransaction()
    }

    @Test
    fun testSaveUser() {
        for (i in 0 until 10) {
            val user = com.yellow.table.User()
            user.username = "李四"
            user.password = "123456"
            user.alias = "小四"
            user.lastLoginTime = Date().time
            user.lastLoginIp = "192.168.1.3"
            session!!.save(user)//保存对象进入数据库
            session!!.flush()
            session!!.evict(user)
        }

    }

    @Test
    fun testUpdateUser() {
        val user = com.yellow.table.User()
        user.uid = 30
        user.username = "李四"
        user.password = "123132"
        user.alias = "小四"
        user.lastLoginTime = Date().time
        user.lastLoginIp = "192.168.1.1"
        session!!.update(user)//保存对象进入数据库
    }

    @Test
    fun testDeleteUser() {
        val user = com.yellow.table.User()
        user.uid = 1
        session!!.delete(user)//保存对象进入数据库
    }

    @Test// 每次走数据库
    fun testGetUser() {
        val user = session!!.get(com.yellow.table.User::class.java, 2)//保存对象进入数据库
        System.out.println("$user")
    }

    @Test// 有代理对象，不会每次走数据库，没有数据，会报ObjectNotFoundException
    fun testLoadUser() {
        try {
            val user = session!!.load(com.yellow.table.User::class.java, 30) as User
            System.out.println("${user.uid}")
        } catch (e: Exception) {
            System.out.println("没有这条数据")
        }
    }

    @Test
    fun testLoadAll() {
        val criteria = session!!.createCriteria(User::class.java)//创建Criteria对象，此方法需要给出实体类名称
        val usersEntitys = criteria.list()//调用Criteria方法进行查询

    }

    /**
     * 条件查询
     */
    @Test
    fun testWhereLoad(){
        val criteria = session?.createCriteria(User::class.java, "u")
        //业务：查询出id为1或为2的用户
        val list = criteria?.add(
                Restrictions.or(Restrictions.eq("id", 24),
                Restrictions.eq("id", 30)))
                ?.list()
        Util.sys(list.toString())
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