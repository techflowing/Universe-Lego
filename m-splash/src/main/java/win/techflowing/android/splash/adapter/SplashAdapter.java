/*
 * Copyright 2019. techflowing
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package win.techflowing.android.splash.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import win.techflowing.android.splash.model.Ad;
import win.techflowing.android.splash.model.Guide;
import win.techflowing.android.splash.model.Slogan;
import win.techflowing.android.splash.model.Splash;
import win.techflowing.android.splash.ui.GuideFragment;
import win.techflowing.android.splash.ui.SloganFragment;
import win.techflowing.android.splash.ui.SplashAdFragment;

/**
 * 启动页面Adapter
 *
 * @author techflowing
 * @since 2019/1/1 5:46 PM
 */
public class SplashAdapter extends FragmentPagerAdapter {

    private List<Splash> mSplashList;

    public SplashAdapter(FragmentManager fm, List<Splash> splashList) {
        super(fm);
        this.mSplashList = splashList;
    }

    @Override
    public Fragment getItem(int position) {
        Splash splash = mSplashList.get(position);
        Bundle bundle = new Bundle();
        if (splash instanceof Guide) {
            bundle.putInt(GuideFragment.KEY_IMG_RES, ((Guide) splash).getImgRes());
            bundle.putBoolean(GuideFragment.KEY_SHOW_ENTER, ((Guide) splash).isShowInter());
            GuideFragment guideFragment = new GuideFragment();
            guideFragment.setArguments(bundle);
            return guideFragment;
        } else if (splash instanceof Slogan) {
            bundle.putInt(SloganFragment.KEY_IMG_RES, ((Slogan) splash).getImgRes());
            SloganFragment sloganFragment = new SloganFragment();
            sloganFragment.setArguments(bundle);
            return sloganFragment;
        } else if (splash instanceof Ad) {
            bundle.putString(GuideFragment.KEY_IMG_RES, ((Ad) splash).getImgPath());
            SplashAdFragment adFragment = new SplashAdFragment();
            adFragment.setArguments(bundle);
            return adFragment;
        } else {
            throw new IllegalStateException("不支持的引导页类型");
        }
    }

    @Override
    public int getCount() {
        return mSplashList != null ? mSplashList.size() : 0;
    }
}
