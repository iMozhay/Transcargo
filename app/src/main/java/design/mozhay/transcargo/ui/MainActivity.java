package design.mozhay.transcargo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayoutMediator;

import design.mozhay.transcargo.R;
import design.mozhay.transcargo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        MainViewPagerAdapter mainAdapter = new MainViewPagerAdapter(this);
        binding.viewPager2.setAdapter(mainAdapter);

        new TabLayoutMediator(binding.tabs, binding.viewPager2, (tab, position) -> {
            if (position == 0) {
                tab.setText(getString(R.string.tab_text_1));
            } else if (position == 1) {
                tab.setText(getString(R.string.tab_text_2));
            } else {
                tab.setText(getString(R.string.tab_text_3));
            }
        })
                .attach();
    }
}