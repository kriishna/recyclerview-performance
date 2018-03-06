package com.github.vivchar.recyclerviewperfomance.pages.adapterdelegates;

import android.content.Context;
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
import com.github.vivchar.recyclerviewperfomance.pages.RecyclerViewHolder;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivchar Vitaly on 06.03.18.
 */

public class AdapterDelegatesFragment extends BaseScreenFragment {

	private ConcreteAdapter mAdapter;
	private RecyclerView mRecyclerView;
	private AdapterDelegatesPresenter mPresenter;

	@Nullable
	@Override
	public View onCreateView(@NonNull final LayoutInflater inflater,
	                         @Nullable final ViewGroup container,
	                         @Nullable final Bundle savedInstanceState) {
		mPresenter = new AdapterDelegatesPresenter(this);
		mAdapter = new ConcreteAdapter(getContext());

		mRecyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		mRecyclerView.setAdapter(mAdapter);
		return mRecyclerView;
	}

	@Override
	public void onStart() {
		super.onStart();
		mPresenter.viewShown();
	}

	@Override
	public void onStop() {
		super.onStop();
		mPresenter.viewHidden();
	}

	public void updateItems(@NonNull final ArrayList<BaseItem> items) {
		mAdapter.setItems(items);
		mAdapter.notifyDataSetChanged();
	}

	interface BaseItem {}

	static class Model1 implements BaseItem {}

	static class Model2 implements BaseItem {}

	static class Model3 implements BaseItem {}

	static class Model4 implements BaseItem {}

	static class Model5 implements BaseItem {}

	static class Model6 implements BaseItem {}

	static class Model7 implements BaseItem {}

	static class Model8 implements BaseItem {}

	static class Model9 implements BaseItem {}

	static class Model10 implements BaseItem {}

	private class ConcreteAdapter extends RecyclerView.Adapter {

		private AdapterDelegatesManager<List<BaseItem>> delegatesManager;
		private ArrayList<BaseItem> items = new ArrayList<>();

		ConcreteAdapter(@NonNull final Context context) {
			delegatesManager = new AdapterDelegatesManager<>();
			delegatesManager
					.addDelegate(new AdapterDelegate1(context))
					.addDelegate(new AdapterDelegate2(context))
					.addDelegate(new AdapterDelegate3(context))
					.addDelegate(new AdapterDelegate4(context))
					.addDelegate(new AdapterDelegate5(context))
					.addDelegate(new AdapterDelegate6(context))
					.addDelegate(new AdapterDelegate7(context))
					.addDelegate(new AdapterDelegate8(context))
					.addDelegate(new AdapterDelegate9(context))
					.addDelegate(new AdapterDelegate10(context));
		}

		@Override
		public int getItemViewType(int position) {
			return delegatesManager.getItemViewType(items, position);
		}

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			return delegatesManager.onCreateViewHolder(parent, viewType);
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
			delegatesManager.onBindViewHolder(items, position, holder);
		}

		@Override
		public int getItemCount() {
			return items.size();
		}

		public void setItems(final ArrayList<BaseItem> items) {
			this.items.clear();
			this.items.addAll(items);
		}
	}

	public abstract class BaseAdapterDelegate extends AdapterDelegate<List<BaseItem>> {

		@NonNull
		private final LayoutInflater mInflater;

		BaseAdapterDelegate(@NonNull final Context context) {
			mInflater = LayoutInflater.from(context);
		}

		@NonNull
		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
			return new RecyclerViewHolder(mInflater.inflate(R.layout.recycler_view_item, parent, false));
		}

		@Override
		public void onBindViewHolder(@NonNull List<BaseItem> items,
		                             int position,
		                             @NonNull RecyclerView.ViewHolder holder,
		                             @Nullable List<Object> payloads) {

			RecyclerViewHolder vh = (RecyclerViewHolder) holder;
			vh.textView.setText(items.get(position).getClass().getSimpleName());
		}
	}

	private class AdapterDelegate1 extends BaseAdapterDelegate {

		AdapterDelegate1(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model1;
		}
	}

	private class AdapterDelegate2 extends BaseAdapterDelegate {

		AdapterDelegate2(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model2;
		}
	}

	private class AdapterDelegate3 extends BaseAdapterDelegate {

		AdapterDelegate3(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model3;
		}
	}

	private class AdapterDelegate4 extends BaseAdapterDelegate {

		AdapterDelegate4(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model4;
		}
	}

	private class AdapterDelegate5 extends BaseAdapterDelegate {

		AdapterDelegate5(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model5;
		}
	}

	private class AdapterDelegate6 extends BaseAdapterDelegate {

		AdapterDelegate6(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model6;
		}
	}

	private class AdapterDelegate7 extends BaseAdapterDelegate {

		AdapterDelegate7(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model7;
		}
	}

	private class AdapterDelegate8 extends BaseAdapterDelegate {

		AdapterDelegate8(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model8;
		}
	}

	private class AdapterDelegate9 extends BaseAdapterDelegate {

		AdapterDelegate9(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model9;
		}
	}

	private class AdapterDelegate10 extends BaseAdapterDelegate {

		AdapterDelegate10(final Context context) {
			super(context);
		}

		@Override
		protected boolean isForViewType(@NonNull final List<BaseItem> items, final int position) {
			return items.get(position) instanceof Model10;
		}
	}
}
