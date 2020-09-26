package kr.co.tjoeun.library_20200926

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {

        loadWebImageBtn.setOnClickListener {

        Glide.with(mContext).load("https://search.pstatic.net/common/?src=http%3A%2F%2Fpost.phinf.naver.net%2FMjAxOTAxMDJfMjYx%2FMDAxNTQ2NDE1MTIxMDMz.Rjbz_7nebW4wpWAjhWvXzDDyNMB4C31s2jMUdDM5enEg.eVAS4Sr02RslUK46NcB8KORsBTROm87BAvZtihYQFJQg.JPEG%2FIoNeRDLzprO3EPNqH0JwGq2sa6UU.jpg&type=sc960_832").into(otherPersonImg)

        }

        profilePhotoImg.setOnClickListener {
            Toast.makeText(mContext, "사진 클릭됨", Toast.LENGTH_SHORT).show()

            val myIntent = Intent(mContext,ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }
    }
}