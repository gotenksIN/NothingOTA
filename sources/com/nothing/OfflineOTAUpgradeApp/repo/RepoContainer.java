package com.nothing.OfflineOTAUpgradeApp.repo;

import com.nothing.OfflineOTAUpgradeApp.MainApplication;
import com.nothing.OfflineOTAUpgradeApp.remote.OTAUpdateService;
import com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: RepoContainer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/repo/RepoContainer;", "", "appContext", "Lcom/nothing/OfflineOTAUpgradeApp/MainApplication;", "(Lcom/nothing/OfflineOTAUpgradeApp/MainApplication;)V", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "getDebugRepository", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "debugRepository$delegate", "Lkotlin/Lazy;", "remoteRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository;", "getRemoteRepository", "()Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository;", "remoteRepository$delegate", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoContainer {
    public static final int $stable = 8;
    private final MainApplication appContext;
    private final Lazy debugRepository$delegate;
    private final Lazy remoteRepository$delegate;

    public RepoContainer(MainApplication appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        this.debugRepository$delegate = LazyKt.lazy(new Function0<DebugRepository>() { // from class: com.nothing.OfflineOTAUpgradeApp.repo.RepoContainer$debugRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DebugRepository invoke() {
                MainApplication mainApplication;
                mainApplication = RepoContainer.this.appContext;
                return new DebugRepository(mainApplication.getOtaPrefs());
            }
        });
        this.remoteRepository$delegate = LazyKt.lazy(new Function0<RemoteRepository>() { // from class: com.nothing.OfflineOTAUpgradeApp.repo.RepoContainer$remoteRepository$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RemoteRepository invoke() {
                MainApplication mainApplication;
                mainApplication = RepoContainer.this.appContext;
                return new RemoteRepository(mainApplication, CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain())), Dispatchers.getIO(), OTAUpdateService.Companion.getAPIService(), OTAUpdateService.Companion.getDownloadService(), Utils.INSTANCE, EncryptUtil.INSTANCE, RepoContainer.this.getDebugRepository());
            }
        });
    }

    public final DebugRepository getDebugRepository() {
        return (DebugRepository) this.debugRepository$delegate.getValue();
    }

    public final RemoteRepository getRemoteRepository() {
        return (RemoteRepository) this.remoteRepository$delegate.getValue();
    }
}
