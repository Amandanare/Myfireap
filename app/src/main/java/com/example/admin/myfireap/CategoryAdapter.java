package com.example.admin.myfireap;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 8/3/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new Entertainment();
        }
        if (position==1){
            return new GameReserves();
        }
        if (position==2){
            return new Accomodation();

        }if (position==3){
            return new ShoppingMalls();
        }
       return (null);
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public CharSequence getPageTitle (int position){
        if (position==0){
            return "Entertainment";
        }
        if (position==1){
            return "GameReserves";
        }
        if (position==2){
            return "Accomodation";
        }if (position==3){
            return "ShoppingMalls";
        }else {
            return "null";
        }
    }
}
