package com.example.sampledialog.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sampledialog.R

class CustomDialog : DialogFragment() {

    // 呼び出し側がViewの要素にアクセスできるようにフィールドで保持する
    var dialogView: View? = null
    var nameTextView: TextView? = null
    var ageTextView: TextView? = null
    var heightTextView: TextView? = null
    var phoneEditText: EditText? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // **NOTE**
        // findViewByIdは直接Viewから取得する必要がある。
        // dialog.findViewByIdはshow()されている状態でないとnullを返却するため注意
        dialogView = activity?.layoutInflater?.inflate(R.layout.dialog_custom, null, false)
        nameTextView = dialogView?.findViewById(R.id.nameTextView)
        ageTextView = dialogView?.findViewById(R.id.ageTextView)
        heightTextView = dialogView?.findViewById(R.id.heightTextView)
        phoneEditText = dialogView?.findViewById(R.id.phoneEditText)

        nameTextView?.text = "Tanaka Taro"
        ageTextView?.text = "23"
        heightTextView?.text = "165.8cm"

        return AlertDialog.Builder(context)
            .setTitle("Custom dialog")
            .setView(dialogView)
            .setPositiveButton("ok") { _, _ ->
                val phoneValue = phoneEditText?.text
                Toast.makeText(context, phoneValue, Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(context, "Click cancel!", Toast.LENGTH_SHORT).show()
            }
            .create()
    }
}