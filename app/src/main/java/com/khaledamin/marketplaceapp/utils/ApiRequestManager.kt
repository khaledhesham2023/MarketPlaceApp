package com.khaledamin.marketplaceapp.utils

import android.content.Context
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ApiRequestManager(private val context: Context) {

    fun <T> requestApi(
        request: Single<T>,
        liveData: MutableLiveData<ViewState<T>>,
    ) {
        if (isInternetConnected(context)) {
            liveData.value = ViewState.Loading
            request.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(object : SingleObserver<T> {
                    override fun onSubscribe(d: Disposable) {
//                TODO("Not yet implemented")
                    }

                    override fun onSuccess(t: T) {
                        liveData.value = ViewState.Success(t,"Success")
                    }

                    override fun onError(e: Throwable) {
                        liveData.value = ViewState.Error(e.message!!)
                    }
                })
        }
    }
}