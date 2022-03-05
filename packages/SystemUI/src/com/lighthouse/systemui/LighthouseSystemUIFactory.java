package com.lighthouse.systemui;

import android.content.Context;
import android.content.res.AssetManager;

import com.lighthouse.systemui.dagger.LighthouseGlobalRootComponent;
import com.lighthouse.systemui.dagger.LighthouseSysUIComponent;
import com.lighthouse.systemui.dagger.DaggerLighthouseGlobalRootComponent;
import com.android.systemui.navigationbar.gestural.BackGestureTfClassifierProvider;
import com.android.systemui.screenshot.ScreenshotNotificationSmartActionsProvider;

import com.google.android.systemui.gesture.BackGestureTfClassifierProviderGoogle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;

public class LighthouseSystemUIFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerLighthouseGlobalRootComponent.builder()
                .context(context)
                .build();
    }

    @Override
    public BackGestureTfClassifierProvider createBackGestureTfClassifierProvider(AssetManager am, String modelName) {
        return new BackGestureTfClassifierProviderGoogle(am, modelName);
    }

    @Override
    public void init(Context context, boolean fromTest) throws ExecutionException, InterruptedException {
        super.init(context, fromTest);
        if (shouldInitializeComponents()) {
            ((LighthouseSysUIComponent) getSysUIComponent()).createKeyguardSmartspaceController();
        }
    }
}
