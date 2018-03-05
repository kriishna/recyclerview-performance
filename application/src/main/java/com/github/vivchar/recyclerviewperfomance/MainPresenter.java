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
		mMenuController.hideMenuItem(DONE);
	}

	@Override
	protected void viewShown() {
		addSubscription(mMenuController.getItemSelection().subscribe(menuItemID -> {
			@MenuItemID final int menuID = menuItemID;
			switch (menuID) {
				case MAIN:
					mUIRouter.openRendererPage();
					break;
				case DONE:
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
				case VIEW_RENDERER:
					mUIRouter.openViewRendererPage();
					break;
			}
		}));
	}
}
