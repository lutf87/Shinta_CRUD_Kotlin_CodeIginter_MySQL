package com.shinta.crud_kotlin_codeiginter_mysql

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_update_add.*

@Suppress("SENSELESS_COMPARISON")
class UpdateAdd : AppCompatActivity(), CrudView {

    private lateinit var presenter: Presenter2

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)

        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null) {
            btn_Action.text = "Tambah"
            btn_Action.setOnClickListener() {
                presenter.addData(
                    ed_name.text.toString(),
                    ed_phone.text.toString(),
                    ed_address.text.toString()
                )
            }
        } else if (itemDataItem != null) {
            btn_Action.text = "Update"
            val item = itemDataItem as DataItem?
            ed_name.setText(item?.staffName.toString())
            ed_phone.setText(item?.staffHp.toString())
            ed_phone.setText(item?.staffAlamat.toString())
            btn_Action.setOnClickListener() {
                presenter.updateData(
                    item?.staffId ?: "",
                    ed_name.text.toString(),
                    ed_phone.text.toString(),
                    ed_address.text.toString()
                )
                finish()
            }
        }

    }

    override fun onSuccessGet(data: List<DataItem>?) {
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
    }

    override fun onErrorDelete(msg: String) {
    }

    override fun successAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun errorAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorUpdate(msg: String) {
    }
}