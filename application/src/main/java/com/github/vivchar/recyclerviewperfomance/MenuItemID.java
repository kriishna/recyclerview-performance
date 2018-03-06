package com.github.vivchar.recyclerviewperfomance;

/**
 * Created by Vivchar Vitaly on 12/29/17.
 */

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

import static com.github.vivchar.recyclerviewperfomance.MenuItemID.*;

@Retention(RetentionPolicy.SOURCE)
@IntDef({
		RENDERER,
		DIFF_UTIL,
		PAYLOAD,
		VIEW_STATE,
		LOAD_MORE,
		VIEW_BINDER,
		COMPOSITE_VIEW_RENDERER,
		ADAPTER_DELEGATES,
})
public @interface MenuItemID {
	int RENDERER = R.id.renderer;
	int DIFF_UTIL = R.id.diff_util;
	int PAYLOAD = R.id.payload;
	int VIEW_STATE = R.id.view_state;
	int LOAD_MORE = R.id.load_more;
	int VIEW_BINDER = R.id.view_binder;
	int COMPOSITE_VIEW_RENDERER = R.id.composite_view_renderer;
	int ADAPTER_DELEGATES = R.id.adapterDelegates;

	List<Integer> ALL = Arrays.asList(
			RENDERER,
			DIFF_UTIL,
			PAYLOAD,
			VIEW_STATE,
			LOAD_MORE,
			VIEW_BINDER,
			COMPOSITE_VIEW_RENDERER,
			ADAPTER_DELEGATES
	);
}