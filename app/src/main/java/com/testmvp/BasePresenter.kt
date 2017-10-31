package com.testmvp

/**
 * Created by Master on 2017/10/20.
 */

open class BasePresenter<V : BaseMvpContract.BaseMvpView> : BaseMvpContract.BaseMvpPresenter<V> {

    private var view: V? = null

    fun getView(): V? = view

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

}
