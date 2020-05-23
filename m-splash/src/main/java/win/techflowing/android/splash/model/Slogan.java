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

package win.techflowing.android.splash.model;

/**
 * Slogan页面数据
 *
 * @author techflowing
 * @since 2019/1/1 6:12 PM
 */
public class Slogan implements Splash {

    private int mImgRes;

    public Slogan(int imgRes) {
        mImgRes = imgRes;
    }

    public int getImgRes() {
        return mImgRes;
    }
}
