package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class i {
    static final Logger a = Logger.getLogger(i.class.getName());

    private i() {
    }

    public static BufferedSink a(Sink sink) {
        return new k(sink);
    }

    public static BufferedSource a(Source source) {
        return new l(source);
    }

    public static Sink a(OutputStream outputStream) {
        return a(outputStream, new p());
    }

    private static Sink a(final OutputStream outputStream, final p pVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (pVar != null) {
            return new Sink() {
                public void close() {
                    outputStream.close();
                }

                public void flush() {
                    outputStream.flush();
                }

                public p timeout() {
                    return pVar;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                public void write(d dVar, long j) {
                    q.a(dVar.b, 0, j);
                    while (j > 0) {
                        pVar.g();
                        m mVar = dVar.a;
                        int min = (int) Math.min(j, (long) (mVar.c - mVar.b));
                        outputStream.write(mVar.a, mVar.b, min);
                        mVar.b += min;
                        j -= (long) min;
                        dVar.b -= (long) min;
                        if (mVar.b == mVar.c) {
                            dVar.a = mVar.a();
                            n.a(mVar);
                        }
                    }
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        p c = c(socket);
        return c.a(a(socket.getOutputStream(), c));
    }

    public static Source a(File file) {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source a(InputStream inputStream) {
        return a(inputStream, new p());
    }

    private static Source a(final InputStream inputStream, final p pVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (pVar != null) {
            return new Source() {
                public void close() {
                    inputStream.close();
                }

                public long read(d dVar, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            pVar.g();
                            m g = dVar.g(1);
                            int read = inputStream.read(g.a, g.c, (int) Math.min(j, (long) (8192 - g.c)));
                            if (read == -1) {
                                return -1;
                            }
                            g.c += read;
                            dVar.b += (long) read;
                            return (long) read;
                        } catch (AssertionError e) {
                            if (i.a(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                public p timeout() {
                    return pVar;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink b(File file) {
        if (file != null) {
            return a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        p c = c(socket);
        return c.a(a(socket.getInputStream(), c));
    }

    public static Sink c(File file) {
        if (file != null) {
            return a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    private static a c(final Socket socket) {
        return new a() {
            protected IOException a(@Nullable IOException iOException) {
                IOException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            protected void a() {
                try {
                    socket.close();
                } catch (Throwable e) {
                    i.a.log(Level.WARNING, "Failed to close timed out socket " + socket, e);
                } catch (AssertionError e2) {
                    if (i.a(e2)) {
                        i.a.log(Level.WARNING, "Failed to close timed out socket " + socket, e2);
                        return;
                    }
                    throw e2;
                }
            }
        };
    }
}
