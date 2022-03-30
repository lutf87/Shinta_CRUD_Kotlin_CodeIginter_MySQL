package com.shinta.crud_kotlin_codeiginter_mysql

import java.util.*

interface CrudView{

    //get
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg: String)

    //delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)

    //add atau tambah data
    fun successAdd(msg: String)
    fun errorAdd(msg: String)

    //update
    fun onSuccessUpdate(msg: String)
    fun onErrorUpdate(msg: String)
}