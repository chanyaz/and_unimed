package com.puzzlersworld.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
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
import com.puzzlersworld.wp.dto.Customer;
import com.puzzlersworld.wp.dto.StringConstants;
import javax.inject.Inject;
import mobi.androapp.ac.c8700.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.ai;

public class LoginFragment extends Fragment {
    @Inject
    RestServiceManager a;
    @Inject
    g b;
    private EditText c;
    private EditText d;
    private Button e;

    private boolean ac() {
        boolean z;
        String obj = this.c.getText().toString();
        if (obj == null || obj.isEmpty()) {
            this.c.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z = true;
        } else {
            z = false;
        }
        String obj2 = this.d.getText().toString();
        if (obj2 == null || obj2.isEmpty()) {
            this.d.setError(StringConstants.CANT_BE_EMPTY.getMessage());
            z = true;
        }
        return !z;
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.login_fragment, viewGroup, false);
        InjectibleApplication.a((Fragment) this);
        this.c = (EditText) inflate.findViewById(R.id.nameTextBox);
        this.d = (EditText) inflate.findViewById(R.id.emailTextBox);
        ((TextView) inflate.findViewById(R.id.name)).setText(StringConstants.USERNAME.getMessage());
        ((TextView) inflate.findViewById(R.id.email)).setText(StringConstants.PASSWORD.getMessage());
        ((TextView) inflate.findViewById(R.id.enter)).setText(StringConstants.SUBMIT.getMessage());
        this.e = (Button) inflate.findViewById(R.id.enter);
        this.e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LoginFragment.this.a();
            }
        });
        return inflate;
    }

    public void a() {
        if (ac()) {
            String obj = this.c.getText().toString();
            FullscreenActivity.s = Base64.encodeToString((obj + ":" + this.d.getText().toString()).getBytes(), 2);
            this.a.getWooSecureService().getCustomerInfo().enqueue(new Callback<Customer>() {
                public void onFailure(Call<Customer> call, Throwable th) {
                }

                public void onResponse(Call<Customer> call, ai<Customer> aiVar) {
                    Customer customer = (Customer) aiVar.b();
                    if (customer == null) {
                        w.a(LoginFragment.this.getLifecycleActivity(), (ai) aiVar);
                    }
                    if (customer != null && customer.getId() != null) {
                        ((LoginActivity) LoginFragment.this.getLifecycleActivity()).a(customer);
                    }
                }
            });
        }
    }
}
