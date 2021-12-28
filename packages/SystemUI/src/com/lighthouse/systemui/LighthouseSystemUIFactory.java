package com.lighthouse.systemui;

import android.content.Context;

import com.lighthouse.systemui.dagger.LighthouseGlobalRootComponent;
import com.lighthouse.systemui.dagger.DaggerLighthouseGlobalRootComponent;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;

public class LighthouseSystemUIFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerLighthouseGlobalRootComponent.builder()
                .context(context)
                .build();
    }
}
