package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText cardName, cardAge, cardAddress;
    RecyclerView rv;
    MyPhonebookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardName = findViewById(R.id.cardName);
        cardAge = findViewById(R.id.cardAge);
        cardAddress = findViewById(R.id.cardAddress);

        rv = findViewById(R.id.rv);

        // RecyclerView 를 사용하기 위해서는 LayoutManager 지정해주어야 한다.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        // Adapter 객체 생성
        adapter = new MyPhonebookAdapter();


        rv.setAdapter(adapter); // RecyclerView 에 Adapter 장착!

        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
            }
        });

    }

    protected void insertData(View v){

        // 리스트 맨 앞에 추가
        adapter.addItem(0,new MyPhonebook(cardName.getText().toString(), cardAge.getText().toString(), cardAddress.getText().toString()));
        adapter.notifyDataSetChanged(); // 데이터변경을 Adapter 에 알리고, 리스트뷰에 반영.
    }
}
