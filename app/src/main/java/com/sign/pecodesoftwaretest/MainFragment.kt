package com.sign.pecodesoftwaretest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.sign.pecodesoftwaretest.Constants.CHANNEL_ID
import com.sign.pecodesoftwaretest.Constants.CHANNEL_NAME
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_layout.*
import kotlinx.android.synthetic.main.fragment_main_layout.view.*

class MainFragment : Fragment(R.layout.fragment_main_layout) {

    var itemPosition = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter = (activity as MainActivity).adapter
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager)

        createNotificationChannel()

        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setContentTitle("Chat heads active")
            .setSmallIcon(R.drawable.ic_brightness)
            .setPriority(NotificationCompat.PRIORITY_HIGH)


        val notiFicationManager = NotificationManagerCompat.from(requireContext())

        btn_create_notification.setOnClickListener {
            Log.e("STARTED","$itemPosition")
            notification.setContentText("Notification ${itemPosition}")
            notiFicationManager.notify(itemPosition,notification.build())
        }

        btn_add.setOnClickListener {

            viewPagerAdapter.addFragment()
        }

        btn_remove.setOnClickListener {
            notiFicationManager.cancel(viewPagerAdapter.itemCount)
            viewPagerAdapter.deleteFragment()
        }

    }


    fun setTextNum(string: String){
        tv_num.text = string
    }


    fun hideRemoveButton(){
        if (tv_num.text.toString()=="1"){
            btn_remove.visibility = View.INVISIBLE
        }
    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT)

            val manager = requireActivity()
                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

}