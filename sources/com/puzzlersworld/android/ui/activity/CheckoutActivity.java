package com.puzzlersworld.android.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.FriopinApplication;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.common.AndroAppFragmentType;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.ui.a.d;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.annotations.ForBackground;
import com.puzzlersworld.android.util.annotations.ForUi;
import com.puzzlersworld.android.util.c;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.h;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.dto.Address;
import com.puzzlersworld.wp.dto.BillingAddress;
import com.puzzlersworld.wp.dto.Cart;
import com.puzzlersworld.wp.dto.CreateOrderRequest;
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.LineItem;
import com.puzzlersworld.wp.dto.Order;
import com.puzzlersworld.wp.dto.PaymentDetails;
import com.puzzlersworld.wp.dto.PaymentGateway;
import com.puzzlersworld.wp.dto.ShippingAddress;
import com.puzzlersworld.wp.dto.ShippingLine;
import com.puzzlersworld.wp.dto.StringConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.ai;

public class CheckoutActivity extends Fragment implements AndroAppFragment {
    private static PaymentGateway as = null;
    @Inject
    b a;
    private LinearLayout ae;
    private LinearLayout af;
    private LinearLayout ag;
    private RadioGroup ah;
    private RadioGroup ai;
    private LinearLayout aj;
    private LinearLayout ak;
    private LinearLayout al;
    private LinearLayout am;
    private Map<String, String> an = null;
    private a ao;
    private CreateOrderRequest ap;
    private Cart aq;
    private Button ar;
    private Long at = null;
    @Inject
    c b;
    @Inject
    g c;
    @Inject
    ObjectMapper d;
    @Inject
    RestServiceManager e;
    @Inject
    @ForBackground
    ListeningScheduledExecutorService f;
    @ForUi
    @Inject
    ListeningExecutorService g;
    private LinearLayout h;
    private LinearLayout i;

