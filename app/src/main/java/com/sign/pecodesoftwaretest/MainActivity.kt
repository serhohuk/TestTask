package com.sign.pecodesoftwaretest

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : ViewPagerAdapter
    lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter = adapter
        adapter.addFragment()

        val intent = Intent(this, MainActivity::class.java)
        pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }


        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val fragment = supportFragmentManager.findFragmentByTag("f"+position) as MainFragment
                if (position==0){
                    fragment.hideRemoveButton()
                }
                fragment.setTextNum((position+1).toString())
                fragment.itemPosition = position+1
            }
        })
    }


}