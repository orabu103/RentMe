package com.example.rentme.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.rentme.R;
import com.example.rentme.adapters.ProductListAdapter;
import com.example.rentme.model.Product;

import java.util.ArrayList;

public class InsideCategoryFragment extends Fragment{

    Button backBtn;
    MainFragment mainFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inside_category, container, false);
        backBtn = view.findViewById(R.id.back_to_last_page);

        ListView listView = view.findViewById(R.id.products_list);

        //need to delete and change for data base/////////////////////////////////////////////////
        ArrayList<Product> items = new ArrayList<Product>();
        Product p1 = new Product("במבה נוגט", "אביזרים", "מוצר מעולה עובד טוב","good" ,"8","day","https://firebasestorage.googleapis.com/v0/b/rentme-cdf84.appspot.com/o/1575064589026.jpg?alt=media&token=1fccfb2a-15b3-4c66-957b-861657637f68");
        Product p2 = new Product("במבה נוגט", "אביזרים", "מוצר מעולה עובד טוב",
                "good" ,"8","day", "https://firebasestorage.googleapis.com/v0/b/rentme-cdf84.appspot.com/o/1575064589026.jpg?alt=media&token=1fccfb2a-15b3-4c66-957b-861657637f68");
        Product p3 = new Product("כיסאות", "אביזרים", "מאזור אשדוד","good","8","99");
        Product p4 = new Product("אחר", "אביזרים", "אחר אחר","goof","8","99");
        Product p5 = new Product("אחר 2", "אביזרים", "אחר אחר", "good","8","99");
        Product p6 = new Product("אחר", "אביזרים", "אחר אחר", "good","8","99");
        Product p7 = new Product("אחר 2", "אביזרים", "אחר אחר", "good","8","99");
        items.add(p1);
        items.add(p2);
        items.add(p3);
        items.add(p4);
        items.add(p5);
        items.add(p6);
        items.add(p7);

        ArrayList<Product> items2 = new ArrayList<Product>();
        Product q1 = new Product("מברגה חשמלית", "מוצרי חשמל", "מוצר מעולה עובד טוב", "dd","8","99");
        Product q2 = new Product("לפטופ", "מוצרי חשמל", "השכרה גם לשבוע", "good","8","99");
        Product q3 = new Product("כיסאות", "מוצרי חשמל", "מאזור אשדוד", "good","8","99");
        Product q4 = new Product("אחר", "מוצרי חשמל", "אחר אחר", "good","8","99");
        Product q5 = new Product("אחר 2", "מוצרי חשמל", "אחר אחר", "good","8","99");
        Product q6 = new Product("אחר", "מוצרי חשמל", "אחר אחר","good","8","99");
        Product q7 = new Product("אחר 2", "מוצרי חשמל", "אחר אחר","good","8","99");
        items2.add(q1);
        items2.add(q2);
        items2.add(q3);
        items2.add(q4);
        items2.add(q5);
        items2.add(q6);
        items2.add(q7);

        //need to delete and change for data base/////////////////////////////////////////////////

        //get the category name that was clicked
        String category = "none";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            category = bundle.getString("category");
        }

        ProductListAdapter adapter;

        if (category.equals("אביזרים"))
            adapter = new ProductListAdapter(items, getActivity());//suppose to get from the data base
        else
            adapter = new ProductListAdapter(items2, getActivity());//suppose to get from the data base

        listView.setAdapter(adapter);

        //set the category title
        TextView CategoryTitle = view.findViewById(R.id.category_title);
        CategoryTitle.setText(category);


        // Back To Main Activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainFragment == null)
                    mainFragment = new MainFragment();
                outerTransaction(mainFragment);
            }
        });


        return view;
    }
/*
    @Override
    public void showMoreDetails() {
        if (inItemFragment == null)
            inItemFragment = new InItemFragment();
        outerTransaction(inItemFragment);

    }
*/
    private void outerTransaction(Fragment fragment){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.OuterFragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}


