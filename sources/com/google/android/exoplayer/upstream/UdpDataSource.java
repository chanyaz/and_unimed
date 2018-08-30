package com.google.android.exoplayer.upstream;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

public final class UdpDataSource implements UriDataSource {
    private final TransferListener a;
    private final DatagramPacket b;
    private c c;
    private DatagramSocket d;
    private MulticastSocket e;
    private InetAddress f;
    private InetSocketAddress g;
    private boolean h;
    private byte[] i;
    private int j;

    public final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public void close() {
        if (this.e != null) {
            try {
                this.e.leaveGroup(this.f);
            } catch (IOException e) {
            }
            this.e = null;
        }
        if (this.d != null) {
            this.d.close();
            this.d = null;
        }
        this.f = null;
        this.g = null;
        this.j = 0;
        if (this.h) {
            this.h = false;
            if (this.a != null) {
                this.a.onTransferEnd();
            }
        }
    }

    public String getUri() {
        return this.c == null ? null : this.c.a.toString();
    }

    public long open(c cVar) {
        this.c = cVar;
        String uri = cVar.a.toString();
        String substring = uri.substring(0, uri.indexOf(58));
        int parseInt = Integer.parseInt(uri.substring(uri.indexOf(58) + 1));
        try {
            this.f = InetAddress.getByName(substring);
            this.g = new InetSocketAddress(this.f, parseInt);
            if (this.f.isMulticastAddress()) {
                this.e = new MulticastSocket(this.g);
                this.e.joinGroup(this.f);
                this.d = this.e;
            } else {
                this.d = new DatagramSocket(this.g);
            }
            this.h = true;
            if (this.a != null) {
                this.a.onTransferStart();
            }
            return -1;
        } catch (IOException e) {
            throw new UdpDataSourceException(e);
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.j == 0) {
            try {
                this.d.receive(this.b);
                this.j = this.b.getLength();
                if (this.a != null) {
                    this.a.onBytesTransferred(this.j);
                }
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length = this.b.getLength() - this.j;
        int min = Math.min(this.j, i2);
        System.arraycopy(this.i, length, bArr, i, min);
        this.j -= min;
        return min;
    }
}
