package com.testmvp

import android.os.Bundle
import android.widget.Toast
import com.testmvp.mvp.LoginPresenter
import com.testmvp.mvp.LoginView

class MainActivity : BaseMvpActivity<LoginView, LoginPresenter>(), LoginView {

    override fun onResult(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById(R.id.id).setOnClickListener {
            getPresenter()?.login("", "")
        }
    }
}
