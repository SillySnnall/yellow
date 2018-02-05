package com.yellow.table

import javax.persistence.*
import java.util.Objects

@Entity
@Table(name = "api_request", schema = "yellow", catalog = "")
class ApiRequest {
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
    @get:Column(name = "requiredIs")
    var requiredIs: String? = null
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
        val that = other as ApiRequest?
        return id == that!!.id &&
                paramName == that.paramName &&
                paramType == that.paramType &&
                requiredIs == that.requiredIs &&
                doc == that.doc &&
                interfName == that.interfName &&
                createTime == that.createTime
    }

    override fun hashCode(): Int {

        return Objects.hash(id, paramName, paramType, requiredIs, doc, interfName, createTime)
    }
}
