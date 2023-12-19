package com.nothing.OfflineOTAUpgradeApp.viewmodel;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.nothing.OfflineOTAUpgradeApp.R;
import com.nothing.OfflineOTAUpgradeApp.UpdateManager;
import com.nothing.OfflineOTAUpgradeApp.UpdaterState;
import com.nothing.OfflineOTAUpgradeApp.remote.RemoteOTAUpdateInfo;
import com.nothing.OfflineOTAUpgradeApp.repo.DebugRepository;
import com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository;
import com.nothing.OfflineOTAUpgradeApp.state.DialogInfo;
import com.nothing.OfflineOTAUpgradeApp.state.DownloadState;
import com.nothing.OfflineOTAUpgradeApp.state.ToastBundle;
import com.nothing.OfflineOTAUpgradeApp.state.UpdateStage;
import com.nothing.OfflineOTAUpgradeApp.util.Event;
import com.nothing.OfflineOTAUpgradeApp.util.LogUtil;
import com.nothing.OfflineOTAUpgradeApp.util.OTAPrefs;
import com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils;
import com.nothing.OfflineOTAUpgradeApp.util.Utils;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: OTAUpdateViewModel.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b&\b\u0007\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0082\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010Z\u001a\u00020#2\u0006\u0010[\u001a\u00020#H\u0002J\u0006\u0010\\\u001a\u00020]J\u0006\u0010^\u001a\u00020]J\u0006\u0010_\u001a\u00020]J\u0006\u0010`\u001a\u00020]J\u0006\u0010a\u001a\u00020]J\u0006\u0010b\u001a\u00020]J\u0006\u0010c\u001a\u00020]J\u0006\u0010d\u001a\u00020]J\u000e\u0010e\u001a\u00020]2\u0006\u0010f\u001a\u00020\u0012J\u0006\u0010g\u001a\u00020\u0012J\u0010\u0010h\u001a\u00020]2\b\b\u0002\u0010i\u001a\u00020\u0012J\u0010\u0010j\u001a\u00020]2\u0006\u0010k\u001a\u00020\u0017H\u0002J\u0010\u0010l\u001a\u00020]2\u0006\u0010m\u001a\u00020\u0017H\u0002J\u0010\u0010n\u001a\u00020]2\u0006\u0010[\u001a\u00020#H\u0002J\u0010\u0010o\u001a\u00020]2\u0006\u0010p\u001a\u00020\u0017H\u0002J\u0006\u0010q\u001a\u00020]J\u000e\u0010r\u001a\u00020]2\u0006\u0010s\u001a\u00020\u0012J\u000e\u0010t\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u000e\u0010v\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u000e\u0010w\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u000e\u0010x\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u000e\u0010y\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u000e\u0010z\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u000e\u0010{\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u0006\u0010|\u001a\u00020]J\u000e\u0010}\u001a\u00020]2\u0006\u0010u\u001a\u00020\u0012J\u000e\u0010~\u001a\u00020]2\u0006\u0010\u007f\u001a\u00020%J\u001b\u0010\u0080\u0001\u001a\u00020!2\u0006\u0010\u007f\u001a\u00020%H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0081\u0001R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00120\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00120\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00120\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001109¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001109¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u001d\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001109¢\u0006\b\n\u0000\u001a\u0004\b?\u0010;R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bA\u0010;R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001109¢\u0006\b\n\u0000\u001a\u0004\bC\u0010;R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bI\u0010;R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bK\u0010;R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020.09¢\u0006\b\n\u0000\u001a\u0004\bM\u0010;R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bO\u0010;R\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010;R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bS\u0010;R\u001d\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u001109¢\u0006\b\n\u0000\u001a\u0004\bU\u0010;R\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001209¢\u0006\b\n\u0000\u001a\u0004\bW\u0010;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020609¢\u0006\b\n\u0000\u001a\u0004\bY\u0010;R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0083\u0001"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModel;", "Landroidx/lifecycle/ViewModel;", "updateManager", "Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;", "updateUtils", "Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;", "utils", "Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;", "otaPrefs", "Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;", "remoteRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository;", "debugRepository", "Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;", "(Lcom/nothing/OfflineOTAUpgradeApp/UpdateManager;Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils;Lcom/nothing/OfflineOTAUpgradeApp/util/Utils;Lcom/nothing/OfflineOTAUpgradeApp/util/OTAPrefs;Lcom/nothing/OfflineOTAUpgradeApp/repo/RemoteRepository;Lcom/nothing/OfflineOTAUpgradeApp/repo/DebugRepository;)V", "_checkNetworkLive", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/nothing/OfflineOTAUpgradeApp/util/Event;", "", "_downloadStateLive", "Landroidx/lifecycle/MutableLiveData;", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "_engineErrorCodeLive", "", "_engineStatusLive", "_finishActivityEventLive", "_handlingActionLive", "kotlin.jvm.PlatformType", "_isRemoteProcessingLive", "_launchBrowseEventLive", "_lockActionsLive", "_lockProgress", "_otaApplyMetadataLive", "Lcom/nothing/OfflineOTAUpgradeApp/util/UpdateUtils$OTAApplyMetadata;", "_progressLive", "", "_readyToInstallOtaFileId", "", "_rebootEventLive", "_remoteOTAUpdateInfo", "Lcom/nothing/OfflineOTAUpgradeApp/remote/RemoteOTAUpdateInfo;", "_showCancelDownloadConfirmationLive", "_showCancelInstallConfirmationLive", "_showCheckDownloadWithCellularLive", "_showCheckUpdateFailLive", "_showDownloadErrorLive", "Lcom/nothing/OfflineOTAUpgradeApp/state/DialogInfo;", "_showInstallErrorLive", "_showInstallSuccessLive", "_showScreenStageLive", "_showToastEventLive", "Lcom/nothing/OfflineOTAUpgradeApp/state/ToastBundle;", "_showUnauthorizedUserTipsLive", "_updateStageLive", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdateStage;", "_updaterStateLive", "checkNetworkLive", "Landroidx/lifecycle/LiveData;", "getCheckNetworkLive", "()Landroidx/lifecycle/LiveData;", "finishActivityEventLive", "getFinishActivityEventLive", "launchBrowseEventLive", "getLaunchBrowseEventLive", "lockActionsLive", "getLockActionsLive", "rebootEventLive", "getRebootEventLive", "showCancelDownloadConfirmationLive", "getShowCancelDownloadConfirmationLive", "showCancelInstallConfirmationLive", "getShowCancelInstallConfirmationLive", "showCheckDownloadWithCellularLive", "getShowCheckDownloadWithCellularLive", "showCheckUpdateFailLive", "getShowCheckUpdateFailLive", "showDownloadErrorLive", "getShowDownloadErrorLive", "showInstallErrorLive", "getShowInstallErrorLive", "showInstallSuccessLive", "getShowInstallSuccessLive", "showScreenStageLive", "getShowScreenStageLive", "showToastEventList", "getShowToastEventList", "showUnauthorizedUserTipsLive", "getShowUnauthorizedUserTipsLive", "updateStageLive", "getUpdateStageLive", "calculateRealProgress", NotificationCompat.CATEGORY_PROGRESS, "cancelDownload", "", "cancelInstallation", "clickFirstButton", "clickSecondButton", "deInit", "init", "installOTAFile", "installOTAFileFail", "installOTAFileSuccess", "reboot", "isInstalling", "onCallForDownload", "allowMeteredNetwork", "onEnginePayloadApplicationComplete", "errorCode", "onEngineStatusUpdate", NotificationCompat.CATEGORY_STATUS, "onProgressUpdate", "onUpdaterStateChange", "state", "queryOTAUpdateInfo", "setFinishActivity", "finish", "showCancelDownloadConfirmationDialog", "show", "showCancelInstallConfirmation", "showCheckDownloadWithCellularDialog", "showCheckUpdateFailDialog", "showDownloadErrorDialog", "showInstallFailDialog", "showInstallSuccessDialog", "showMainPage", "showUnauthorizedUserTips", "verifyOTAFile", "otaFileId", "verifyOTAFileSuspend", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OTAUpdateViewModel extends ViewModel {
    private final MediatorLiveData<Event<Boolean>> _checkNetworkLive;
    private final MutableLiveData<DownloadState> _downloadStateLive;
    private final MutableLiveData<Integer> _engineErrorCodeLive;
    private final MutableLiveData<Integer> _engineStatusLive;
    private final MutableLiveData<Event<Boolean>> _finishActivityEventLive;
    private final MutableLiveData<Boolean> _handlingActionLive;
    private final MutableLiveData<Boolean> _isRemoteProcessingLive;
    private final MutableLiveData<Event<Boolean>> _launchBrowseEventLive;
    private final MediatorLiveData<Boolean> _lockActionsLive;
    private boolean _lockProgress;
    private MutableLiveData<UpdateUtils.OTAApplyMetadata> _otaApplyMetadataLive;
    private final MutableLiveData<Double> _progressLive;
    private String _readyToInstallOtaFileId;
    private final MutableLiveData<Event<Boolean>> _rebootEventLive;
    private RemoteOTAUpdateInfo _remoteOTAUpdateInfo;
    private final MutableLiveData<Boolean> _showCancelDownloadConfirmationLive;
    private final MutableLiveData<Boolean> _showCancelInstallConfirmationLive;
    private final MutableLiveData<Boolean> _showCheckDownloadWithCellularLive;
    private final MediatorLiveData<Boolean> _showCheckUpdateFailLive;
    private final MediatorLiveData<DialogInfo> _showDownloadErrorLive;
    private final MediatorLiveData<Boolean> _showInstallErrorLive;
    private final MutableLiveData<Boolean> _showInstallSuccessLive;
    private final MediatorLiveData<Boolean> _showScreenStageLive;
    private final MediatorLiveData<Event<ToastBundle>> _showToastEventLive;
    private final MutableLiveData<Boolean> _showUnauthorizedUserTipsLive;
    private final MediatorLiveData<UpdateStage> _updateStageLive;
    private final MutableLiveData<Integer> _updaterStateLive;
    private final LiveData<Event<Boolean>> checkNetworkLive;
    private final DebugRepository debugRepository;
    private final LiveData<Event<Boolean>> finishActivityEventLive;
    private final LiveData<Event<Boolean>> launchBrowseEventLive;
    private final LiveData<Boolean> lockActionsLive;
    private final OTAPrefs otaPrefs;
    private final LiveData<Event<Boolean>> rebootEventLive;
    private final RemoteRepository remoteRepository;
    private final LiveData<Boolean> showCancelDownloadConfirmationLive;
    private final LiveData<Boolean> showCancelInstallConfirmationLive;
    private final LiveData<Boolean> showCheckDownloadWithCellularLive;
    private final LiveData<Boolean> showCheckUpdateFailLive;
    private final LiveData<DialogInfo> showDownloadErrorLive;
    private final LiveData<Boolean> showInstallErrorLive;
    private final LiveData<Boolean> showInstallSuccessLive;
    private final LiveData<Boolean> showScreenStageLive;
    private final LiveData<Event<ToastBundle>> showToastEventList;
    private final LiveData<Boolean> showUnauthorizedUserTipsLive;
    private final UpdateManager updateManager;
    private final LiveData<UpdateStage> updateStageLive;
    private final UpdateUtils updateUtils;
    private final Utils utils;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "OTAUpdateViewModel";

    public OTAUpdateViewModel(UpdateManager updateManager, UpdateUtils updateUtils, Utils utils, OTAPrefs otaPrefs, RemoteRepository remoteRepository, DebugRepository debugRepository) {
        Intrinsics.checkNotNullParameter(updateManager, "updateManager");
        Intrinsics.checkNotNullParameter(updateUtils, "updateUtils");
        Intrinsics.checkNotNullParameter(utils, "utils");
        Intrinsics.checkNotNullParameter(otaPrefs, "otaPrefs");
        Intrinsics.checkNotNullParameter(remoteRepository, "remoteRepository");
        Intrinsics.checkNotNullParameter(debugRepository, "debugRepository");
        this.updateManager = updateManager;
        this.updateUtils = updateUtils;
        this.utils = utils;
        this.otaPrefs = otaPrefs;
        this.remoteRepository = remoteRepository;
        this.debugRepository = debugRepository;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._engineStatusLive = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>(0);
        this._updaterStateLive = mutableLiveData2;
        MutableLiveData<Double> mutableLiveData3 = new MutableLiveData<>(Double.valueOf(0.0d));
        this._progressLive = mutableLiveData3;
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>(-1);
        this._engineErrorCodeLive = mutableLiveData4;
        MutableLiveData<DownloadState> mutableLiveData5 = new MutableLiveData<>(DownloadState.Idle.INSTANCE);
        this._downloadStateLive = mutableLiveData5;
        MutableLiveData<Event<Boolean>> mutableLiveData6 = new MutableLiveData<>();
        this._launchBrowseEventLive = mutableLiveData6;
        this.launchBrowseEventLive = mutableLiveData6;
        this._readyToInstallOtaFileId = "";
        this._otaApplyMetadataLive = new MutableLiveData<>();
        final MediatorLiveData<Event<ToastBundle>> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(this._otaApplyMetadataLive, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<UpdateUtils.OTAApplyMetadata, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_showToastEventLive$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateUtils.OTAApplyMetadata oTAApplyMetadata) {
                invoke2(oTAApplyMetadata);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateUtils.OTAApplyMetadata oTAApplyMetadata) {
                Integer valueOf = oTAApplyMetadata != null ? Integer.valueOf(oTAApplyMetadata.getVerifyState()) : null;
                if (valueOf != null && valueOf.intValue() == -1) {
                    mediatorLiveData.setValue(new Event<>(new ToastBundle(R.string.verify_error_1, null, null, 6, null)));
                } else if (valueOf != null && valueOf.intValue() == -2) {
                    mediatorLiveData.setValue(new Event<>(new ToastBundle(R.string.verify_error_2, null, null, 6, null)));
                } else if (valueOf != null && valueOf.intValue() == -3) {
                    mediatorLiveData.setValue(new Event<>(new ToastBundle(R.string.verify_error_3, null, null, 6, null)));
                } else if (valueOf != null && valueOf.intValue() == -4) {
                    mediatorLiveData.setValue(new Event<>(new ToastBundle(R.string.verify_error_file, null, null, 6, null)));
                }
            }
        }));
        this._showToastEventLive = mediatorLiveData;
        this.showToastEventList = mediatorLiveData;
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>();
        this._showCancelInstallConfirmationLive = mutableLiveData7;
        this.showCancelInstallConfirmationLive = mutableLiveData7;
        final MediatorLiveData<Boolean> mediatorLiveData2 = new MediatorLiveData<>();
        mediatorLiveData2.addSource(mutableLiveData2, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_showInstallErrorLive$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (num != null && num.intValue() == 1) {
                    mediatorLiveData2.setValue(true);
                }
            }
        }));
        this._showInstallErrorLive = mediatorLiveData2;
        this.showInstallErrorLive = mediatorLiveData2;
        final MediatorLiveData<Boolean> mediatorLiveData3 = new MediatorLiveData<>();
        mediatorLiveData3.addSource(mutableLiveData5, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<DownloadState, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_showCheckUpdateFailLive$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadState downloadState) {
                invoke2(downloadState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadState downloadState) {
                mediatorLiveData3.setValue(Boolean.valueOf(downloadState instanceof DownloadState.FetchError));
            }
        }));
        this._showCheckUpdateFailLive = mediatorLiveData3;
        this.showCheckUpdateFailLive = mediatorLiveData3;
        final MediatorLiveData<DialogInfo> mediatorLiveData4 = new MediatorLiveData<>();
        mediatorLiveData4.addSource(mutableLiveData5, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<DownloadState, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_showDownloadErrorLive$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadState downloadState) {
                invoke2(downloadState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadState downloadState) {
                DialogInfo.Hide hide;
                MediatorLiveData<DialogInfo> mediatorLiveData5 = mediatorLiveData4;
                if (downloadState instanceof DownloadState.DownloadFail) {
                    hide = new DialogInfo.DialogBundle(0, null, null, 0, ((DownloadState.DownloadFail) downloadState).getMessage(), null, 47, null);
                } else {
                    hide = DialogInfo.Hide.INSTANCE;
                }
                mediatorLiveData5.setValue(hide);
            }
        }));
        this._showDownloadErrorLive = mediatorLiveData4;
        this.showDownloadErrorLive = mediatorLiveData4;
        MutableLiveData<Boolean> mutableLiveData8 = new MutableLiveData<>();
        this._showCancelDownloadConfirmationLive = mutableLiveData8;
        this.showCancelDownloadConfirmationLive = mutableLiveData8;
        MutableLiveData<Boolean> mutableLiveData9 = new MutableLiveData<>();
        this._showCheckDownloadWithCellularLive = mutableLiveData9;
        this.showCheckDownloadWithCellularLive = mutableLiveData9;
        MutableLiveData<Boolean> mutableLiveData10 = new MutableLiveData<>();
        this._showInstallSuccessLive = mutableLiveData10;
        this.showInstallSuccessLive = mutableLiveData10;
        MutableLiveData<Event<Boolean>> mutableLiveData11 = new MutableLiveData<>();
        this._rebootEventLive = mutableLiveData11;
        this.rebootEventLive = mutableLiveData11;
        final MediatorLiveData<Event<Boolean>> mediatorLiveData5 = new MediatorLiveData<>();
        mediatorLiveData5.addSource(mutableLiveData5, new Observer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OTAUpdateViewModel._checkNetworkLive$lambda$5$lambda$4(MediatorLiveData.this, (DownloadState) obj);
            }
        });
        this._checkNetworkLive = mediatorLiveData5;
        this.checkNetworkLive = mediatorLiveData5;
        MutableLiveData<Boolean> mutableLiveData12 = new MutableLiveData<>(false);
        this._isRemoteProcessingLive = mutableLiveData12;
        MutableLiveData<Boolean> mutableLiveData13 = new MutableLiveData<>(false);
        this._handlingActionLive = mutableLiveData13;
        final MediatorLiveData<Boolean> mediatorLiveData6 = new MediatorLiveData<>(false);
        final Function2<Boolean, Boolean, Unit> function2 = new Function2<Boolean, Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_lockActionsLive$1$mediator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, boolean z2) {
                mediatorLiveData6.setValue(Boolean.valueOf(z || z2));
            }
        };
        mediatorLiveData6.addSource(mutableLiveData12, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_lockActionsLive$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                MutableLiveData mutableLiveData14;
                Function2<Boolean, Boolean, Unit> function22 = function2;
                Intrinsics.checkNotNull(bool);
                mutableLiveData14 = this._handlingActionLive;
                boolean z = (Boolean) mutableLiveData14.getValue();
                if (z == null) {
                    z = false;
                }
                function22.invoke(bool, z);
            }
        }));
        mediatorLiveData6.addSource(mutableLiveData13, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_lockActionsLive$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Function2<Boolean, Boolean, Unit> function22 = function2;
                boolean z = (Boolean) this._isRemoteProcessingLive.getValue();
                if (z == null) {
                    z = false;
                }
                Intrinsics.checkNotNull(bool);
                function22.invoke(z, bool);
            }
        }));
        this._lockActionsLive = mediatorLiveData6;
        this.lockActionsLive = mediatorLiveData6;
        final MediatorLiveData<UpdateStage> mediatorLiveData7 = new MediatorLiveData<>();
        final Function5<Integer, Integer, Double, Integer, DownloadState, Unit> function5 = new Function5<Integer, Integer, Double, Integer, DownloadState, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_updateStageLive$1$mediator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Double d, Integer num3, DownloadState downloadState) {
                invoke(num.intValue(), num2.intValue(), d.doubleValue(), num3.intValue(), downloadState);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, int i2, double d, int i3, DownloadState downloadState) {
                MutableLiveData mutableLiveData14;
                Utils utils2;
                DebugRepository debugRepository2;
                OTAPrefs oTAPrefs;
                String updatingBuildNumber;
                OTAPrefs oTAPrefs2;
                String updatingBuildNumber2;
                double calculateRealProgress;
                OTAPrefs oTAPrefs3;
                String updatingBuildNumber3;
                double calculateRealProgress2;
                OTAPrefs oTAPrefs4;
                String updatingBuildNumber4;
                Intrinsics.checkNotNullParameter(downloadState, "downloadState");
                UpdateStage value = mediatorLiveData7.getValue();
                mutableLiveData14 = this._otaApplyMetadataLive;
                UpdateUtils.OTAApplyMetadata oTAApplyMetadata = (UpdateUtils.OTAApplyMetadata) mutableLiveData14.getValue();
                utils2 = this.utils;
                debugRepository2 = this.debugRepository;
                utils2.getBuildNumber(debugRepository2);
                if (i3 == 0) {
                    if (value instanceof UpdateStage.StageInstalling) {
                        updatingBuildNumber4 = ((UpdateStage.StageInstalling) value).getBuildNumber();
                    } else if (oTAApplyMetadata == null || (updatingBuildNumber4 = oTAApplyMetadata.getBuildNumber()) == null) {
                        oTAPrefs4 = this.otaPrefs;
                        updatingBuildNumber4 = oTAPrefs4.getUpdatingBuildNumber();
                    }
                    mediatorLiveData7.setValue(new UpdateStage.StageInstallComplete(updatingBuildNumber4));
                } else if (i == 0) {
                    OTAUpdateViewModel._updateStageLive$lambda$7$mediateRemoteState(this, mediatorLiveData7, downloadState);
                } else if (i == 5) {
                    if (value instanceof UpdateStage.StageInstalling) {
                        updatingBuildNumber = ((UpdateStage.StageInstalling) value).getBuildNumber();
                    } else if (oTAApplyMetadata == null || (updatingBuildNumber = oTAApplyMetadata.getBuildNumber()) == null) {
                        oTAPrefs = this.otaPrefs;
                        updatingBuildNumber = oTAPrefs.getUpdatingBuildNumber();
                    }
                    mediatorLiveData7.setValue(new UpdateStage.StageInstallComplete(updatingBuildNumber));
                } else if (i == 2) {
                    if (value instanceof UpdateStage.StageInstalling) {
                        updatingBuildNumber2 = ((UpdateStage.StageInstalling) value).getBuildNumber();
                    } else if (oTAApplyMetadata == null || (updatingBuildNumber2 = oTAApplyMetadata.getBuildNumber()) == null) {
                        oTAPrefs2 = this.otaPrefs;
                        updatingBuildNumber2 = oTAPrefs2.getUpdatingBuildNumber();
                    }
                    calculateRealProgress = this.calculateRealProgress(d);
                    mediatorLiveData7.setValue(new UpdateStage.StageInstallingRunning(updatingBuildNumber2, calculateRealProgress));
                } else if (i != 3) {
                } else {
                    if (value instanceof UpdateStage.StageInstalling) {
                        updatingBuildNumber3 = ((UpdateStage.StageInstalling) value).getBuildNumber();
                    } else if (oTAApplyMetadata == null || (updatingBuildNumber3 = oTAApplyMetadata.getBuildNumber()) == null) {
                        oTAPrefs3 = this.otaPrefs;
                        updatingBuildNumber3 = oTAPrefs3.getUpdatingBuildNumber();
                    }
                    calculateRealProgress2 = this.calculateRealProgress(d);
                    mediatorLiveData7.setValue(new UpdateStage.StageInstallingPaused(updatingBuildNumber3, calculateRealProgress2));
                }
            }
        };
        mediatorLiveData7.addSource(mutableLiveData2, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_updateStageLive$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                MutableLiveData mutableLiveData14;
                MutableLiveData mutableLiveData15;
                MutableLiveData mutableLiveData16;
                Function5<Integer, Integer, Double, Integer, DownloadState, Unit> function52 = function5;
                Intrinsics.checkNotNull(num);
                mutableLiveData14 = this._engineStatusLive;
                int i = (Integer) mutableLiveData14.getValue();
                if (i == null) {
                    i = 0;
                }
                Integer num2 = i;
                mutableLiveData15 = this._progressLive;
                Double d = (Double) mutableLiveData15.getValue();
                if (d == null) {
                    d = Double.valueOf(0.0d);
                }
                Double d2 = d;
                mutableLiveData16 = this._engineErrorCodeLive;
                int i2 = (Integer) mutableLiveData16.getValue();
                if (i2 == null) {
                    i2 = -1;
                }
                Integer num3 = i2;
                DownloadState.Idle idle = (DownloadState) this._downloadStateLive.getValue();
                if (idle == null) {
                    idle = DownloadState.Idle.INSTANCE;
                }
                DownloadState downloadState = idle;
                Intrinsics.checkNotNull(downloadState);
                function52.invoke(num, num2, d2, num3, downloadState);
            }
        }));
        mediatorLiveData7.addSource(mutableLiveData, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_updateStageLive$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                MutableLiveData mutableLiveData14;
                MutableLiveData mutableLiveData15;
                MutableLiveData mutableLiveData16;
                Function5<Integer, Integer, Double, Integer, DownloadState, Unit> function52 = function5;
                mutableLiveData14 = this._updaterStateLive;
                int i = (Integer) mutableLiveData14.getValue();
                if (i == null) {
                    i = 0;
                }
                Intrinsics.checkNotNull(num);
                mutableLiveData15 = this._progressLive;
                Double d = (Double) mutableLiveData15.getValue();
                if (d == null) {
                    d = Double.valueOf(0.0d);
                }
                Double d2 = d;
                mutableLiveData16 = this._engineErrorCodeLive;
                int i2 = (Integer) mutableLiveData16.getValue();
                if (i2 == null) {
                    i2 = -1;
                }
                Integer num2 = i2;
                DownloadState.Idle idle = (DownloadState) this._downloadStateLive.getValue();
                if (idle == null) {
                    idle = DownloadState.Idle.INSTANCE;
                }
                DownloadState downloadState = idle;
                Intrinsics.checkNotNull(downloadState);
                function52.invoke(i, num, d2, num2, downloadState);
            }
        }));
        mediatorLiveData7.addSource(mutableLiveData3, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Double, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_updateStageLive$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d) {
                invoke2(d);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Double d) {
                MutableLiveData mutableLiveData14;
                MutableLiveData mutableLiveData15;
                MutableLiveData mutableLiveData16;
                Function5<Integer, Integer, Double, Integer, DownloadState, Unit> function52 = function5;
                mutableLiveData14 = this._updaterStateLive;
                Integer num = (Integer) mutableLiveData14.getValue();
                if (num == null) {
                    num = r2;
                }
                mutableLiveData15 = this._engineStatusLive;
                Integer num2 = (Integer) mutableLiveData15.getValue();
                r2 = num2 != null ? num2 : 0;
                Intrinsics.checkNotNull(d);
                mutableLiveData16 = this._engineErrorCodeLive;
                int i = (Integer) mutableLiveData16.getValue();
                if (i == null) {
                    i = -1;
                }
                Integer num3 = i;
                DownloadState.Idle idle = (DownloadState) this._downloadStateLive.getValue();
                if (idle == null) {
                    idle = DownloadState.Idle.INSTANCE;
                }
                DownloadState downloadState = idle;
                Intrinsics.checkNotNull(downloadState);
                function52.invoke(num, r2, d, num3, downloadState);
            }
        }));
        mediatorLiveData7.addSource(mutableLiveData4, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_updateStageLive$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                MutableLiveData mutableLiveData14;
                MutableLiveData mutableLiveData15;
                MutableLiveData mutableLiveData16;
                Function5<Integer, Integer, Double, Integer, DownloadState, Unit> function52 = function5;
                mutableLiveData14 = this._updaterStateLive;
                Integer num2 = (Integer) mutableLiveData14.getValue();
                if (num2 == null) {
                    num2 = r2;
                }
                mutableLiveData15 = this._engineStatusLive;
                Integer num3 = (Integer) mutableLiveData15.getValue();
                r2 = num3 != null ? num3 : 0;
                mutableLiveData16 = this._progressLive;
                Double d = (Double) mutableLiveData16.getValue();
                if (d == null) {
                    d = Double.valueOf(0.0d);
                }
                Intrinsics.checkNotNull(num);
                DownloadState.Idle idle = (DownloadState) this._downloadStateLive.getValue();
                if (idle == null) {
                    idle = DownloadState.Idle.INSTANCE;
                }
                DownloadState downloadState = idle;
                Intrinsics.checkNotNull(downloadState);
                function52.invoke(num2, r2, d, num, downloadState);
            }
        }));
        mediatorLiveData7.addSource(mutableLiveData5, new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<DownloadState, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_updateStageLive$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadState downloadState) {
                invoke2(downloadState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadState downloadState) {
                MutableLiveData mutableLiveData14;
                MutableLiveData mutableLiveData15;
                MutableLiveData mutableLiveData16;
                MutableLiveData mutableLiveData17;
                Function5<Integer, Integer, Double, Integer, DownloadState, Unit> function52 = function5;
                mutableLiveData14 = this._updaterStateLive;
                Integer num = (Integer) mutableLiveData14.getValue();
                if (num == null) {
                    num = r2;
                }
                mutableLiveData15 = this._engineStatusLive;
                Integer num2 = (Integer) mutableLiveData15.getValue();
                r2 = num2 != null ? num2 : 0;
                mutableLiveData16 = this._progressLive;
                Double d = (Double) mutableLiveData16.getValue();
                if (d == null) {
                    d = Double.valueOf(0.0d);
                }
                mutableLiveData17 = this._engineErrorCodeLive;
                int i = (Integer) mutableLiveData17.getValue();
                if (i == null) {
                    i = -1;
                }
                Intrinsics.checkNotNull(downloadState);
                function52.invoke(num, r2, d, i, downloadState);
            }
        }));
        this._updateStageLive = mediatorLiveData7;
        this.updateStageLive = mediatorLiveData7;
        final MediatorLiveData<Boolean> mediatorLiveData8 = new MediatorLiveData<>();
        mediatorLiveData8.addSource(debugRepository.isEnableDebugModeLive(), new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_showScreenStageLive$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                boolean z;
                DebugRepository debugRepository2;
                MediatorLiveData<Boolean> mediatorLiveData9 = mediatorLiveData8;
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    debugRepository2 = this.debugRepository;
                    z = debugRepository2.isShowScreenState();
                } else {
                    z = false;
                }
                mediatorLiveData9.setValue(Boolean.valueOf(z));
            }
        }));
        mediatorLiveData8.addSource(debugRepository.getShowScreenStateLive(), new OTAUpdateViewModel$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$_showScreenStageLive$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                DebugRepository debugRepository2;
                MediatorLiveData<Boolean> mediatorLiveData9 = mediatorLiveData8;
                debugRepository2 = this.debugRepository;
                if (!debugRepository2.isEnableDebugMode()) {
                    bool = false;
                }
                mediatorLiveData9.setValue(bool);
            }
        }));
        this._showScreenStageLive = mediatorLiveData8;
        this.showScreenStageLive = mediatorLiveData8;
        MutableLiveData<Boolean> mutableLiveData14 = new MutableLiveData<>();
        this._showUnauthorizedUserTipsLive = mutableLiveData14;
        this.showUnauthorizedUserTipsLive = mutableLiveData14;
        MutableLiveData<Event<Boolean>> mutableLiveData15 = new MutableLiveData<>();
        this._finishActivityEventLive = mutableLiveData15;
        this.finishActivityEventLive = mutableLiveData15;
        OTAUpdateViewModel oTAUpdateViewModel = this;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(oTAUpdateViewModel), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(oTAUpdateViewModel), null, null, new AnonymousClass2(null), 3, null);
    }

    /* compiled from: OTAUpdateViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/viewmodel/OTAUpdateViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final LiveData<Event<Boolean>> getLaunchBrowseEventLive() {
        return this.launchBrowseEventLive;
    }

    public final LiveData<Event<ToastBundle>> getShowToastEventList() {
        return this.showToastEventList;
    }

    public final LiveData<Boolean> getShowCancelInstallConfirmationLive() {
        return this.showCancelInstallConfirmationLive;
    }

    public final LiveData<Boolean> getShowInstallErrorLive() {
        return this.showInstallErrorLive;
    }

    public final LiveData<Boolean> getShowCheckUpdateFailLive() {
        return this.showCheckUpdateFailLive;
    }

    public final LiveData<DialogInfo> getShowDownloadErrorLive() {
        return this.showDownloadErrorLive;
    }

    public final LiveData<Boolean> getShowCancelDownloadConfirmationLive() {
        return this.showCancelDownloadConfirmationLive;
    }

    public final LiveData<Boolean> getShowCheckDownloadWithCellularLive() {
        return this.showCheckDownloadWithCellularLive;
    }

    public final LiveData<Boolean> getShowInstallSuccessLive() {
        return this.showInstallSuccessLive;
    }

    public final LiveData<Event<Boolean>> getRebootEventLive() {
        return this.rebootEventLive;
    }

    public static final void _checkNetworkLive$lambda$5$lambda$4(MediatorLiveData this_apply, DownloadState downloadState) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if ((downloadState instanceof DownloadState.DownloadPause) && ((DownloadState.DownloadPause) downloadState).getShouldCheckUnmeteredNetwork()) {
            this_apply.setValue(new Event(true));
        }
    }

    public final LiveData<Event<Boolean>> getCheckNetworkLive() {
        return this.checkNetworkLive;
    }

    public final LiveData<Boolean> getLockActionsLive() {
        return this.lockActionsLive;
    }

    public static final void _updateStageLive$lambda$7$mediateRemoteState(OTAUpdateViewModel oTAUpdateViewModel, MediatorLiveData<UpdateStage> mediatorLiveData, DownloadState downloadState) {
        UpdateStage.StageReadyInstallOTA stageReadyInstallOTA;
        UpdateStage.StageReadyToDownload stageReadyToDownload;
        UpdateUtils.OTAApplyMetadata value = oTAUpdateViewModel._otaApplyMetadataLive.getValue();
        String buildNumber = oTAUpdateViewModel.utils.getBuildNumber(oTAUpdateViewModel.debugRepository);
        if (Intrinsics.areEqual(downloadState, DownloadState.Fetching.INSTANCE)) {
            mediatorLiveData.setValue(UpdateStage.StageLookingVersion.INSTANCE);
        } else if (downloadState instanceof DownloadState.Fetched) {
            RemoteOTAUpdateInfo info = ((DownloadState.Fetched) downloadState).getInfo();
            if (info.isUpToDate()) {
                stageReadyToDownload = new UpdateStage.StageUpToDate(buildNumber);
            } else {
                stageReadyToDownload = new UpdateStage.StageReadyToDownload(info.getBuildNumber(), oTAUpdateViewModel.utils.formatSize(info.getBytes()));
            }
            mediatorLiveData.setValue(stageReadyToDownload);
        } else if (downloadState instanceof DownloadState.Downloading) {
            DownloadState.Downloading downloading = (DownloadState.Downloading) downloadState;
            mediatorLiveData.setValue(new UpdateStage.StageDownloading(downloading.getInfo().getBuildNumber(), downloading.getProgress()));
        } else if (downloadState instanceof DownloadState.DownloadPause) {
            DownloadState.DownloadPause downloadPause = (DownloadState.DownloadPause) downloadState;
            mediatorLiveData.setValue(new UpdateStage.StageDownloadPaused(downloadPause.getInfo().getBuildNumber(), downloadPause.getProgress()));
        } else if (downloadState instanceof DownloadState.DownloadComplete) {
            mediatorLiveData.setValue(new UpdateStage.StageReadyInstallDownloaded(((DownloadState.DownloadComplete) downloadState).getBuildNumber()));
        } else {
            boolean z = true;
            if (Intrinsics.areEqual(downloadState, DownloadState.Idle.INSTANCE) ? true : downloadState instanceof DownloadState.FetchError ? true : downloadState instanceof DownloadState.DownloadFail) {
                if (value == null || value.getVerifyState() != 0) {
                    z = false;
                }
                if (!z) {
                    stageReadyInstallOTA = new UpdateStage.StageCurrentVersion(buildNumber);
                } else {
                    stageReadyInstallOTA = new UpdateStage.StageReadyInstallOTA(buildNumber, value.getBuildNumber());
                }
                mediatorLiveData.setValue(stageReadyInstallOTA);
            }
        }
    }

    public final LiveData<UpdateStage> getUpdateStageLive() {
        return this.updateStageLive;
    }

    public final LiveData<Boolean> getShowScreenStageLive() {
        return this.showScreenStageLive;
    }

    public final LiveData<Boolean> getShowUnauthorizedUserTipsLive() {
        return this.showUnauthorizedUserTipsLive;
    }

    public final LiveData<Event<Boolean>> getFinishActivityEventLive() {
        return this.finishActivityEventLive;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OTAUpdateViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1", f = "OTAUpdateViewModel.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1 */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            OTAUpdateViewModel.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (OTAUpdateViewModel.this.remoteRepository.getDownloadStateFlow().collect(new C00841(OTAUpdateViewModel.this), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* compiled from: OTAUpdateViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "downloadState", "Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;", "emit", "(Lcom/nothing/OfflineOTAUpgradeApp/state/DownloadState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1 */
        /* loaded from: classes2.dex */
        public static final class C00841<T> implements FlowCollector {
            final /* synthetic */ OTAUpdateViewModel this$0;

            C00841(OTAUpdateViewModel oTAUpdateViewModel) {
                this.this$0 = oTAUpdateViewModel;
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x0024  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x003a  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0060  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x006a  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(com.nothing.OfflineOTAUpgradeApp.state.DownloadState r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1$emit$1
                    if (r0 == 0) goto L14
                    r0 = r6
                    com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1$emit$1 r0 = (com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r6 = r0.label
                    int r6 = r6 - r2
                    r0.label = r6
                    goto L19
                L14:
                    com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1$emit$1 r0 = new com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1$emit$1
                    r0.<init>(r4, r6)
                L19:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L3a
                    if (r2 != r3) goto L32
                    java.lang.Object r5 = r0.L$1
                    com.nothing.OfflineOTAUpgradeApp.state.DownloadState r5 = (com.nothing.OfflineOTAUpgradeApp.state.DownloadState) r5
                    java.lang.Object r0 = r0.L$0
                    com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$1$1 r0 = (com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.AnonymousClass1.C00841) r0
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L58
                L32:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L3a:
                    kotlin.ResultKt.throwOnFailure(r6)
                    boolean r6 = r5 instanceof com.nothing.OfflineOTAUpgradeApp.state.DownloadState.DownloadComplete
                    if (r6 == 0) goto L74
                    com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel r6 = r4.this$0
                    r2 = r5
                    com.nothing.OfflineOTAUpgradeApp.state.DownloadState$DownloadComplete r2 = (com.nothing.OfflineOTAUpgradeApp.state.DownloadState.DownloadComplete) r2
                    java.lang.String r2 = r2.getOtaFileId()
                    r0.L$0 = r4
                    r0.L$1 = r5
                    r0.label = r3
                    java.lang.Object r6 = com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.access$verifyOTAFileSuspend(r6, r2, r0)
                    if (r6 != r1) goto L57
                    return r1
                L57:
                    r0 = r4
                L58:
                    com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils$OTAApplyMetadata r6 = (com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.OTAApplyMetadata) r6
                    int r6 = r6.getVerifyState()
                    if (r6 == 0) goto L6a
                    com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel r5 = r0.this$0
                    com.nothing.OfflineOTAUpgradeApp.repo.RemoteRepository r5 = com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.access$getRemoteRepository$p(r5)
                    r5.resetDownloadStatus()
                    goto L7d
                L6a:
                    com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel r6 = r0.this$0
                    androidx.lifecycle.MutableLiveData r6 = com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.access$get_downloadStateLive$p(r6)
                    r6.setValue(r5)
                    goto L7d
                L74:
                    com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel r6 = r4.this$0
                    androidx.lifecycle.MutableLiveData r6 = com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.access$get_downloadStateLive$p(r6)
                    r6.setValue(r5)
                L7d:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.AnonymousClass1.C00841.emit(com.nothing.OfflineOTAUpgradeApp.state.DownloadState, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((DownloadState) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OTAUpdateViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$2", f = "OTAUpdateViewModel.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$2 */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            OTAUpdateViewModel.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> isDownloadResourceProcessing = OTAUpdateViewModel.this.remoteRepository.getIsDownloadResourceProcessing();
                final OTAUpdateViewModel oTAUpdateViewModel = OTAUpdateViewModel.this;
                this.label = 1;
                if (isDownloadResourceProcessing.collect(new FlowCollector() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        oTAUpdateViewModel._isRemoteProcessingLive.setValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final void init() {
        this.updateManager.setOnStateChangeCallback(new IntConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$$ExternalSyntheticLambda1
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                OTAUpdateViewModel.this.onUpdaterStateChange(i);
            }
        });
        this.updateManager.setOnEngineStatusUpdateCallback(new IntConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                OTAUpdateViewModel.this.onEngineStatusUpdate(i);
            }
        });
        this.updateManager.setOnEngineCompleteCallback(new IntConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                OTAUpdateViewModel.this.onEnginePayloadApplicationComplete(i);
            }
        });
        this.updateManager.setOnProgressUpdateCallback(new DoubleConsumer() { // from class: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$$ExternalSyntheticLambda4
            @Override // java.util.function.DoubleConsumer
            public final void accept(double d) {
                OTAUpdateViewModel.this.onProgressUpdate(d);
            }
        });
        if (this.updateManager.getUpdaterState() == 2) {
            this.updateUtils.acquireWakeLock();
        }
        this.updateManager.bind();
    }

    public final void deInit() {
        this.updateUtils.releaseWakeLock();
        this.updateManager.setOnStateChangeCallback(null);
        this.updateManager.setOnEngineStatusUpdateCallback(null);
        this.updateManager.setOnEngineCompleteCallback(null);
        this.updateManager.setOnProgressUpdateCallback(null);
        this.updateManager.unbind();
    }

    public final void showMainPage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showMainPage$1(this, null), 3, null);
    }

    public final void clickFirstButton() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$clickFirstButton$1(this, null), 3, null);
    }

    public final void clickSecondButton() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$clickSecondButton$1(this, null), 3, null);
    }

    public final void verifyOTAFile(String otaFileId) {
        Intrinsics.checkNotNullParameter(otaFileId, "otaFileId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$verifyOTAFile$1(this, otaFileId, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object verifyOTAFileSuspend(java.lang.String r6, kotlin.coroutines.Continuation<? super com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.OTAApplyMetadata> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$1
            if (r0 == 0) goto L14
            r0 = r7
            com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$1 r0 = (com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$1 r0 = new com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.L$0
            com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel r0 = (com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L59
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getDefault()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1 r2 = new com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel$verifyOTAFileSuspend$otaApplyMetadata$1
            r4 = 0
            r2.<init>(r5, r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            r0 = r5
        L59:
            com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils$OTAApplyMetadata r7 = (com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils.OTAApplyMetadata) r7
            int r1 = r7.getVerifyState()
            if (r1 != 0) goto L63
            r0._readyToInstallOtaFileId = r6
        L63:
            androidx.lifecycle.MutableLiveData<com.nothing.OfflineOTAUpgradeApp.util.UpdateUtils$OTAApplyMetadata> r6 = r0._otaApplyMetadataLive
            r6.setValue(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.viewmodel.OTAUpdateViewModel.verifyOTAFileSuspend(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void installOTAFile() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$installOTAFile$1(this, null), 3, null);
    }

    public final void installOTAFileSuccess(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$installOTAFileSuccess$1(this, z, null), 3, null);
    }

    public final void installOTAFileFail() {
        this._engineErrorCodeLive.setValue(-1);
        try {
            this.updateManager.setUpdaterStateIdle();
        } catch (UpdaterState.InvalidTransitionException e) {
            Log.w(TAG, "Fail to set updater state idle when failing to install OTA file", e);
        }
    }

    public final void onUpdaterStateChange(int i) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.i$default(logUtil, TAG2, "UpdaterStateChange state= " + UpdaterState.getStateText(i) + '/' + i, null, 4, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$onUpdaterStateChange$1(this, i, null), 3, null);
    }

    public final void onEngineStatusUpdate(int i) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "onEngineStatusUpdate, status: " + i, null, 4, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$onEngineStatusUpdate$1(this, i, null), 3, null);
    }

    public final void onProgressUpdate(double d) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "onProgressUpdate: " + d, null, 4, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$onProgressUpdate$1(this, d, null), 3, null);
    }

    public final double calculateRealProgress(double d) {
        Integer value = this._engineStatusLive.getValue();
        boolean z = false;
        if ((((value != null && value.intValue() == 0) || (value != null && value.intValue() == 2)) || (value != null && value.intValue() == 11)) || (value != null && value.intValue() == 3)) {
            return d * 0.7d;
        }
        if (value != null && value.intValue() == 4) {
            return (d * 0.3d) + 0.7d;
        }
        if ((value != null && value.intValue() == 5) || (value != null && value.intValue() == 6)) {
            z = true;
        }
        if (z) {
            return 1.0d;
        }
        return d;
    }

    public final void onEnginePayloadApplicationComplete(int i) {
        LogUtil logUtil = LogUtil.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogUtil.d$default(logUtil, TAG2, "onEnginePayloadApplicationComplete, errorCode: " + i, null, 4, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$onEnginePayloadApplicationComplete$1(this, i, null), 3, null);
    }

    public final void showCancelInstallConfirmation(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showCancelInstallConfirmation$1(this, z, null), 3, null);
    }

    public final void cancelInstallation() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$cancelInstallation$1(this, null), 3, null);
    }

    public final void showInstallSuccessDialog(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showInstallSuccessDialog$1(this, z, null), 3, null);
    }

    public final void showInstallFailDialog(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showInstallFailDialog$1(this, z, null), 3, null);
    }

    public final void showCheckUpdateFailDialog(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showCheckUpdateFailDialog$1(this, z, null), 3, null);
    }

    public final void showDownloadErrorDialog(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showDownloadErrorDialog$1(this, z, null), 3, null);
    }

    public final void showCancelDownloadConfirmationDialog(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showCancelDownloadConfirmationDialog$1(this, z, null), 3, null);
    }

    public final void showCheckDownloadWithCellularDialog(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showCheckDownloadWithCellularDialog$1(this, z, null), 3, null);
    }

    public final void queryOTAUpdateInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$queryOTAUpdateInfo$1(this, null), 3, null);
    }

    public static /* synthetic */ void onCallForDownload$default(OTAUpdateViewModel oTAUpdateViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        oTAUpdateViewModel.onCallForDownload(z);
    }

    public final void onCallForDownload(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$onCallForDownload$1(this, z, null), 3, null);
    }

    public final void cancelDownload() {
        this.remoteRepository.cancelDownload();
    }

    public final boolean isInstalling() {
        return this._updateStageLive.getValue() instanceof UpdateStage.StageInstalling;
    }

    public final void showUnauthorizedUserTips(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$showUnauthorizedUserTips$1(this, z, null), 3, null);
    }

    public final void setFinishActivity(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OTAUpdateViewModel$setFinishActivity$1(this, z, null), 3, null);
    }
}
