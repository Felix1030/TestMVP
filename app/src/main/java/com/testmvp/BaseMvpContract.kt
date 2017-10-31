package com.testmvp

/**
 * Created by Master on 2017/10/20.
 */
interface BaseMvpContract {

    interface BaseMvpView {

    }

    interface BaseMvpPresenter<in V : BaseMvpView> {
        fun attachView(view: V)
        fun detachView()
    }

}