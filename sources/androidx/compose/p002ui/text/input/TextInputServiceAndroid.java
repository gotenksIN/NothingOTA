package androidx.compose.p002ui.text.input;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.p002ui.text.TextRange;
import androidx.compose.runtime.collection.MutableVector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(m41d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001DB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\b\u00102\u001a\u00020!H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0017J\b\u00106\u001a\u00020!H\u0002J\b\u00107\u001a\u00020!H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020+H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020!H\u0016JI\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020!0\u001e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020!0\u001eH\u0016ø\u0001\u0000J\b\u0010@\u001a\u00020!H\u0016J\u001a\u0010A\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010%2\u0006\u0010C\u001a\u00020%H\u0016R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020!0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020!0\u001eX\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, m40d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "context", "Landroidx/compose/ui/text/input/PlatformTextInput;", "(Landroid/view/View;Landroidx/compose/ui/text/input/PlatformTextInput;)V", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "platformTextInput", "inputCommandProcessorExecutor", "Ljava/util/concurrent/Executor;", "(Landroid/view/View;Landroidx/compose/ui/text/input/InputMethodManager;Landroidx/compose/ui/text/input/PlatformTextInput;Ljava/util/concurrent/Executor;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "focusedRect", "Landroid/graphics/Rect;", "frameCallback", "Ljava/lang/Runnable;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "textInputCommandQueue", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "processInputCommands", "restartInputImmediately", "sendInputCommand", "command", "setKeyboardVisibleImmediately", "visible", "", "showSoftwareKeyboard", "startInput", "value", "stopInput", "updateState", "oldValue", "newValue", "TextInputCommand", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid */
/* loaded from: classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    private final Lazy baseInputConnection$delegate;
    private Rect focusedRect;
    private Runnable frameCallback;
    private List<WeakReference<RecordingInputConnection>> ics;
    private ImeOptions imeOptions;
    private final Executor inputCommandProcessorExecutor;
    private final InputMethodManager inputMethodManager;
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    private Function1<? super ImeAction, Unit> onImeActionPerformed;
    private final PlatformTextInput platformTextInput;
    private TextFieldValue state;
    private final MutableVector<TextInputCommand> textInputCommandQueue;
    private final View view;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextInputServiceAndroid.android.kt */
    @Metadata(m41d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m40d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid$TextInputCommand;", "", "(Ljava/lang/String;I)V", "StartInput", "StopInput", "ShowKeyboard", "HideKeyboard", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand */
    /* loaded from: classes.dex */
    public enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    /* compiled from: TextInputServiceAndroid.android.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    /* renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$WhenMappings */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            try {
                iArr[TextInputCommand.StartInput.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextInputCommand.StopInput.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextInputCommand.HideKeyboard.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextInputServiceAndroid(View view, InputMethodManager inputMethodManager, PlatformTextInput platformTextInput, Executor inputCommandProcessorExecutor) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
        Intrinsics.checkNotNullParameter(inputCommandProcessorExecutor, "inputCommandProcessorExecutor");
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.platformTextInput = platformTextInput;
        this.inputCommandProcessorExecutor = inputCommandProcessorExecutor;
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onEditCommand$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends EditCommand> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends EditCommand> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onImeActionPerformed$1
            /* renamed from: invoke-KlQnJC8  reason: not valid java name */
            public final void m5098invokeKlQnJC8(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
                m5098invokeKlQnJC8(imeAction.m5027unboximpl());
                return Unit.INSTANCE;
            }
        };
        this.state = new TextFieldValue("", TextRange.Companion.m4893getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Functions) new Functions<BaseInputConnection>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$baseInputConnection$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final BaseInputConnection invoke() {
                return new BaseInputConnection(TextInputServiceAndroid.this.getView(), false);
            }
        });
        this.textInputCommandQueue = new MutableVector<>(new TextInputCommand[16], 0);
    }

    public final View getView() {
        return this.view;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ TextInputServiceAndroid(android.view.View r1, androidx.compose.p002ui.text.input.InputMethodManager r2, androidx.compose.p002ui.text.input.PlatformTextInput r3, java.util.concurrent.Executor r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 4
            if (r6 == 0) goto L5
            r3 = 0
        L5:
            r5 = r5 & 8
            if (r5 == 0) goto L16
            android.view.Choreographer r4 = android.view.Choreographer.getInstance()
            java.lang.String r5 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.util.concurrent.Executor r4 = androidx.compose.p002ui.text.input.TextInputServiceAndroid_androidKt.asExecutor(r4)
        L16:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p002ui.text.input.TextInputServiceAndroid.<init>(android.view.View, androidx.compose.ui.text.input.InputMethodManager, androidx.compose.ui.text.input.PlatformTextInput, java.util.concurrent.Executor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    public /* synthetic */ TextInputServiceAndroid(View view, PlatformTextInput platformTextInput, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? null : platformTextInput);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputServiceAndroid(View view, PlatformTextInput platformTextInput) {
        this(view, new InputMethodManagerImpl(view), platformTextInput, null, 8, null);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public final InputConnection createInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        TextInputServiceAndroid_androidKt.update(outAttrs, this.imeOptions, this.state);
        TextInputServiceAndroid_androidKt.updateWithEmojiCompat(outAttrs);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new InputEventCallback2() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$createInputConnection$1
            @Override // androidx.compose.p002ui.text.input.InputEventCallback2
            public void onEditCommands(List<? extends EditCommand> editCommands) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(editCommands, "editCommands");
                function1 = TextInputServiceAndroid.this.onEditCommand;
                function1.invoke(editCommands);
            }

            @Override // androidx.compose.p002ui.text.input.InputEventCallback2
            /* renamed from: onImeAction-KlQnJC8 */
            public void mo5051onImeActionKlQnJC8(int i) {
                Function1 function1;
                function1 = TextInputServiceAndroid.this.onImeActionPerformed;
                function1.invoke(ImeAction.m5021boximpl(i));
            }

            @Override // androidx.compose.p002ui.text.input.InputEventCallback2
            public void onKeyEvent(KeyEvent event) {
                BaseInputConnection baseInputConnection;
                Intrinsics.checkNotNullParameter(event, "event");
                baseInputConnection = TextInputServiceAndroid.this.getBaseInputConnection();
                baseInputConnection.sendKeyEvent(event);
            }

            @Override // androidx.compose.p002ui.text.input.InputEventCallback2
            public void onConnectionClosed(RecordingInputConnection ic) {
                List list;
                List list2;
                List list3;
                Intrinsics.checkNotNullParameter(ic, "ic");
                list = TextInputServiceAndroid.this.ics;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list2 = TextInputServiceAndroid.this.ics;
                    if (Intrinsics.areEqual(((WeakReference) list2.get(i)).get(), ic)) {
                        list3 = TextInputServiceAndroid.this.ics;
                        list3.remove(i);
                        return;
                    }
                }
            }
        }, this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference<>(recordingInputConnection));
        return recordingInputConnection;
    }

    @Override // androidx.compose.p002ui.text.input.PlatformTextInputService
    public void startInput(TextFieldValue value, ImeOptions imeOptions, Function1<? super List<? extends EditCommand>, Unit> onEditCommand, Function1<? super ImeAction, Unit> onImeActionPerformed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(onEditCommand, "onEditCommand");
        Intrinsics.checkNotNullParameter(onImeActionPerformed, "onImeActionPerformed");
        PlatformTextInput platformTextInput = this.platformTextInput;
        if (platformTextInput != null) {
            platformTextInput.requestInputFocus();
        }
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = onEditCommand;
        this.onImeActionPerformed = onImeActionPerformed;
        sendInputCommand(TextInputCommand.StartInput);
    }

    @Override // androidx.compose.p002ui.text.input.PlatformTextInputService
    public void stopInput() {
        PlatformTextInput platformTextInput = this.platformTextInput;
        if (platformTextInput != null) {
            platformTextInput.releaseInputFocus();
        }
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends EditCommand> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends EditCommand> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$2
            /* renamed from: invoke-KlQnJC8  reason: not valid java name */
            public final void m5099invokeKlQnJC8(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
                m5099invokeKlQnJC8(imeAction.m5027unboximpl());
                return Unit.INSTANCE;
            }
        };
        this.focusedRect = null;
        sendInputCommand(TextInputCommand.StopInput);
    }

    @Override // androidx.compose.p002ui.text.input.PlatformTextInputService
    public void showSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.p002ui.text.input.PlatformTextInputService
    public void hideSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.HideKeyboard);
    }

    private final void sendInputCommand(TextInputCommand textInputCommand) {
        this.textInputCommandQueue.add(textInputCommand);
        if (this.frameCallback == null) {
            Runnable runnable = new Runnable() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputServiceAndroid.sendInputCommand$lambda$1(TextInputServiceAndroid.this);
                }
            };
            this.inputCommandProcessorExecutor.execute(runnable);
            this.frameCallback = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendInputCommand$lambda$1(TextInputServiceAndroid this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.frameCallback = null;
        this$0.processInputCommands();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void processInputCommands() {
        /*
            r8 = this;
            android.view.View r0 = r8.view
            boolean r0 = r0.isFocused()
            if (r0 != 0) goto Le
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r0 = r8.textInputCommandQueue
            r0.clear()
            return
        Le:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r2 = r8.textInputCommandQueue
            int r3 = r2.getSize()
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L31
            java.lang.Object[] r2 = r2.getContent()
            r6 = r4
        L27:
            r7 = r2[r6]
            androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r7 = (androidx.compose.p002ui.text.input.TextInputServiceAndroid.TextInputCommand) r7
            processInputCommands$applyToState(r7, r0, r1)
            int r6 = r6 + r5
            if (r6 < r3) goto L27
        L31:
            T r2 = r0.element
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L40
            r8.restartInputImmediately()
        L40:
            T r1 = r1.element
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            if (r1 == 0) goto L4d
            boolean r1 = r1.booleanValue()
            r8.setKeyboardVisibleImmediately(r1)
        L4d:
            T r0 = r0.element
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L5c
            r8.restartInputImmediately()
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p002ui.text.input.TextInputServiceAndroid.processInputCommands():void");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Boolean] */
    private static final void processInputCommands$applyToState(TextInputCommand textInputCommand, Ref.ObjectRef<Boolean> objectRef, Ref.ObjectRef<Boolean> objectRef2) {
        int i = WhenMappings.$EnumSwitchMapping$0[textInputCommand.ordinal()];
        if (i == 1) {
            objectRef.element = true;
            objectRef2.element = true;
        } else if (i == 2) {
            objectRef.element = false;
            objectRef2.element = false;
        } else if ((i == 3 || i == 4) && !Intrinsics.areEqual((Object) objectRef.element, (Object) false)) {
            objectRef2.element = Boolean.valueOf(textInputCommand == TextInputCommand.ShowKeyboard);
        }
    }

    @Override // androidx.compose.p002ui.text.input.PlatformTextInputService
    public void updateState(TextFieldValue textFieldValue, TextFieldValue newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        boolean z = true;
        boolean z2 = (TextRange.m4881equalsimpl0(this.state.m5097getSelectiond9O1mEE(), newValue.m5097getSelectiond9O1mEE()) && Intrinsics.areEqual(this.state.m5096getCompositionMzsxiRA(), newValue.m5096getCompositionMzsxiRA())) ? false : true;
        this.state = newValue;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setMTextFieldValue$ui_release(newValue);
            }
        }
        if (Intrinsics.areEqual(textFieldValue, newValue)) {
            if (z2) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                int m4886getMinimpl = TextRange.m4886getMinimpl(newValue.m5097getSelectiond9O1mEE());
                int m4885getMaximpl = TextRange.m4885getMaximpl(newValue.m5097getSelectiond9O1mEE());
                TextRange m5096getCompositionMzsxiRA = this.state.m5096getCompositionMzsxiRA();
                int m4886getMinimpl2 = m5096getCompositionMzsxiRA != null ? TextRange.m4886getMinimpl(m5096getCompositionMzsxiRA.m4892unboximpl()) : -1;
                TextRange m5096getCompositionMzsxiRA2 = this.state.m5096getCompositionMzsxiRA();
                inputMethodManager.updateSelection(m4886getMinimpl, m4885getMaximpl, m4886getMinimpl2, m5096getCompositionMzsxiRA2 != null ? TextRange.m4885getMaximpl(m5096getCompositionMzsxiRA2.m4892unboximpl()) : -1);
                return;
            }
            return;
        }
        if (textFieldValue == null || (Intrinsics.areEqual(textFieldValue.getText(), newValue.getText()) && (!TextRange.m4881equalsimpl0(textFieldValue.m5097getSelectiond9O1mEE(), newValue.m5097getSelectiond9O1mEE()) || Intrinsics.areEqual(textFieldValue.m5096getCompositionMzsxiRA(), newValue.m5096getCompositionMzsxiRA())))) {
            z = false;
        }
        if (z) {
            restartInputImmediately();
            return;
        }
        int size2 = this.ics.size();
        for (int i2 = 0; i2 < size2; i2++) {
            RecordingInputConnection recordingInputConnection2 = this.ics.get(i2).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
            }
        }
    }

    @Override // androidx.compose.p002ui.text.input.PlatformTextInputService
    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    public void notifyFocusedRect(androidx.compose.p002ui.geometry.Rect rect) {
        Rect rect2;
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (!this.ics.isEmpty() || (rect2 = this.focusedRect) == null) {
            return;
        }
        this.view.requestRectangleOnScreen(new Rect(rect2));
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    private final void setKeyboardVisibleImmediately(boolean z) {
        if (z) {
            this.inputMethodManager.showSoftInput();
        } else {
            this.inputMethodManager.hideSoftInput();
        }
    }
}
