package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b#\b \u0018\u0000 \u0092\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004\u0092\u0002\u0093\u0002B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020\u000e2\u0007\u0010\u0087\u0001\u001a\u00020 H\u0002J,\u0010\u0084\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00002\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J \u0010\u008c\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0013\u0010\u008f\u0001\u001a\u00020D2\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H&J*\u0010\u0092\u0001\u001a\u00020\u001a2\b\u0010\u0093\u0001\u001a\u00030\u0088\u00012\u0006\u0010N\u001a\u00020OH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0010\u0010\u0096\u0001\u001a\u00020\u00072\u0007\u0010\u0097\u0001\u001a\u00020\u0006J\u001c\u0010\u0098\u0001\u001a\u00020\u00072\u0007\u0010\u0097\u0001\u001a\u00020\u00062\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0004J\u0012\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u0097\u0001\u001a\u00020\u0006H\u0002J\u0018\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u009e\u0001J\"\u0010\u009f\u0001\u001a\u00030\u0088\u00012\u0007\u0010`\u001a\u00030\u0088\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010\u008e\u0001J\u001b\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0087\u0001\u001a\u00020 H\u0002J$\u0010£\u0001\u001a\u00020 2\f\u0010¤\u0001\u001a\u0007\u0012\u0002\b\u00030¥\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J6\u0010¨\u0001\u001a\u0005\u0018\u0001H©\u0001\"\u0007\b\u0000\u0010©\u0001\u0018\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010¥\u0001H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J\u0014\u0010¬\u0001\u001a\u0004\u0018\u00010u2\u0007\u0010\u00ad\u0001\u001a\u00020 H\u0002J1\u0010®\u0001\u001a\u0005\u0018\u0001H©\u0001\"\u0005\b\u0000\u0010©\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010¥\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¯\u0001\u0010«\u0001J`\u0010°\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0093\u0001\u001a\u00030\u0088\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¸\u0001\u0010¹\u0001Jb\u0010º\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0093\u0001\u001a\u00030\u0088\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¹\u0001J\t\u0010¼\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010½\u0001\u001a\u00020\u00072\u0007\u0010\u0097\u0001\u001a\u00020\u0006H\u0096\u0002J\"\u0010¾\u0001\u001a\u00020 2\b\u0010\u0093\u0001\u001a\u00030\u0088\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0007\u0010Á\u0001\u001a\u00020 J\u001c\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020\u00032\u0007\u0010\u0087\u0001\u001a\u00020 H\u0016J,\u0010Å\u0001\u001a\u00030\u0088\u00012\u0007\u0010Ä\u0001\u001a\u00020\u00032\b\u0010Æ\u0001\u001a\u00030\u0088\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÇ\u0001\u0010È\u0001J#\u0010É\u0001\u001a\u00030\u0088\u00012\b\u0010Ê\u0001\u001a\u00030\u0088\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u008e\u0001J#\u0010Ì\u0001\u001a\u00030\u0088\u00012\b\u0010Ê\u0001\u001a\u00030\u0088\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010\u008e\u0001J#\u0010Î\u0001\u001a\u00030\u0088\u00012\b\u0010\u0093\u0001\u001a\u00030\u0088\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÏ\u0001\u0010\u008e\u0001J/\u0010Ð\u0001\u001a\u00020\u00072\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\t\b\u0002\u0010Ñ\u0001\u001a\u00020 H\u0002J\t\u0010Ò\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010Ó\u0001\u001a\u00020\u0007J\u001b\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Õ\u0001\u001a\u00020T2\u0007\u0010Ö\u0001\u001a\u00020TH\u0014J\u0007\u0010×\u0001\u001a\u00020\u0007J\u0007\u0010Ø\u0001\u001a\u00020\u0007J\u0007\u0010Ù\u0001\u001a\u00020\u0007J\u0012\u0010Ú\u0001\u001a\u00020\u00072\u0007\u0010\u0097\u0001\u001a\u00020\u0006H\u0016J6\u0010Û\u0001\u001a\u00030Ü\u00012\u0007\u0010Ý\u0001\u001a\u00020-2\u000e\u0010Þ\u0001\u001a\t\u0012\u0005\u0012\u00030Ü\u00010$H\u0084\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bß\u0001\u0010à\u0001JD\u0010á\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020_2\u0007\u0010\u0080\u0001\u001a\u00020\u001a2\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u001d\u0010ä\u0001\u001a\u00020\u00072\b\u0010\u0086\u0001\u001a\u00030Ã\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010å\u0001J,\u0010æ\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000e2\u0007\u0010\u0087\u0001\u001a\u00020 2\t\b\u0002\u0010ç\u0001\u001a\u00020 H\u0000¢\u0006\u0003\bè\u0001J\u000f\u0010é\u0001\u001a\u00020\u0007H\u0010¢\u0006\u0003\bê\u0001J\u0007\u0010ë\u0001\u001a\u00020 J\"\u0010ì\u0001\u001a\u00030\u0088\u00012\u0007\u0010`\u001a\u00030\u0088\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bí\u0001\u0010\u008e\u0001J\b\u0010î\u0001\u001a\u00030Ã\u0001J+\u0010ï\u0001\u001a\u00020\u00072\u0007\u0010Ä\u0001\u001a\u00020\u00032\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J+\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ö\u0001J+\u0010÷\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00002\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bø\u0001\u0010ö\u0001J-\u0010ù\u0001\u001a\u00020\u00072\u0019\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\t\b\u0002\u0010Ñ\u0001\u001a\u00020 J\t\u0010ú\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010û\u0001\u001a\u00020\u00072\u0006\u0010E\u001a\u00020DH\u0004J\u001b\u0010ü\u0001\u001a\u00020\u00072\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0000¢\u0006\u0003\bý\u0001JL\u0010þ\u0001\u001a\u00020\u0007\"\u0007\b\u0000\u0010©\u0001\u0018\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010¥\u00012\u0014\u0010Þ\u0001\u001a\u000f\u0012\u0005\u0012\u0003H©\u0001\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J4\u0010þ\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0002\u001a\u00020T2\u0007\u0010\u00ad\u0001\u001a\u00020 2\u0013\u0010Þ\u0001\u001a\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0003J#\u0010\u0082\u0002\u001a\u00030\u0088\u00012\b\u0010\u0083\u0002\u001a\u00030\u0088\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0084\u0002\u0010\u008e\u0001J+\u0010\u0085\u0002\u001a\u00020\u00072\u0007\u0010\u0097\u0001\u001a\u00020\u00062\u0013\u0010Þ\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0084\bø\u0001\u0003J\"\u0010\u0086\u0002\u001a\u00020 2\b\u0010\u0093\u0001\u001a\u00030\u0088\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0087\u0002\u0010À\u0001Ji\u0010\u0088\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u0001*\u0005\u0018\u0001H©\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0093\u0001\u001a\u00030\u0088\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002Jr\u0010\u008b\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u0001*\u0005\u0018\u0001H©\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0093\u0001\u001a\u00030\u0088\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 2\u0007\u0010\u008c\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0002\u0010\u008e\u0002Jr\u0010\u008f\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010©\u0001*\u00030±\u0001*\u0005\u0018\u0001H©\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010³\u00012\b\u0010\u0093\u0001\u001a\u00030\u0088\u00012\u000f\u0010´\u0001\u001a\n\u0012\u0005\u0012\u0003H©\u00010µ\u00012\u0007\u0010¶\u0001\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020 2\u0007\u0010\u008c\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0090\u0002\u0010\u008e\u0002J\r\u0010\u0091\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u000e\u0010(\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020 @BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u001d\u0010,\u001a\u00020-8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b.\u0010/R\"\u00101\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u000100@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103RD\u00106\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b52\u0019\u0010)\u001a\u0015\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b5@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\"\u0010E\u001a\u0004\u0018\u00010D2\b\u0010)\u001a\u0004\u0018\u00010D@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR$\u0010I\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020O8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bP\u0010/R\u001c\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010U\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0015R\u0013\u0010W\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bX\u0010\u0018R\u0016\u0010Y\u001a\u0004\u0018\u00010Z8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0013\u0010]\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b^\u0010\u0018R/\u0010`\u001a\u00020_2\u0006\u0010)\u001a\u00020_@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\ba\u0010/\"\u0004\bb\u0010cR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020S0f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u00020n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bo\u0010/R\u0014\u0010p\u001a\u00020q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0012\u0010t\u001a\u00020uX¦\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001c\u0010}\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010z\"\u0004\b\u007f\u0010|R(\u0010\u0080\u0001\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u001c\"\u0006\b\u0082\u0001\u0010\u0083\u0001\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u0094\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate$ui_release", "()Landroidx/compose/ui/node/LookaheadDelegate;", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "createLookaheadDelegate", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "T", "head-H91voCI", "(I)Ljava/lang/Object;", "headNode", "includeTail", "headUnchecked", "headUnchecked-H91voCI", "hitTest", "Landroidx/compose/ui/node/DelegatableNode;", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onLayerBlockUpdated", "forceLayerInvalidated", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerBlock", "updateLayerParameters", "updateLookaheadDelegate", "updateLookaheadScope", "updateLookaheadScope$ui_release", "visitNodes", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function0<Unit> invalidateParentLayer;
    private boolean isClipping;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private LookaheadDelegate lookaheadDelegate;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;
    public static final Companion Companion = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator coordinator) {
            LayerPositionalProperties layerPositionalProperties;
            LayerPositionalProperties layerPositionalProperties2;
            LayerPositionalProperties layerPositionalProperties3;
            Intrinsics.checkNotNullParameter(coordinator, "coordinator");
            if (coordinator.isValidOwnerScope()) {
                layerPositionalProperties = coordinator.layerPositionalProperties;
                if (layerPositionalProperties == null) {
                    coordinator.updateLayerParameters();
                    return;
                }
                layerPositionalProperties2 = NodeCoordinator.tmpLayerPositionalProperties;
                layerPositionalProperties2.copyFrom(layerPositionalProperties);
                coordinator.updateLayerParameters();
                layerPositionalProperties3 = NodeCoordinator.tmpLayerPositionalProperties;
                if (layerPositionalProperties3.hasSameValuesAs(layerPositionalProperties)) {
                    return;
                }
                LayoutNode layoutNode = coordinator.getLayoutNode();
                LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                if (layoutDelegate$ui_release.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if (layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                }
                Owner owner$ui_release = layoutNode.getOwner$ui_release();
                if (owner$ui_release != null) {
                    owner$ui_release.requestOnPositionedCallback(layoutNode);
                }
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator coordinator) {
            Intrinsics.checkNotNullParameter(coordinator, "coordinator");
            OwnedLayer layer = coordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m2780constructorimpl$default(null, 1, null);
    private static final HitTestSource<PointerInputModifierNode> PointerInputSource = new HitTestSource<PointerInputModifierNode>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(PointerInputModifierNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return node.interceptOutOfBoundsChildEvents();
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
        public void mo4272childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult<PointerInputModifierNode> hitTestResult, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m4204hitTestM_7yMNQ$ui_release(j, hitTestResult, z, z2);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        public int mo4273entityTypeOLwlOKw() {
            return NodeKind.m4277constructorimpl(16);
        }
    };
    private static final HitTestSource<SemanticsModifierNode> SemanticsSource = new HitTestSource<SemanticsModifierNode>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(SemanticsModifierNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration collapsedSemanticsConfiguration;
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(parentLayoutNode);
            boolean z = false;
            if (outerSemantics != null && (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) != null && collapsedSemanticsConfiguration.isClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI */
        public void mo4272childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult<SemanticsModifierNode> hitTestResult, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m4205hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z, z2);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo4273entityTypeOLwlOKw() {
            return NodeKind.m4277constructorimpl(8);
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H&ø\u0001\u0003\u0082\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "N", "Landroidx/compose/ui/node/DelegatableNode;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface HitTestSource<N extends DelegatableNode> {
        /* renamed from: childHitTest-YqVAtuI */
        void mo4272childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult<N> hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw */
        int mo4273entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(N n);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public abstract LookaheadDelegate createLookaheadDelegate(LookaheadScope lookaheadScope);

    public abstract Modifier.Node getTail();

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
        invoke2(canvas);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.Companion.m5178getZeronOccac();
        this.invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
                NodeCoordinator wrappedBy$ui_release = NodeCoordinator.this.getWrappedBy$ui_release();
                if (wrappedBy$ui_release != null) {
                    wrappedBy$ui_release.invalidateLayer();
                }
            }
        };
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null && (tail = nodeCoordinator.getTail()) != null) {
                return tail.getChild$ui_release();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    public final void visitNodes(int i, boolean z, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Modifier.Node tail = getTail();
        if (!z && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(z); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                block.invoke(headNode);
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ  reason: not valid java name */
    public final /* synthetic */ <T> void m4270visitNodesaLcG6gQ(int i, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean m4285getIncludeSelfInTraversalH91voCI = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!m4285getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m4285getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, "T");
                if (headNode instanceof Object) {
                    block.invoke(headNode);
                }
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: hasNode-H91voCI  reason: not valid java name */
    public final boolean m4262hasNodeH91voCI(int i) {
        Modifier.Node headNode = headNode(NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(i));
        return headNode != null && DelegatableNodeKt.m4177has64DMado(headNode, i);
    }

    /* renamed from: head-H91voCI  reason: not valid java name */
    public final /* synthetic */ <T> T m4263headH91voCI(int i) {
        boolean m4285getIncludeSelfInTraversalH91voCI = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!m4285getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        for (Modifier.Node headNode = headNode(m4285getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(2, "T");
                return (T) headNode;
            } else if (headNode == tail) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: headUnchecked-H91voCI  reason: not valid java name */
    public final <T> T m4264headUncheckedH91voCI(int i) {
        boolean m4285getIncludeSelfInTraversalH91voCI = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!m4285getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        for (Modifier.Node headNode = headNode(m4285getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                return (T) headNode;
            }
            if (headNode == tail) {
                return null;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo4080getSizeYbymL2g() {
        return m4119getMeasuredSizeYbymL2g();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer == null || this.lastLayerAlpha > 0.0f) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                return nodeCoordinator.isTransparent();
            }
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo4076placeAtf8xVGno(mo4226getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return !this.released && getLayoutNode().isAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MeasureResult measureResult = this._measureResult;
        if (value != measureResult) {
            this._measureResult = value;
            if (measureResult == null || value.getWidth() != measureResult.getWidth() || value.getHeight() != measureResult.getHeight()) {
                onMeasureResultChanged(value.getWidth(), value.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!value.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual(value.getAlignmentLines(), this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                LinkedHashMap linkedHashMap = this.oldAlignmentLines;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    this.oldAlignmentLines = linkedHashMap;
                }
                linkedHashMap.clear();
                linkedHashMap.putAll(value.getAlignmentLines());
            }
        }
    }

    public final LookaheadDelegate getLookaheadDelegate$ui_release() {
        return this.lookaheadDelegate;
    }

    public final void updateLookaheadScope$ui_release(LookaheadScope lookaheadScope) {
        LookaheadDelegate lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate2 = null;
        if (lookaheadScope != null) {
            LookaheadDelegate lookaheadDelegate3 = this.lookaheadDelegate;
            if (!Intrinsics.areEqual(lookaheadScope, lookaheadDelegate3 != null ? lookaheadDelegate3.getLookaheadScope() : null)) {
                lookaheadDelegate = createLookaheadDelegate(lookaheadScope);
            } else {
                lookaheadDelegate = this.lookaheadDelegate;
            }
            lookaheadDelegate2 = lookaheadDelegate;
        }
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void updateLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z = true;
            }
            if (z) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? SetsKt.emptySet() : linkedHashSet;
    }

    protected void onMeasureResultChanged(int i, int i2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo4322resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
        m4121setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        graphicsLayerScope.m2858setSizeuvyYCjk(IntSizeKt.m5220toSizeozmzZPI(m4119getMeasuredSizeYbymL2g()));
        int m4277constructorimpl = NodeKind.m4277constructorimpl(4);
        boolean m4285getIncludeSelfInTraversalH91voCI = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(m4277constructorimpl);
        Modifier.Node tail = getTail();
        if (!m4285getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode = headNode(m4285getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m4277constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & m4277constructorimpl) != 0 && (headNode instanceof DrawModifierNode)) {
                ((DrawModifierNode) headNode).onMeasureResultChanged();
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac */
    public long mo4226getPositionnOccac() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    protected void m4268setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.Object] */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Modifier.Node tail = getTail();
        if (getLayoutNode().getNodes$ui_release().m4240hasH91voCI$ui_release(NodeKind.m4277constructorimpl(64))) {
            Density density = getLayoutNode().getDensity();
            for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if (tail$ui_release != tail) {
                    if (((NodeKind.m4277constructorimpl(64) & tail$ui_release.getKindSet$ui_release()) != 0) && (tail$ui_release instanceof ParentDataModifierNode)) {
                        objectRef.element = ((ParentDataModifierNode) tail$ui_release).modifyParentData(density, objectRef.element);
                    }
                }
            }
        }
        return objectRef.element;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        return this.wrappedBy;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect == null) {
            MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
            this._rectCache = mutableRect2;
            return mutableRect2;
        }
        return mutableRect;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: getLastMeasurementConstraints-msEJaDk$ui_release  reason: not valid java name */
    public final long m4260getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m4120getMeasurementConstraintsmsEJaDk();
    }

    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    protected final Placeable m4267performingMeasureK40F9xA(long j, Function0<? extends Placeable> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m4122setMeasurementConstraintsBRTryo0(j);
        Placeable invoke = block.invoke();
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.mo4322resizeozmzZPI(m4119getMeasuredSizeYbymL2g());
        }
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo4076placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        onLayerBlockUpdated$default(this, function1, false, 2, null);
        if (!IntOffset.m5167equalsimpl0(mo4226getPositionnOccac(), j)) {
            m4268setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo4321movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float m5168getXimpl = IntOffset.m5168getXimpl(mo4226getPositionnOccac());
        float m5169getYimpl = IntOffset.m5169getYimpl(mo4226getPositionnOccac());
        canvas.translate(m5168getXimpl, m5169getYimpl);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-m5168getXimpl, -m5169getYimpl);
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public final void onPlaced() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (lookaheadDelegate != null) {
            int m4277constructorimpl = NodeKind.m4277constructorimpl(128);
            boolean m4285getIncludeSelfInTraversalH91voCI = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(m4277constructorimpl);
            Modifier.Node tail = getTail();
            if (m4285getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
                for (Modifier.Node headNode = headNode(m4285getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m4277constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
                    if ((headNode.getKindSet$ui_release() & m4277constructorimpl) != 0 && (headNode instanceof LayoutAwareModifierNode)) {
                        ((LayoutAwareModifierNode) headNode).onLookaheadPlaced(lookaheadDelegate.getLookaheadLayoutCoordinates());
                    }
                    if (headNode == tail) {
                        break;
                    }
                }
            }
        }
        int m4277constructorimpl2 = NodeKind.m4277constructorimpl(128);
        boolean m4285getIncludeSelfInTraversalH91voCI2 = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(m4277constructorimpl2);
        Modifier.Node tail2 = getTail();
        if (!m4285getIncludeSelfInTraversalH91voCI2 && (tail2 = tail2.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode2 = headNode(m4285getIncludeSelfInTraversalH91voCI2); headNode2 != null && (headNode2.getAggregateChildKindSet$ui_release() & m4277constructorimpl2) != 0; headNode2 = headNode2.getChild$ui_release()) {
            if ((headNode2.getKindSet$ui_release() & m4277constructorimpl2) != 0 && (headNode2 instanceof LayoutAwareModifierNode)) {
                ((LayoutAwareModifierNode) headNode2).onPlaced(this);
            }
            if (headNode2 == tail2) {
                return;
            }
        }
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public void invoke2(final Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayoutNode().isPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invoke$1
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
                    NodeCoordinator.this.drawContainedDrawModifiers(canvas);
                }
            });
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.lastLayerDrawingWasSkipped = true;
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(function1, z);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> function1, boolean z) {
        boolean z2 = this.layerBlock != function1 || z;
        this.layerBlock = function1;
        onLayerBlockUpdated(function1, z2);
    }

    static /* synthetic */ void onLayerBlockUpdated$default(NodeCoordinator nodeCoordinator, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLayerBlockUpdated");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.onLayerBlockUpdated(function1, z);
    }

    private final void onLayerBlockUpdated(Function1<? super GraphicsLayerScope, Unit> function1, boolean z) {
        Owner owner$ui_release;
        boolean z2 = (this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, getLayoutNode().getDensity()) && this.layerLayoutDirection == getLayoutNode().getLayoutDirection() && !z) ? false : true;
        this.layerBlock = function1;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        if (isAttached() && function1 != null) {
            if (this.layer != null) {
                if (z2) {
                    updateLayerParameters();
                    return;
                }
                return;
            }
            OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this, this.invalidateParentLayer);
            createLayer.mo4322resizeozmzZPI(m4119getMeasuredSizeYbymL2g());
            createLayer.mo4321movegyyYBs(mo4226getPositionnOccac());
            this.layer = createLayer;
            updateLayerParameters();
            getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
            reusableGraphicsLayerScope.m2858setSizeuvyYCjk(IntSizeKt.m5220toSizeozmzZPI(mo4080getSizeYbymL2g()));
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope2;
                    Function1<GraphicsLayerScope, Unit> function12 = function1;
                    reusableGraphicsLayerScope2 = NodeCoordinator.graphicsLayerScope;
                    function12.invoke(reusableGraphicsLayerScope2);
                }
            });
            LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
            if (layerPositionalProperties == null) {
                layerPositionalProperties = new LayerPositionalProperties();
                this.layerPositionalProperties = layerPositionalProperties;
            }
            layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
            ownedLayer.mo4324updateLayerPropertiesdDxrwY(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.mo2740getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getClip(), reusableGraphicsLayerScope.getRenderEffect(), reusableGraphicsLayerScope.mo2736getAmbientShadowColor0d7_KjU(), reusableGraphicsLayerScope.mo2739getSpotShadowColor0d7_KjU(), reusableGraphicsLayerScope.mo2737getCompositingStrategyNrFUSI(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
            this.isClipping = reusableGraphicsLayerScope.getClip();
        } else {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.layer != null && isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m4261getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo303toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo4208getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: hitTest-YqVAtuI  reason: not valid java name */
    public final <T extends DelegatableNode> void m4265hitTestYqVAtuI(HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        DelegatableNode delegatableNode = (DelegatableNode) m4264headUncheckedH91voCI(hitTestSource.mo4273entityTypeOLwlOKw());
        boolean z3 = true;
        if (!m4271withinLayerBoundsk4lQ0M(j)) {
            if (z) {
                float m4258distanceInMinimumTouchTargettz77jQw = m4258distanceInMinimumTouchTargettz77jQw(j, m4261getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(m4258distanceInMinimumTouchTargettz77jQw) || Float.isNaN(m4258distanceInMinimumTouchTargettz77jQw)) {
                    z3 = false;
                }
                if (z3 && hitTestResult.isHitInMinimumTouchTargetBetter(m4258distanceInMinimumTouchTargettz77jQw, false)) {
                    m4252hitNearJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, false, m4258distanceInMinimumTouchTargettz77jQw);
                }
            }
        } else if (delegatableNode == null) {
            mo4199hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (m4266isPointerInBoundsk4lQ0M(j)) {
            m4251hit1hIXUjU(delegatableNode, hitTestSource, j, hitTestResult, z, z2);
        } else {
            float m4258distanceInMinimumTouchTargettz77jQw2 = !z ? Float.POSITIVE_INFINITY : m4258distanceInMinimumTouchTargettz77jQw(j, m4261getMinimumTouchTargetSizeNHjbRc());
            if (Float.isInfinite(m4258distanceInMinimumTouchTargettz77jQw2) || Float.isNaN(m4258distanceInMinimumTouchTargettz77jQw2)) {
                z3 = false;
            }
            if (z3 && hitTestResult.isHitInMinimumTouchTargetBetter(m4258distanceInMinimumTouchTargettz77jQw2, z2)) {
                m4252hitNearJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, z2, m4258distanceInMinimumTouchTargettz77jQw2);
            } else {
                m4254speculativeHitJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, z2, m4258distanceInMinimumTouchTargettz77jQw2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU  reason: not valid java name */
    public final <T extends DelegatableNode> void m4251hit1hIXUjU(final T t, final HitTestSource<T> hitTestSource, final long j, final HitTestResult<T> hitTestResult, final boolean z, final boolean z2) {
        if (t == null) {
            mo4199hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(t, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/NodeCoordinator;TT;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource<TT;>;JLandroidx/compose/ui/node/HitTestResult<TT;>;ZZ)V */
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
                    Object m4275nextUncheckedUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m4275nextUncheckedUntilhw7D004 = NodeCoordinatorKt.m4275nextUncheckedUntilhw7D004(t, hitTestSource.mo4273entityTypeOLwlOKw(), NodeKind.m4277constructorimpl(2));
                    nodeCoordinator.m4251hit1hIXUjU((DelegatableNode) m4275nextUncheckedUntilhw7D004, hitTestSource, j, hitTestResult, z, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m4252hitNearJHbHoSQ(final T t, final HitTestSource<T> hitTestSource, final long j, final HitTestResult<T> hitTestResult, final boolean z, final boolean z2, final float f) {
        if (t == null) {
            mo4199hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(t, f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/NodeCoordinator;TT;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource<TT;>;JLandroidx/compose/ui/node/HitTestResult<TT;>;ZZF)V */
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
                    Object m4275nextUncheckedUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m4275nextUncheckedUntilhw7D004 = NodeCoordinatorKt.m4275nextUncheckedUntilhw7D004(t, hitTestSource.mo4273entityTypeOLwlOKw(), NodeKind.m4277constructorimpl(2));
                    nodeCoordinator.m4252hitNearJHbHoSQ((DelegatableNode) m4275nextUncheckedUntilhw7D004, hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: speculativeHit-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m4254speculativeHitJHbHoSQ(final T t, final HitTestSource<T> hitTestSource, final long j, final HitTestResult<T> hitTestResult, final boolean z, final boolean z2, final float f) {
        if (t == null) {
            mo4199hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(t)) {
            hitTestResult.speculativeHit(t, f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/NodeCoordinator;TT;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource<TT;>;JLandroidx/compose/ui/node/HitTestResult<TT;>;ZZF)V */
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
                    Object m4275nextUncheckedUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m4275nextUncheckedUntilhw7D004 = NodeCoordinatorKt.m4275nextUncheckedUntilhw7D004(t, hitTestSource.mo4273entityTypeOLwlOKw(), NodeKind.m4277constructorimpl(2));
                    nodeCoordinator.m4254speculativeHitJHbHoSQ((DelegatableNode) m4275nextUncheckedUntilhw7D004, hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        } else {
            m4254speculativeHitJHbHoSQ((DelegatableNode) NodeCoordinatorKt.m4274access$nextUncheckedUntilhw7D004(t, hitTestSource.mo4273entityTypeOLwlOKw(), NodeKind.m4277constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
        }
    }

    /* renamed from: hitTestChild-YqVAtuI */
    public <T extends DelegatableNode> void mo4199hitTestChildYqVAtuI(HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m4265hitTestYqVAtuI(hitTestSource, nodeCoordinator.m4259fromParentPositionMKHz9U(j), hitTestResult, z, z2);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long m4257calculateMinimumTouchTargetPaddingE7KxVPU = m4257calculateMinimumTouchTargetPaddingE7KxVPU(m4261getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m2387getWidthimpl(m4257calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m2384getHeightimpl(m4257calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m2387getWidthimpl(m4257calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m2384getHeightimpl(m4257calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo4085windowToLocalMKHz9U(long j) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo4081localPositionOfR5De75A(findRootCoordinates, Offset.m2322minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo4325calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo4083localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo4326calculatePositionInWindowMKHz9U(mo4082localToRootMKHz9U(j));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) layoutCoordinates : null;
        if (lookaheadLayoutCoordinatesImpl == null || (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) == null) {
            Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
            return (NodeCoordinator) layoutCoordinates;
        }
        return coordinator;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo4081localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long j) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            j = coordinator.m4269toParentPositionMKHz9U(j);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m4250ancestorToLocalR5De75A(findCommonAncestor$ui_release, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo4084transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m2789resetimpl(matrix);
        coordinator.m4256transformToAncestorEL8BTi8(findCommonAncestor$ui_release, matrix);
        m4255transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, matrix);
    }

    /* renamed from: transformToAncestor-EL8BTi8  reason: not valid java name */
    private final void m4256transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.mo4323transform58bKbWc(fArr);
            }
            long mo4226getPositionnOccac = nodeCoordinator2.mo4226getPositionnOccac();
            if (!IntOffset.m5167equalsimpl0(mo4226getPositionnOccac, IntOffset.Companion.m5178getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m2789resetimpl(fArr2);
                Matrix.m2800translateimpl$default(fArr2, IntOffset.m5168getXimpl(mo4226getPositionnOccac), IntOffset.m5169getYimpl(mo4226getPositionnOccac), 0.0f, 4, null);
                Matrix.m2797timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8  reason: not valid java name */
    private final void m4255transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator2);
        nodeCoordinator2.m4255transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.m5167equalsimpl0(mo4226getPositionnOccac(), IntOffset.Companion.m5178getZeronOccac())) {
            float[] fArr2 = tmpMatrix;
            Matrix.m2789resetimpl(fArr2);
            Matrix.m2800translateimpl$default(fArr2, -IntOffset.m5168getXimpl(mo4226getPositionnOccac()), -IntOffset.m5169getYimpl(mo4226getPositionnOccac()), 0.0f, 4, null);
            Matrix.m2797timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo4318inverseTransform58bKbWc(fArr);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        if (!sourceCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m5210getWidthimpl(sourceCoordinates.mo4080getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m5209getHeightimpl(sourceCoordinates.mo4080getSizeYbymL2g()));
        while (coordinator != findCommonAncestor$ui_release) {
            rectInParent$ui_release$default(coordinator, rectCache, z, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        ancestorToLocal(findCommonAncestor$ui_release, rectCache, z);
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: ancestorToLocal-R5De75A  reason: not valid java name */
    private final long m4250ancestorToLocalR5De75A(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
            return m4259fromParentPositionMKHz9U(j);
        }
        return m4259fromParentPositionMKHz9U(nodeCoordinator2.m4250ancestorToLocalR5De75A(nodeCoordinator, j));
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        fromParentRect(mutableRect, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo4082localToRootMKHz9U(long j) {
        if (isAttached()) {
            for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
                j = nodeCoordinator.m4269toParentPositionMKHz9U(j);
            }
            return j;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(block, "block");
        float m5168getXimpl = IntOffset.m5168getXimpl(mo4226getPositionnOccac());
        float m5169getYimpl = IntOffset.m5169getYimpl(mo4226getPositionnOccac());
        canvas.translate(m5168getXimpl, m5169getYimpl);
        block.invoke(canvas);
        canvas.translate(-m5168getXimpl, -m5169getYimpl);
    }

    /* renamed from: toParentPosition-MK-Hz9U  reason: not valid java name */
    public long m4269toParentPositionMKHz9U(long j) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.mo4320mapOffset8S9VItk(j, false);
        }
        return IntOffsetKt.m5182plusNvtHpc(j, mo4226getPositionnOccac());
    }

    /* renamed from: fromParentPosition-MK-Hz9U  reason: not valid java name */
    public long m4259fromParentPositionMKHz9U(long j) {
        long m5180minusNvtHpc = IntOffsetKt.m5180minusNvtHpc(j, mo4226getPositionnOccac());
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo4320mapOffset8S9VItk(m5180minusNvtHpc, true) : m5180minusNvtHpc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m5210getWidthimpl(m4119getMeasuredSizeYbymL2g()) - 0.5f, IntSize.m5209getHeightimpl(m4119getMeasuredSizeYbymL2g()) - 0.5f), paint);
    }

    public final void onLayoutNodeAttach() {
        onLayerBlockUpdated$default(this, this.layerBlock, false, 2, null);
    }

    public final void onRelease() {
        this.released = true;
        if (this.layer != null) {
            onLayerBlockUpdated$default(this, null, false, 2, null);
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long m4261getMinimumTouchTargetSizeNHjbRc = m4261getMinimumTouchTargetSizeNHjbRc();
                    float m2387getWidthimpl = Size.m2387getWidthimpl(m4261getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float m2384getHeightimpl = Size.m2384getHeightimpl(m4261getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    bounds.intersect(-m2387getWidthimpl, -m2384getHeightimpl, IntSize.m5210getWidthimpl(mo4080getSizeYbymL2g()) + m2387getWidthimpl, IntSize.m5209getHeightimpl(mo4080getSizeYbymL2g()) + m2384getHeightimpl);
                } else if (z) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m5210getWidthimpl(mo4080getSizeYbymL2g()), IntSize.m5209getHeightimpl(mo4080getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float m5168getXimpl = IntOffset.m5168getXimpl(mo4226getPositionnOccac());
        bounds.setLeft(bounds.getLeft() + m5168getXimpl);
        bounds.setRight(bounds.getRight() + m5168getXimpl);
        float m5169getYimpl = IntOffset.m5169getYimpl(mo4226getPositionnOccac());
        bounds.setTop(bounds.getTop() + m5169getYimpl);
        bounds.setBottom(bounds.getBottom() + m5169getYimpl);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float m5168getXimpl = IntOffset.m5168getXimpl(mo4226getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - m5168getXimpl);
        mutableRect.setRight(mutableRect.getRight() - m5168getXimpl);
        float m5169getYimpl = IntOffset.m5169getYimpl(mo4226getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - m5169getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() - m5169getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, IntSize.m5210getWidthimpl(mo4080getSizeYbymL2g()), IntSize.m5209getHeightimpl(mo4080getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m4271withinLayerBoundsk4lQ0M(long j) {
        if (OffsetKt.m2335isFinitek4lQ0M(j)) {
            OwnedLayer ownedLayer = this.layer;
            return ownedLayer == null || !this.isClipping || ownedLayer.mo4319isInLayerk4lQ0M(j);
        }
        return false;
    }

    /* renamed from: isPointerInBounds-k-4lQ0M  reason: not valid java name */
    protected final boolean m4266isPointerInBoundsk4lQ0M(long j) {
        float m2318getXimpl = Offset.m2318getXimpl(j);
        float m2319getYimpl = Offset.m2319getYimpl(j);
        return m2318getXimpl >= 0.0f && m2319getYimpl >= 0.0f && m2318getXimpl < ((float) getMeasuredWidth()) && m2319getYimpl < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator nodeCoordinator, Rect rect, Continuation<? super Unit> continuation) {
        Object propagateRelocationRequest;
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        return (nodeCoordinator2 != null && (propagateRelocationRequest = nodeCoordinator2.propagateRelocationRequest(rect.m2355translatek4lQ0M(nodeCoordinator2.localBoundingBoxOf(nodeCoordinator, false).m2353getTopLeftF1C5BW0()), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        Intrinsics.checkNotNullParameter(other, "other");
        LayoutNode layoutNode = other.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = other.getTail();
            Modifier.Node tail2 = getTail();
            int m4277constructorimpl = NodeKind.m4277constructorimpl(2);
            if (!tail2.getNode().isAttached()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & m4277constructorimpl) != 0 && parent$ui_release == tail) {
                    return other;
                }
            }
            return this;
        }
        while (layoutNode.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode != null) {
                if (layoutNode2 == null) {
                }
            }
            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
        return layoutNode2 == getLayoutNode() ? this : layoutNode == other.getLayoutNode() ? other : layoutNode.getInnerCoordinator$ui_release();
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m4253offsetFromEdgeMKHz9U(long j) {
        float m2318getXimpl = Offset.m2318getXimpl(j);
        float max = Math.max(0.0f, m2318getXimpl < 0.0f ? -m2318getXimpl : m2318getXimpl - getMeasuredWidth());
        float m2319getYimpl = Offset.m2319getYimpl(j);
        return OffsetKt.Offset(max, Math.max(0.0f, m2319getYimpl < 0.0f ? -m2319getYimpl : m2319getYimpl - getMeasuredHeight()));
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU  reason: not valid java name */
    protected final long m4257calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m2387getWidthimpl(j) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m2384getHeightimpl(j) - getMeasuredHeight()) / 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw  reason: not valid java name */
    public final float m4258distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() < Size.m2387getWidthimpl(j2) || getMeasuredHeight() < Size.m2384getHeightimpl(j2)) {
            long m4257calculateMinimumTouchTargetPaddingE7KxVPU = m4257calculateMinimumTouchTargetPaddingE7KxVPU(j2);
            float m2387getWidthimpl = Size.m2387getWidthimpl(m4257calculateMinimumTouchTargetPaddingE7KxVPU);
            float m2384getHeightimpl = Size.m2384getHeightimpl(m4257calculateMinimumTouchTargetPaddingE7KxVPU);
            long m4253offsetFromEdgeMKHz9U = m4253offsetFromEdgeMKHz9U(j);
            if ((m2387getWidthimpl > 0.0f || m2384getHeightimpl > 0.0f) && Offset.m2318getXimpl(m4253offsetFromEdgeMKHz9U) <= m2387getWidthimpl && Offset.m2319getYimpl(m4253offsetFromEdgeMKHz9U) <= m2384getHeightimpl) {
                return Offset.m2317getDistanceSquaredimpl(m4253offsetFromEdgeMKHz9U);
            }
            return Float.POSITIVE_INFINITY;
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0019X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001a\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInputSource$annotations", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPointerInputSource$annotations() {
        }

        private Companion() {
        }

        public final HitTestSource<PointerInputModifierNode> getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource<SemanticsModifierNode> getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    public final void onMeasured() {
        Modifier.Node parent$ui_release;
        if (m4262hasNodeH91voCI(NodeKind.m4277constructorimpl(128))) {
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                int m4277constructorimpl = NodeKind.m4277constructorimpl(128);
                boolean m4285getIncludeSelfInTraversalH91voCI = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(m4277constructorimpl);
                if (m4285getIncludeSelfInTraversalH91voCI) {
                    parent$ui_release = getTail();
                } else {
                    parent$ui_release = getTail().getParent$ui_release();
                    if (parent$ui_release == null) {
                        Unit unit = Unit.INSTANCE;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    }
                }
                for (Modifier.Node headNode = headNode(m4285getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m4277constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
                    if ((headNode.getKindSet$ui_release() & m4277constructorimpl) != 0 && (headNode instanceof LayoutAwareModifierNode)) {
                        ((LayoutAwareModifierNode) headNode).mo4163onRemeasuredozmzZPI(m4119getMeasuredSizeYbymL2g());
                    }
                    if (headNode == parent$ui_release) {
                        break;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            } finally {
                createNonObservableSnapshot.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        int m4277constructorimpl = NodeKind.m4277constructorimpl(4);
        boolean m4285getIncludeSelfInTraversalH91voCI = NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(m4277constructorimpl);
        Modifier.Node tail = getTail();
        if (m4285getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node headNode = headNode(m4285getIncludeSelfInTraversalH91voCI);
            while (true) {
                if (headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m4277constructorimpl) != 0) {
                    if ((headNode.getKindSet$ui_release() & m4277constructorimpl) == 0) {
                        if (headNode == tail) {
                            break;
                        }
                        headNode = headNode.getChild$ui_release();
                    } else {
                        r2 = headNode instanceof DrawModifierNode ? headNode : null;
                    }
                } else {
                    break;
                }
            }
        }
        DrawModifierNode drawModifierNode = r2;
        if (drawModifierNode == null) {
            performDraw(canvas);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m4214drawx_KDEd0$ui_release(canvas, IntSizeKt.m5220toSizeozmzZPI(mo4080getSizeYbymL2g()), this, drawModifierNode);
        }
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m4285getIncludeSelfInTraversalH91voCI(NodeKind.m4277constructorimpl(16)));
        if (headNode == null) {
            return false;
        }
        Modifier.Node node = headNode;
        int m4277constructorimpl = NodeKind.m4277constructorimpl(16);
        if (!node.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node2 = node.getNode();
        if ((node2.getAggregateChildKindSet$ui_release() & m4277constructorimpl) != 0) {
            for (Modifier.Node child$ui_release = node2.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & m4277constructorimpl) != 0 && (child$ui_release instanceof PointerInputModifierNode) && ((PointerInputModifierNode) child$ui_release).sharePointerInputWithSiblings()) {
                    return true;
                }
            }
        }
        return false;
    }
}
