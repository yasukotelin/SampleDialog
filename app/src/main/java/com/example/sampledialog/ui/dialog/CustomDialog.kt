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

    // Fragmentなので引数受け取りはFragmentのイディオムを使って受け取る
    companion object {
        private const val ARG_NAME = "argName"
        private const val ARG_AGE = "argAge"
        private const val ARG_HEIGHT = "argHeight"

        fun newInstance(name: String, age: String, height: String): CustomDialog {
            val f = CustomDialog()
            f.arguments = Bundle().apply {
                putString(ARG_NAME, name)
                putString(ARG_AGE, age)
                putString(ARG_HEIGHT, height)
            }
            return f
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // **NOTE**
        // findViewByIdは直接Viewから取得する必要がある。
        // dialog.findViewByIdはshow()されている状態でないとnullを返却するため注意
        if (dialogView == null) {
            dialogView = activity?.layoutInflater?.inflate(R.layout.dialog_custom, null, false)
            nameTextView = dialogView?.findViewById(R.id.nameTextView)
            ageTextView = dialogView?.findViewById(R.id.ageTextView)
            heightTextView = dialogView?.findViewById(R.id.heightTextView)
            phoneEditText = dialogView?.findViewById(R.id.phoneEditText)
        }

        nameTextView?.text = arguments?.getString(ARG_NAME)
        ageTextView?.text = arguments?.getString(ARG_AGE)
        heightTextView?.text = arguments?.getString(ARG_HEIGHT)

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