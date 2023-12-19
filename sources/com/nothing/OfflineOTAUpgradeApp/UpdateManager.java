package com.nothing.OfflineOTAUpgradeApp;

import android.content.Context;
import android.os.Handler;
import android.os.UpdateEngine;
import android.os.UpdateEngineCallback;
import android.util.Log;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AtomicDouble;
import com.nothing.OfflineOTAUpgradeApp.UpdaterState;
import com.nothing.OfflineOTAUpgradeApp.services.PrepareUpdateService;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateEngineProperties;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public class UpdateManager {
    static final String HTTP_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36";
    private static final String TAG = "UpdateManager";
    private final Handler mHandler;
    private final UpdateEngine mUpdateEngine;
    private AtomicInteger mUpdateEngineStatus = new AtomicInteger(0);
    private AtomicInteger mEngineErrorCode = new AtomicInteger(-1);
    private AtomicDouble mProgress = new AtomicDouble(0.0d);
    private UpdaterState mUpdaterState = new UpdaterState(0);
    private AtomicBoolean mManualSwitchSlotRequired = new AtomicBoolean(true);
    private AtomicBoolean mStateSynchronized = new AtomicBoolean(false);
    private UpdateData mLastUpdateData = null;
    private IntConsumer mOnStateChangeCallback = null;
    private IntConsumer mOnEngineStatusUpdateCallback = null;
    private DoubleConsumer mOnProgressUpdateCallback = null;
    private IntConsumer mOnEngineCompleteCallback = null;
    private final Object mLock = new Object();
    private final UpdateEngineCallbackImpl mUpdateEngineCallback = new UpdateEngineCallbackImpl();

    public UpdateManager(UpdateEngine updateEngine, Handler handler) {
        this.mUpdateEngine = updateEngine;
        this.mHandler = handler;
    }

    public void bind() {
        getOnStateChangeCallback().ifPresent(new Consumer() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                UpdateManager.this.m5619lambda$bind$0$comnothingOfflineOTAUpgradeAppUpdateManager((IntConsumer) obj);
            }
        });
        this.mStateSynchronized.set(false);
        this.mUpdateEngine.bind(this.mUpdateEngineCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bind$0$com-nothing-OfflineOTAUpgradeApp-UpdateManager  reason: not valid java name */
    public /* synthetic */ void m5619lambda$bind$0$comnothingOfflineOTAUpgradeAppUpdateManager(IntConsumer intConsumer) {
        intConsumer.accept(this.mUpdaterState.get());
    }

    public void unbind() {
        this.mUpdateEngine.unbind();
    }

    public int getUpdaterState() {
        return this.mUpdaterState.get();
    }

    public boolean isManualSwitchSlotRequired() {
        return this.mManualSwitchSlotRequired.get();
    }

    public void setOnStateChangeCallback(IntConsumer intConsumer) {
        synchronized (this.mLock) {
            this.mOnStateChangeCallback = intConsumer;
        }
    }

    private Optional<IntConsumer> getOnStateChangeCallback() {
        Optional<IntConsumer> of;
        synchronized (this.mLock) {
            IntConsumer intConsumer = this.mOnStateChangeCallback;
            if (intConsumer == null) {
                of = Optional.empty();
            } else {
                of = Optional.of(intConsumer);
            }
        }
        return of;
    }

    public void setOnEngineStatusUpdateCallback(IntConsumer intConsumer) {
        synchronized (this.mLock) {
            this.mOnEngineStatusUpdateCallback = intConsumer;
        }
    }

    private Optional<IntConsumer> getOnEngineStatusUpdateCallback() {
        Optional<IntConsumer> of;
        synchronized (this.mLock) {
            IntConsumer intConsumer = this.mOnEngineStatusUpdateCallback;
            if (intConsumer == null) {
                of = Optional.empty();
            } else {
                of = Optional.of(intConsumer);
            }
        }
        return of;
    }

    public void setOnEngineCompleteCallback(IntConsumer intConsumer) {
        synchronized (this.mLock) {
            this.mOnEngineCompleteCallback = intConsumer;
        }
    }

    private Optional<IntConsumer> getOnEngineCompleteCallback() {
        Optional<IntConsumer> of;
        synchronized (this.mLock) {
            IntConsumer intConsumer = this.mOnEngineCompleteCallback;
            if (intConsumer == null) {
                of = Optional.empty();
            } else {
                of = Optional.of(intConsumer);
            }
        }
        return of;
    }

    public void setOnProgressUpdateCallback(DoubleConsumer doubleConsumer) {
        synchronized (this.mLock) {
            this.mOnProgressUpdateCallback = doubleConsumer;
        }
    }

    private Optional<DoubleConsumer> getOnProgressUpdateCallback() {
        Optional<DoubleConsumer> of;
        synchronized (this.mLock) {
            DoubleConsumer doubleConsumer = this.mOnProgressUpdateCallback;
            if (doubleConsumer == null) {
                of = Optional.empty();
            } else {
                of = Optional.of(doubleConsumer);
            }
        }
        return of;
    }

    public synchronized void suspend() throws UpdaterState.InvalidTransitionException {
        Log.d(TAG, "suspend invoked");
        setUpdaterState(3);
        this.mUpdateEngine.suspend();
    }

    public synchronized void resume() throws UpdaterState.InvalidTransitionException {
        Log.d(TAG, "resume invoked");
        setUpdaterState(2);
        this.mUpdateEngine.resume();
    }

    public synchronized void setUpdaterStateRunning() throws UpdaterState.InvalidTransitionException {
        Log.d(TAG, "set state running");
        setUpdaterState(2);
    }

    public synchronized void setUpdaterStateIdle() throws UpdaterState.InvalidTransitionException {
        Log.d(TAG, "set state idle");
        setUpdaterState(0);
    }

    private void setUpdaterState(final int i) throws UpdaterState.InvalidTransitionException {
        Log.d(TAG, "setUpdaterState invoked newState=" + i);
        int i2 = this.mUpdaterState.get();
        this.mUpdaterState.set(i);
        if (i2 != i) {
            getOnStateChangeCallback().ifPresent(new Consumer() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((IntConsumer) obj).accept(i);
                }
            });
        }
    }

    private void setUpdaterStateSilent(int i) {
        try {
            setUpdaterState(i);
        } catch (UpdaterState.InvalidTransitionException e) {
            Log.e(TAG, "Failed to set updater state", e);
        }
    }

    private void initializeUpdateState(final int i) {
        this.mUpdaterState = new UpdaterState(i);
        getOnStateChangeCallback().ifPresent(new Consumer() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((IntConsumer) obj).accept(i);
            }
        });
    }

    public synchronized void cancelRunningUpdate() throws UpdaterState.InvalidTransitionException {
        Log.d(TAG, "cancelRunningUpdate invoked");
        setUpdaterState(0);
        this.mUpdateEngine.cancel();
    }

    public synchronized void resetUpdate() throws UpdaterState.InvalidTransitionException {
        Log.d(TAG, "resetUpdate invoked");
        setUpdaterState(0);
        this.mUpdateEngine.resetStatus();
    }

    public synchronized void applyUpdate(Context context, final UpdateConfig updateConfig) throws UpdaterState.InvalidTransitionException {
        this.mEngineErrorCode.set(-1);
        setUpdaterState(2);
        synchronized (this.mLock) {
            this.mLastUpdateData = null;
        }
        if (!updateConfig.getAbConfig().getForceSwitchSlot()) {
            this.mManualSwitchSlotRequired.set(true);
        } else {
            this.mManualSwitchSlotRequired.set(false);
        }
        Log.d(TAG, "Starting PrepareUpdateService");
        PrepareUpdateService.startService(context, updateConfig, this.mHandler, new PrepareUpdateService.UpdateResultCallback() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda6
            @Override // com.nothing.OfflineOTAUpgradeApp.services.PrepareUpdateService.UpdateResultCallback
            public final void onReceiveResult(int i, PayloadSpec payloadSpec) {
                UpdateManager.this.m55x83f209dc(updateConfig, i, payloadSpec);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$applyUpdate$3$com-nothing-OfflineOTAUpgradeApp-UpdateManager */
    public /* synthetic */ void m55x83f209dc(UpdateConfig updateConfig, int i, PayloadSpec payloadSpec) {
        if (i != 0) {
            Log.e(TAG, "PrepareUpdateService failed, result code is " + i);
            setUpdaterStateSilent(1);
            return;
        }
        updateEngineApplyPayload(UpdateData.builder().setExtraProperties(prepareExtraProperties(updateConfig)).setPayload(payloadSpec).build());
    }

    public synchronized void applyUpdate(UpdateData updateData) throws UpdaterState.InvalidTransitionException {
        this.mEngineErrorCode.set(-1);
        setUpdaterState(2);
        synchronized (this.mLock) {
            this.mLastUpdateData = null;
        }
        updateEngineApplyPayload(updateData);
    }

    private List<String> prepareExtraProperties(UpdateConfig updateConfig) {
        final ArrayList arrayList = new ArrayList();
        if (!updateConfig.getAbConfig().getForceSwitchSlot()) {
            arrayList.add(UpdateEngineProperties.PROPERTY_DISABLE_SWITCH_SLOT_ON_REBOOT);
        }
        if (updateConfig.getInstallType() == 1) {
            arrayList.add("USER_AGENT=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
            updateConfig.getAbConfig().getAuthorization().ifPresent(new Consumer() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList.add("AUTHORIZATION=" + ((String) obj));
                }
            });
        }
        return arrayList;
    }

    private void updateEngineApplyPayload(UpdateData updateData) {
        Log.d(TAG, "updateEngineApplyPayload invoked with url " + updateData.mPayload.getUrl());
        synchronized (this.mLock) {
            this.mLastUpdateData = updateData;
        }
        ArrayList arrayList = new ArrayList(updateData.getPayload().getProperties());
        arrayList.addAll(updateData.getExtraProperties());
        try {
            this.mUpdateEngine.applyPayload(updateData.getPayload().getUrl(), updateData.getPayload().getOffset(), updateData.getPayload().getSize(), (String[]) arrayList.toArray(new String[0]));
        } catch (Exception e) {
            Log.e(TAG, "UpdateEngine failed to apply the update", e);
            setUpdaterStateSilent(1);
        }
    }

    private void updateEngineReApplyPayload() {
        UpdateData updateData;
        Log.d(TAG, "updateEngineReApplyPayload invoked");
        synchronized (this.mLock) {
            Preconditions.checkArgument(this.mLastUpdateData != null, "mLastUpdateData must be present.");
            updateData = this.mLastUpdateData;
        }
        updateEngineApplyPayload(updateData);
    }

    public synchronized void setSwitchSlotOnReboot() {
        UpdateData.Builder builder;
        Log.d(TAG, "setSwitchSlotOnReboot invoked");
        this.mManualSwitchSlotRequired.set(false);
        synchronized (this.mLock) {
            Preconditions.checkArgument(this.mLastUpdateData != null, "mLastUpdateData must be present.");
            builder = this.mLastUpdateData.toBuilder();
        }
        builder.setExtraProperties(Collections.singletonList(UpdateEngineProperties.PROPERTY_SKIP_POST_INSTALL));
        updateEngineApplyPayload(builder.build());
    }

    private void synchronizeUpdaterStateWithUpdateEngineStatus() {
        Log.d(TAG, "synchronizeUpdaterStateWithUpdateEngineStatus is invoked.");
        int i = this.mUpdaterState.get();
        int i2 = this.mUpdateEngineStatus.get();
        if (i2 == 6) {
            initializeUpdateState(5);
        } else if (i == 0) {
            if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                try {
                    setUpdaterStateRunning();
                } catch (UpdaterState.InvalidTransitionException e) {
                    Log.w(TAG, "Fail to set updater state running to synchronize engine status", e);
                }
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    if (i2 == 6 || i2 == 0) {
                        Log.i(TAG, "ensureUpdateEngineStatusIsRunning - re-applying last payload");
                        updateEngineReApplyPayload();
                        return;
                    }
                    return;
                } else if (i != 3 && i != 4) {
                    if (i == 5) {
                        Preconditions.checkState(i2 == 6, "When mUpdaterState is %s, mUpdateEngineStatus must be 6/UPDATED_NEED_REBOOT, but it is %s", i, i2);
                        return;
                    }
                    throw new IllegalStateException("This block should not be reached.");
                }
            }
            Preconditions.checkState(i2 == 0, "When mUpdaterState is %s, mUpdateEngineStatus must be 0/IDLE, but it is %s", i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusUpdate(final int i, float f) {
        Log.d(TAG, String.format("onStatusUpdate invoked, status=%s, progress=%.2f", Integer.valueOf(i), Float.valueOf(f)));
        int i2 = this.mUpdateEngineStatus.get();
        this.mUpdateEngineStatus.set(i);
        this.mProgress.set(f);
        if (!this.mStateSynchronized.getAndSet(true)) {
            synchronizeUpdaterStateWithUpdateEngineStatus();
        }
        getOnProgressUpdateCallback().ifPresent(new Consumer() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                UpdateManager.this.m54x99a5be5d((DoubleConsumer) obj);
            }
        });
        if (i2 != i) {
            getOnEngineStatusUpdateCallback().ifPresent(new Consumer() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((IntConsumer) obj).accept(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onStatusUpdate$5$com-nothing-OfflineOTAUpgradeApp-UpdateManager */
    public /* synthetic */ void m54x99a5be5d(DoubleConsumer doubleConsumer) {
        doubleConsumer.accept(this.mProgress.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPayloadApplicationComplete(final int i) {
        Log.d(TAG, "onPayloadApplicationComplete invoked, errorCode=" + i);
        this.mEngineErrorCode.set(i);
        if (i == 0 || i == 52) {
            setUpdaterStateSilent(isManualSwitchSlotRequired() ? 4 : 5);
        } else if (i != 48) {
            setUpdaterStateSilent(1);
        }
        getOnEngineCompleteCallback().ifPresent(new Consumer() { // from class: com.nothing.OfflineOTAUpgradeApp.UpdateManager$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((IntConsumer) obj).accept(i);
            }
        });
    }

    /* loaded from: classes2.dex */
    class UpdateEngineCallbackImpl extends UpdateEngineCallback {
        UpdateEngineCallbackImpl() {
        }

        public void onStatusUpdate(int i, float f) {
            UpdateManager.this.onStatusUpdate(i, f);
        }

        public void onPayloadApplicationComplete(int i) {
            UpdateManager.this.onPayloadApplicationComplete(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class UpdateData {
        private final ImmutableList<String> mExtraProperties;
        private final PayloadSpec mPayload;

        public static Builder builder() {
            return new Builder();
        }

        UpdateData(Builder builder) {
            this.mPayload = builder.mPayload;
            this.mExtraProperties = ImmutableList.copyOf((Collection) builder.mExtraProperties);
        }

        public PayloadSpec getPayload() {
            return this.mPayload;
        }

        public ImmutableList<String> getExtraProperties() {
            return this.mExtraProperties;
        }

        public Builder toBuilder() {
            return builder().setPayload(this.mPayload).setExtraProperties(this.mExtraProperties);
        }

        /* loaded from: classes2.dex */
        public static class Builder {
            private List<String> mExtraProperties;
            private PayloadSpec mPayload;

            public Builder setPayload(PayloadSpec payloadSpec) {
                this.mPayload = payloadSpec;
                return this;
            }

            public Builder setExtraProperties(List<String> list) {
                this.mExtraProperties = new ArrayList(list);
                return this;
            }

            public Builder addExtraProperty(String str) {
                if (this.mExtraProperties == null) {
                    this.mExtraProperties = new ArrayList();
                }
                this.mExtraProperties.add(str);
                return this;
            }

            public UpdateData build() {
                return new UpdateData(this);
            }
        }
    }
}
