package android.support.v7.widget;

import java.util.List;

class OpReorderer {
    final Callback a;

    interface Callback {
        s obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(s sVar);
    }

    OpReorderer(Callback callback) {
        this.a = callback;
    }

    private void a(List<s> list, int i, int i2) {
        s sVar = (s) list.get(i);
        s sVar2 = (s) list.get(i2);
        switch (sVar2.a) {
            case 1:
                c(list, i, sVar, i2, sVar2);
                return;
            case 2:
                a(list, i, sVar, i2, sVar2);
                return;
            case 4:
                b(list, i, sVar, i2, sVar2);
                return;
            default:
                return;
        }
    }

    private int b(List<s> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((s) list.get(size)).a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }

    private void c(List<s> list, int i, s sVar, int i2, s sVar2) {
        int i3 = 0;
        if (sVar.d < sVar2.b) {
            i3 = -1;
        }
        if (sVar.b < sVar2.b) {
            i3++;
        }
        if (sVar2.b <= sVar.b) {
            sVar.b += sVar2.d;
        }
        if (sVar2.b <= sVar.d) {
            sVar.d += sVar2.d;
        }
        sVar2.b = i3 + sVar2.b;
        list.set(i, sVar2);
        list.set(i2, sVar);
    }

    void a(List<s> list) {
        while (true) {
            int b = b(list);
            if (b != -1) {
                a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    void a(List<s> list, int i, s sVar, int i2, s sVar2) {
        int i3;
        s sVar3;
        int i4 = 0;
        if (sVar.b < sVar.d) {
            i3 = (sVar2.b == sVar.b && sVar2.d == sVar.d - sVar.b) ? 1 : 0;
        } else if (sVar2.b == sVar.d + 1 && sVar2.d == sVar.b - sVar.d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (sVar.d < sVar2.b) {
            sVar2.b--;
        } else if (sVar.d < sVar2.b + sVar2.d) {
            sVar2.d--;
            sVar.a = 2;
            sVar.d = 1;
            if (sVar2.d == 0) {
                list.remove(i2);
                this.a.recycleUpdateOp(sVar2);
                return;
            }
            return;
        }
        if (sVar.b <= sVar2.b) {
            sVar2.b++;
            sVar3 = null;
        } else if (sVar.b < sVar2.b + sVar2.d) {
            sVar3 = this.a.obtainUpdateOp(2, sVar.b + 1, (sVar2.b + sVar2.d) - sVar.b, null);
            sVar2.d = sVar.b - sVar2.b;
        } else {
            sVar3 = null;
        }
        if (i3 != 0) {
            list.set(i, sVar2);
            list.remove(i2);
            this.a.recycleUpdateOp(sVar);
            return;
        }
        if (i4 != 0) {
            if (sVar3 != null) {
                if (sVar.b > sVar3.b) {
                    sVar.b -= sVar3.d;
                }
                if (sVar.d > sVar3.b) {
                    sVar.d -= sVar3.d;
                }
            }
            if (sVar.b > sVar2.b) {
                sVar.b -= sVar2.d;
            }
            if (sVar.d > sVar2.b) {
                sVar.d -= sVar2.d;
            }
        } else {
            if (sVar3 != null) {
                if (sVar.b >= sVar3.b) {
                    sVar.b -= sVar3.d;
                }
                if (sVar.d >= sVar3.b) {
                    sVar.d -= sVar3.d;
                }
            }
            if (sVar.b >= sVar2.b) {
                sVar.b -= sVar2.d;
            }
            if (sVar.d >= sVar2.b) {
                sVar.d -= sVar2.d;
            }
        }
        list.set(i, sVar2);
        if (sVar.b != sVar.d) {
            list.set(i2, sVar);
        } else {
            list.remove(i2);
        }
        if (sVar3 != null) {
            list.add(i, sVar3);
        }
    }

    void b(List<s> list, int i, s sVar, int i2, s sVar2) {
        Object obj;
        Object obj2 = null;
        if (sVar.d < sVar2.b) {
            sVar2.b--;
            obj = null;
        } else if (sVar.d < sVar2.b + sVar2.d) {
            sVar2.d--;
            obj = this.a.obtainUpdateOp(4, sVar.b, 1, sVar2.c);
        } else {
            obj = null;
        }
        if (sVar.b <= sVar2.b) {
            sVar2.b++;
        } else if (sVar.b < sVar2.b + sVar2.d) {
            int i3 = (sVar2.b + sVar2.d) - sVar.b;
            obj2 = this.a.obtainUpdateOp(4, sVar.b + 1, i3, sVar2.c);
            sVar2.d -= i3;
        }
        list.set(i2, sVar);
        if (sVar2.d > 0) {
            list.set(i, sVar2);
        } else {
            list.remove(i);
            this.a.recycleUpdateOp(sVar2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }
}
