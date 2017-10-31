package com.testmvp

import android.os.Bundle

/**
 * Created by Master on 2017/10/20.
 */
class BaseMvpActivityDelegateImp<V : BaseMvpContract.BaseMvpView, P : BaseMvpContract.BaseMvpPresenter<V>> : BaseMvpActivityDelegate<V, P> {

    private val callbackProxy: BaseMvpCallBackProxy<V, P>
    private val baseMvpCallBack: BaseMvpCallBack<V, P>

    constructor(callback: BaseMvpCallBack<V, P>) {
        this.baseMvpCallBack = callback
        this.callbackProxy = BaseMvpCallBackProxy(callback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        callbackProxy.createPresenter()
        callbackProxy.createView()
        callbackProxy.attachView()
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onRestart() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
        callbackProxy.detachView()
    }
}