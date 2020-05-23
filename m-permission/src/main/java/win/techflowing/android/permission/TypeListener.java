/*
 * Copyright 2018. techflowing
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

package win.techflowing.android.permission;

/**
 * 接口抽象
 *
 * @author techflowing
 * @since 2018/10/7 9:24 PM
 */
interface TypeListener<T> {

    /**
     * 接口回调
     *
     * @param params  参数
     * @param process 进度回调
     */
    void doAction(T params, Process process);

    /**
     * 进度回调接口
     */
    interface Process {
        /**
         * 下一步操作
         */
        void onNext();

        /**
         * 取消操作
         */
        void onCancel();
    }
}
