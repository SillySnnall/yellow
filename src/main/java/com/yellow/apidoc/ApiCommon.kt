import com.yellow.apidoc.ApiRequestDoc
import com.yellow.apidoc.RequestParam
import com.yellow.utils.Util

//package com.yellow.apidoc
//
//import com.yellow.utils.Util
//
//object ApiCommon {
//
//    const val interfName = "interf_name"
//
//    // API列表
//    var apiList: ArrayList<ApiList> = arrayListOf()
//    var api = mapOf<String, Api>().toMutableMap()
//
//    /**
//     * 从包中获取API列表数据
//     */
//    fun getApiListData(): List<ApiList> {
//        if (apiList.isEmpty()) {
//            val classes = Util.getClasses("com.yellow.servlet")
//            classes
//                    .map { Class.forName(it.name).annotations[0] as ApiInterfDoc }
//                    .forEach {
//                        apiList.add(ApiList(it.interfEnName, it.interfZhName, it.interfUrl, it.returnType, it.requestType, it.doc))// 获取ApiInterfDoc注解对象
//                    }
//        }
//        return apiList
//    }
//
//    /**
//     * API数据整合
//     */
//    fun getApiData(interfName: String): Api? {
//        if (!api.containsKey(interfName)) {
//            var index = apiList.indexOf(ApiList(interfName))
//            if (index != -1) {
//                api[interfName] = Api(apiList[index], getApiP(interfName), getApiR(interfName))
//            }else{
//                getApiListData()
//                index = apiList.indexOf(ApiList(interfName))
//                if (index != -1) {
//                    api[interfName] = Api(apiList[index], getApiP(interfName), getApiR(interfName))
//                }else{
//                    return null
//                }
//            }
//        }
//        return api[interfName]
//    }
//
    /**
     * 从类中获取API请求数据
     */
    @Throws(ClassNotFoundException::class)
    private fun getApiP(interfName: String): List<ApiRequestDoc> {
        val requestParamList: ArrayList<ApiRequestDoc> = arrayListOf()
        val methods = Class.forName("com.yellow.requestp.${Util.toUpperFristChar(interfName)}P").declaredMethods
        methods
                .map { it.annotations[0] as ApiRequestDoc }
                .forEach {
//                        requestParamList.add(RequestParam(it.paramName, it.paramType, it.isRequired, it.doc))
                }
        return requestParamList
    }
//
//    /**
//     * 从类中获取API返回数据
//     */
//    @Throws(ClassNotFoundException::class)
//    private fun getApiR(interfName: String): List<ReturnParam> {
//        val returnParamList: ArrayList<ReturnParam> = arrayListOf()
//        val methods = Class.forName("com.yellow.returnp.${Util.toUpperFristChar(interfName)}R").declaredMethods
//        methods
//                .map { it.annotations[0] as ApiReturnParamDoc }
//                .forEach {
//                    if (apiList.size != 0) {
//                        returnParamList.add(ReturnParam(it.paramName, it.paramType, it.doc))
//                    } else {
//                        getApiListData()
//                    }
//                }
//        return returnParamList
//    }
//}