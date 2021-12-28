package com.lighthouse.android.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SystemUIBinder;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SystemUIModule;

import com.lighthouse.android.systemui.keyguard.KeyguardSliceProviderLighthouse;
import com.lighthouse.android.systemui.smartspace.KeyguardSmartspaceController;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(modules = {
        DefaultComponentBinder.class,
        DependencyProvider.class,
        SystemUIBinder.class,
        SystemUIModule.class,
        SystemUILighthouseModule.class})
public interface SysUIComponentLighthouse extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        SysUIComponentLighthouse build();
    }

    /**
     * Member injection into the supplied argument.
     */
    void inject(KeyguardSliceProviderLighthouse keyguardSliceProviderLighthouse);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}
