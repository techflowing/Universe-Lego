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

package win.techflowing.android.splash.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import butterknife.BindView;
import win.techflowing.android.framework.fragment.AbsFragment;
import win.techflowing.android.splash.R;
import win.techflowing.android.splash.R2;


/**
 * Slogan 启动页面
 *
 * @author techflowing
 * @since 2019/1/1 5:53 PM
 */
public class SloganFragment extends AbsFragment {

    private static final int DELAY = 1500;
    public static final String KEY_IMG_RES = "key_img_res";

    @BindView(R2.id.img_slogan)
    ImageView sloganImg;

    @DrawableRes
    private int mImgRes;
    private OnEnterHomeListener mEnterHomeListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_slogan;
    }

    @Override
    protected void initVariable() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        mImgRes = bundle.getInt(KEY_IMG_RES);
    }

    @Override
    protected void initView() {
        sloganImg.setImageResource(mImgRes);
    }

    @Override
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mEnterHomeListener != null) {
                    mEnterHomeListener.enterHome();
                }
            }
        }, DELAY);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnEnterHomeListener) {
            mEnterHomeListener = (OnEnterHomeListener) context;
        }
    }
}
