package com.appnext.base.receivers.imp;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.e;
import com.appnext.base.b.f;
import com.appnext.base.b.l;
import com.appnext.base.receivers.b;

public class bcon extends b {
    protected static final String TAG = bcon.class.getSimpleName();

    public IntentFilter getBRFilter() {
        try {
            if (!hasPermission()) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
            return intentFilter;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return null;
        }
    }

    public boolean hasPermission() {
        return f.g(d.getContext(), "android.permission.BLUETOOTH");
    }

    public void onReceive(Context context, final Intent intent) {
        try {
            l.k("Receiver", getClass().getSimpleName());
            super.onReceive(context, intent);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        c av = e.cy().av(bcon.TAG);
                        if (av == null || com.appnext.base.b.c.jy.equalsIgnoreCase(av.ba())) {
                            l.l(bcon.TAG, "config is off , Not executing anything, unregisterReceiver");
                            d.getContext().unregisterReceiver(bcon.this);
                            return;
                        }
                        String action = intent.getAction();
                        if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action) || "android.bluetooth.device.action.ACL_CONNECTED".equals(action) || "android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                            Bundle extras = intent.getExtras();
                            if (extras != null && extras.size() > 0) {
                                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                                String name = bluetoothDevice != null ? bluetoothDevice.getName() : null;
                                Boolean valueOf = "android.bluetooth.device.action.FOUND".equals(action) ? null : "android.bluetooth.device.action.ACL_CONNECTED".equals(action) ? Boolean.valueOf(true) : "android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action) ? Boolean.valueOf(false) : "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED".equals(action) ? Boolean.valueOf(false) : "android.bluetooth.device.action.ACL_DISCONNECTED".equals(action) ? Boolean.valueOf(false) : null;
                                if (name != null && valueOf != null) {
                                    bcon.this.a(bcon.TAG, bcon.this.a(valueOf, name), a.JSONArray);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.appnext.base.b.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
        }
    }
}
