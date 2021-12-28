package com.lighthouse.android.systemui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;

import com.google.android.systemui.gesture.BackGestureTfClassifierProviderGoogle;

import com.lighthouse.android.systemui.dagger.DaggerGlobalRootComponentLighthouse;
import com.lighthouse.android.systemui.dagger.GlobalRootComponentLighthouse;
import com.lighthouse.android.systemui.dagger.SysUIComponentLighthouse;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;
import com.android.systemui.navigationbar.gestural.BackGestureTfClassifierProvider;
import com.android.systemui.screenshot.ScreenshotNotificationSmartActionsProvider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class SystemUILighthouseFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerGlobalRootComponentLighthouse.builder()
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
            ((SysUIComponentLighthouse) getSysUIComponent()).createKeyguardSmartspaceController();
        }
    }
}
