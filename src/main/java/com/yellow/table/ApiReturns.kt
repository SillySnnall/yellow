package com.yellow.table

import javax.persistence.*
import java.util.Objects

@Entity
@Table(name = "api_returns", schema = "yellow", catalog = "")
class ApiReturns {
    @get:Id
    @get:Column(name = "id")
    var id: Int = 0
    @get:Basic
    @get:Column(name = "paramName")
    var paramName: String? = null
    @get:Basic
    @get:Column(name = "paramType")
    var paramType: String? = null
    @get:Basic
    @get:Column(name = "doc")
    var doc: String? = null
    @get:Basic
    @get:Column(name = "interfName")
    var interfName: String? = null
    @get:Basic
    @get:Column(name = "create_time")
    var createTime: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ApiReturns?
        return id == that!!.id &&
                paramName == that.paramName &&
                paramType == that.paramType &&
                doc == that.doc &&
                interfName == that.interfName &&
                createTime == that.createTime
    }

    override fun hashCode(): Int {

        return Objects.hash(id, paramName, paramType, doc, interfName, createTime)
    }

    override fun toString(): String {
        return "ApiReturns(id:$id, paramName:$paramName, paramType:$paramType, doc:$doc, interfName:$interfName, createTime:$createTime)"
    }

    fun toApi():String{
        return "{\"paramName\":\"$paramName\",\"paramType\":\"$paramType\",\"doc\":\"$doc\"}"
    }
}
