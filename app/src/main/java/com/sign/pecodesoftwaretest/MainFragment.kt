package com.sign.pecodesoftwaretest

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_main_layout.*

class MainFragment : Fragment(R.layout.fragment_main_layout) {

   val args : MainFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("STARTED","STARTED FRAGMENT ${args.fragmentNumber}")
        setFragmentNumber()
        hideRemoveButton()

        btn_add.setOnClickListener {
            val numberForArgs = tv_num.text.toString().toInt()+1
            val action = MainFragmentDirections.actionMainFragmentSelf(numberForArgs)
            findNavController().navigate(action)
        }

        btn_remove.setOnClickListener {
            val numberForArgs = tv_num.text.toString().toInt()-1
            val action = MainFragmentDirections.actionMainFragmentSelf(numberForArgs)
            findNavController().popBackStack(R.id.mainFragment,true)
            //findNavController().navigate(action)

        }

    }

    private fun setFragmentNumber(){
        if (args.fragmentNumber!=0){
            tv_num.text = args.fragmentNumber.toString()
        }
    }

    private fun hideRemoveButton(){
        if (tv_num.text.toString()=="1"){
            btn_remove.visibility = View.INVISIBLE
        }
    }
}