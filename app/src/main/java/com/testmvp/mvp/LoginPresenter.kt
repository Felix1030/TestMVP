package com.testmvp.mvp

import com.testmvp.BasePresenter
import com.testmvp.OnResultListener

/**
 * Created by Master on 2017/10/20.
 */
class LoginPresenter : BasePresenter<LoginView>(), OnResultListener {

    private val loginModel: LoginModel = LoginModel() //   M层引用

    fun login(name: String, pass: String) = loginModel.login(name, pass, this)

    override fun onResult(result: String?) {
        val view = getView()
        view?.onResult(result.toString())
    }
}