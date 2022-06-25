package com.dangtrananhtu.qlsv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ActivityAdd extends AppCompatActivity {
    TextInputEditText edtId, edtTen, edtQue, edtGioiTinh, edtKhoa, edtNganh, edtKhoaSv, edtEmail, edtSdt,edtGhichu;
    Button btnAdd;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dbHelper = new DBHelper(this);
        edtId = findViewById(R.id.edt_id);
        edtTen = findViewById(R.id.edt_ten);
        edtQue = findViewById(R.id.edt_que);
        edtGioiTinh = findViewById(R.id.edt_gioitinh);
        edtKhoa = findViewById(R.id.edt_khoa);
        edtNganh = findViewById(R.id.edt_nganh);
        edtKhoaSv = findViewById(R.id.edt_khoasv);
        edtEmail = findViewById(R.id.edt_email);
        edtSdt = findViewById(R.id.edt_sdt);
        edtGhichu = findViewById(R.id.edt_ghichu);
        btnAdd = findViewById(R.id.btn_add);
        if (getIntent().getBooleanExtra("edit", false)) {
            btnAdd.setText("Sửa");
            SinhVien sinhVien = dbHelper.getSinhVien(getIntent().getStringExtra("id"));
            edtId.setText(sinhVien.mssv);
            edtTen.setText(sinhVien.tensv);
            edtQue.setText(sinhVien.que);
            edtGioiTinh.setText(sinhVien.gioitinh);
            edtKhoa.setText(sinhVien.khoa);
            edtNganh.setText(sinhVien.nganh);
            edtKhoaSv.setText(sinhVien.khoaSv);
            edtEmail.setText(sinhVien.email);
            edtSdt.setText(sinhVien.sdt);
            edtGhichu.setText(sinhVien.ghichu);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMssv(edtId.getText().toString());
                sinhVien.setTensv(edtTen.getText().toString());
                sinhVien.setQue(edtQue.getText().toString());
                sinhVien.setGioitinh(edtGioiTinh.getText().toString());
                sinhVien.setKhoa(edtKhoa.getText().toString());
                sinhVien.setNganh(edtNganh.getText().toString());
                sinhVien.setKhoaSv(edtKhoaSv.getText().toString());
                sinhVien.setEmail(edtEmail.getText().toString());
                sinhVien.setSdt(edtSdt.getText().toString());
                sinhVien.setGhichu(edtGhichu.getText().toString());
                if (getIntent().getBooleanExtra("edit", false)) {
                    sinhVien.setId(getIntent().getStringExtra("id"));
                    dbHelper.updateSv(sinhVien);
                } else {
                    dbHelper.insertSv(sinhVien);
                }
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}