package com.yellow.table

import javax.persistence.*
import java.util.Objects

@Entity
@Table(name = "api_list", schema = "yellow", catalog = "")
class ApiList {
    @get:Id
    @get:Column(name = "id")
    var id: Int = 0
    @get:Basic
    @get:Column(name = "interfUrl")
    var interfUrl: String? = null
    @get:Basic
    @get:Column(name = "returnType")
    var returnType: String? = null
    @get:Basic
    @get:Column(name = "requestType")
    var requestType: String? = null
    @get:Basic
    @get:Column(name = "interfName")
    var interfName: String? = null
    @get:Basic
    @get:Column(name = "doc")
    var doc: String? = null
    @get:Basic
    @get:Column(name = "create_time")
    var createTime: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val apiList = other as ApiList?
        return id == apiList!!.id &&
                interfUrl == apiList.interfUrl &&
                returnType == apiList.returnType &&
                requestType == apiList.requestType &&
                interfName == apiList.interfName &&
                doc == apiList.doc &&
                createTime == apiList.createTime
    }

    override fun hashCode(): Int {

        return Objects.hash(id, interfUrl, returnType, requestType, interfName, doc, createTime)
    }
}
