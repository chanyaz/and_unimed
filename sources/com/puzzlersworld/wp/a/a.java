package com.puzzlersworld.wp.a;

import com.puzzlersworld.wp.dto.Comment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    public static List<Comment> a(List<Comment> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        List<Comment> arrayList2 = new ArrayList();
        for (Comment comment : list) {
            if (comment.getParent().longValue() == 0) {
                arrayList.add(comment);
            }
            hashMap.put(comment.getID(), comment);
        }
        for (Comment comment2 : list) {
            Comment comment3 = (Comment) hashMap.get(comment2.getParent());
            if (comment3 != null) {
                comment3.getChilds().add(comment2);
            }
        }
        a(arrayList, arrayList2, 1);
        return arrayList2;
    }

    private static void a(List<Comment> list, List<Comment> list2, int i) {
        for (Comment comment : list) {
            comment.setLevel(i);
            list2.add(comment);
            a(comment.getChilds(), list2, i + 1);
        }
    }
}
