package com.puzzlersworld.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.puzzlersworld.android.FullscreenActivity;
import com.puzzlersworld.android.util.InjectibleApplication;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.w;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.dto.CreateCustomerRequest;
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.StringConstants;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.ai;

public class RegisterFragment extends Fragment {
    @Inject
    RestServiceManager a;
    @Inject
    g b;
    private EditText c;
    private EditText d;
    private EditText e;
    private EditText f;
    private EditText g;
    private EditText h;
    private Button i;

    private void a(EditText editText) {
        String obj = editText.getText().toString();
        if (obj == null || obj.isEmpty()) {
            editText.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            throw new Exception("Invalid");
        }
    }

    private boolean ac() {
        try {
            a(this.c);
            a(this.d);
            a(this.e);
            a(this.f);
            a(this.g);
            a(this.h);
            if (!Patterns.EMAIL_ADDRESS.matcher(this.d.getText().toString()).matches()) {
                this.d.setError(StringConstants.VALID_EMAIL.getMessage());
                return false;
            } else if (this.g.getText().toString().equals(this.h.getText().toString())) {
                return true;
            } else {
                this.h.setError(StringConstants.PASSWORDS_DONT_MATCH.getMessage());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Customer ad() {
        Customer customer = new Customer();
        customer.setFirst_name(this.c.getText().toString());
        customer.setLast_name(this.e.getText().toString());
        customer.setEmail(this.d.getText().toString());
        customer.setUsername(this.f.getText().toString());
        return customer;
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.register_fragment, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        this.c = (EditText) inflate.findViewById(R.id.first_name);
        this.d = (EditText) inflate.findViewById(R.id.email);
        this.e = (EditText) inflate.findViewById(R.id.last_name);
        this.f = (EditText) inflate.findViewById(R.id.user_name);
        this.g = (EditText) inflate.findViewById(R.id.password);
        this.h = (EditText) inflate.findViewById(R.id.repassword);
        this.c.setHint(StringConstants.FIRST_NAME.getMessage());
        this.d.setHint(StringConstants.EMAIL.getMessage());
        this.e.setHint(StringConstants.LAST_NAME.getMessage());
        this.f.setHint(StringConstants.USERNAME.getMessage());
        this.g.setHint(StringConstants.PASSWORD.getMessage());
        this.h.setHint(StringConstants.REPASSWORD.getMessage());
        ((TextView) inflate.findViewById(R.id.enter)).setText(StringConstants.SUBMIT.getMessage());
        this.i = (Button) inflate.findViewById(R.id.enter);
        this.c.setText(this.b.j());
        this.d.setText(this.b.k());
        this.i.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                RegisterFragment.this.a();
            }
        });
        return inflate;
    }

    public void a() {
        if (ac()) {
            Customer ad = ad();
            final CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
            createCustomerRequest.setPassword(this.g.getText().toString());
            createCustomerRequest.setCustomer(ad);
            this.a.getWpApiService().createCustomer(createCustomerRequest).enqueue(new Callback<Customer>() {
                public void onFailure(Call<Customer> call, Throwable th) {
                }

                public void onResponse(Call<Customer> call, ai<Customer> aiVar) {
                    Customer customer = (Customer) aiVar.b();
                    if (customer == null) {
                        w.a(RegisterFragment.this.getLifecycleActivity(), (ai) aiVar);
                    }
                    if (customer != null && customer.getId() != null) {
                        String username = createCustomerRequest.getCustomer().getUsername();
                        FullscreenActivity.s = Base64.encodeToString((username + ":" + createCustomerRequest.getPassword()).getBytes(), 2);
                        ((LoginActivity) RegisterFragment.this.getLifecycleActivity()).a(customer);
                    }
                }
            });
        }
    }
}
