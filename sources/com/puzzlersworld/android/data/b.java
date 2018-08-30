package com.puzzlersworld.android.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import com.fasterxml.jackson.core.type.TypeReference;
import com.puzzlersworld.android.FriopinAppModule;
import com.puzzlersworld.wp.dto.CartItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class b {
    private final a a;

    @Inject
    public b(a aVar) {
        this.a = aVar;
    }

    private CartItem a(Cursor cursor) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(Long.valueOf(cursor.getLong(cursor.getColumnIndex("pid"))));
        cartItem.setTitle(cursor.getString(cursor.getColumnIndex("product_name")));
        cartItem.setImage(cursor.getString(cursor.getColumnIndex("image_link")));
        cartItem.setMrp(Double.valueOf(cursor.getDouble(cursor.getColumnIndex("mrp"))));
        cartItem.setSellingPrice(Double.valueOf(cursor.getDouble(cursor.getColumnIndex("selling_price"))));
        cartItem.setQuantity(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("product_quantity"))));
        cartItem.setItemType(CartObjectType.valueOf(cursor.getString(cursor.getColumnIndex("type"))));
        cartItem.setVariation_id(Long.valueOf(cursor.getLong(cursor.getColumnIndex("vid"))));
        String string = cursor.getString(cursor.getColumnIndex("variant"));
        cartItem.setVariant(string);
        if (!(string == null || string.isEmpty())) {
            try {
                cartItem.setVariation((Map) FriopinAppModule.getMapper().readValue(string, new TypeReference<HashMap<String, String>>() {
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cartItem;
    }

    public int a() {
        Cursor rawQuery = this.a.getReadableDatabase().rawQuery("SELECT  count(1) AS total FROM cart", null);
        return (rawQuery.getCount() <= 0 || !rawQuery.moveToFirst()) ? 0 : rawQuery.getInt(rawQuery.getColumnIndex("total"));
    }

    public int a(String str) {
        return this.a.getWritableDatabase().delete("cart", "cart_item_key='" + str + "'", null);
    }

    public void a(CartItem cartItem) {
        try {
            CartItem b = b(cartItem.getCart_item_key());
            ContentValues contentValues = new ContentValues();
            contentValues.put("product_name", cartItem.getTitle());
            contentValues.put("mrp", cartItem.getMrp());
            contentValues.put("selling_price", cartItem.getSellingPrice());
            contentValues.put("image_link", cartItem.getImage());
            contentValues.put("vid", cartItem.getVariation_id());
            if (cartItem.getVariation() != null) {
                contentValues.put("variant", FriopinAppModule.getMapper().writeValueAsString(cartItem.getVariation()));
            }
            contentValues.put("pid", cartItem.getProductId());
            contentValues.put("type", CartObjectType.CART.name());
            if (b != null) {
                contentValues.put("product_quantity", Integer.valueOf(b.getQuantity().intValue() + 1));
                this.a.getWritableDatabase().update("cart", contentValues, "cart_item_key='" + cartItem.getCart_item_key() + "'", null);
                return;
            }
            contentValues.put("cart_item_key", cartItem.getCart_item_key());
            contentValues.put("product_quantity", Integer.valueOf(1));
            this.a.getWritableDatabase().insert("cart", null, contentValues);
        } catch (Throwable th) {
            Log.e("AndroApp", "Unable to write contact to disk", th);
        }
    }

    public CartItem b(String str) {
        Cursor rawQuery = this.a.getReadableDatabase().rawQuery("SELECT  * FROM cart where cart_item_key='" + str + "'", null);
        return rawQuery.moveToFirst() ? a(rawQuery) : null;
    }

    public void b() {
        this.a.getWritableDatabase().delete("cart", null, null);
    }

    public List<CartItem> c() {
        List<CartItem> arrayList = new ArrayList();
        Cursor rawQuery = this.a.getReadableDatabase().rawQuery("SELECT  * FROM cart", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(a(rawQuery));
            } while (rawQuery.moveToNext());
        }
        return arrayList;
    }
}
