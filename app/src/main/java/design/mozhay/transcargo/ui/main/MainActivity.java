package design.mozhay.transcargo.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import design.mozhay.transcargo.R;
import design.mozhay.transcargo.data.service.logs.LogsRepositoryImpl;
import design.mozhay.transcargo.databinding.ActivityMainBinding;
import design.mozhay.transcargo.ui.cargoFragment.CargoFragment;
import design.mozhay.transcargo.ui.logsFragment.LogsFragment;
import design.mozhay.transcargo.ui.settingsFragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private MainViewPagerAdapter mAdapter;
    private LogsRepositoryImpl mLogsRepo;
    private TabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        mTabs = findViewById(R.id.tabs);
        setupViewPager(findViewById(R.id.view_pager));

    }

    private void setupViewPager(ViewPager viewPager){
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),1);
        mAdapter.addFragment(CargoFragment.newInstance(0), getString(R.string.tab_text_1));
        mAdapter.addFragment(SettingsFragment.newInstance(1), getString(R.string.tab_text_2));

        LogsFragment logsFragment = LogsFragment.newInstance(2);

        mAdapter.addFragment(logsFragment, getString(R.string.tab_text_3));
        viewPager.setAdapter(mAdapter);
        mTabs.setupWithViewPager(viewPager);
    }
}