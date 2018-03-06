package com.github.vivchar.recyclerviewperfomance.pages.adapterdelegates;

import android.util.Log;

import com.github.vivchar.recyclerviewperfomance.BasePresenter;
import com.github.vivchar.recyclerviewperfomance.pages.adapterdelegates.AdapterDelegatesFragment.BaseItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.github.vivchar.recyclerviewperfomance.pages.adapterdelegates.AdapterDelegatesFragment.*;

/**
 * Created by Vivchar Vitaly on 06.03.18.
 */

class AdapterDelegatesPresenter extends BasePresenter {

	private AdapterDelegatesFragment mView;
	private ArrayList<BaseItem> mList = new ArrayList<>();

	public AdapterDelegatesPresenter(final AdapterDelegatesFragment view) {
		mView = view;
		for (int i = 0; i < 100; i++) {
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
	}

	@Override
	protected void viewShown() {
		addSubscription(
				Observable.combineLatest(
						Observable.interval(0, INTERVAL, TimeUnit.MILLISECONDS),
						Observable.just(mList),
						(tick, items) -> new ArrayList<>(items.subList((int) (tick % 10), items.size()))
				),
				mView::updateItems
		);
	}
}
