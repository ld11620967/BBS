package com.mob.bbssdk.theme0.page.user;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.mob.bbssdk.gui.pages.misc.PageFollowings;
import com.mob.bbssdk.theme0.page.Theme0StyleModifier;

public class Theme0PageFollowings extends PageFollowings {

	@Override
	protected View onCreateContentView(Context context) {
		View view = LayoutInflater.from(context).inflate(getLayoutId("bbs_theme0_followings"), null);
		return view;
	}

	@Override
	protected void onViewCreated(View contentView) {
		super.onViewCreated(contentView);
		titleBar.setLeftImageResource(getDrawableId("bbs_titlebar_back_black"));
		titleBar.setTitle(getStringRes("theme0_pagemyfollowing_title"));
		Theme0StyleModifier.modifyUniformWhiteStyle(this);
		followingsPullRequestView.performPullingDown(true);
	}
}
