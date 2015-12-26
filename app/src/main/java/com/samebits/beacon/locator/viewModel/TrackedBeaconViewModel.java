/*
 *
 *  Copyright (c) 2015 SameBits UG. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.samebits.beacon.locator.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.samebits.beacon.locator.model.IManagedBeacon;
import com.samebits.beacon.locator.ui.activity.BeaconActivity;
import com.samebits.beacon.locator.util.Constants;

/**
 * Created by vitas on 19/10/15.
 */
public class TrackedBeaconViewModel extends DetectedBeaconViewModel {

    public TrackedBeaconViewModel(Context context, @NonNull IManagedBeacon managedBeacon) {
        super(context, managedBeacon);
    }

    protected void launchBeaconDetailsActivity() {
        Intent intent = BeaconActivity.getStartIntent(context);
        intent.putExtra(ARG_BEACON, (Parcelable) managedBeacon);
        intent.putExtra(ARG_MODE, Constants.TRACKED_BEACON_MODE);
        ((Activity) context).startActivityForResult(intent, Constants.REQ_UPDATED_TRACKED_BEACON);
    }
}