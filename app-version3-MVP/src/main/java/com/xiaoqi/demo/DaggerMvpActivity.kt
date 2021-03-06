package com.xiaoqi.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import com.xiaoqi.demo.presenter.BasePresenter
import com.xiaoqi.demo.view.IBaseView
import dagger.android.AndroidInjection
import javax.inject.Inject

open class DaggerMvpActivity<T: BasePresenter<K>, K: IBaseView>: AppCompatActivity(), IBaseView {


    @Inject lateinit var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        presenter.attachView(this as K)
        lifecycle.addObserver(presenter as LifecycleObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(presenter as LifecycleObserver)
    }
}