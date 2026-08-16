package androidx.activity;

import androidx.core.util.Consumer;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;
    private Consumer<Boolean> mEnabledConsumer;

    public abstract void handleOnBackPressed();

    public OnBackPressedCallback(boolean enabled) {
        this.mEnabled = enabled;
    }

    public final void setEnabled(boolean enabled) {
        this.mEnabled = enabled;
        if (this.mEnabledConsumer != null) {
            this.mEnabledConsumer.accept(Boolean.valueOf(this.mEnabled));
        }
    }

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        for (Cancellable cancellable : this.mCancellables) {
            cancellable.cancel();
        }
    }

    void addCancellable(Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    void removeCancellable(Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }

    void setIsEnabledConsumer(Consumer<Boolean> isEnabled) {
        this.mEnabledConsumer = isEnabled;
    }
}
