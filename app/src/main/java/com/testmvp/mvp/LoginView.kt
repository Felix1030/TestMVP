package com.testmvp.mvp

import com.testmvp.BaseMvpContract

/**
 * Created by Master on 2017/10/20.
 */
interface LoginView : BaseMvpContract.BaseMvpView {
    fun onResult(str: String)
}