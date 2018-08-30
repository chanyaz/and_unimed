package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

class d extends IllegalStateException {
    static final StackTraceElement[] a = new StackTraceElement[0];
    static Set<String> b = ImmutableSet.a(CycleDetectingLockFactory.class.getName(), d.class.getName(), e.class.getName());
}
