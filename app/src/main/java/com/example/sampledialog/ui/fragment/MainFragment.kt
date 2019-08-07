package com.example.sampledialog.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.example.sampledialog.R
import com.example.sampledialog.ui.dialog.CustomDialog
import com.example.sampledialog.ui.dialog.SimpleDialog
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        simpleDialogButton.setOnClickListener { onClickSimpleDialogButton() }
        customDialogButton.setOnClickListener { onClickCustomDialogButton() }
    }

    private fun onClickSimpleDialogButton() {
        SimpleDialog().show(fragmentManager, "simpleDialog")
    }

    private fun onClickCustomDialogButton() {
        CustomDialog().show(fragmentManager, "customDialog")
    }
}
