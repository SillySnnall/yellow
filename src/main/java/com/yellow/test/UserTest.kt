package com.yellow.test

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

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
        //创建会话工厂对象

        sessionFactory = config.buildSessionFactory(serviceRegistry)
        //创建会话对象
        session = sessionFactory!!.openSession()
        //开启事务
        transaction = session!!.beginTransaction()
    }

    @Test
    fun testSaveUser() {
        val user = com.yellow.table.User()
        user.username = "李四"
        user.password = "123456"
        user.alias = "小四"
        user.lastLoginTime = Date().time
        user.lastLoginIp = "192.168.1.3"
        session!!.save(user)//保存对象进入数据库
    }

    @Test
    fun testUpdateUser() {
        val user = com.yellow.table.User()
        user.uid = 1
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
            val user = session!!.load(com.yellow.table.User::class.java,1)
            System.out.println("${user.uid}")
        } catch (e: Exception) {
            System.out.println("没有这条数据")
        }
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