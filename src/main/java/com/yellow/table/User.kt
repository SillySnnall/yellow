package com.yellow.table

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import java.util.Objects

@Entity
class User {
    @get:Id
    @get:Column(name = "uid")
    var uid: Int = 0
    @get:Basic
    @get:Column(name = "username")
    var username: String? = null
    @get:Basic
    @get:Column(name = "password")
    var password: String? = null
    @get:Basic
    @get:Column(name = "alias")
    var alias: String? = null
    @get:Basic
    @get:Column(name = "last_login_time")
    var lastLoginTime: Long? = null
    @get:Basic
    @get:Column(name = "last_login_ip")
    var lastLoginIp: String? = null
    @get:Basic
    @get:Column(name = "token")
    var token: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val user = other as User?
        return uid == user!!.uid &&
                username == user.username &&
                password == user.password &&
                alias == user.alias &&
                lastLoginTime == user.lastLoginTime &&
                lastLoginIp == user.lastLoginIp &&
                token == user.token
    }

    override fun hashCode(): Int {

        return Objects.hash(uid, username, password, alias, lastLoginTime, lastLoginIp, token)
    }
}
