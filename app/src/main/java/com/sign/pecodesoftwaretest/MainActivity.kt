package com.sign.pecodesoftwaretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_layout.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter = adapter
        adapter.addFragment()


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