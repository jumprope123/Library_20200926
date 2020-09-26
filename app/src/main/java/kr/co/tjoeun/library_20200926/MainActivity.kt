package kr.co.tjoeun.library_20200926

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        loadWebImageBtn.setOnClickListener {

            Glide.with(mContext).load("https://search.pstatic.net/common/?src=http%3A%2F%2Fpost.phinf.naver.net%2FMjAxOTAxMDJfMjYx%2FMDAxNTQ2NDE1MTIxMDMz.Rjbz_7nebW4wpWAjhWvXzDDyNMB4C31s2jMUdDM5enEg.eVAS4Sr02RslUK46NcB8KORsBTROm87BAvZtihYQFJQg.JPEG%2FIoNeRDLzprO3EPNqH0JwGq2sa6UU.jpg&type=sc960_832").into(otherPersonImg)

        }

        profilePhotoImg.setOnClickListener {
            Toast.makeText(mContext, "사진 클릭됨", Toast.LENGTH_SHORT).show()

            val myIntent = Intent(mContext,ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

        callPhoneBtn.setOnClickListener {

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
                    
                    val phoneNum = phoneNumTxt.text.toString()

                    val myUri = Uri.parse("tel:${phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "내용이 거부되어 통화불가", Toast.LENGTH_SHORT).show()
                }

            }
        TedPermission.with(mContext)
            .setPermissionListener(pl)
            .setDeniedMessage("권한이 거부되었습니다.")
            .setPermissions(Manifest.permission.CALL_PHONE)
            .check()

        }

    }

    override fun setValues() {


    }
}