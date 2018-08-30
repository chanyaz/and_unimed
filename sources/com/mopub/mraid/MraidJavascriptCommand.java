package com.mopub.mraid;

import android.support.annotation.NonNull;

public enum MraidJavascriptCommand {
    CLOSE("close"),
    EXPAND("expand") {
        boolean a(@NonNull PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN("open") {
        boolean a(@NonNull PlacementType placementType) {
            return true;
        }
    },
    RESIZE("resize") {
        boolean a(@NonNull PlacementType placementType) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo") {
        boolean a(@NonNull PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    STORE_PICTURE("storePicture") {
        boolean a(@NonNull PlacementType placementType) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT("createCalendarEvent") {
        boolean a(@NonNull PlacementType placementType) {
            return true;
        }
    },
    UNSPECIFIED("");
    
    @NonNull
    private final String a;

    private MraidJavascriptCommand(String str) {
        this.a = str;
    }

    static MraidJavascriptCommand a(@NonNull String str) {
        for (MraidJavascriptCommand mraidJavascriptCommand : values()) {
            if (mraidJavascriptCommand.a.equals(str)) {
                return mraidJavascriptCommand;
            }
        }
        return UNSPECIFIED;
    }

    String a() {
        return this.a;
    }

    boolean a(@NonNull PlacementType placementType) {
        return false;
    }
}
