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

import java.util.List;

/**
 * 权限申请结果回调
 *
 * @author techflowing
 * @since 2018/10/7 9:57 PM
 */
public interface PermissionRequestCallback {

    /**
     * 权限申请通过
     */
    void onPermissionGranted();

    /**
     * 权限申请失败
     *
     * @param deniedPermissions 权限拒绝列表
     */
    void onPermissionDenied(List<String> deniedPermissions);
}
