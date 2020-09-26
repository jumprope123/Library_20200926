package kr.co.tjoeun.library_20200926

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setupEvents()
    abstract fun setValues()

}