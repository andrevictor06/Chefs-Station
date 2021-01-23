package com.yorkdecorsoftware.chefsstation.ui.modopreparo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.yorkdecorsoftware.chefsstation.R;
import com.yorkdecorsoftware.chefsstation.ui.receita.TabsReceitaFragmentAdapter;


public class MedidaFragment extends Fragment {

    private MedidaViewModel medidaViewModel;
    private TabsReceitaFragmentAdapter adapter;
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        medidaViewModel =
//                new ViewModelProvider(this).get(MedidaViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_medida, container, false);
//        final TextView textView = root.findViewById(R.id.text_medida);
//        medidaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }

    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medida, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        adapter = new TabsReceitaFragmentAdapter(getContext());
//        viewPager = view.findViewById(R.id.pager);
//        viewPager.setAdapter(adapter);
    }
}
