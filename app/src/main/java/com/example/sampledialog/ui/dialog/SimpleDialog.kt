package com.example.sampledialog.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast

class SimpleDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context)
            .setTitle("Title")
            .setMessage("this is message.")
            .setPositiveButton("ok") { _, _ ->
                Toast.makeText(context, "Click ok!", Toast.LENGTH_SHORT).show()
            }
            .create()
    }

}