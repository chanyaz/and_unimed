package com.fasterxml.jackson.core;

import java.io.Serializable;

public class Version implements Serializable, Comparable<Version> {
    private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, null, null, null);
    private static final long serialVersionUID = 1;
    protected final String _artifactId;
    protected final String _groupId;
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;

    public Version(int i, int i2, int i3, String str, String str2, String str3) {
        this._majorVersion = i;
        this._minorVersion = i2;
        this._patchLevel = i3;
        this._snapshotInfo = str;
        if (str2 == null) {
            str2 = "";
        }
        this._groupId = str2;
        if (str3 == null) {
            str3 = "";
        }
        this._artifactId = str3;
    }

    public static Version unknownVersion() {
        return UNKNOWN_VERSION;
    }

    public int compareTo(Version version) {
        if (version == this) {
            return 0;
        }
        int compareTo = this._groupId.compareTo(version._groupId);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this._artifactId.compareTo(version._artifactId);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this._majorVersion - version._majorVersion;
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this._minorVersion - version._minorVersion;
        return compareTo == 0 ? this._patchLevel - version._patchLevel : compareTo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Version version = (Version) obj;
        return version._majorVersion == this._majorVersion && version._minorVersion == this._minorVersion && version._patchLevel == this._patchLevel && version._artifactId.equals(this._artifactId) && version._groupId.equals(this._groupId);
    }

    public int hashCode() {
        return this._artifactId.hashCode() ^ (((this._groupId.hashCode() + this._majorVersion) - this._minorVersion) + this._patchLevel);
    }

    public boolean isSnapshot() {
        return this._snapshotInfo != null && this._snapshotInfo.length() > 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._majorVersion).append('.');
        stringBuilder.append(this._minorVersion).append('.');
        stringBuilder.append(this._patchLevel);
        if (isSnapshot()) {
            stringBuilder.append('-').append(this._snapshotInfo);
        }
        return stringBuilder.toString();
    }
}
