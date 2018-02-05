package com.yellow.base

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration

open class BaseDao{

    var sessionFactory: SessionFactory? = null
    var session: Session? = null
    var transaction: Transaction? = null

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

    fun destory() {
        //提交事务
        transaction!!.commit()
        //关闭session
        session!!.close()
        //关闭sessionFactory
        sessionFactory!!.close()
    }
}