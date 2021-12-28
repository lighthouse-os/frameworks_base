package com.lighthouse.android.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SystemUIBinder;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SystemUIModule;

import com.lighthouse.android.systemui.keyguard.LighthouseKeyguardSliceProvider;
import com.lighthouse.android.systemui.smartspace.KeyguardSmartspaceController;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(modules = {
        DefaultComponentBinder.class,
        DependencyProvider.class,
        SystemUIBinder.class,
        SystemUIModule.class,
        LighthouseSystemUIModule.class})
public interface LighthouseSysUIComponent extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        LighthouseSysUIComponent build();
    }

    /**
     * Member injection into the supplied argument.
     */
    void inject(LighthouseKeyguardSliceProvider keyguardSliceProvider);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}
