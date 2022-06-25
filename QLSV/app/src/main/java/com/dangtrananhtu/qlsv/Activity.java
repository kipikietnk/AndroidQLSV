package com.dangtrananhtu.qlsv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Activity extends AppCompatActivity {
    RecyclerView rcvSinhVien;
    EditText editText;
    StudentAdapter adapter;
    ArrayList<SinhVien> list = new ArrayList<>();
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        dbHelper = new DBHelper(this);
        dbHelper.createTable();
        list = dbHelper.getAllSinhVien();
        ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == android.app.Activity.RESULT_OK) {

                        }
                        list = dbHelper.getAllSinhVien();
                        adapter.notifyData(list);
                    }
                });
        editText = findViewById(R.id.edt_search);
        rcvSinhVien = findViewById(R.id.rcv_sinhvien);
        adapter = new StudentAdapter(this, list, mGetContent);
        rcvSinhVien.setAdapter(adapter);


        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch(new Intent(Activity.this, ActivityAdd.class));
            }
        });


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                list = dbHelper.getAllSinhVien(editable.toString());
                adapter = new StudentAdapter(Activity.this, list, mGetContent);
                rcvSinhVien.setAdapter(adapter);
            }
        });
    }
}