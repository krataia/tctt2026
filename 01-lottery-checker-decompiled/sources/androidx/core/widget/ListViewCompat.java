package androidx.core.widget;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ListViewCompat {
    @Deprecated
    public static void scrollListBy(ListView listView, int y) {
        listView.scrollListBy(y);
    }

    @Deprecated
    public static boolean canScrollList(ListView listView, int direction) {
        return listView.canScrollList(direction);
    }

    private ListViewCompat() {
    }
}
