package com.github.vivchar.recyclerviewperfomance.pages;

import android.support.annotation.NonNull;

import com.github.vivchar.recyclerviewperfomance.BasePresenter;
import com.github.vivchar.recyclerviewperfomance.IView;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vivchar Vitaly on 05.03.18.
 */
class RendererPresenter extends BasePresenter {


	private ArrayList<ViewModel> mList = new ArrayList<>();

	private View mView;

	public RendererPresenter(@NonNull final View view) {
		mView = view;
		mList.add(new Model1());
		mList.add(new Model2());
		mList.add(new Model3());
		mList.add(new Model4());
		mList.add(new Model5());
		mList.add(new Model6());
		mList.add(new Model7());
		mList.add(new Model8());
		mList.add(new Model9());
		mList.add(new Model10());
	}

	@Override
	protected void viewShown() {
		addSubscription(Observable
				.combineLatest(Observable.interval(0, 500, TimeUnit.MILLISECONDS), Observable.just(mList), (tick, items) -> items)
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(items -> mView.updateItems(items))
		);
	}

	interface View extends IView {
		void updateItems(@NonNull ArrayList<ViewModel> items);
	}

	class Model1 implements ViewModel {}

	class Model2 implements ViewModel {}

	class Model3 implements ViewModel {}

	class Model4 implements ViewModel {}

	class Model5 implements ViewModel {}

	class Model6 implements ViewModel {}

	class Model7 implements ViewModel {}

	class Model8 implements ViewModel {}

	class Model9 implements ViewModel {}

	class Model10 implements ViewModel {}
}
