package com.testmvp

import android.os.Bundle

/**
 * Created by Master on 2017/10/20.
 */
interface BaseMvpActivityDelegate<V : BaseMvpContract.BaseMvpView, P : BaseMvpContract.BaseMvpPresenter<V>> {

    fun onCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onRestart()

    fun onPause()

    fun onStop()

    fun onDestroy()
}