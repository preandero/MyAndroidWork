package com.lec.android.a008_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyPhonebookAdapter extends RecyclerView.Adapter<MyPhonebookAdapter.ViewHolder> {

    List<MyPhonebook> items = new ArrayList<MyPhonebook>();


    static MyPhonebookAdapter adapter;

    public MyPhonebookAdapter() {
        this.adapter = this;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 주어진 ViewGroup 으로부터 LayoutInflater 호출
        LayoutInflater inf = LayoutInflater.from(parent.getContext());
        // 준비된 레이아웃(XML) 으로부터 View 를 만들어 ViewGroup 에 붙이고
        // 그렇게 만들어진 View 를 리턴한다
        View itemView = inf.inflate(R.layout.myitem, parent, false);

        // 위에서 만들어진 새로운 View를 ViewHolder 에 담아 리턴

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyPhonebook item = items.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        // ViewHolder 에 담긴 각각의 View 들을 담을 변수

        TextView cardName, cardAge, cardAddress;
        ImageButton btnDelete;


        // 생성자 필수
        public ViewHolder(@NonNull View itemView) { // item 레이아웃의 View 객체가 전달됨.
            super(itemView);

            // View 객체 가져오기

            cardName = itemView.findViewById(R.id.cardName);
            cardAge = itemView.findViewById(R.id.cardAge);
            cardAddress = itemView.findViewById(R.id.cardAddress);


            btnDelete = itemView.findViewById(R.id.btnDelete);



            // 삭제버튼 누르면 item 삭제되게 하기

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // position 정보 필요하다
                    // adapter 로 부터 데이터 삭제도 진행되어야 한다.
                    adapter.removeItem(getAdapterPosition()); // 데이터 삭제
                    // 데이터 변경 내역이 adapter 에 반영되어야 정상적으로 동작함!!!
                    adapter.notifyDataSetChanged();

                }
            });




        }

        public void setItem (MyPhonebook item){

            cardName.setText(item.getName());
            cardAge.setText(item.getAge());
            cardAddress.setText(item.getAddress());
        }


    }


    public void addItem(MyPhonebook item) {
        items.add(item);
    }

    public void addItem(int position, MyPhonebook item) {
        items.add(position, item);
    }

    public void setItems(ArrayList<MyPhonebook> items) {
        this.items = items;
    }

    public MyPhonebook getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, MyPhonebook item) {
        items.set(position, item);
    }

    public void removeItem(int position) {
        items.remove(position);
    }
}
