package com.testmvp

/**
 * Created by Master on 2017/10/20.
 */
class BaseMvpCallBackProxy<V : BaseMvpContract.BaseMvpView, P : BaseMvpContract.BaseMvpPresenter<V>> : BaseMvpCallBack<V, P> {

    private val baseMvpCallback: BaseMvpCallBack<V, P>

    constructor(callback: BaseMvpCallBack<V, P>) {
        this.baseMvpCallback = callback
    }

    override fun createPresenter(): P? {
        var presenter = baseMvpCallback.getPresenter()
        if (null == presenter) {
            presenter = baseMvpCallback.createPresenter()
        }
//        if (presenter == null) {
//            throw NullPointerException("presenter can not be null")
//        }
        baseMvpCallback.setPresenter(presenter)
        return getPresenter()
    }

    override fun createView(): V {
        var view = baseMvpCallback.getView()
        if (null == view) {
            view = baseMvpCallback.createView()
        }
//        if (presenter == null) {
//            throw NullPointerException("view can not be null")
//        }
        baseMvpCallback.setView(view)
        return getView()
    }

    override fun setPresenter(presenter: P?) {
        baseMvpCallback.setPresenter(presenter)
    }

    override fun getPresenter(): P? {
        return baseMvpCallback.getPresenter()
    }

    override fun setView(view: V?) {
        baseMvpCallback.setView(view)
    }

    override fun getView(): V {
        return baseMvpCallback.getView()!!
    }

    fun attachView() {
        getPresenter()?.attachView(getView())
    }

    fun detachView() {
        getPresenter()?.detachView()
    }
}