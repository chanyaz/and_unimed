package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.f;
import android.support.v4.util.a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class c extends k implements Animatable2Compat {
    final Callback a;
    private d c;
    private Context d;
    private ArgbEvaluator e;
    private AnimatorListener f;
    private ArrayList<b> g;

    c() {
        this(null, null, null);
    }

    private c(@Nullable Context context) {
        this(context, null, null);
    }

    private c(@Nullable Context context, @Nullable d dVar, @Nullable Resources resources) {
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = new Callback() {
            public void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.d = context;
        if (dVar != null) {
            this.c = dVar;
        } else {
            this.c = new d(context, dVar, this.a, resources);
        }
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void a() {
        if (this.f != null) {
            this.c.c.removeListener(this.f);
            this.f = null;
        }
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childAnimations.size()) {
                        break;
                    }
                    a((Animator) childAnimations.get(i2));
                    i = i2 + 1;
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.e == null) {
                    this.e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.e);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.c.b.a(str));
        if (VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.c.e == null) {
            this.c.e = new ArrayList();
            this.c.d = new a();
        }
        this.c.e.add(animator);
        this.c.d.put(animator, str);
    }

    @RequiresApi(23)
    private static boolean a(AnimatedVectorDrawable animatedVectorDrawable, b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
    }

    @RequiresApi(23)
    private static void b(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    public void applyTheme(Theme theme) {
        if (this.b != null) {
            android.support.v4.graphics.drawable.a.a(this.b, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.b != null ? android.support.v4.graphics.drawable.a.d(this.b) : false;
    }

    public void clearAnimationCallbacks() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).clearAnimationCallbacks();
            return;
        }
        a();
        if (this.g != null) {
            this.g.clear();
        }
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        this.c.b.draw(canvas);
        if (this.c.c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.b != null ? android.support.v4.graphics.drawable.a.c(this.b) : this.c.b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.b != null ? this.b.getChangingConfigurations() : super.getChangingConfigurations() | this.c.a;
    }

    public ConstantState getConstantState() {
        return (this.b == null || VERSION.SDK_INT < 24) ? null : new e(this.b.getConstantState());
    }

    public int getIntrinsicHeight() {
        return this.b != null ? this.b.getIntrinsicHeight() : this.c.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.b != null ? this.b.getIntrinsicWidth() : this.c.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : this.c.b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            android.support.v4.graphics.drawable.a.a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = f.a(resources, theme, attributeSet, a.e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        l a2 = l.a(resources, resourceId, theme);
                        a2.a(false);
                        a2.setCallback(this.a);
                        if (this.c.b != null) {
                            this.c.b.setCallback(null);
                        }
                        this.c.b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, a.f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.d != null) {
                            a(string, g.a(this.d, resourceId2));
                        } else {
                            a.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.c.a();
    }

    public boolean isAutoMirrored() {
        return this.b != null ? android.support.v4.graphics.drawable.a.b(this.b) : this.c.b.isAutoMirrored();
    }

    public boolean isRunning() {
        return this.b != null ? ((AnimatedVectorDrawable) this.b).isRunning() : this.c.c.isRunning();
    }

    public boolean isStateful() {
        return this.b != null ? this.b.isStateful() : this.c.b.isStateful();
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            this.c.b.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.b != null ? this.b.setLevel(i) : this.c.b.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        return this.b != null ? this.b.setState(iArr) : this.c.b.setState(iArr);
    }

    public void registerAnimationCallback(@NonNull b bVar) {
        if (this.b != null) {
            b((AnimatedVectorDrawable) this.b, bVar);
        } else if (bVar != null) {
            if (this.g == null) {
                this.g = new ArrayList();
            }
            if (!this.g.contains(bVar)) {
                this.g.add(bVar);
                if (this.f == null) {
                    this.f = new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ArrayList arrayList = new ArrayList(c.this.g);
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                ((b) arrayList.get(i)).b(c.this);
                            }
                        }

                        public void onAnimationStart(Animator animator) {
                            ArrayList arrayList = new ArrayList(c.this.g);
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                ((b) arrayList.get(i)).a(c.this);
                            }
                        }
                    };
                }
                this.c.c.addListener(this.f);
            }
        }
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else {
            this.c.b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            android.support.v4.graphics.drawable.a.a(this.b, z);
        } else {
            this.c.b.setAutoMirrored(z);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
        } else {
            this.c.b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.b != null) {
            android.support.v4.graphics.drawable.a.a(this.b, i);
        } else {
            this.c.b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            android.support.v4.graphics.drawable.a.a(this.b, colorStateList);
        } else {
            this.c.b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            android.support.v4.graphics.drawable.a.a(this.b, mode);
        } else {
            this.c.b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        this.c.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).start();
        } else if (!this.c.c.isStarted()) {
            this.c.c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).stop();
        } else {
            this.c.c.end();
        }
    }

    public boolean unregisterAnimationCallback(@NonNull b bVar) {
        if (this.b != null) {
            a((AnimatedVectorDrawable) this.b, bVar);
        }
        if (this.g == null || bVar == null) {
            return false;
        }
        boolean remove = this.g.remove(bVar);
        if (this.g.size() != 0) {
            return remove;
        }
        a();
        return remove;
    }
}
