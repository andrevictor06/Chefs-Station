package com.yorkdecorsoftware.chefsstation.ui.receita;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.yorkdecorsoftware.chefsstation.databinding.FragmentReceitaBinding;
import com.yorkdecorsoftware.chefsstation.ui.receita.TabsReceita;

public class TabsReceitaFragmentAdapter extends FragmentStateAdapter {

    private FragmentReceitaBinding binding;
    private Bundle savedInstanceState;

    public TabsReceitaFragmentAdapter(Fragment fragment, Bundle savedInstanceState) {
        super(fragment);
        this.savedInstanceState = savedInstanceState;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        TabsReceita tab = TabsReceita.values()[position];
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment = null;
        try {
            fragment = tab.getClasse().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt("title", tab.getTitleResId());
        args.putInt("layout", tab.getLayoutResId());
        if(this.savedInstanceState != null){
            this.savedInstanceState.putAll(args);
        }else{
            this.savedInstanceState = args;
        }
        fragment.setArguments(this.savedInstanceState);
        return fragment;
    }



//    @Override
//        public Object instantiateItem(ViewGroup collection, int position) {
//            TabsReceita tabsReceita = TabsReceita.values()[position];
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            ViewGroup layout = (ViewGroup) inflater.inflate(tabsReceita.getLayoutResId(), collection, false);
//            System.out.println("layout.getContext() "+ layout.getContext().getClass().getSimpleName());
//        try {
//            Fragment fragment = tabsReceita.getClasse().newInstance();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//        collection.addView(layout);
//            return layout;
//        }

//        @Override
//        public void destroyItem(ViewGroup collection, int position, Object view) {
//            collection.removeView((View) view);
//        }

        @Override
        public int getItemCount() {
            return TabsReceita.values().length;
        }

//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            TabsReceita customPagerEnum = TabsReceita.values()[position];
//            return mContext.getString(customPagerEnum.getTitleResId());
//        }

}
