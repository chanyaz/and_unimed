package com.google.common.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;

class j implements FinalizerLoader {
    j() {
    }

    URL a() {
        String str = "com.google.common.base.internal.Finalizer".replace('.', '/') + ".class";
        URL resource = getClass().getClassLoader().getResource(str);
        if (resource == null) {
            throw new FileNotFoundException(str);
        }
        String url = resource.toString();
        if (url.endsWith(str)) {
            return new URL(resource, url.substring(0, url.length() - str.length()));
        }
        throw new IOException("Unsupported path style: " + url);
    }

    URLClassLoader a(URL url) {
        return new URLClassLoader(new URL[]{url}, null);
    }

    public Class<?> loadFinalizer() {
        try {
            return a(a()).loadClass("com.google.common.base.internal.Finalizer");
        } catch (Throwable e) {
            FinalizableReferenceQueue.d.log(Level.WARNING, "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.", e);
            return null;
        }
    }
}
