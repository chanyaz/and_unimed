package com.google.android.exoplayer.upstream;

public interface Allocator {
    a allocate();

    void blockWhileTotalBytesAllocatedExceeds(int i);

    int getIndividualAllocationLength();

    int getTotalBytesAllocated();

    void release(a aVar);

    void trim(int i);
}