    private View a(String str, String str2) {
        View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.order_line_item, null);
        ((TextView) inflate.findViewById(R.id.lineHeader)).setText(str);
        ((TextView) inflate.findViewById(R.id.lineValue)).setText(str2);
        return inflate;
    }

    public static String a() {
        return RestServiceManager.hostName + "/wp-json/androapppayment";
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            if (this.aq == null && bundle.getSerializable("cartObject") != null) {
                this.aq = (Cart) bundle.getSerializable("cartObject");
            }
            if (this.ap == null && bundle.getSerializable("createOrderRequestObject") != null) {
                this.ap = (CreateOrderRequest) bundle.getSerializable("createOrderRequestObject");
                this.ao = (a) bundle.getSerializable("checkOutStep");
                return;
            }
            return;
        }
        Log.d("AndroApp:", "Saved instance is null");
    }

    private void a(LinearLayout linearLayout) {
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.country_spinner);
        SpinnerAdapter arrayAdapter = new ArrayAdapter(getLifecycleActivity(), 17367048, w.a(this.aq.getShippable_countries()));
        arrayAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(arrayAdapter);
        spinner.setAdapter(new h(arrayAdapter, (int) R.layout.nothing_selected_spinner_layout, getLifecycleActivity(), StringConstants.COUNTRY.getMessage()));
    }

    private void a(LinearLayout linearLayout, Address address) {
        TextView textView = (TextView) linearLayout.findViewById(R.id.last_name);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.address1);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.address2);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.city);
        TextView textView5 = (TextView) linearLayout.findViewById(R.id.postcode);
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.state_spinner);
        spinner = (Spinner) linearLayout.findViewById(R.id.country_spinner);
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.email);
        TextView textView7 = (TextView) linearLayout.findViewById(R.id.phone);
        ((TextView) linearLayout.findViewById(R.id.first_name)).setText(address.getFirst_name());
        textView.setText(address.getLast_name());
        textView2.setText(address.getAddress_1());
        textView3.setText(address.getAddress_2());
        textView4.setText(address.getCity());
        textView5.setText(address.getPostcode());
        if (textView6 != null) {
            textView6.setText(((BillingAddress) address).getEmail());
        }
        if (textView7 != null) {
            textView7.setText(((BillingAddress) address).getPhone());
        }
        int indexOf = w.a(this.aq.getShippable_countries()).indexOf(this.aq.getShippable_countries().get(address.getCountry()));
        if (indexOf != -1) {
            spinner.setSelection(indexOf + 1);
        }
    }

    private void a(LinearLayout linearLayout, Map<String, String> map, String str) {
        Spinner spinner = (Spinner) linearLayout.findViewById(R.id.state_spinner);
        List arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(map.get(str2));
        }
        SpinnerAdapter arrayAdapter = new ArrayAdapter(getLifecycleActivity(), 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(new h(arrayAdapter, (int) R.layout.nothing_selected_spinner_layout, getLifecycleActivity(), StringConstants.STATE.getMessage()));
        if (str != null) {
            int indexOf = w.a(this.an).indexOf(this.an.get(str));
            if (indexOf != -1) {
                spinner.setSelection(indexOf + 1);
            }
        }
    }

    private void a(Cart cart, LinearLayout linearLayout) {
        linearLayout.findViewById(R.id.shipping_handling_layout).setVisibility(0);
        linearLayout.findViewById(R.id.separator5).setVisibility(0);
        ((TextView) linearLayout.findViewById(R.id.subtotalHeader)).setText(StringConstants.SUBTOTAL.getMessage());
        ((TextView) linearLayout.findViewById(R.id.taxesHeader)).setText(StringConstants.TAXES.getMessage());
        ((TextView) linearLayout.findViewById(R.id.totalHeader)).setText(StringConstants.TOTAL.getMessage());
        ((TextView) linearLayout.findViewById(R.id.discountHeader)).setText(StringConstants.Discount.getMessage());
        ((TextView) linearLayout.findViewById(R.id.shippingHeader)).setText(StringConstants.SHIPPING_AND_HANDLING.getMessage());
        TextView textView = (TextView) linearLayout.findViewById(R.id.discountValue);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.taxesValue);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.totalValue);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.shippingValue);
        ((TextView) linearLayout.findViewById(R.id.subtotalValue)).setText("" + cart.getSubtotal_ex_tax());
        textView2.setText("" + cart.getTax_total());
        textView.setText("" + cart.getDiscount_cart());
        textView4.setText("" + cart.getShipping_total());
        textView3.setText("" + (((cart.getSubtotal_ex_tax().doubleValue() - cart.getDiscount_cart().doubleValue()) + cart.getTax_total().doubleValue()) + cart.getShipping_total().doubleValue()));
    }

    private void a(Customer customer) {
        try {
            this.c.d(this.d.writeValueAsString(customer));
            if (FullscreenActivity.D == null || FullscreenActivity.D.isEmpty()) {
                FullscreenActivity.D = customer.getUsername();
                FullscreenActivity.E = customer.getEmail();
                this.c.g(customer.getUsername());
                this.c.h(customer.getEmail());
            }
            this.c.f(FullscreenActivity.s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void a(Order order) {
        this.al.findViewById(R.id.orderDetails).setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.al.findViewById(R.id.orderDetails);
        linearLayout.removeAllViews();
        Iterator it = order.getLine_items().iterator();
        while (it.hasNext()) {
            LineItem lineItem = (LineItem) it.next();
            View inflate = LayoutInflater.from(getLifecycleActivity()).inflate(R.layout.order_product_line, null);
            ((TextView) inflate.findViewById(R.id.productHeader)).setText(lineItem.getName() + " x " + lineItem.getQuantity());
            linearLayout.addView(inflate);
        }
        if (order.getShipping_lines() != null && order.getShipping_lines().length > 0) {
            ShippingLine shippingLine = order.getShipping_lines()[0];
            linearLayout.addView(a(StringConstants.SHIPPING_METHOD.getMessage(), shippingLine.getMethod_title() + " (" + shippingLine.getTotal() + ")"));
        }
        if (order.getPayment_details() != null) {
            linearLayout.addView(a(StringConstants.PAYMENT_METHOD.getMessage(), "" + order.getPayment_details().getMethod_title()));
        }
        linearLayout.addView(a(StringConstants.TOTAL.getMessage(), "" + order.getTotal()));
        ((FullscreenActivity) getLifecycleActivity()).a(StringConstants.ORDER.getMessage() + " #" + order.getId());
        if (order.getStatus() != null) {
            ((TextView) this.al.findViewById(R.id.orderCompleteTitle)).setText(StringConstants.ORDER_COMPLETE.getMessage() + " " + order.getStatus().toUpperCase());
        }
    }

    public static PaymentGateway ac() {
        return as;
    }

    private void ad() {
        int parseColor = Color.parseColor(FullscreenActivity.z().getActionBarBgColor());
        int parseColor2 = Color.parseColor(FullscreenActivity.z().getActionBarTitleColor());
        TextView textView = (TextView) this.i.findViewById(R.id.first_name);
        TextView textView2 = (TextView) this.i.findViewById(R.id.last_name);
        TextView textView3 = (TextView) this.i.findViewById(R.id.address1);
        TextView textView4 = (TextView) this.i.findViewById(R.id.address2);
        TextView textView5 = (TextView) this.i.findViewById(R.id.city);
        TextView textView6 = (TextView) this.i.findViewById(R.id.postcode);
        TextView textView7 = (TextView) this.i.findViewById(R.id.email);
        TextView textView8 = (TextView) this.i.findViewById(R.id.phone);
        ((TextView) this.i.findViewById(R.id.billingaddressHeader)).setText(StringConstants.BILLING_ADDRESS.getMessage());
        ((TextView) this.i.findViewById(R.id.billingaddressHeader)).setBackgroundColor(parseColor);
        ((TextView) this.i.findViewById(R.id.billingaddressHeader)).setTextColor(parseColor2);
        textView.setHint(StringConstants.FIRST_NAME.getMessage());
        textView2.setHint(StringConstants.LAST_NAME.getMessage());
        textView3.setHint(StringConstants.ADDRESS1.getMessage());
        textView4.setHint(StringConstants.ADDRESS2.getMessage());
        textView5.setHint(StringConstants.CITY.getMessage());
        textView6.setHint(StringConstants.PINCODE.getMessage());
        textView7.setHint(StringConstants.EMAIL.getMessage());
        textView8.setHint(StringConstants.PHONE.getMessage());
        CheckBox checkBox = (CheckBox) this.ae.findViewById(R.id.checkbox_ship);
        textView2 = (TextView) this.ae.findViewById(R.id.first_name);
        textView3 = (TextView) this.ae.findViewById(R.id.last_name);
        textView4 = (TextView) this.ae.findViewById(R.id.address1);
        textView5 = (TextView) this.ae.findViewById(R.id.address2);
        textView6 = (TextView) this.ae.findViewById(R.id.city);
        textView7 = (TextView) this.ae.findViewById(R.id.postcode);
        ((TextView) this.ae.findViewById(R.id.shippingAddressHeader)).setText(StringConstants.SHIPPING_ADDRESS.getMessage());
        ((TextView) this.ae.findViewById(R.id.shippingAddressHeader)).setBackgroundColor(parseColor);
        ((TextView) this.ae.findViewById(R.id.shippingAddressHeader)).setTextColor(parseColor2);
        checkBox.setText(StringConstants.SAME_AS_BILLING_ADDRESS.getMessage());
        textView2.setHint(StringConstants.FIRST_NAME.getMessage());
        textView3.setHint(StringConstants.LAST_NAME.getMessage());
        textView4.setHint(StringConstants.ADDRESS1.getMessage());
        textView5.setHint(StringConstants.ADDRESS2.getMessage());
        textView6.setHint(StringConstants.CITY.getMessage());
        textView7.setHint(StringConstants.PINCODE.getMessage());
        ((TextView) this.ag.findViewById(R.id.shippingMethodTitle)).setText(StringConstants.SHIPPING_METHOD.getMessage());
        ((TextView) this.ag.findViewById(R.id.shippingMethodTitle)).setBackgroundColor(parseColor);
        ((TextView) this.ag.findViewById(R.id.shippingMethodTitle)).setTextColor(parseColor2);
        ((EditText) this.ag.findViewById(R.id.order_note)).setHint(StringConstants.ORDER_NOTE.getMessage());
        ((TextView) this.ak.findViewById(R.id.paymentMethodTitle)).setText(StringConstants.PAYMENT_METHOD.getMessage());
        ((TextView) this.ak.findViewById(R.id.paymentMethodTitle)).setBackgroundColor(parseColor);
        ((TextView) this.ak.findViewById(R.id.paymentMethodTitle)).setTextColor(parseColor2);
        ((TextView) this.aj.findViewById(R.id.billingaddressHeader)).setText(StringConstants.BILLING_ADDRESS.getMessage());
        ((TextView) this.aj.findViewById(R.id.shippingAddressHeader)).setText(StringConstants.SHIPPING_ADDRESS.getMessage());
        ((TextView) this.aj.findViewById(R.id.orderReviewTitle)).setText(StringConstants.ORDER_REVIEW.getMessage());
        ((TextView) this.aj.findViewById(R.id.orderReviewTitle)).setBackgroundColor(parseColor);
        ((TextView) this.aj.findViewById(R.id.orderReviewTitle)).setTextColor(parseColor2);
        ((TextView) this.al.findViewById(R.id.orderCompleteTitle)).setText(StringConstants.ORDER_COMPLETE.getMessage());
        ((TextView) this.al.findViewById(R.id.orderCompleteTitle)).setBackgroundColor(parseColor);
        ((TextView) this.al.findViewById(R.id.orderCompleteTitle)).setTextColor(parseColor2);
    }

    private void ae() {
        final Spinner spinner = (Spinner) this.i.findViewById(R.id.country_spinner);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (spinner.getSelectedItem() != null) {
                    CheckoutActivity.this.e.getCartService().getStates(w.a(CheckoutActivity.this.aq.getShippable_countries(), spinner.getSelectedItem().toString())).enqueue(new Callback<Map<String, String>>() {
                        public void onFailure(Call<Map<String, String>> call, Throwable th) {
                        }

                        public void onResponse(Call<Map<String, String>> call, ai<Map<String, String>> aiVar) {
                            Map map = (Map) aiVar.b();
                            if (map != null) {
                                CheckoutActivity.this.an = map;
                                CheckoutActivity.this.a(CheckoutActivity.this.i, CheckoutActivity.this.an, CheckoutActivity.this.ap.getOrder().getBilling_address().getState());
                                return;
                            }
                            w.a(CheckoutActivity.this.getLifecycleActivity(), (ai) aiVar);
                        }
                    });
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner = (Spinner) this.ae.findViewById(R.id.country_spinner);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (spinner.getSelectedItem() != null) {
                    CheckoutActivity.this.e.getCartService().getStates(w.a(CheckoutActivity.this.aq.getShippable_countries(), spinner.getSelectedItem().toString())).enqueue(new Callback<Map<String, String>>() {
                        public void onFailure(Call<Map<String, String>> call, Throwable th) {
                        }

                        public void onResponse(Call<Map<String, String>> call, ai<Map<String, String>> aiVar) {
                            Map map = (Map) aiVar.b();
                            if (map != null) {
                                CheckoutActivity.this.an = map;
                                CheckoutActivity.this.a(CheckoutActivity.this.ae, CheckoutActivity.this.an, CheckoutActivity.this.ap.getOrder().getShipping_address().getState());
                                return;
                            }
                            w.a(CheckoutActivity.this.getLifecycleActivity(), (ai) aiVar);
                        }
                    });
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        final CheckBox checkBox = (CheckBox) this.ae.findViewById(R.id.checkbox_ship);
        checkBox.setChecked(true);
        this.af.setVisibility(4);
        checkBox.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    CheckoutActivity.this.af.setVisibility(4);
                } else {
                    CheckoutActivity.this.af.setVisibility(0);
                }
            }
        });
    }

    private void af() {
        switch (this.ao) {
            case COMPLETED:
                this.ao = a.PAYMENT_METHOD;
                break;
            case PAYMENT_METHOD:
                this.ao = a.ORDER_REVIEW;
                break;
            case ORDER_REVIEW:
                this.ao = a.SHIPPING_METHOD;
                break;
            case SHIPPING_METHOD:
                this.ao = a.SHIPPING_ADDRESS;
                break;
            case SHIPPING_ADDRESS:
                this.ar.setEnabled(false);
                this.ao = a.BILLING;
                break;
        }
        ar();
    }

    private void ag() {
        boolean z = false;
        switch (this.ao) {
            case PAYMENT_METHOD:
                if (an() && aj()) {
                    this.ao = a.COMPLETED;
                    z = true;
                    break;
                }
            case ORDER_REVIEW:
                this.ao = a.PAYMENT_METHOD;
                z = true;
                break;
            case SHIPPING_METHOD:
                if (ao()) {
                    this.ao = a.ORDER_REVIEW;
                    z = true;
                    break;
                }
                break;
            case SHIPPING_ADDRESS:
                if (al()) {
                    this.ao = a.SHIPPING_METHOD;
                    z = true;
                    break;
                }
                break;
            case BILLING:
                if (ak()) {
                    this.ao = a.SHIPPING_ADDRESS;
                    z = true;
                    break;
                }
                break;
            default:
                z = true;
                break;
        }
        if (z) {
            this.ar.setEnabled(true);
            ar();
        }
    }

    private boolean ah() {
        TextView textView = (TextView) this.aj.findViewById(R.id.shipping_address);
        ((TextView) this.aj.findViewById(R.id.billingaddress)).setText(w.d(this.ap.getOrder().getBilling_address().toString(this.aq.getShippable_countries(), this.an)));
        textView.setText(w.d(this.ap.getOrder().getShipping_address().toString(this.aq.getShippable_countries(), this.an)));
        a(this.aq, (LinearLayout) this.aj.findViewById(R.id.price_details));
        return true;
    }

    private void ai() {
        this.e.getWooSecureService().getCustomerInfo().enqueue(new Callback<Customer>() {
            public void onFailure(Call<Customer> call, Throwable th) {
            }

            public void onResponse(Call<Customer> call, ai<Customer> aiVar) {
                Customer customer = (Customer) aiVar.b();
                if (customer != null && customer.getId() != null) {
                    CheckoutActivity.this.a(customer);
                }
            }
        });
    }

    private boolean aj() {
        this.e.getWooSecureService().createOrder(this.ap).enqueue(new Callback<Order>() {
            public void onFailure(Call<Order> call, Throwable th) {
            }

            public void onResponse(Call<Order> call, ai<Order> aiVar) {
                Order order = (Order) aiVar.b();
                if (order != null) {
                    Log.d("AndroApp", "Created order id = " + order.getId());
                    CheckoutActivity.this.ao = a.COMPLETED;
                    CheckoutActivity.this.ar();
                    CheckoutActivity.this.a.b();
                    CheckoutActivity.this.b.a(new HashMap());
                    CheckoutActivity.this.at = order.getId();
                    final String str = CheckoutActivity.a() + "?orderId=" + order.getId() + "&gateway=" + CheckoutActivity.this.ap.getOrder().getPayment_details().getMethod_id() + "&e=" + CheckoutActivity.this.ap.getOrder().getBilling_address().getEmail();
                    CheckoutActivity.this.g.execute(new Runnable() {
                        public void run() {
                            d.a(CheckoutActivity.this.getLifecycleActivity(), str, false);
                        }
                    });
                } else {
                    w.a(CheckoutActivity.this.getLifecycleActivity(), (ai) aiVar);
                }
                CheckoutActivity.this.ai();
            }
        });
        return false;
    }

    private boolean ak() {
        View a;
        boolean z = false;
        TextView textView = (TextView) this.i.findViewById(R.id.first_name);
        TextView textView2 = (TextView) this.i.findViewById(R.id.last_name);
        TextView textView3 = (TextView) this.i.findViewById(R.id.address1);
        TextView textView4 = (TextView) this.i.findViewById(R.id.address2);
        TextView textView5 = (TextView) this.i.findViewById(R.id.city);
        TextView textView6 = (TextView) this.i.findViewById(R.id.postcode);
        Spinner spinner = (Spinner) this.i.findViewById(R.id.state_spinner);
        Spinner spinner2 = (Spinner) this.i.findViewById(R.id.country_spinner);
        TextView textView7 = (TextView) this.i.findViewById(R.id.email);
        TextView textView8 = (TextView) this.i.findViewById(R.id.phone);
        boolean z2 = true;
        if (textView.getText().toString().isEmpty()) {
            textView.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z2 = false;
        }
        if (textView2.getText().toString().isEmpty()) {
            textView2.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z2 = false;
        }
        if (textView3.getText().toString().isEmpty()) {
            textView3.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z2 = false;
        }
        if (textView5.getText().toString().isEmpty()) {
            textView5.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z2 = false;
        }
        if (textView6.getText().toString().isEmpty()) {
            textView6.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z2 = false;
        }
        if (spinner2.getSelectedItem() == null) {
            a = ((h) spinner2.getAdapter()).a();
            if (a != null && (a instanceof TextView)) {
                ((TextView) a).setError(StringConstants.SELECT.getMessage());
            }
            z2 = false;
        }
        if (spinner.getSelectedItem() == null) {
            a = ((h) spinner.getAdapter()).a();
            if (a != null && (a instanceof TextView)) {
                ((TextView) a).setError(StringConstants.SELECT.getMessage());
            }
            z2 = false;
        }
        if (textView7.getText().toString().isEmpty()) {
            textView7.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z2 = false;
        } else if (!b(textView7.getText().toString())) {
            textView7.setError(StringConstants.VALID_EMAIL.getMessage());
            z2 = false;
        }
        if (textView8.getText().toString().isEmpty()) {
            textView8.setError(StringConstants.CANT_BE_EMPTY.getMessage());
        } else {
            z = z2;
        }
        if (z) {
            BillingAddress billing_address = this.ap.getOrder().getBilling_address();
            billing_address.setFirst_name(textView.getText().toString());
            billing_address.setLast_name(textView2.getText().toString());
            billing_address.setAddress_1(textView3.getText().toString());
            billing_address.setAddress_2(textView4.getText().toString());
            billing_address.setCity(textView5.getText().toString());
            billing_address.setPostcode(textView6.getText().toString());
            billing_address.setState(w.a(this.an, String.valueOf(spinner.getSelectedItem())));
            billing_address.setCountry(w.a(this.aq.getShippable_countries(), String.valueOf(spinner2.getSelectedItem())));
            billing_address.setEmail(textView7.getText().toString());
            billing_address.setPhone(textView8.getText().toString());
        }
        return z;
    }

    private boolean al() {
        TextView textView = (TextView) this.ae.findViewById(R.id.first_name);
        TextView textView2 = (TextView) this.ae.findViewById(R.id.last_name);
        TextView textView3 = (TextView) this.ae.findViewById(R.id.address1);
        TextView textView4 = (TextView) this.ae.findViewById(R.id.address2);
        TextView textView5 = (TextView) this.ae.findViewById(R.id.city);
        TextView textView6 = (TextView) this.ae.findViewById(R.id.postcode);
        Spinner spinner = (Spinner) this.ae.findViewById(R.id.state_spinner);
        Spinner spinner2 = (Spinner) this.ae.findViewById(R.id.country_spinner);
        if (((CheckBox) this.ae.findViewById(R.id.checkbox_ship)).isChecked()) {
            this.ap.getOrder().setShipping_address(ShippingAddress.fromBillingAddress(this.ap.getOrder().getBilling_address()));
            am();
        } else {
            boolean z;
            View a;
            if (textView.getText().toString().isEmpty()) {
                textView.setError(StringConstants.CANT_BE_EMPTY.getMessage());
                z = false;
            } else {
                z = true;
            }
            if (textView2.getText().toString().isEmpty()) {
                textView2.setError(StringConstants.CANT_BE_EMPTY.getMessage());
                z = false;
            }
            if (textView3.getText().toString().isEmpty()) {
                textView3.setError(StringConstants.CANT_BE_EMPTY.getMessage());
                z = false;
            }
            if (textView5.getText().toString().isEmpty()) {
                textView5.setError(StringConstants.CANT_BE_EMPTY.getMessage());
                z = false;
            }
            if (textView6.getText().toString().isEmpty()) {
                textView6.setError(StringConstants.CANT_BE_EMPTY.getMessage());
                z = false;
            }
            if (spinner2.getSelectedItem() == null) {
                a = ((h) spinner2.getAdapter()).a();
                if (a != null && (a instanceof TextView)) {
                    ((TextView) a).setError(StringConstants.SELECT.getMessage());
                }
                z = false;
            }
            if (spinner.getSelectedItem() == null) {
                a = ((h) spinner.getAdapter()).a();
                if (a != null && (a instanceof TextView)) {
                    ((TextView) a).setError(StringConstants.SELECT.getMessage());
                }
                z = false;
            }
            if (z) {
                ShippingAddress shipping_address = this.ap.getOrder().getShipping_address();
                shipping_address.setFirst_name(textView.getText().toString());
                shipping_address.setLast_name(textView2.getText().toString());
                shipping_address.setAddress_1(textView3.getText().toString());
                shipping_address.setAddress_2(textView4.getText().toString());
                shipping_address.setCity(textView5.getText().toString());
                shipping_address.setPostcode(textView6.getText().toString());
                shipping_address.setState(w.a(this.an, String.valueOf(spinner.getSelectedItem())));
                shipping_address.setCountry(w.a(this.aq.getShippable_countries(), String.valueOf(spinner2.getSelectedItem())));
                am();
            }
        }
        return false;
    }

    private void am() {
        this.e.getCartService().addAddress(this.ap.getOrder()).enqueue(new Callback<Cart>() {
            public void onFailure(Call<Cart> call, Throwable th) {
            }

            public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                Cart cart = (Cart) aiVar.b();
                if (cart != null) {
                    CheckoutActivity.this.aq = cart;
                    CheckoutActivity.this.ao = a.SHIPPING_METHOD;
                    CheckoutActivity.this.ar();
                    return;
                }
                w.a(CheckoutActivity.this.getLifecycleActivity(), (ai) aiVar);
            }
        });
    }

    private boolean an() {
        RadioButton radioButton = (RadioButton) this.ai.findViewById(this.ai.getCheckedRadioButtonId());
        if (radioButton == null) {
            return false;
        }
        PaymentGateway paymentGateway = (PaymentGateway) radioButton.getTag();
        as = paymentGateway;
        this.ap.getOrder().setPayment_details(PaymentDetails.fromPaymentGateway(paymentGateway));
        return true;
    }

    private boolean ao() {
        this.ap.getOrder().setNote(((EditText) this.ag.findViewById(R.id.order_note)).getText().toString());
        if (this.aq.getShipping_lines() == null || this.aq.getShipping_lines().size() == 0) {
            ah();
            this.ao = a.ORDER_REVIEW;
            ar();
        } else {
            RadioButton radioButton = (RadioButton) this.ah.findViewById(this.ah.getCheckedRadioButtonId());
            if (radioButton != null) {
                this.ap.getOrder().setShipping_lines(new ShippingLine[]{(ShippingLine) radioButton.getTag()});
                this.e.getCartService().addShippingMethod(r0).enqueue(new Callback<Cart>() {
                    public void onFailure(Call<Cart> call, Throwable th) {
                    }

                    public void onResponse(Call<Cart> call, ai<Cart> aiVar) {
                        Cart cart = (Cart) aiVar.b();
                        if (cart != null) {
                            CheckoutActivity.this.aq = cart;
                            CheckoutActivity.this.ah();
                            CheckoutActivity.this.ao = a.ORDER_REVIEW;
                            CheckoutActivity.this.ar();
                            return;
                        }
                        w.a(CheckoutActivity.this.getLifecycleActivity(), (ai) aiVar);
                    }
                });
            }
        }
        return false;
    }

    private void ap() {
        int i = 1;
        new LinearLayout(getLifecycleActivity()).setOrientation(1);
        this.ai.removeAllViews();
        Iterator it = this.aq.getPayment_gateways().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                PaymentGateway paymentGateway = (PaymentGateway) it.next();
                View radioButton = new RadioButton(getLifecycleActivity());
                radioButton.setId((this.aq.getPayment_gateways().size() * 2) + i2);
                radioButton.setTag(paymentGateway);
                radioButton.setText(paymentGateway.getMethod_title());
                this.ai.addView(radioButton);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void aq() {
        int i = 1;
        new LinearLayout(getLifecycleActivity()).setOrientation(1);
        this.ah.removeAllViews();
        if (this.aq.getShipping_lines() != null) {
            Iterator it = this.aq.getShipping_lines().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                ShippingLine shippingLine = (ShippingLine) it.next();
                View radioButton = new RadioButton(getLifecycleActivity());
                radioButton.setId((this.aq.getShipping_lines().size() * 2) + i2);
                radioButton.setTag(shippingLine);
                radioButton.setText(shippingLine.getMethod_title() + "(" + shippingLine.getTotal() + ")");
                this.ah.addView(radioButton);
                i = i2 + 1;
            }
        }
        if (this.aq.getShipping_lines() == null || this.aq.getShipping_lines().size() == 0) {
            ((TextView) this.ag.findViewById(R.id.shippingMethodTitle)).setText(StringConstants.ORDER_NOTE.getMessage());
        } else {
            ((TextView) this.ag.findViewById(R.id.shippingMethodTitle)).setText(StringConstants.SHIPPING_METHOD.getMessage());
        }
    }

    private void ar() {
        if (this.ao == a.BILLING) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        if (this.ao == a.SHIPPING_ADDRESS) {
            this.ae.setVisibility(0);
        } else {
            this.ae.setVisibility(8);
        }
        if (this.ao == a.SHIPPING_METHOD) {
            aq();
            this.ag.setVisibility(0);
        } else {
            this.ag.setVisibility(8);
        }
        if (this.ao == a.ORDER_REVIEW) {
            this.aj.setVisibility(0);
        } else {
            this.aj.setVisibility(8);
        }
        if (this.ao == a.PAYMENT_METHOD) {
            ap();
            this.ak.setVisibility(0);
        } else {
            this.ak.setVisibility(8);
        }
        if (this.ao == a.COMPLETED) {
            this.am.setVisibility(4);
            this.al.setVisibility(0);
            return;
        }
        this.al.setVisibility(8);
    }

    private void as() {
        if (this.at != null) {
            this.e.getWooSecureService().getOrderInfo(this.at).enqueue(new Callback<Order>() {
                public void onFailure(Call<Order> call, Throwable th) {
                }

                public void onResponse(Call<Order> call, ai<Order> aiVar) {
                    Order order = (Order) aiVar.b();
                    if (order != null) {
                        CheckoutActivity.this.a(order);
                    }
                }
            });
        }
    }

    private boolean b(String str) {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(str).matches();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.checkout_acitivity, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        this.h = (LinearLayout) inflate.findViewById(R.id.placeholder);
        Button button = (Button) inflate.findViewById(R.id.next);
        button.setText(StringConstants.NEXT.getMessage());
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CheckoutActivity.this.ag();
            }
        });
        this.ar = (Button) inflate.findViewById(R.id.back);
        this.ar.setText(StringConstants.BACK.getMessage());
        this.ar.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CheckoutActivity.this.af();
            }
        });
        if (this.ao == null) {
            this.ao = a.BILLING;
            this.ar.setEnabled(false);
        } else if (this.ao == a.BILLING) {
            this.ar.setEnabled(false);
        }
        this.i = (LinearLayout) inflate.findViewById(R.id.billingaddress);
        this.ae = (LinearLayout) inflate.findViewById(R.id.shipping_address);
        this.af = (LinearLayout) inflate.findViewById(R.id.shipping_address_inner);
        this.ag = (LinearLayout) inflate.findViewById(R.id.shipping_method);
        this.ah = (RadioGroup) inflate.findViewById(R.id.shippingRadio);
        this.ai = (RadioGroup) inflate.findViewById(R.id.paymentMethodRadio);
        this.aj = (LinearLayout) inflate.findViewById(R.id.order_review);
        this.ak = (LinearLayout) inflate.findViewById(R.id.payment_method);
        this.al = (LinearLayout) inflate.findViewById(R.id.order_complete);
        this.am = (LinearLayout) inflate.findViewById(R.id.actions);
        ae();
        ad();
        a(this.i);
        a(this.i, new HashMap(), null);
        a(this.ae);
        a(this.ae, new HashMap(), null);
        a(this.i, this.ap.getOrder().getBilling_address());
        a(this.ae, this.ap.getOrder().getShipping_address());
        ar();
        return inflate;
    }

    public void a(Menu menu, MenuInflater menuInflater) {
        Log.d("AndroApp:", "OnCreateOptionsMenu Called CartActivity");
        menu.clear();
        super.a(menu, menuInflater);
    }

    public void a(Cart cart) {
        this.aq = cart;
    }

    public void a(CreateOrderRequest createOrderRequest) {
        this.ap = createOrderRequest;
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        a(bundle);
        d(true);
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        if (this.aq != null) {
            bundle.putSerializable("cartObject", this.aq);
        }
        if (this.ap != null) {
            bundle.putSerializable("createOrderRequestObject", this.ap);
            bundle.putSerializable("checkOutStep", this.ao);
        }
    }

    public AndroAppFragmentType getFragmentType() {
        return AndroAppFragmentType.CHECKOUT_ACTIVITY;
    }

    public String getTitle() {
        return StringConstants.CHECKOUT.getMessage();
    }

    public Object getTriggerObject() {
        return null;
    }

    public void t() {
        super.t();
        Log.d("AndroApp", "CheckoutActivity Resume");
        if (getLifecycleActivity() != null) {
            ((FullscreenActivity) getLifecycleActivity()).a(getFragmentType());
            ((FullscreenActivity) getLifecycleActivity()).a(getTitle());
            ((FullscreenActivity) getLifecycleActivity()).b(false);
        }
        if (this.ao == a.COMPLETED) {
            as();
        }
        FriopinApplication.a().a("checkout screen");
    }
}
