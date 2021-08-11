package com.sign.pecodesoftwaretest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main_layout.*

class MainFragment : Fragment(R.layout.fragment_main_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("STARTED", "NEW FRAGMENT STARTED")

//        button.setOnClickListener {
//            findNavController().navigate(R.id.mainFragment)
//        }
    }
}