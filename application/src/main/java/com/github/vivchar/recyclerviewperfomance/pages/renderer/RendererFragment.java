package com.github.vivchar.recyclerviewperfomance.pages.renderer;

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
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model1.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model2.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model3.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model4.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model5.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model6.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model7.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model8.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model9.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));
		mAdapter.registerRenderer(new ViewBinder<>(
				R.layout.recycler_view_item,
				Model10.class,
				(m, v, p) -> v.setText(R.id.textView, m.getClass().getSimpleName())
		));

		mRecyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
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


	static class Model1 implements ViewModel {}

	static class Model2 implements ViewModel {}

	static class Model3 implements ViewModel {}

	static class Model4 implements ViewModel {}

	static class Model5 implements ViewModel {}

	static class Model6 implements ViewModel {}

	static class Model7 implements ViewModel {}

	static class Model8 implements ViewModel {}

	static class Model9 implements ViewModel {}

	static class Model10 implements ViewModel {}
}