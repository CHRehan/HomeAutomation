package com.waheed.home.auto.mation;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.waheed.home.auto.mation.web_services.ApiClient;
import com.waheed.home.auto.mation.web_services.Routes;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.ip_layout)
    LinearLayout ipLayout;
    @BindView(R.id.button10)
    SwitchCompat button10;
    @BindView(R.id.button11)
    SwitchCompat button11;
    @BindView(R.id.button12)
    SwitchCompat button12;
    @BindView(R.id.button13)
    SwitchCompat button13;
    @BindView(R.id.component_layout)
    LinearLayout componentLayout;

    PrefManager prefManager;
    ProgressDialog progressDialog;
    private Routes apiService;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.black));

        prefManager = PrefManager.getInstance(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Waiting...");
        progressDialog.setTitle("Sending....");
        progressDialog.setCancelable(false);

        if (prefManager.getIP() == null) {
            ipLayout.setVisibility(View.VISIBLE);
            componentLayout.setVisibility(View.GONE);
        } else {
            ApiClient.BASE_URL = prefManager.getIP();

            componentLayout.setVisibility(View.VISIBLE);
            ipLayout.setVisibility(View.GONE);
            toolbar.setSubtitle(ApiClient.BASE_URL);
            apiService = ApiClient.getClient().create(Routes.class);
        }

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter == 5) {
                    prefManager.deletAllPref();
                    ipLayout.setVisibility(View.VISIBLE);
                    componentLayout.setVisibility(View.GONE);
                    finish();
                }
            }
        });
        if (prefManager.getPin10() ) {
            button10.setChecked(true);
            button10.setText(getString(R.string.on));
        }
        if (prefManager.getPin11() ) {
            button11.setChecked(true);
            button11.setText(getString(R.string.on));
        }
        if (prefManager.getPin12()) {
            button12.setChecked(true);
            button12.setText(getString(R.string.on));
        }
        if (prefManager.getPin13() ) {
            button13.setChecked(true);
            button13.setText(getString(R.string.on));
        }
        button10.setOnCheckedChangeListener((compoundButton, b) -> {
            progressDialog.show();
            if (b) {
                apiService.getRequest(10).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                    }

                    @Override
                    public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                        progressDialog.dismiss();
                        compoundButton.setText(getString(R.string.on));
                        prefManager.setPin10(true);
                    }
                });

            } else {
                apiService.getRequest(10).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                    }

                    @Override
                    public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                        progressDialog.dismiss();
                        compoundButton.setText(getString(R.string.off));
                        prefManager.setPin10(false);
                    }
                });

            }
        });
        button11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton compoundButton, boolean b) {
                progressDialog.show();
                if (b) {
                    apiService.getRequest(11).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            progressDialog.dismiss();
                            compoundButton.setText(getString(R.string.on));
                            prefManager.setPin11(true);
                        }
                    });

                } else {
                    apiService.getRequest(11).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            progressDialog.dismiss();
                            compoundButton.setText(getString(R.string.off));
                            prefManager.setPin11(false);
                        }
                    });

                }
            }
        });
        button12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton compoundButton, boolean b) {
                progressDialog.show();
                if (b) {
                    apiService.getRequest(12).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            progressDialog.dismiss();
                            compoundButton.setText(getString(R.string.on));
                            prefManager.setPin12(true);
                        }
                    });

                } else {
                    apiService.getRequest(12).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            progressDialog.dismiss();
                            compoundButton.setText(getString(R.string.off));
                            prefManager.setPin12(false);
                        }
                    });

                }
            }
        });
        button13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton compoundButton, boolean b) {
                progressDialog.show();
                if (b) {
                    apiService.getRequest(13).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            progressDialog.dismiss();
                            compoundButton.setText(getString(R.string.on));
                            prefManager.setPin13(true);
                        }
                    });

                } else {
                    apiService.getRequest(13).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            progressDialog.dismiss();
                            compoundButton.setText(R.string.off);
                            prefManager.setPin13(false);
                        }
                    });

                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() <= 4) {
                    editText.setError("Please Enter IP ");
                    return;
                }
                ApiClient.BASE_URL = "http://" + editText.getText().toString();
                prefManager.setIP(ApiClient.BASE_URL);
                toolbar.setSubtitle(ApiClient.BASE_URL);
                ipLayout.setVisibility(View.GONE);
                componentLayout.setVisibility(View.VISIBLE);
                apiService = ApiClient.getClient().create(Routes.class);
            }
        });

    }

}
