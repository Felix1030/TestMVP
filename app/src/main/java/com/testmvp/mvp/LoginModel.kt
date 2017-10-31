package com.testmvp.mvp

import com.testmvp.APIUtils
import com.testmvp.OnResultListener

/**
 * Created by Master on 2017/10/20.
 */
class LoginModel {
    fun login(name: String, pass: String, listener: OnResultListener) {
        APIUtils.login("", "", listener)
    }
}