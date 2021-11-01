package com.example.sample_mvp_architecture.model

import android.os.Handler
import android.os.Looper
import com.example.sample_mvp_architecture.contract.Contract
import java.util.*


class Model : Contract.Model {
    // array list of strings from which
    // random strings will be selected
    // to display in the activity
    private val arrayList =
        listOf(
            "First textView.",
            "Second textView.",
            "Third textView",
            "Fourth textView"
        )

    // this method will invoke when
    // user clicks on the button
    // and it will take a delay of
    // 1200 milliseconds to display next course detail
    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler(Looper.getMainLooper()).postDelayed({ onFinishedListener!!.onFinished(getRandomString) }, 1200)
    }


    // method to select random
    // string from the list of strings
    private val getRandomString: String
        private get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }
}
