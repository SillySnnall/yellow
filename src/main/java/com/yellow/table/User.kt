package com.yellow.table

import com.yellow.apidoc.ApiReturnDoc
import java.util.Objects
import javax.persistence.*

@Entity
@Table(name = "user", schema = "yellow", catalog = "")
class User {
    @ApiReturnDoc("用户唯一标识符,uid")
    @get:Id
    @get:Column(name = "uid")
    var uid: Int = 0
    @get:Basic
    @get:Column(name = "username")// 帐号
    var username: String? = null
    @get:Basic
    @get:Column(name = "password")// 密码
    var password: String? = null
    @ApiReturnDoc("别名")
    @get:Basic
    @get:Column(name = "alias")
    var alias: String? = null
    @get:Basic
    @get:Column(name = "last_login_time")
    var lastLoginTime: Long? = null// 最后一次登录时间
    @get:Basic
    @get:Column(name = "last_login_ip")
    var lastLoginIp: String? = null // 最后一次登录的IP
    @ApiReturnDoc("临时身份认证标识符")
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

    override fun toString(): String {
        return "User(uid=$uid, username=$username, password=$password, alias=$alias, lastLoginTime=$lastLoginTime, lastLoginIp=$lastLoginIp, token=$token)"
    }


}
