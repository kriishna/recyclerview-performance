package com.github.vivchar.recyclerviewperfomance;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;


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

	@NonNull
	private final CompositeDisposable disposables = new CompositeDisposable();

	protected abstract void viewShown();

	@CallSuper
	public void viewHidden() {
		disposables.clear();
	}

	protected void addSubscription(@NonNull final Observable observable, @NonNull final Consumer consumer) {
		addSubscription(observable
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(consumer)
		);
	}

	protected void addSubscription(@NonNull final Disposable disposable) {
		disposables.add(disposable);
	}
}
