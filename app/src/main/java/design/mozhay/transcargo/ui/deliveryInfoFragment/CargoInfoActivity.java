package design.mozhay.transcargo.ui.deliveryInfoFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import design.mozhay.transcargo.App;
import design.mozhay.transcargo.R;
import design.mozhay.transcargo.databinding.FragmentDeliveryInfoBinding;

public class CargoInfoActivity extends AppCompatActivity {

    public static final String DELIVERY_ID = "transcargo.delivery.id";
    public static final String DELIVERY_CREATE = "transcargo.delivery.create";
    private Button mButtonClose;
    private Button mButtonOk;
    private FragmentDeliveryInfoBinding mDeliveryBinding;
    private CargoInfoActivityPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_delivery_info);

        mDeliveryBinding = FragmentDeliveryInfoBinding.inflate(getLayoutInflater());
        mButtonOk = findViewById(R.id.cargo_button_search);
        mButtonClose = findViewById(R.id.cargo_button_close);

        initialize();
        setupTextListeners();
    }

    private void initialize(){

        mPresenter = new CargoInfoActivityPresenterImpl(
                mDeliveryBinding,
                getIntent().getBooleanExtra(DELIVERY_CREATE,true));

       mButtonClose.setOnClickListener(v -> finish());

        mButtonOk.setOnClickListener(v -> mPresenter.actionSearch());
    }

    private void setupTextListeners(){
        mDeliveryBinding.cargoName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoTotalWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setCargoWeight(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoTotalVolume.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setCargoVolume(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoTotalQty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setCargoQuantity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoDerivalCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setDerivalCity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoDerivalStreet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setDerivalStreet(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoDerivalHouse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setDerivalHouse(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoArrivalCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setArrivalCity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoArrivalStreet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setArrivalStreet(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDeliveryBinding.cargoArrivalHouse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPresenter.setArrivalHouse(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



}
