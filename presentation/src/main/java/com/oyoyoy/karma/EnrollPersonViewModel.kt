package com.oyoyoy.karma

import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import android.text.TextUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.oyoyoy.karma.base.BaseViewModel

class EnrollPersonViewModel:BaseViewModel() {
    var editPersonName : LiveData<String> = LiveData()
    var editPersonContent : LiveData<String> = LiveData()

    override fun onCreate() {
        super.onCreate()
    }




    fun onButtonClick(){
        val replyIntent = Intent()
        if (TextUtils.isEmpty(editPersonName.value)) {
            setResult(Fragment.RESULT_CANCELED, replyIntent)
        } else {
            val word = editWordView.text.toString()
            replyIntent.putExtra(EXTRA_REPLY, word)
            setResult(Activity.RESULT_OK, replyIntent)
        }
        finish()

    }

}