package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.j;
import android.support.annotation.NonNull;
import android.support.v4.util.d;
import android.support.v4.util.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl extends LoaderManager {
    static boolean a = false;
    @NonNull
    private final LifecycleOwner b;
    @NonNull
    private final LoaderViewModel c;

    class LoaderViewModel extends j {
        private static final Factory a = new Factory() {
            @NonNull
            public <T extends j> T create(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        private t<ai> b = new t();

        LoaderViewModel() {
        }

        protected void a() {
            super.a();
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                ((ai) this.b.e(i)).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.b.b()) {
                        ai aiVar = (ai) this.b.e(i2);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(this.b.d(i2));
                        printWriter.print(": ");
                        printWriter.println(aiVar.toString());
                        aiVar.a(str2, fileDescriptor, printWriter, strArr);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        void b() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                ((ai) this.b.e(i)).g();
            }
        }
    }

    void a() {
        this.c.b();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        d.a(this.b, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
