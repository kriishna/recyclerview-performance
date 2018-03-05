package com.github.vivchar.recyclerviewperfomance.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vivchar.recyclerviewperfomance.BaseScreenFragment;
import com.github.vivchar.recyclerviewperfomance.R;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;
import com.github.vivchar.rendererrecyclerviewadapter.binder.ViewBinder;

import java.util.ArrayList;

/**
 * Created by Vivchar Vitaly on 05.03.18.
 */

public class RendererFragment extends BaseScreenFragment implements RendererPresenter.View {

	private RecyclerView mRecyclerView;
	private RendererRecyclerViewAdapter mAdapter;
	private RendererPresenter mRendererPresenter;

	@Nullable
	@Override
	public View onCreateView(@NonNull final LayoutInflater inflater,
	                         @Nullable final ViewGroup container,
	                         @Nullable final Bundle savedInstanceState) {
		mRendererPresenter = new RendererPresenter(this);

		mAdapter = new RendererRecyclerViewAdapter();
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model1.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model2.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model3.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model4.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model5.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model6.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model7.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model8.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model9.class, (m, v, p) -> {}));
		mAdapter.registerRenderer(new ViewBinder<>(R.layout.renderer_item, RendererPresenter.Model10.class, (m, v, p) -> {}));

		mRecyclerView = (RecyclerView) inflater.inflate(R.layout.renderer_adapter, container, false);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		mRecyclerView.setAdapter(mAdapter);

		return mRecyclerView;
	}

	@Override
	public void onStart() {
		super.onStart();
		mRendererPresenter.viewShown();
	}

	@Override
	public void onStop() {
		super.onStop();
		mRendererPresenter.viewHidden();
	}

	@Override
	public void updateItems(@NonNull final ArrayList<ViewModel> items) {
		mAdapter.setItems(items);
		mAdapter.notifyDataSetChanged();
	}
}