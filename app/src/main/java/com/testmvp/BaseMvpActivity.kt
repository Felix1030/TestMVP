package com.testmvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.reflect.ParameterizedType

abstract class BaseMvpActivity<V : BaseMvpContract.BaseMvpView, P : BaseMvpContract.BaseMvpPresenter<V>> : AppCompatActivity(),
        BaseMvpContract.BaseMvpView, BaseMvpCallBack<V, P> {

    private var presenter: P? = null
    private var view: V? = null

    private var baseMvpDelegate: BaseMvpActivityDelegateImp<V, P>? = null

    private fun getMvpDelegate(): BaseMvpActivityDelegateImp<V, P> {
        if (null == baseMvpDelegate) {
            baseMvpDelegate = BaseMvpActivityDelegateImp(this)
        }
        return baseMvpDelegate as BaseMvpActivityDelegateImp<V, P>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_base_mvp)
        getMvpDelegate().onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        getMvpDelegate().onStart()
    }

    override fun onResume() {
        super.onResume()
        getMvpDelegate().onResume()
    }

    override fun onRestart() {
        super.onRestart()
        getMvpDelegate().onRestart()
    }

    override fun onPause() {
        super.onPause()
        getMvpDelegate().onPause()
    }

    override fun onStop() {
        super.onStop()
        getMvpDelegate().onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        getMvpDelegate().onDestroy()
    }

    override fun createPresenter(): P? = getT<P>(this, 1)

    override fun createView(): V = this as V

    private fun <T> getT(o: Any, i: Int): T? {
        try {
            if (this.javaClass.genericSuperclass is ParameterizedType) return ((o.javaClass
                    .genericSuperclass as ParameterizedType).actualTypeArguments[i] as Class<T>).newInstance()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: ClassCastException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        return null
    }

    override fun setPresenter(presenter: P?) {
        this.presenter = presenter
    }

    override fun getPresenter(): P? {
        return presenter
    }

    override fun setView(view: V?) {
        this.view = view
    }

    override fun getView(): V? {
        return view
    }
}
