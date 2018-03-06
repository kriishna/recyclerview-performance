package com.github.vivchar.recyclerviewperfomance.pages;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.vivchar.recyclerviewperfomance.R;

/**
 * Created by Vivchar Vitaly on 06.03.18.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

	public final TextView textView;

	public RecyclerViewHolder(View itemView) {
		super(itemView);
		textView = (TextView) itemView.findViewById(R.id.textView);
	}
}
