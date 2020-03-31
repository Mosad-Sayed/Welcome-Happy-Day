package com.mosad.Happy_Day.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.mosad.Happy_Day.R;

public class AboutFragment extends Fragment {
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    public static Fragment newInstance() {
        AboutFragment aboutFragment = new AboutFragment();
        return aboutFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        View contenedor = (View) container.getParent();
        appBar = (AppBarLayout) contenedor.findViewById(R.id.appBar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fragmentManager) {

            super(fragmentManager);
        }

        String[] tituloTabs = {"About Us", "Connect Us"};

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new AbotUsFragment();
                case 1:
                    return new SocialMedia();

            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tituloTabs[position];
        }
    }

}





