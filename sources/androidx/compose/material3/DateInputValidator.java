package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "stateData", "Landroidx/compose/material3/StateData;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "validate", "calendarDate", "Landroidx/compose/material3/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "validate-XivgLIo", "(Landroidx/compose/material3/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateInputValidator {
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final Function1<Long, Boolean> dateValidator;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final StateData stateData;

    /* JADX WARN: Multi-variable type inference failed */
    public DateInputValidator(StateData stateData, DateInputFormat dateInputFormat, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> dateValidator, String errorDatePattern, String errorDateOutOfYearRange, String errorInvalidNotAllowed, String errorInvalidRangeInput) {
        Intrinsics.checkNotNullParameter(stateData, "stateData");
        Intrinsics.checkNotNullParameter(dateInputFormat, "dateInputFormat");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(dateValidator, "dateValidator");
        Intrinsics.checkNotNullParameter(errorDatePattern, "errorDatePattern");
        Intrinsics.checkNotNullParameter(errorDateOutOfYearRange, "errorDateOutOfYearRange");
        Intrinsics.checkNotNullParameter(errorInvalidNotAllowed, "errorInvalidNotAllowed");
        Intrinsics.checkNotNullParameter(errorInvalidRangeInput, "errorInvalidRangeInput");
        this.stateData = stateData;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = dateFormatter;
        this.dateValidator = dateValidator;
        this.errorDatePattern = errorDatePattern;
        this.errorDateOutOfYearRange = errorDateOutOfYearRange;
        this.errorInvalidNotAllowed = errorInvalidNotAllowed;
        this.errorInvalidRangeInput = errorInvalidRangeInput;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d4, code lost:
        if (r0 < (r14 != null ? r14.getUtcTimeMillis() : Long.MAX_VALUE)) goto L24;
     */
    /* renamed from: validate-XivgLIo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m1065validateXivgLIo(androidx.compose.material3.CalendarDate r12, int r13, java.util.Locale r14) {
        /*
            r11 = this;
            java.lang.String r0 = "locale"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "format(this, *args)"
            r1 = 0
            r2 = 1
            if (r12 != 0) goto L2f
            java.lang.String r12 = r11.errorDatePattern
            java.lang.Object[] r13 = new java.lang.Object[r2]
            androidx.compose.material3.DateInputFormat r14 = r11.dateInputFormat
            java.lang.String r14 = r14.getPatternWithDelimiters()
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r14 = r14.toUpperCase(r3)
            java.lang.String r3 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)
            r13[r1] = r14
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r2)
            java.lang.String r12 = java.lang.String.format(r12, r13)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            return r12
        L2f:
            androidx.compose.material3.StateData r3 = r11.stateData
            kotlin.ranges.IntRange r3 = r3.getYearRange()
            int r4 = r12.getYear()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L70
            java.lang.String r12 = r11.errorDateOutOfYearRange
            r13 = 2
            java.lang.Object[] r14 = new java.lang.Object[r13]
            androidx.compose.material3.StateData r3 = r11.stateData
            kotlin.ranges.IntRange r3 = r3.getYearRange()
            int r3 = r3.getFirst()
            java.lang.String r3 = androidx.compose.material3.DatePickerKt.toLocalString(r3)
            r14[r1] = r3
            androidx.compose.material3.StateData r1 = r11.stateData
            kotlin.ranges.IntRange r1 = r1.getYearRange()
            int r1 = r1.getLast()
            java.lang.String r1 = androidx.compose.material3.DatePickerKt.toLocalString(r1)
            r14[r2] = r1
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r14, r13)
            java.lang.String r12 = java.lang.String.format(r12, r13)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            return r12
        L70:
            kotlin.jvm.functions.Function1<java.lang.Long, java.lang.Boolean> r3 = r11.dateValidator
            long r4 = r12.getUtcTimeMillis()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r3 = r3.invoke(r4)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto Laa
            java.lang.String r13 = r11.errorInvalidNotAllowed
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.material3.DatePickerFormatter r4 = r11.dateFormatter
            androidx.compose.material3.StateData r5 = r11.stateData
            androidx.compose.material3.CalendarModel r6 = r5.getCalendarModel()
            r8 = 0
            r9 = 8
            r10 = 0
            r5 = r12
            r7 = r14
            java.lang.String r12 = androidx.compose.material3.DatePickerFormatter.formatDate$material3_release$default(r4, r5, r6, r7, r8, r9, r10)
            r3[r1] = r12
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r3, r2)
            java.lang.String r12 = java.lang.String.format(r13, r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            return r12
        Laa:
            androidx.compose.material3.InputIdentifier$Companion r14 = androidx.compose.material3.InputIdentifier.Companion
            int r14 = r14.m1185getStartDateInputJ2x2o4M()
            boolean r14 = androidx.compose.material3.InputIdentifier.m1179equalsimpl0(r13, r14)
            if (r14 == 0) goto Ld6
            long r0 = r12.getUtcTimeMillis()
            androidx.compose.material3.StateData r14 = r11.stateData
            androidx.compose.runtime.MutableState r14 = r14.getSelectedEndDate()
            java.lang.Object r14 = r14.getValue()
            androidx.compose.material3.CalendarDate r14 = (androidx.compose.material3.CalendarDate) r14
            if (r14 == 0) goto Lcd
            long r2 = r14.getUtcTimeMillis()
            goto Ld2
        Lcd:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        Ld2:
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 >= 0) goto Lff
        Ld6:
            androidx.compose.material3.InputIdentifier$Companion r14 = androidx.compose.material3.InputIdentifier.Companion
            int r14 = r14.m1183getEndDateInputJ2x2o4M()
            boolean r13 = androidx.compose.material3.InputIdentifier.m1179equalsimpl0(r13, r14)
            if (r13 == 0) goto L102
            long r12 = r12.getUtcTimeMillis()
            androidx.compose.material3.StateData r14 = r11.stateData
            androidx.compose.runtime.MutableState r14 = r14.getSelectedStartDate()
            java.lang.Object r14 = r14.getValue()
            androidx.compose.material3.CalendarDate r14 = (androidx.compose.material3.CalendarDate) r14
            if (r14 == 0) goto Lf9
            long r0 = r14.getUtcTimeMillis()
            goto Lfb
        Lf9:
            r0 = -9223372036854775808
        Lfb:
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 > 0) goto L102
        Lff:
            java.lang.String r12 = r11.errorInvalidRangeInput
            return r12
        L102:
            java.lang.String r12 = ""
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m1065validateXivgLIo(androidx.compose.material3.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}
