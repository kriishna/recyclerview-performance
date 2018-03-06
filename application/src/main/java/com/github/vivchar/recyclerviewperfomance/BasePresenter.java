package com.github.vivchar.recyclerviewperfomance;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.util.Log;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vivchar Vitaly on 10.10.17.
 */

public abstract class BasePresenter {

	private static final String TAG = BasePresenter.class.getSimpleName();

	@NonNull
	private final CompositeDisposable disposables = new CompositeDisposable();

	protected abstract void viewShown();

	@CallSuper
	public void viewHidden() {
		disposables.clear();
	}


	protected <T> void addSubscription(@NonNull final Observable<T> observable,
	                                   @NonNull final Consumer<T> onNext) {
		addSubscription(observable, onNext, getDefaultOnError());
	}

	@NonNull
	private Consumer<Throwable> getDefaultOnError() {
		return throwable -> Log.d(TAG, "getDefaultOnError", throwable);
	}

	protected <T> void addSubscription(@NonNull final Observable<T> observable,
	                                   @NonNull final Consumer<T> onNext,
	                                   @NonNull final Consumer<Throwable> onError) {
		addSubscription(observable
				.subscribeOn(Schedulers.newThread()) //TODO move to up?
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(onNext, onError)
		);
	}

	protected void addSubscription(@NonNull final Disposable disposable) {
		disposables.add(disposable);
	}
}
