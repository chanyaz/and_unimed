package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;
import okio.i;

public interface FileSystem {
    public static final FileSystem a = new FileSystem() {
        public Sink appendingSink(File file) {
            try {
                return i.c(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return i.c(file);
            }
        }

        public void delete(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public void deleteContents(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public void rename(File file, File file2) {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public Sink sink(File file) {
            try {
                return i.b(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return i.b(file);
            }
        }

        public long size(File file) {
            return file.length();
        }

        public Source source(File file) {
            return i.a(file);
        }
    };

    Sink appendingSink(File file);

    void delete(File file);

    void deleteContents(File file);

    boolean exists(File file);

    void rename(File file, File file2);

    Sink sink(File file);

    long size(File file);

    Source source(File file);
}
