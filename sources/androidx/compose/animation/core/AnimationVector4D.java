package androidx.compose.animation.core;

import kotlin.Metadata;

/* compiled from: AnimationVectors.kt */
@Metadata(m41d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\tH\u0090\u0002¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\tH\u0016J\r\u0010\u001f\u001a\u00020\u0000H\u0010¢\u0006\u0002\b J\r\u0010!\u001a\u00020\"H\u0010¢\u0006\u0002\b#J\u001e\u0010$\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0003H\u0090\u0002¢\u0006\u0002\b&J\b\u0010'\u001a\u00020(H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006)"}, m40d2 = {"Landroidx/compose/animation/core/AnimationVector4D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "v3", "v4", "(FFFF)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "getV1", "()F", "setV1$animation_core_release", "(F)V", "getV2", "setV2$animation_core_release", "getV3", "setV3$animation_core_release", "getV4", "setV4$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "value", "set$animation_core_release", "toString", "", "animation-core_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class AnimationVector4D extends AnimationVectors {
    public static final int $stable = 8;
    private final int size;

    /* renamed from: v1 */
    private float f23v1;

    /* renamed from: v2 */
    private float f24v2;

    /* renamed from: v3 */
    private float f25v3;

    /* renamed from: v4 */
    private float f26v4;

    public AnimationVector4D(float f, float f2, float f3, float f4) {
        super(null);
        this.f23v1 = f;
        this.f24v2 = f2;
        this.f25v3 = f3;
        this.f26v4 = f4;
        this.size = 4;
    }

    public final float getV1() {
        return this.f23v1;
    }

    public final void setV1$animation_core_release(float f) {
        this.f23v1 = f;
    }

    public final float getV2() {
        return this.f24v2;
    }

    public final void setV2$animation_core_release(float f) {
        this.f24v2 = f;
    }

    public final float getV3() {
        return this.f25v3;
    }

    public final void setV3$animation_core_release(float f) {
        this.f25v3 = f;
    }

    public final float getV4() {
        return this.f26v4;
    }

    public final void setV4$animation_core_release(float f) {
        this.f26v4 = f;
    }

    @Override // androidx.compose.animation.core.AnimationVectors
    public void reset$animation_core_release() {
        this.f23v1 = 0.0f;
        this.f24v2 = 0.0f;
        this.f25v3 = 0.0f;
        this.f26v4 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVectors
    public AnimationVector4D newVector$animation_core_release() {
        return new AnimationVector4D(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // androidx.compose.animation.core.AnimationVectors
    public float get$animation_core_release(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0.0f;
                    }
                    return this.f26v4;
                }
                return this.f25v3;
            }
            return this.f24v2;
        }
        return this.f23v1;
    }

    @Override // androidx.compose.animation.core.AnimationVectors
    public void set$animation_core_release(int i, float f) {
        if (i == 0) {
            this.f23v1 = f;
        } else if (i == 1) {
            this.f24v2 = f;
        } else if (i == 2) {
            this.f25v3 = f;
        } else if (i != 3) {
        } else {
            this.f26v4 = f;
        }
    }

    @Override // androidx.compose.animation.core.AnimationVectors
    public int getSize$animation_core_release() {
        return this.size;
    }

    public String toString() {
        return "AnimationVector4D: v1 = " + this.f23v1 + ", v2 = " + this.f24v2 + ", v3 = " + this.f25v3 + ", v4 = " + this.f26v4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AnimationVector4D) {
            AnimationVector4D animationVector4D = (AnimationVector4D) obj;
            if (animationVector4D.f23v1 == this.f23v1) {
                if (animationVector4D.f24v2 == this.f24v2) {
                    if (animationVector4D.f25v3 == this.f25v3) {
                        return (animationVector4D.f26v4 > this.f26v4 ? 1 : (animationVector4D.f26v4 == this.f26v4 ? 0 : -1)) == 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f23v1) * 31) + Float.hashCode(this.f24v2)) * 31) + Float.hashCode(this.f25v3)) * 31) + Float.hashCode(this.f26v4);
    }
}
