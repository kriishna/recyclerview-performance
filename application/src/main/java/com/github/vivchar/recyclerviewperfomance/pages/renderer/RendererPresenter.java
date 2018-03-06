package com.github.vivchar.recyclerviewperfomance.pages.renderer;

import android.support.annotation.NonNull;

import com.github.vivchar.recyclerviewperfomance.BasePresenter;
import com.github.vivchar.recyclerviewperfomance.IView;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

import static com.github.vivchar.recyclerviewperfomance.pages.renderer.RendererFragment.*;

/**
 * Created by Vivchar Vitaly on 05.03.18.
 */
class RendererPresenter extends BasePresenter {

	private ArrayList<ViewModel> mList = new ArrayList<>();

	private View mView;

	public RendererPresenter(@NonNull final View view) {
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

	interface View extends IView {
		void updateItems(@NonNull ArrayList<ViewModel> items);
	}
}
