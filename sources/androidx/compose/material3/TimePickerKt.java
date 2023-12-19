package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a:\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00190\u001e¢\u0006\u0002\b\u001fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001d\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u0010.\u001a\u0015\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u00100\u001a\u001d\u00101\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u00104\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a=\u00106\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0003¢\u0006\u0002\u0010<\u001a)\u0010=\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010>\u001a%\u0010?\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010@\u001a;\u0010A\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010B\u001a\u00020CH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001ae\u0010F\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00190I2\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a=\u0010R\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\u0006\u0010%\u001a\u00020&H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001aQ\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020:2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010%\u001a\u00020&2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00190I¢\u0006\u0002\b\u001f¢\u0006\u0002\bZH\u0003¢\u0006\u0002\u0010[\u001a\u001d\u0010\\\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010'\u001a%\u0010]\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u00103\u001a1\u0010^\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\u00105\u001a\u0018\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\tH\u0002\u001a(\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007H\u0002\u001a-\u0010g\u001a\u00020h2\u0006\u0010J\u001a\u00020K2\u0006\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u0007H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a+\u0010m\u001a\u00020$2\b\b\u0002\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020\u00072\b\b\u0002\u0010i\u001a\u00020*H\u0007¢\u0006\u0002\u0010p\u001a`\u0010q\u001a\u00020\u00192\u0006\u0010J\u001a\u00020K2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020G2\u0006\u0010r\u001a\u00020G2\u0006\u0010s\u001a\u00020\u00072!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bu\u0012\b\bv\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00190IH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010x\u001a$\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0z2\u0006\u0010{\u001a\u00020\t2\u0006\u0010|\u001a\u00020\tH\u0002\u001a\u001c\u0010}\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u001c\u0010~\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002\u001a\u0015\u0010\u007f\u001a\u00020h*\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\u0081\u0001\u001a\u00020\u001b*\u00020\u001b2\u0007\u0010\u0081\u0001\u001a\u00020*H\u0003\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\f\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\r\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u000f\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0010\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0017\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0082\u0001"}, d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "", "", "FullCircle", "", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "Landroidx/compose/material3/TimePickerState;", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", "value", "(Landroidx/compose/material3/TimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/Selection;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-lxUZ_iY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-uXwN82Y", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "is24Hour", "number", "numberContentDescription-YKJpE6Y", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "initialHour", "initialMinute", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "timeInputOnChange-gIWD5Rc", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "valuesForAnimation", "Lkotlin/Pair;", "current", "new", "clockDial", "drawSelector", "toLocalString", "minDigits", "visible", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerKt {
    private static final float ClockFaceBottomMargin;
    private static final float DisplaySeparatorWidth;
    private static final List<Integer> ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final List<Integer> Hours;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float TimeInputBottomPadding;
    private static final float OuterCircleSizeRadius = Dp.m5050constructorimpl((float) androidx.appcompat.R.styleable.AppCompatTheme_switchStyle);
    private static final float InnerCircleRadius = Dp.m5050constructorimpl(69);
    private static final float ClockDisplayBottomMargin = Dp.m5050constructorimpl(36);
    private static final float SupportLabelTop = Dp.m5050constructorimpl(7);
    private static final float MaxDistance = Dp.m5050constructorimpl(74);
    private static final float MinimumInteractiveSize = Dp.m5050constructorimpl(48);
    private static final List<Integer> Minutes = CollectionsKt.listOf((Object[]) new Integer[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55});

    /* JADX WARN: Removed duplicated region for block: B:119:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x017b  */
    /* renamed from: TimePicker-mT9BvqQ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1499TimePickermT9BvqQ(final androidx.compose.material3.TimePickerState r42, androidx.compose.ui.Modifier r43, androidx.compose.material3.TimePickerColors r44, int r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m1499TimePickermT9BvqQ(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TimeInput(final androidx.compose.material3.TimePickerState r39, androidx.compose.ui.Modifier r40, androidx.compose.material3.TimePickerColors r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInput(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TimePickerState rememberTimePickerState(final int i, final int i2, final boolean z, Composer composer, int i3, int i4) {
        composer.startReplaceableGroup(1237715277);
        ComposerKt.sourceInformation(composer, "C(rememberTimePickerState)441@21331L14,444@21424L133,442@21368L189:TimePicker.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = TimeFormat_androidKt.is24HourFormat(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i3, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:438)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerState, ?> Saver = TimePickerState.Companion.Saver();
        Integer valueOf = Integer.valueOf(i);
        Integer valueOf2 = Integer.valueOf(i2);
        Boolean valueOf3 = Boolean.valueOf(z);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(valueOf) | composer.changed(valueOf2) | composer.changed(valueOf3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (Function0) new Function0<TimePickerState>() { // from class: androidx.compose.material3.TimePickerKt$rememberTimePickerState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TimePickerState invoke() {
                    return new TimePickerState(i, i2, z);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TimePickerState timePickerState = (TimePickerState) RememberSaveableKt.m2208rememberSaveable(objArr, Saver, (String) null, (Function0<? extends Object>) rememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return timePickerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void VerticalTimePicker(final androidx.compose.material3.TimePickerState r40, androidx.compose.ui.Modifier r41, androidx.compose.material3.TimePickerColors r42, final boolean r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.VerticalTimePicker(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void HorizontalTimePicker(final androidx.compose.material3.TimePickerState r40, androidx.compose.ui.Modifier r41, androidx.compose.material3.TimePickerColors r42, final boolean r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalTimePicker(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void TimeInputImpl(final Modifier modifier, final TimePickerColors timePickerColors, final TimePickerState timePickerState, Composer composer, final int i) {
        int i2;
        Composer composer2;
        TextStyle m4600copyCXVQc50;
        Composer startRestartGroup = composer.startRestartGroup(-475657989);
        ComposerKt.sourceInformation(startRestartGroup, "C(TimeInputImpl)P(1)698@29965L92,698@29913L144,701@30133L84,701@30081L136,705@30223L3592:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(timePickerState) ? 256 : 128;
        }
        final int i3 = i2;
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, i3, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:693)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.Companion.getSaver();
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(timePickerState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        String localString;
                        MutableState<TextFieldValue> mutableStateOf$default;
                        localString = TimePickerKt.toLocalString(TimePickerState.this.getHourForDisplay$material3_release(), 2);
                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(localString, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        return mutableStateOf$default;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState rememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, startRestartGroup, 72, 4);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = TextFieldValue.Companion.getSaver();
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(timePickerState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        String localString;
                        MutableState<TextFieldValue> mutableStateOf$default;
                        localString = TimePickerKt.toLocalString(TimePickerState.this.getMinute(), 2);
                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(localString, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                        return mutableStateOf$default;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState rememberSaveable2 = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (String) null, (Function0) rememberedValue2, startRestartGroup, 72, 4);
            composer2 = startRestartGroup;
            Modifier m419paddingqDBjuR0$default = PaddingKt.m419paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, null);
            Alignment.Vertical top = Alignment.Companion.getTop();
            composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), top, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m419paddingqDBjuR0$default);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer m2195constructorimpl = Updater.m2195constructorimpl(composer2);
            Updater.m2202setimpl(m2195constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1230444741, "C709@30386L10,715@30597L2787:TimePicker.kt#uh7d8r");
            m4600copyCXVQc50 = r19.m4600copyCXVQc50((r46 & 1) != 0 ? r19.spanStyle.m4547getColor0d7_KjU() : timePickerColors.m1495timeSelectorContentColorvNxB06k$material3_release(true), (r46 & 2) != 0 ? r19.spanStyle.m4548getFontSizeXSAIIZE() : 0L, (r46 & 4) != 0 ? r19.spanStyle.getFontWeight() : null, (r46 & 8) != 0 ? r19.spanStyle.m4549getFontStyle4Lr2A7w() : null, (r46 & 16) != 0 ? r19.spanStyle.m4550getFontSynthesisZQGJjVo() : null, (r46 & 32) != 0 ? r19.spanStyle.getFontFamily() : null, (r46 & 64) != 0 ? r19.spanStyle.getFontFeatureSettings() : null, (r46 & 128) != 0 ? r19.spanStyle.m4551getLetterSpacingXSAIIZE() : 0L, (r46 & 256) != 0 ? r19.spanStyle.m4546getBaselineShift5SSeXJ0() : null, (r46 & 512) != 0 ? r19.spanStyle.getTextGeometricTransform() : null, (r46 & 1024) != 0 ? r19.spanStyle.getLocaleList() : null, (r46 & 2048) != 0 ? r19.spanStyle.m4545getBackground0d7_KjU() : 0L, (r46 & 4096) != 0 ? r19.spanStyle.getTextDecoration() : null, (r46 & 8192) != 0 ? r19.spanStyle.getShadow() : null, (r46 & 16384) != 0 ? r19.paragraphStyle.m4504getTextAlignbuA522U() : TextAlign.m4937boximpl(TextAlign.Companion.m4944getCentere0LSkKk()), (r46 & 32768) != 0 ? r19.paragraphStyle.m4506getTextDirectionmmuk1to() : null, (r46 & 65536) != 0 ? r19.paragraphStyle.m4503getLineHeightXSAIIZE() : 0L, (r46 & 131072) != 0 ? r19.paragraphStyle.getTextIndent() : null, (r46 & 262144) != 0 ? r19.platformStyle : null, (r46 & 524288) != 0 ? r19.paragraphStyle.getLineHeightStyle() : null, (r46 & 1048576) != 0 ? r19.paragraphStyle.m4501getLineBreakLgCVezo() : null, (r46 & 2097152) != 0 ? TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont()).paragraphStyle.m4499getHyphensEaSxIns() : null);
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{TextKt.getLocalTextStyle().provides(m4600copyCXVQc50)}, ComposableLambdaKt.composableLambda(composer2, 1306700887, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r42v0, types: [androidx.compose.runtime.Composer] */
                /* JADX WARN: Type inference failed for: r6v12 */
                /* JADX WARN: Type inference failed for: r6v4 */
                /* JADX WARN: Type inference failed for: r9v11 */
                /* JADX WARN: Type inference failed for: r9v3 */
                public final void invoke(Composer composer3, int i4) {
                    TextFieldValue TimeInputImpl$lambda$5;
                    float f;
                    TextFieldValue TimeInputImpl$lambda$8;
                    ComposerKt.sourceInformation(composer3, "C719@30761L411,731@31241L353,746@31903L38,717@30672L1318,749@32003L85,752@32197L376,765@32645L331,780@33287L38,750@32101L1273:TimePicker.kt#uh7d8r");
                    if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1306700887, i4, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:715)");
                        }
                        Modifier.Companion companion = Modifier.Companion;
                        final MutableState<TextFieldValue> mutableState = rememberSaveable;
                        final TimePickerState timePickerState2 = timePickerState;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean changed3 = composer3.changed(mutableState) | composer3.changed(timePickerState2);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m1508invokeZmokQxo(keyEvent.m3813unboximpl());
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
                                    if (r6.getText().length() == 2) goto L11;
                                 */
                                /* renamed from: invoke-ZmokQxo  reason: not valid java name */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final java.lang.Boolean m1508invokeZmokQxo(android.view.KeyEvent r6) {
                                    /*
                                        r5 = this;
                                        java.lang.String r0 = "event"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                                        int r6 = androidx.compose.ui.input.key.KeyEvent_androidKt.m3826getUtf16CodePointZmokQxo(r6)
                                        r0 = 48
                                        r1 = 1
                                        r2 = 0
                                        if (r0 > r6) goto L15
                                        r0 = 58
                                        if (r6 >= r0) goto L15
                                        r6 = r1
                                        goto L16
                                    L15:
                                        r6 = r2
                                    L16:
                                        if (r6 == 0) goto L3a
                                        androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r6 = r2
                                        androidx.compose.ui.text.input.TextFieldValue r6 = androidx.compose.material3.TimePickerKt.access$TimeInputImpl$lambda$5(r6)
                                        long r3 = r6.m4796getSelectiond9O1mEE()
                                        int r6 = androidx.compose.ui.text.TextRange.m4587getStartimpl(r3)
                                        r0 = 2
                                        if (r6 != r0) goto L3a
                                        androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r6 = r2
                                        androidx.compose.ui.text.input.TextFieldValue r6 = androidx.compose.material3.TimePickerKt.access$TimeInputImpl$lambda$5(r6)
                                        java.lang.String r6 = r6.getText()
                                        int r6 = r6.length()
                                        if (r6 != r0) goto L3a
                                        goto L3b
                                    L3a:
                                        r1 = r2
                                    L3b:
                                        if (r1 == 0) goto L48
                                        androidx.compose.material3.TimePickerState r6 = androidx.compose.material3.TimePickerState.this
                                        androidx.compose.material3.Selection$Companion r0 = androidx.compose.material3.Selection.Companion
                                        int r0 = r0.m1312getMinuteJiIwxys()
                                        r6.m1527setSelectioniHAOin8$material3_release(r0)
                                    L48:
                                        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
                                        return r6
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1.m1508invokeZmokQxo(android.view.KeyEvent):java.lang.Boolean");
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(companion, (Function1) rememberedValue3);
                        TimeInputImpl$lambda$5 = TimePickerKt.TimeInputImpl$lambda$5(rememberSaveable);
                        final TimePickerState timePickerState3 = timePickerState;
                        final MutableState<TextFieldValue> mutableState2 = rememberSaveable;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean changed4 = composer3.changed(timePickerState3) | composer3.changed(mutableState2);
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue newValue) {
                                    TextFieldValue TimeInputImpl$lambda$52;
                                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                                    int m1311getHourJiIwxys = Selection.Companion.m1311getHourJiIwxys();
                                    TimePickerState timePickerState4 = TimePickerState.this;
                                    TimeInputImpl$lambda$52 = TimePickerKt.TimeInputImpl$lambda$5(mutableState2);
                                    int i5 = TimePickerState.this.is24hour() ? 23 : 12;
                                    final MutableState<TextFieldValue> mutableState3 = mutableState2;
                                    TimePickerKt.m1507timeInputOnChangegIWD5Rc(m1311getHourJiIwxys, timePickerState4, newValue, TimeInputImpl$lambda$52, i5, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                            invoke2(textFieldValue);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextFieldValue it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState3.setValue(it);
                                        }
                                    });
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue4);
                        }
                        composer3.endReplaceableGroup();
                        Function1 function1 = rememberedValue4;
                        TimePickerState timePickerState4 = timePickerState;
                        int m1311getHourJiIwxys = Selection.Companion.m1311getHourJiIwxys();
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, KeyboardType.Companion.m4785getNumberPjHm6EE(), ImeAction.Companion.m4738getNexteUduSuo(), 3, null);
                        final TimePickerState timePickerState5 = timePickerState;
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean changed5 = composer3.changed(timePickerState5);
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (changed5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$3$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                                    invoke2(keyboardActionScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyboardActionScope $receiver) {
                                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                    TimePickerState.this.m1527setSelectioniHAOin8$material3_release(Selection.Companion.m1312getMinuteJiIwxys());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        composer3.endReplaceableGroup();
                        KeyboardActions keyboardActions = new KeyboardActions(null, null, rememberedValue5, null, null, null, 59, null);
                        TimePickerColors timePickerColors2 = timePickerColors;
                        int i5 = i3;
                        TimePickerKt.m1500TimePickerTextFieldlxUZ_iY(onKeyEvent, TimeInputImpl$lambda$5, function1, timePickerState4, m1311getHourJiIwxys, keyboardOptions, keyboardActions, timePickerColors2, composer3, ((i5 << 3) & 7168) | 24576 | ((i5 << 18) & 29360128), 0);
                        f = TimePickerKt.DisplaySeparatorWidth;
                        TimePickerKt.DisplaySeparator(SizeKt.m460sizeVpY3zN4(Modifier.Companion, f, TimeInputTokens.INSTANCE.m2086getPeriodSelectorContainerHeightD9Ej5fM()), composer3, 6);
                        Modifier.Companion companion2 = Modifier.Companion;
                        final MutableState<TextFieldValue> mutableState3 = rememberSaveable2;
                        final TimePickerState timePickerState6 = timePickerState;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean changed6 = composer3.changed(mutableState3) | composer3.changed(timePickerState6);
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (changed6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                            rememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$4$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m1509invokeZmokQxo(keyEvent.m3813unboximpl());
                                }

                                /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
                                /* renamed from: invoke-ZmokQxo  reason: not valid java name */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final java.lang.Boolean m1509invokeZmokQxo(android.view.KeyEvent r3) {
                                    /*
                                        r2 = this;
                                        java.lang.String r0 = "event"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                        int r3 = androidx.compose.ui.input.key.KeyEvent_androidKt.m3826getUtf16CodePointZmokQxo(r3)
                                        if (r3 != 0) goto L1d
                                        androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r3 = r2
                                        androidx.compose.ui.text.input.TextFieldValue r3 = androidx.compose.material3.TimePickerKt.access$TimeInputImpl$lambda$8(r3)
                                        long r0 = r3.m4796getSelectiond9O1mEE()
                                        int r3 = androidx.compose.ui.text.TextRange.m4587getStartimpl(r0)
                                        if (r3 != 0) goto L1d
                                        r3 = 1
                                        goto L1e
                                    L1d:
                                        r3 = 0
                                    L1e:
                                        if (r3 == 0) goto L2b
                                        androidx.compose.material3.TimePickerState r0 = androidx.compose.material3.TimePickerState.this
                                        androidx.compose.material3.Selection$Companion r1 = androidx.compose.material3.Selection.Companion
                                        int r1 = r1.m1311getHourJiIwxys()
                                        r0.m1527setSelectioniHAOin8$material3_release(r1)
                                    L2b:
                                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                                        return r3
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$4$1.m1509invokeZmokQxo(android.view.KeyEvent):java.lang.Boolean");
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        composer3.endReplaceableGroup();
                        Modifier onPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(companion2, (Function1) rememberedValue6);
                        TimeInputImpl$lambda$8 = TimePickerKt.TimeInputImpl$lambda$8(rememberSaveable2);
                        final TimePickerState timePickerState7 = timePickerState;
                        final MutableState<TextFieldValue> mutableState4 = rememberSaveable2;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean changed7 = composer3.changed(timePickerState7) | composer3.changed(mutableState4);
                        Object rememberedValue7 = composer3.rememberedValue();
                        if (changed7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                            rememberedValue7 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue newValue) {
                                    TextFieldValue TimeInputImpl$lambda$82;
                                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                                    int m1312getMinuteJiIwxys = Selection.Companion.m1312getMinuteJiIwxys();
                                    TimePickerState timePickerState8 = TimePickerState.this;
                                    TimeInputImpl$lambda$82 = TimePickerKt.TimeInputImpl$lambda$8(mutableState4);
                                    final MutableState<TextFieldValue> mutableState5 = mutableState4;
                                    TimePickerKt.m1507timeInputOnChangegIWD5Rc(m1312getMinuteJiIwxys, timePickerState8, newValue, TimeInputImpl$lambda$82, 59, new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                            invoke2(textFieldValue);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextFieldValue it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState5.setValue(it);
                                        }
                                    });
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue7);
                        }
                        composer3.endReplaceableGroup();
                        Function1 function12 = rememberedValue7;
                        TimePickerState timePickerState8 = timePickerState;
                        int m1312getMinuteJiIwxys = Selection.Companion.m1312getMinuteJiIwxys();
                        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, KeyboardType.Companion.m4785getNumberPjHm6EE(), ImeAction.Companion.m4736getDoneeUduSuo(), 3, null);
                        final TimePickerState timePickerState9 = timePickerState;
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean changed8 = composer3.changed(timePickerState9);
                        Object rememberedValue8 = composer3.rememberedValue();
                        if (changed8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                            rememberedValue8 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$6$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                                    invoke2(keyboardActionScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(KeyboardActionScope $receiver) {
                                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                    TimePickerState.this.m1527setSelectioniHAOin8$material3_release(Selection.Companion.m1312getMinuteJiIwxys());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue8);
                        }
                        composer3.endReplaceableGroup();
                        KeyboardActions keyboardActions2 = new KeyboardActions(null, null, rememberedValue8, null, null, null, 59, null);
                        TimePickerColors timePickerColors3 = timePickerColors;
                        int i6 = i3;
                        TimePickerKt.m1500TimePickerTextFieldlxUZ_iY(onPreviewKeyEvent, TimeInputImpl$lambda$8, function12, timePickerState8, m1312getMinuteJiIwxys, keyboardOptions2, keyboardActions2, timePickerColors3, composer3, ((i6 << 3) & 7168) | 24576 | ((i6 << 18) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 56);
            composer2.startReplaceableGroup(565119480);
            ComposerKt.sourceInformation(composer2, "786@33429L370");
            if (!timePickerState.is24hour()) {
                Modifier m419paddingqDBjuR0$default2 = PaddingKt.m419paddingqDBjuR0$default(modifier, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m419paddingqDBjuR0$default2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer m2195constructorimpl2 = Updater.m2195constructorimpl(composer2);
                Updater.m2202setimpl(m2195constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2202setimpl(m2195constructorimpl2, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2202setimpl(m2195constructorimpl2, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2202setimpl(m2195constructorimpl2, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                composer2.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1645137119, "C787@33497L288:TimePicker.kt#uh7d8r");
                VerticalPeriodToggle(SizeKt.m460sizeVpY3zN4(Modifier.Companion, TimeInputTokens.INSTANCE.m2087getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m2086getPeriodSelectorContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composer2, ((i3 >> 3) & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 6 | ((i3 << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                TimePickerKt.TimeInputImpl(Modifier.this, timePickerColors, timePickerState, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final TextFieldValue TimeInputImpl$lambda$5(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    public static final TextFieldValue TimeInputImpl$lambda$8(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    public static final void HorizontalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalClockDisplay)P(1)802@33922L554:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i2, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:801)");
            }
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -385990141, "C803@33981L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, startRestartGroup, (i2 & 14) | (i2 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
            startRestartGroup.startReplaceableGroup(-552398963);
            ComposerKt.sourceInformation(startRestartGroup, "805@34059L401");
            if (!timePickerState.is24hour()) {
                Modifier m419paddingqDBjuR0$default = PaddingKt.m419paddingqDBjuR0$default(Modifier.Companion, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m419paddingqDBjuR0$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2195constructorimpl2 = Updater.m2195constructorimpl(startRestartGroup);
                Updater.m2202setimpl(m2195constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2202setimpl(m2195constructorimpl2, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2202setimpl(m2195constructorimpl2, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2202setimpl(m2195constructorimpl2, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 34966463, "C806@34136L310:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                HorizontalPeriodToggle(SizeKt.m460sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2098getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2097getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, startRestartGroup, (i3 & 896) | (i3 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalClockDisplay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                TimePickerKt.HorizontalClockDisplay(TimePickerState.this, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void VerticalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalClockDisplay)P(1)821@34581L549:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i2, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:820)");
            }
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getTop(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1085478083, "C822@34639L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, startRestartGroup, (i2 & 14) | (i2 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
            startRestartGroup.startReplaceableGroup(952907597);
            ComposerKt.sourceInformation(startRestartGroup, "824@34717L397");
            if (!timePickerState.is24hour()) {
                Modifier m419paddingqDBjuR0$default = PaddingKt.m419paddingqDBjuR0$default(Modifier.Companion, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m419paddingqDBjuR0$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2195constructorimpl2 = Updater.m2195constructorimpl(startRestartGroup);
                Updater.m2202setimpl(m2195constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2202setimpl(m2195constructorimpl2, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2202setimpl(m2195constructorimpl2, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2202setimpl(m2195constructorimpl2, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1130526335, "C825@34796L304:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                VerticalPeriodToggle(SizeKt.m460sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2101getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2100getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, startRestartGroup, (i3 & 896) | (i3 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalClockDisplay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                TimePickerKt.VerticalClockDisplay(TimePickerState.this, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void ClockDisplayNumbers(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        final int i2;
        Composer startRestartGroup = composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockDisplayNumbers)P(1)844@35316L10,843@35244L1047:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i2, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:839)");
            }
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont()))}, ComposableLambdaKt.composableLambda(startRestartGroup, -477913269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockDisplayNumbers$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    float f;
                    ComposerKt.sourceInformation(composer2, "C846@35380L905:TimePicker.kt#uh7d8r");
                    if ((i3 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-477913269, i3, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:845)");
                        }
                        TimePickerState timePickerState2 = TimePickerState.this;
                        TimePickerColors timePickerColors2 = timePickerColors;
                        int i4 = i2;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density = (Density) consume;
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        LayoutDirection layoutDirection = (LayoutDirection) consume2;
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer m2195constructorimpl = Updater.m2195constructorimpl(composer2);
                        Updater.m2202setimpl(m2195constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
                        Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                        composer2.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 94464085, "C847@35398L338,857@35749L181,863@35943L332:TimePicker.kt#uh7d8r");
                        int i5 = ((i4 << 9) & 57344) | ((i4 << 6) & 896) | 3078;
                        TimePickerKt.m1501TimeSelectoruXwN82Y(SizeKt.m460sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2104getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2103getTimeSelectorContainerHeightD9Ej5fM()), timePickerState2.getHourForDisplay$material3_release(), timePickerState2, Selection.Companion.m1311getHourJiIwxys(), timePickerColors2, composer2, i5);
                        f = TimePickerKt.DisplaySeparatorWidth;
                        TimePickerKt.DisplaySeparator(SizeKt.m460sizeVpY3zN4(Modifier.Companion, f, TimePickerTokens.INSTANCE.m2100getPeriodSelectorVerticalContainerHeightD9Ej5fM()), composer2, 6);
                        TimePickerKt.m1501TimeSelectoruXwN82Y(SizeKt.m460sizeVpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.m2104getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m2103getTimeSelectorContainerHeightD9Ej5fM()), timePickerState2.getMinute(), timePickerState2, Selection.Companion.m1312getMinuteJiIwxys(), timePickerColors2, composer2, i5);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockDisplayNumbers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.ClockDisplayNumbers(TimePickerState.this, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void HorizontalPeriodToggle(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPeriodToggle)P(1,2)883@36453L904,908@37404L9,910@37439L206:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:878)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo12measure3p2s80s(MeasureScope MeasurePolicy, List<? extends Measurable> measurables, long j) {
                        Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        List<? extends Measurable> list = measurables;
                        for (Measurable measurable : list) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                final Placeable mo4075measureBRTryo0 = measurable.mo4075measureBRTryo0(Constraints.m4997copyZbe2FdA$default(j, 0, MathKt.roundToInt(MeasurePolicy.mo302toPx0680j_4(TimePickerTokens.INSTANCE.m2099getPeriodSelectorOutlineWidthD9Ej5fM())), 0, 0, 12, null));
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : list) {
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                ArrayList<Measurable> arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                                for (Measurable measurable2 : arrayList2) {
                                    arrayList3.add(measurable2.mo4075measureBRTryo0(Constraints.m4997copyZbe2FdA$default(j, 0, Constraints.m5006getMaxWidthimpl(j) / 2, 0, 0, 12, null)));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                return MeasureScope.layout$default(MeasurePolicy, Constraints.m5006getMaxWidthimpl(j), Constraints.m5005getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1$measure$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope layout) {
                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(1), arrayList4.get(0).getWidth(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, mo4075measureBRTryo0, arrayList4.get(0).getWidth() - (mo4075measureBRTryo0.getWidth() / 2), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), startRestartGroup, 6);
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, (MeasurePolicy) rememberedValue, ShapesKt.start(cornerBasedShape), ShapesKt.end(cornerBasedShape), startRestartGroup, (i2 & 14) | 3072 | (i2 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.HorizontalPeriodToggle(Modifier.this, timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void VerticalPeriodToggle(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPeriodToggle)P(1,2)926@37805L911,951@38763L9,953@38798L207:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:921)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo12measure3p2s80s(MeasureScope MeasurePolicy, List<? extends Measurable> measurables, long j) {
                        Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        List<? extends Measurable> list = measurables;
                        for (Measurable measurable : list) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                final Placeable mo4075measureBRTryo0 = measurable.mo4075measureBRTryo0(Constraints.m4997copyZbe2FdA$default(j, 0, 0, 0, MathKt.roundToInt(MeasurePolicy.mo302toPx0680j_4(TimePickerTokens.INSTANCE.m2099getPeriodSelectorOutlineWidthD9Ej5fM())), 3, null));
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : list) {
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                ArrayList<Measurable> arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                                for (Measurable measurable2 : arrayList2) {
                                    arrayList3.add(measurable2.mo4075measureBRTryo0(Constraints.m4997copyZbe2FdA$default(j, 0, 0, 0, Constraints.m5005getMaxHeightimpl(j) / 2, 3, null)));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                return MeasureScope.layout$default(MeasurePolicy, Constraints.m5006getMaxWidthimpl(j), Constraints.m5005getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1$measure$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope layout) {
                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, arrayList4.get(1), 0, arrayList4.get(0).getHeight(), 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(layout, mo4075measureBRTryo0, 0, arrayList4.get(0).getHeight() - (mo4075measureBRTryo0.getHeight() / 2), 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), startRestartGroup, 6);
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, (MeasurePolicy) rememberedValue, ShapesKt.top(cornerBasedShape), ShapesKt.bottom(cornerBasedShape), startRestartGroup, (i2 & 14) | 3072 | (i2 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.VerticalPeriodToggle(Modifier.this, timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    public static final void PeriodToggleImpl(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, final MeasurePolicy measurePolicy, final Shape shape, final Shape shape2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1374241901);
        ComposerKt.sourceInformation(startRestartGroup, "C(PeriodToggleImpl)P(3,5!1,2,4)977@39398L9,978@39457L41,981@39562L111,979@39503L1257:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(measurePolicy) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changed(shape2) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374241901, i2, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:964)");
            }
            BorderStroke m171BorderStrokecXLIe8U = BorderStrokeKt.m171BorderStrokecXLIe8U(TimePickerTokens.INSTANCE.m2099getPeriodSelectorOutlineWidthD9Ej5fM(), timePickerColors.m1490getPeriodSelectorBorderColor0d7_KjU$material3_release());
            Shape shape3 = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), startRestartGroup, 6);
            Intrinsics.checkNotNull(shape3, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape3;
            final String m1397getStringNWtq28 = Strings_androidKt.m1397getStringNWtq28(Strings.Companion.m1394getTimePickerPeriodToggleadMyvUU(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m1397getStringNWtq28);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setContainer(semantics, true);
                        SemanticsPropertiesKt.setContentDescription(semantics, m1397getStringNWtq28);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier border = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, null)).then(modifier), m171BorderStrokecXLIe8U, cornerBasedShape);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(border);
            int i3 = ((((i2 >> 3) & 896) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i3 >> 3) & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1654470848, "C993@39989L71,990@39863L303,1003@40399L9,998@40179L244,1009@40575L70,1005@40436L308:TimePicker.kt#uh7d8r");
            boolean z = !timePickerState.isAfternoonToggle$material3_release();
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(timePickerState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TimePickerState.this.setAfternoonToggle$material3_release(false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            int i4 = (i2 << 3) & 7168;
            ToggleItem(z, shape, (Function0) rememberedValue2, timePickerColors, ComposableSingletons$TimePickerKt.INSTANCE.m1061getLambda1$material3_release(), startRestartGroup, ((i2 >> 9) & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 24576 | i4);
            SpacerKt.Spacer(BackgroundKt.m152backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.Companion, "Spacer"), SeparatorZIndex), 0.0f, 1, null), ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getPeriodSelectorOutlineColor(), startRestartGroup, 6), null, 2, null), startRestartGroup, 0);
            boolean isAfternoonToggle$material3_release = timePickerState.isAfternoonToggle$material3_release();
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(timePickerState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TimePickerState.this.setAfternoonToggle$material3_release(true);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            ToggleItem(isAfternoonToggle$material3_release, shape2, rememberedValue3, timePickerColors, ComposableSingletons$TimePickerKt.INSTANCE.m1062getLambda2$material3_release(), startRestartGroup, ((i2 >> 12) & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) | 24576 | i4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                TimePickerKt.PeriodToggleImpl(Modifier.this, timePickerState, timePickerColors, measurePolicy, shape, shape2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void ToggleItem(final boolean z, final Shape shape, final Function0<Unit> function0, final TimePickerColors timePickerColors, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1937408098);
        ComposerKt.sourceInformation(startRestartGroup, "C(ToggleItem)P(!1,4,3)1033@41221L22,1038@41400L112,1029@41086L432:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(timePickerColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((46811 & i2) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, i2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1019)");
            }
            long m1493periodSelectorContentColorvNxB06k$material3_release = timePickerColors.m1493periodSelectorContentColorvNxB06k$material3_release(z);
            long m1492periodSelectorContainerColorvNxB06k$material3_release = timePickerColors.m1492periodSelectorContainerColorvNxB06k$material3_release(z);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, z ? 0.0f : 1.0f), 0.0f, 1, null);
            Boolean valueOf = Boolean.valueOf(z);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(valueOf);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setSelected(semantics, z);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(fillMaxSize$default, false, (Function1) rememberedValue, 1, null), false, shape, ButtonDefaults.INSTANCE.m945textButtonColorsro_MJ88(m1492periodSelectorContainerColorvNxB06k$material3_release, m1493periodSelectorContentColorvNxB06k$material3_release, 0L, 0L, startRestartGroup, 24576, 12), null, null, PaddingKt.m408PaddingValues0680j_4(Dp.m5050constructorimpl(0)), null, function3, startRestartGroup, ((i2 >> 6) & 14) | 12582912 | ((i2 << 6) & 7168) | ((i2 << 15) & 1879048192), 356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.ToggleItem(z, shape, function0, timePickerColors, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final void DisplaySeparator(final Modifier modifier, Composer composer, final int i) {
        int i2;
        TextStyle m4600copyCXVQc50;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisplaySeparator)1048@41655L7,1056@41916L245:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1046)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            m4600copyCXVQc50 = r16.m4600copyCXVQc50((r46 & 1) != 0 ? r16.spanStyle.m4547getColor0d7_KjU() : 0L, (r46 & 2) != 0 ? r16.spanStyle.m4548getFontSizeXSAIIZE() : 0L, (r46 & 4) != 0 ? r16.spanStyle.getFontWeight() : null, (r46 & 8) != 0 ? r16.spanStyle.m4549getFontStyle4Lr2A7w() : null, (r46 & 16) != 0 ? r16.spanStyle.m4550getFontSynthesisZQGJjVo() : null, (r46 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r46 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r46 & 128) != 0 ? r16.spanStyle.m4551getLetterSpacingXSAIIZE() : 0L, (r46 & 256) != 0 ? r16.spanStyle.m4546getBaselineShift5SSeXJ0() : null, (r46 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r46 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r46 & 2048) != 0 ? r16.spanStyle.m4545getBackground0d7_KjU() : 0L, (r46 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r46 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r46 & 16384) != 0 ? r16.paragraphStyle.m4504getTextAlignbuA522U() : TextAlign.m4937boximpl(TextAlign.Companion.m4944getCentere0LSkKk()), (r46 & 32768) != 0 ? r16.paragraphStyle.m4506getTextDirectionmmuk1to() : null, (r46 & 65536) != 0 ? r16.paragraphStyle.m4503getLineHeightXSAIIZE() : 0L, (r46 & 131072) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r46 & 262144) != 0 ? r16.platformStyle : null, (r46 & 524288) != 0 ? r16.paragraphStyle.getLineHeightStyle() : new LineHeightStyle(LineHeightStyle.Alignment.Companion.m4921getCenterPIaL0Z0(), LineHeightStyle.Trim.Companion.m4933getBothEVpEnUU(), null), (r46 & 1048576) != 0 ? r16.paragraphStyle.m4501getLineBreakLgCVezo() : null, (r46 & 2097152) != 0 ? ((TextStyle) consume).paragraphStyle.m4499getHyphensEaSxIns() : null);
            TextStyle copyAndSetFontPadding = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(m4600copyCXVQc50, false);
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$DisplaySeparator$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics2) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics2, "$this$clearAndSetSemantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            });
            Alignment center = Alignment.Companion.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(clearAndSetSemantics);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -617594898, "C1062@42109L9,1060@42035L120:TimePicker.kt#uh7d8r");
            composer2 = startRestartGroup;
            TextKt.m1484Text4IGK_g(":", (Modifier) null, ColorSchemeKt.toColor(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), startRestartGroup, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, copyAndSetFontPadding, composer2, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$DisplaySeparator$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i3) {
                TimePickerKt.DisplaySeparator(Modifier.this, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* renamed from: TimeSelector-uXwN82Y */
    public static final void m1501TimeSelectoruXwN82Y(final Modifier modifier, final int i, final TimePickerState timePickerState, final int i2, final TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        int m1390getTimePickerMinuteSelectionadMyvUU;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(21099367);
        ComposerKt.sourceInformation(startRestartGroup, "C(TimeSelector)P(1,4,3,2:c#material3.Selection)1078@42456L176,1088@42784L24,1091@42898L124,1104@43327L9,1089@42813L1060:TimePicker.kt#uh7d8r");
        if ((i3 & 14) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i4 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i4 |= startRestartGroup.changed(timePickerState) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i4 |= startRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if ((57344 & i3) == 0) {
            i4 |= startRestartGroup.changed(timePickerColors) ? 16384 : 8192;
        }
        final int i5 = i4;
        if ((46811 & i5) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(21099367, i5, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1070)");
            }
            boolean m1307equalsimpl0 = Selection.m1307equalsimpl0(timePickerState.m1524getSelectionJiIwxys$material3_release(), i2);
            if (Selection.m1307equalsimpl0(i2, Selection.Companion.m1311getHourJiIwxys())) {
                m1390getTimePickerMinuteSelectionadMyvUU = Strings.Companion.m1386getTimePickerHourSelectionadMyvUU();
            } else {
                m1390getTimePickerMinuteSelectionadMyvUU = Strings.Companion.m1390getTimePickerMinuteSelectionadMyvUU();
            }
            final String m1397getStringNWtq28 = Strings_androidKt.m1397getStringNWtq28(m1390getTimePickerMinuteSelectionadMyvUU, startRestartGroup, 0);
            long m1494timeSelectorContainerColorvNxB06k$material3_release = timePickerColors.m1494timeSelectorContainerColorvNxB06k$material3_release(m1307equalsimpl0);
            final long m1495timeSelectorContentColorvNxB06k$material3_release = timePickerColors.m1495timeSelectorContentColorvNxB06k$material3_release(m1307equalsimpl0);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m1397getStringNWtq28);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.m4445setRolekuIjeqM(semantics, Role.Companion.m4435getRadioButtono7Vup1c());
                        SemanticsPropertiesKt.setContentDescription(semantics, m1397getStringNWtq28);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            SurfaceKt.m1407Surfaced85dljk(m1307equalsimpl0, new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (Selection.m1307equalsimpl0(i2, timePickerState.m1524getSelectionJiIwxys$material3_release())) {
                        return;
                    }
                    timePickerState.m1527setSelectioniHAOin8$material3_release(i2);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(timePickerState, null), 3, null);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TimePicker.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$TimeSelector$2$1", f = "TimePicker.kt", i = {}, l = {1100}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.TimePickerKt$TimeSelector$2$1  reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ TimePickerState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(TimePickerState timePickerState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$state = timePickerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$state, continuation);
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
                            if (this.$state.animateToCurrent$material3_release(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, SemanticsModifierKt.semantics(modifier, true, (Function1) rememberedValue2), false, ShapesKt.toShape(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), startRestartGroup, 6), m1494timeSelectorContainerColorvNxB06k$material3_release, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -1338709103, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    String localString;
                    ComposerKt.sourceInformation(composer3, "C1108@43428L152,1114@43590L277:TimePicker.kt#uh7d8r");
                    if ((i6 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1338709103, i6, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1106)");
                        }
                        int i7 = i2;
                        boolean is24hour = timePickerState.is24hour();
                        int i8 = i;
                        int i9 = i5;
                        final String m1506numberContentDescriptionYKJpE6Y = TimePickerKt.m1506numberContentDescriptionYKJpE6Y(i7, is24hour, i8, composer3, ((i9 << 3) & 896) | ((i9 >> 9) & 14));
                        Alignment center = Alignment.Companion.getCenter();
                        int i10 = i;
                        long j = m1495timeSelectorContentColorvNxB06k$material3_release;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = composer3.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Density density = (Density) consume;
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        LayoutDirection layoutDirection = (LayoutDirection) consume2;
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer m2195constructorimpl = Updater.m2195constructorimpl(composer3);
                        Updater.m2202setimpl(m2195constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
                        Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                        composer3.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 992575728, "C1116@43697L48,1115@43645L212:TimePicker.kt#uh7d8r");
                        Modifier.Companion companion = Modifier.Companion;
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean changed2 = composer3.changed(m1506numberContentDescriptionYKJpE6Y);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.setContentDescription(semantics, m1506numberContentDescriptionYKJpE6Y);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue3, 1, null);
                        localString = TimePickerKt.toLocalString(i10, 2);
                        TextKt.m1484Text4IGK_g(localString, semantics$default, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131064);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 0, 48, 1992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i6) {
                TimePickerKt.m1501TimeSelectoruXwN82Y(Modifier.this, i, timePickerState, i2, timePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
            }
        });
    }

    public static final void ClockFace(final TimePickerState state, final TimePickerColors colors, final boolean z, Composer composer, final int i) {
        final int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer startRestartGroup = composer.startRestartGroup(-1525091100);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockFace)P(2,1)1130@44011L1899:TimePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i2 |= startRestartGroup.changed(colors) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1525091100, i2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1125)");
            }
            CrossfadeKt.Crossfade(state.getValues$material3_release(), SemanticsModifierKt.semantics$default(SizeKt.m458size3ABfNKs(BackgroundKt.m151backgroundbw27NRU(Modifier.Companion, colors.m1488getClockDialColor0d7_KjU$material3_release(), RoundedCornerShapeKt.getCircleShape()), TimePickerTokens.INSTANCE.m2092getClockDialContainerSizeD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContainer(semantics, false);
                    SemanticsPropertiesKt.selectableGroup(semantics);
                }
            }, 1, null), AnimationSpecKt.tween$default(350, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1628166511, true, new Function3<List<? extends Integer>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list, Composer composer2, Integer num) {
                    invoke((List<Integer>) list, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final List<Integer> screen, Composer composer2, int i3) {
                    Modifier clockDial;
                    Modifier drawSelector;
                    float f;
                    Intrinsics.checkNotNullParameter(screen, "screen");
                    ComposerKt.sourceInformation(composer2, "C1141@44425L1479:TimePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1628166511, i3, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1140)");
                    }
                    clockDial = TimePickerKt.clockDial(Modifier.Companion, TimePickerState.this, z);
                    drawSelector = TimePickerKt.drawSelector(SizeKt.m458size3ABfNKs(clockDial, TimePickerTokens.INSTANCE.m2092getClockDialContainerSizeD9Ej5fM()), TimePickerState.this, colors);
                    f = TimePickerKt.OuterCircleSizeRadius;
                    final TimePickerColors timePickerColors = colors;
                    final TimePickerState timePickerState = TimePickerState.this;
                    final boolean z2 = z;
                    final int i4 = i2;
                    TimePickerKt.m1498CircularLayoutuFdPcIQ(drawSelector, f, ComposableLambdaKt.composableLambda(composer2, -1385633737, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C1148@44687L1207:TimePicker.kt#uh7d8r");
                            if ((i5 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1385633737, i5, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1147)");
                                }
                                ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2546boximpl(TimePickerColors.this.m1487clockDialContentColorvNxB06k$material3_release(false)))};
                                final List<Integer> list = screen;
                                final TimePickerState timePickerState2 = timePickerState;
                                final boolean z3 = z2;
                                final int i6 = i4;
                                CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.composableLambda(composer3, -2018362505, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i7) {
                                        float f2;
                                        int intValue;
                                        ComposerKt.sourceInformation(composer4, "C1161@45270L592:TimePicker.kt#uh7d8r");
                                        if ((i7 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2018362505, i7, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1150)");
                                            }
                                            composer4.startReplaceableGroup(-504302349);
                                            ComposerKt.sourceInformation(composer4, "*1157@45091L64");
                                            int size = list.size();
                                            TimePickerState timePickerState3 = timePickerState2;
                                            List<Integer> list2 = list;
                                            boolean z4 = z3;
                                            int i8 = i6;
                                            for (int i9 = 0; i9 < size; i9++) {
                                                if (!timePickerState3.is24hour() || Selection.m1307equalsimpl0(timePickerState3.m1524getSelectionJiIwxys$material3_release(), Selection.Companion.m1312getMinuteJiIwxys())) {
                                                    intValue = list2.get(i9).intValue();
                                                } else {
                                                    intValue = list2.get(i9).intValue() % 12;
                                                }
                                                TimePickerKt.ClockText(timePickerState3, intValue, z4, composer4, (i8 & 14) | (i8 & 896));
                                            }
                                            composer4.endReplaceableGroup();
                                            if (Selection.m1307equalsimpl0(timePickerState2.m1524getSelectionJiIwxys$material3_release(), Selection.Companion.m1311getHourJiIwxys()) && timePickerState2.is24hour()) {
                                                Modifier m151backgroundbw27NRU = BackgroundKt.m151backgroundbw27NRU(SizeKt.m458size3ABfNKs(LayoutIdKt.layoutId(Modifier.Companion, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m2092getClockDialContainerSizeD9Ej5fM()), Color.Companion.m2591getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                                f2 = TimePickerKt.InnerCircleRadius;
                                                final TimePickerState timePickerState4 = timePickerState2;
                                                final boolean z5 = z3;
                                                final int i10 = i6;
                                                TimePickerKt.m1498CircularLayoutuFdPcIQ(m151backgroundbw27NRU, f2, ComposableLambdaKt.composableLambda(composer4, -448649404, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i11) {
                                                        List list3;
                                                        List list4;
                                                        ComposerKt.sourceInformation(composer5, "C*1170@45750L64:TimePicker.kt#uh7d8r");
                                                        if ((i11 & 11) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-448649404, i11, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1167)");
                                                            }
                                                            list3 = TimePickerKt.ExtraHours;
                                                            int size2 = list3.size();
                                                            TimePickerState timePickerState5 = TimePickerState.this;
                                                            boolean z6 = z5;
                                                            int i12 = i10;
                                                            for (int i13 = 0; i13 < size2; i13++) {
                                                                list4 = TimePickerKt.ExtraHours;
                                                                TimePickerKt.ClockText(timePickerState5, ((Number) list4.get(i13)).intValue(), z6, composer5, (i12 & 14) | (i12 & 896));
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 432, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, 432, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 24584, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                TimePickerKt.ClockFace(TimePickerState.this, colors, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final Modifier drawSelector(Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$drawSelector$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                long Offset = OffsetKt.Offset(drawWithContent.mo302toPx0680j_4(DpOffset.m5111getXD9Ej5fM(TimePickerState.this.m1525getSelectorPosRKDOV3M$material3_release())), drawWithContent.mo302toPx0680j_4(DpOffset.m5113getYD9Ej5fM(TimePickerState.this.m1525getSelectorPosRKDOV3M$material3_release())));
                float f = 2;
                float f2 = drawWithContent.mo302toPx0680j_4(TimePickerTokens.INSTANCE.m2094getClockDialSelectorHandleContainerSizeD9Ej5fM()) / f;
                long m1491getSelectorColor0d7_KjU$material3_release = timePickerColors.m1491getSelectorColor0d7_KjU$material3_release();
                ContentDrawScope contentDrawScope = drawWithContent;
                DrawScope.m3078drawCircleVaOC9Bg$default(contentDrawScope, Color.Companion.m2582getBlack0d7_KjU(), f2, Offset, 0.0f, null, null, BlendMode.Companion.m2473getClear0nO6VwU(), 56, null);
                drawWithContent.drawContent();
                DrawScope.m3078drawCircleVaOC9Bg$default(contentDrawScope, m1491getSelectorColor0d7_KjU$material3_release, f2, Offset, 0.0f, null, null, BlendMode.Companion.m2501getXor0nO6VwU(), 56, null);
                DrawScope.m3083drawLineNGM6Ib0$default(contentDrawScope, m1491getSelectorColor0d7_KjU$material3_release, androidx.compose.ui.geometry.SizeKt.m2397getCenteruvyYCjk(drawWithContent.mo3096getSizeNHjbRc()), Offset.m2322minusMKHz9U(Offset, OffsetKt.Offset(((float) Math.cos(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue())) * f2, ((float) Math.sin(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue())) * f2)), drawWithContent.mo302toPx0680j_4(TimePickerTokens.INSTANCE.m2095getClockDialSelectorTrackContainerWidthD9Ej5fM()), 0, null, 0.0f, null, BlendMode.Companion.m2500getSrcOver0nO6VwU(), 240, null);
                DrawScope.m3078drawCircleVaOC9Bg$default(contentDrawScope, m1491getSelectorColor0d7_KjU$material3_release, drawWithContent.mo302toPx0680j_4(TimePickerTokens.INSTANCE.m2093getClockDialSelectorCenterContainerSizeD9Ej5fM()) / f, androidx.compose.ui.geometry.SizeKt.m2397getCenteruvyYCjk(drawWithContent.mo3096getSizeNHjbRc()), 0.0f, null, null, 0, 120, null);
                DrawScope.m3078drawCircleVaOC9Bg$default(contentDrawScope, timePickerColors.m1487clockDialContentColorvNxB06k$material3_release(true), f2, Offset, 0.0f, null, null, BlendMode.Companion.m2483getDstOver0nO6VwU(), 56, null);
            }
        });
    }

    public static final void ClockText(final TimePickerState timePickerState, final int i, final boolean z, Composer composer, final int i2) {
        int i3;
        boolean areEqual;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1317232110);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClockText)P(1,2)*1287@49593L10,1291@49736L7,1292@49786L40,1293@49843L24,1295@49905L142,1313@50500L39,1308@50299L758:TimePicker.kt#uh7d8r");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(timePickerState) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1317232110, i3, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1286)");
            }
            TextStyle copyAndSetFontPadding = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TimePickerTokens.INSTANCE.getClockDialLabelTextFont()), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float mo302toPx0680j_4 = ((Density) consume).mo302toPx0680j_4(MaxDistance);
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2307boximpl(Offset.Companion.m2334getZeroF1C5BW0()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            final String m1506numberContentDescriptionYKJpE6Y = m1506numberContentDescriptionYKJpE6Y(timePickerState.m1524getSelectionJiIwxys$material3_release(), timePickerState.is24hour(), i, startRestartGroup, (i3 << 3) & 896);
            String localString = toLocalString(i, 1);
            if (Selection.m1307equalsimpl0(timePickerState.m1524getSelectionJiIwxys$material3_release(), Selection.Companion.m1312getMinuteJiIwxys())) {
                areEqual = Intrinsics.areEqual(toLocalString(timePickerState.getMinute(), 1), localString);
            } else {
                areEqual = Intrinsics.areEqual(toLocalString(timePickerState.getHour(), 1), localString);
            }
            Alignment center = Alignment.Companion.getCenter();
            Modifier m458size3ABfNKs = SizeKt.m458size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion), MinimumInteractiveSize);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        TimePickerKt.ClockText$lambda$30(mutableState, LayoutCoordinatesKt.boundsInParent(it).m2348getCenterF1C5BW0());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier focusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(m458size3ABfNKs, (Function1) rememberedValue3), false, null, 3, null);
            final boolean z2 = areEqual;
            Modifier semantics = SemanticsModifierKt.semantics(focusable$default, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics2) {
                    Intrinsics.checkNotNullParameter(semantics2, "$this$semantics");
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final TimePickerState timePickerState2 = timePickerState;
                    final float f = mo302toPx0680j_4;
                    final boolean z3 = z;
                    final MutableState<Offset> mutableState2 = mutableState;
                    SemanticsPropertiesKt.onClick$default(semantics2, null, new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C00461(timePickerState2, f, z3, mutableState2, null), 3, null);
                            return true;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: TimePicker.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1", f = "TimePicker.kt", i = {}, l = {1318}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1  reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static final class C00461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ boolean $autoSwitchToMinute;
                            final /* synthetic */ MutableState<Offset> $center$delegate;
                            final /* synthetic */ float $maxDist;
                            final /* synthetic */ TimePickerState $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00461(TimePickerState timePickerState, float f, boolean z, MutableState<Offset> mutableState, Continuation<? super C00461> continuation) {
                                super(2, continuation);
                                this.$state = timePickerState;
                                this.$maxDist = f;
                                this.$autoSwitchToMinute = z;
                                this.$center$delegate = mutableState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00461(this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                long ClockText$lambda$29;
                                long ClockText$lambda$292;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    TimePickerState timePickerState = this.$state;
                                    ClockText$lambda$29 = TimePickerKt.ClockText$lambda$29(this.$center$delegate);
                                    float m2318getXimpl = Offset.m2318getXimpl(ClockText$lambda$29);
                                    ClockText$lambda$292 = TimePickerKt.ClockText$lambda$29(this.$center$delegate);
                                    this.label = 1;
                                    if (timePickerState.onTap$material3_release(m2318getXimpl, Offset.m2319getYimpl(ClockText$lambda$292), this.$maxDist, this.$autoSwitchToMinute, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, 1, null);
                    SemanticsPropertiesKt.setSelected(semantics2, z2);
                }
            });
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(semantics);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 859623406, "C1324@50912L76,1323@50853L198:TimePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(m1506numberContentDescriptionYKJpE6Y);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$3$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, m1506numberContentDescriptionYKJpE6Y);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue4);
            composer2 = startRestartGroup;
            TextKt.m1484Text4IGK_g(localString, clearAndSetSemantics, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, copyAndSetFontPadding, composer2, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i4) {
                TimePickerKt.ClockText(TimePickerState.this, i, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
            }
        });
    }

    public static final long ClockText$lambda$29(MutableState<Offset> mutableState) {
        return mutableState.getValue().m2328unboximpl();
    }

    public static final void ClockText$lambda$30(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m2307boximpl(j));
    }

    /* renamed from: timeInputOnChange-gIWD5Rc */
    public static final void m1507timeInputOnChangegIWD5Rc(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i2, Function1<? super TextFieldValue, Unit> function1) {
        int parseInt;
        if (Intrinsics.areEqual(textFieldValue.getText(), textFieldValue2.getText())) {
            function1.invoke(textFieldValue);
            return;
        }
        if (textFieldValue.getText().length() == 0) {
            if (Selection.m1307equalsimpl0(i, Selection.Companion.m1311getHourJiIwxys())) {
                timePickerState.setHour$material3_release(0);
            } else {
                timePickerState.setMinute$material3_release(0);
            }
            function1.invoke(TextFieldValue.m4792copy3r_uNRQ$default(textFieldValue, "", 0L, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            if (textFieldValue.getText().length() == 3 && TextRange.m4587getStartimpl(textFieldValue.m4796getSelectiond9O1mEE()) == 1) {
                parseInt = CharsKt.digitToInt(textFieldValue.getText().charAt(0));
            } else {
                parseInt = Integer.parseInt(textFieldValue.getText());
            }
            if (parseInt <= i2) {
                if (Selection.m1307equalsimpl0(i, Selection.Companion.m1311getHourJiIwxys())) {
                    timePickerState.setHour$material3_release(parseInt);
                    if (parseInt > 1 && !timePickerState.is24hour()) {
                        timePickerState.m1527setSelectioniHAOin8$material3_release(Selection.Companion.m1312getMinuteJiIwxys());
                    }
                } else {
                    timePickerState.setMinute$material3_release(parseInt);
                }
                if (textFieldValue.getText().length() > 2) {
                    textFieldValue = TextFieldValue.m4792copy3r_uNRQ$default(textFieldValue, String.valueOf(textFieldValue.getText().charAt(0)), 0L, (TextRange) null, 6, (Object) null);
                }
                function1.invoke(textFieldValue);
            }
        } catch (NumberFormatException | IllegalArgumentException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:309:? A[RETURN, SYNTHETIC] */
    /* renamed from: TimePickerTextField-lxUZ_iY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1500TimePickerTextFieldlxUZ_iY(final androidx.compose.ui.Modifier r115, final androidx.compose.ui.text.input.TextFieldValue r116, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r117, final androidx.compose.material3.TimePickerState r118, final int r119, androidx.compose.foundation.text.KeyboardOptions r120, androidx.compose.foundation.text.KeyboardActions r121, final androidx.compose.material3.TimePickerColors r122, androidx.compose.runtime.Composer r123, final int r124, final int r125) {
        /*
            Method dump skipped, instructions count: 1744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m1500TimePickerTextFieldlxUZ_iY(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: CircularLayout-uFdPcIQ */
    public static final void m1498CircularLayoutuFdPcIQ(Modifier modifier, final float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1548175696);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1502@56908L1669:TimePicker.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, i3, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1497)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo12measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, final long j) {
                    Object obj;
                    Object obj2;
                    boolean z;
                    boolean z2;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final float f2 = Layout.mo302toPx0680j_4(f);
                    long m4997copyZbe2FdA$default = Constraints.m4997copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                    List<? extends Measurable> list = measurables;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (true) {
                        boolean z3 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        Measurable measurable = (Measurable) next;
                        if ((LayoutIdKt.getLayoutId(measurable) == LayoutId.Selector || LayoutIdKt.getLayoutId(measurable) == LayoutId.InnerCircle) ? false : false) {
                            arrayList.add(next);
                        }
                    }
                    ArrayList<Measurable> arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (Measurable measurable2 : arrayList2) {
                        arrayList3.add(measurable2.mo4075measureBRTryo0(m4997copyZbe2FdA$default));
                    }
                    final ArrayList arrayList4 = arrayList3;
                    Iterator<T> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        if (LayoutIdKt.getLayoutId((Measurable) obj) == LayoutId.Selector) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            break;
                        }
                    }
                    Measurable measurable3 = (Measurable) obj;
                    Iterator<T> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it3.next();
                        if (LayoutIdKt.getLayoutId((Measurable) obj2) == LayoutId.InnerCircle) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                    Measurable measurable4 = (Measurable) obj2;
                    final float size = 6.2831855f / arrayList4.size();
                    final Placeable mo4075measureBRTryo0 = measurable3 != null ? measurable3.mo4075measureBRTryo0(m4997copyZbe2FdA$default) : null;
                    final Placeable mo4075measureBRTryo02 = measurable4 != null ? measurable4.mo4075measureBRTryo0(m4997copyZbe2FdA$default) : null;
                    return MeasureScope.layout$default(Layout, Constraints.m5008getMinWidthimpl(j), Constraints.m5007getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$measure$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Placeable placeable;
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            Placeable placeable2 = Placeable.this;
                            if (placeable2 != null) {
                                Placeable.PlacementScope.place$default(layout, placeable2, 0, 0, 0.0f, 4, null);
                            }
                            long j2 = j;
                            float f3 = f2;
                            float f4 = size;
                            Iterator it4 = arrayList4.iterator();
                            int i5 = 0;
                            while (it4.hasNext()) {
                                Object next2 = it4.next();
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                double d = f3;
                                Iterator it5 = it4;
                                double d2 = (i5 * f4) - 1.5707963267948966d;
                                Placeable.PlacementScope.place$default(layout, (Placeable) next2, MathKt.roundToInt((Math.cos(d2) * d) + ((Constraints.m5006getMaxWidthimpl(j2) / 2) - (placeable.getWidth() / 2))), MathKt.roundToInt((d * Math.sin(d2)) + ((Constraints.m5005getMaxHeightimpl(j2) / 2) - (placeable.getHeight() / 2))), 0.0f, 4, null);
                                i5 = i6;
                                it4 = it5;
                            }
                            Placeable placeable3 = mo4075measureBRTryo02;
                            if (placeable3 != null) {
                                Placeable.PlacementScope.place$default(layout, placeable3, (Constraints.m5008getMinWidthimpl(j) - mo4075measureBRTryo02.getWidth()) / 2, (Constraints.m5007getMinHeightimpl(j) - mo4075measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i6 = ((i5 << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2195constructorimpl = Updater.m2195constructorimpl(startRestartGroup);
            Updater.m2202setimpl(m2195constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2202setimpl(m2195constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2202setimpl(m2195constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2202setimpl(m2195constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2186boximpl(SkippableUpdater.m2187constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i6 >> 3) & androidx.appcompat.R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                TimePickerKt.m1498CircularLayoutuFdPcIQ(Modifier.this, f, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* renamed from: numberContentDescription-YKJpE6Y */
    public static final String m1506numberContentDescriptionYKJpE6Y(int i, boolean z, int i2, Composer composer, int i3) {
        int m1387getTimePickerHourSuffixadMyvUU;
        ComposerKt.sourceInformationMarkerStart(composer, 1826155772, "C(numberContentDescription)P(2:c#material3.Selection)1555@58952L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1826155772, i3, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1542)");
        }
        if (Selection.m1307equalsimpl0(i, Selection.Companion.m1312getMinuteJiIwxys())) {
            m1387getTimePickerHourSuffixadMyvUU = Strings.Companion.m1391getTimePickerMinuteSuffixadMyvUU();
        } else if (z) {
            m1387getTimePickerHourSuffixadMyvUU = Strings.Companion.m1383getTimePicker24HourSuffixadMyvUU();
        } else {
            m1387getTimePickerHourSuffixadMyvUU = Strings.Companion.m1387getTimePickerHourSuffixadMyvUU();
        }
        String m1398getStringiSCLEhQ = Strings_androidKt.m1398getStringiSCLEhQ(m1387getTimePickerHourSuffixadMyvUU, new Object[]{Integer.valueOf(i2)}, composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1398getStringiSCLEhQ;
    }

    public static final Pair<Float, Float> valuesForAnimation(float f, float f2) {
        if (Math.abs(f - f2) <= 3.141592653589793d) {
            return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
        }
        double d = f;
        if (d > 3.141592653589793d && f2 < 3.141592653589793d) {
            f2 += FullCircle;
        } else if (d < 3.141592653589793d && f2 > 3.141592653589793d) {
            f += FullCircle;
        }
        return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
    }

    public static final float dist(float f, float f2, int i, int i2) {
        return (float) Math.hypot(i - f, i2 - f2);
    }

    public static final float atan(float f, float f2) {
        float atan2 = ((float) Math.atan2(f, f2)) - 1.5707964f;
        return atan2 < 0.0f ? atan2 + FullCircle : atan2;
    }

    private static final Modifier visible(Modifier modifier, final boolean z) {
        return modifier.then(new VisibleModifier(z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("visible");
                inspectorInfo.getProperties().set("visible", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final String toLocalString(int i, int i2) {
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        integerInstance.setGroupingUsed(false);
        integerInstance.setMinimumIntegerDigits(i2);
        String format = integerInstance.format(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    public static final Modifier clockDial(Modifier modifier, final TimePickerState timePickerState, boolean z) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$clockDial$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("clockDial");
                inspectorInfo.getProperties().set("state", TimePickerState.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new TimePickerKt$clockDial$2(timePickerState, z));
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float f = 24;
        ClockFaceBottomMargin = Dp.m5050constructorimpl(f);
        DisplaySeparatorWidth = Dp.m5050constructorimpl(f);
        TimeInputBottomPadding = Dp.m5050constructorimpl(f);
        List<Integer> listOf = CollectionsKt.listOf((Object[]) new Integer[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        Hours = listOf;
        List<Integer> list = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Number number : list) {
            arrayList.add(Integer.valueOf((number.intValue() % 12) + 12));
        }
        ExtraHours = arrayList;
        PeriodToggleMargin = Dp.m5050constructorimpl(12);
    }
}
