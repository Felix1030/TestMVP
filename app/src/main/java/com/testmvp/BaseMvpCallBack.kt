package com.testmvp

/**
 * Created by Master on 2017/10/20.
 */
interface BaseMvpCallBack< V : BaseMvpContract.BaseMvpView, P : BaseMvpContract.BaseMvpPresenter<V>> {

    fun createPresenter(): P?

    fun createView(): V?

    fun setPresenter(presenter: P?)

    fun getPresenter(): P?

    fun setView(view: V?)

    fun getView(): V?
}