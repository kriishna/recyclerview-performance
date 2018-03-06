package com.github.vivchar.recyclerviewperfomance;

import android.support.annotation.NonNull;

import static com.github.vivchar.recyclerviewperfomance.MenuItemID.*;

/**
 * Created by Vivchar Vitaly on 12/29/17.
 */

class MainPresenter extends BasePresenter {

	@NonNull
	private final OptionsMenuController mMenuController;
	@NonNull
	private final UIRouter mUIRouter;

	public MainPresenter(@NonNull final OptionsMenuController menuController, @NonNull final UIRouter UIRouter) {
		mMenuController = menuController;
		mUIRouter = UIRouter;
		mUIRouter.openRendererPage();
	}

	@Override
	protected void viewShown() {
		addSubscription(
				mMenuController.getItemSelection(),
				menuItemID -> {
					@MenuItemID final int menuID = menuItemID;
					switch (menuID) {
						case RENDERER:
							mUIRouter.openRendererPage();
							break;
						case ADAPTER_DELEGATES:
							mUIRouter.openAdapterDelegatesPage();
							break;
						case DIFF_UTIL:
							mUIRouter.openDiffUtilPage();
							break;
						case PAYLOAD:
							mUIRouter.openPayloadPage();
							break;
						case VIEW_STATE:
							mUIRouter.openViewStatePage();
							break;
						case LOAD_MORE:
							mUIRouter.openLoadMorePage();
							break;
						case VIEW_BINDER:
							mUIRouter.openViewBinderPage();
							break;
						case COMPOSITE_VIEW_RENDERER:
							mUIRouter.openCompositeViewRendererPage();
							break;
					}
				}
		);
	}
}
