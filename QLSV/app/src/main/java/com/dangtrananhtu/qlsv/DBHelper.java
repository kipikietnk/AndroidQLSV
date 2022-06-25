package com.dangtrananhtu.qlsv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBHelper {
    Context context;
    String dbName = "qlsv.db";


    public DBHelper(Context context) {
        this.context = context;
    }

    private SQLiteDatabase openDB() {
        return context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }

    private void closeDB(SQLiteDatabase db) {
        db.close();
    }

    public void createTable() {
        SQLiteDatabase db = openDB();
        String sqlQlsv = "CREATE TABLE IF NOT EXISTS qlsv (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " masv TEXT," +
                " tensv TEXT," +
                " que TEXT," +
                " gioitinh TEXT," +
                " khoa TEXT," +
                " khoa_sv TEXT," +
                " nganh TEXT," +
                " email TEXT," +
                " sdt TEXT," +
                " ghichu TEXT);";


        db.execSQL(sqlQlsv);
        closeDB(db);
    }


    public ArrayList<SinhVien> getAllSinhVien() {
        SQLiteDatabase db = openDB();
        ArrayList<SinhVien> arr = new ArrayList<>();
        String sql = "select * from qlsv";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String mssv = csr.getString(1);
                    String name = csr.getString(2);
                    String que = csr.getString(3);
                    String gioitinh = csr.getString(4);
                    String khoa = csr.getString(5);
                    String khoasv = csr.getString(6);
                    String nganh = csr.getString(7);
                    String email = csr.getString(8);
                    String sdt = csr.getString(9);
                    String ghichu = csr.getString(10);
                    SinhVien sinhVien = new SinhVien(id, mssv, name, que, gioitinh, khoa, khoasv, nganh,email,sdt,ghichu);
                    arr.add(sinhVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }


    public ArrayList<SinhVien> getAllSinhVien(String content) {
        SQLiteDatabase db = openDB();
        ArrayList<SinhVien> arr = new ArrayList<>();
        String sql = "select * from qlsv where tensv like" + "'%" + content + "%'";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String mssv = csr.getString(1);
                    String name = csr.getString(2);
                    String que = csr.getString(3);
                    String gioitinh = csr.getString(4);
                    String khoa = csr.getString(5);
                    String khoasv = csr.getString(6);
                    String nganh = csr.getString(7);
                    String email = csr.getString(8);
                    String sdt = csr.getString(9);
                    String ghichu = csr.getString(10);
                    SinhVien sinhVien = new SinhVien(id, mssv, name, que, gioitinh, khoa, khoasv, nganh,email,sdt,ghichu);
                    arr.add(sinhVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public SinhVien getSinhVien(String idsv) {
        SQLiteDatabase db = openDB();
        ArrayList<SinhVien> arr = new ArrayList<>();
        String sql = "select * from qlsv where id = " + idsv;
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String mssv = csr.getString(1);
                    String name = csr.getString(2);
                    String que = csr.getString(3);
                    String gioitinh = csr.getString(4);
                    String khoa = csr.getString(5);
                    String khoasv = csr.getString(6);
                    String nganh = csr.getString(7);
                    String email = csr.getString(8);
                    String sdt = csr.getString(9);
                    String ghichu = csr.getString(10);
                    SinhVien sinhVien = new SinhVien(id, mssv, name, que, gioitinh, khoa, khoasv, nganh,email,sdt,ghichu);
                    arr.add(sinhVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr.get(0);
    }
    //
//
//
    public void insertSv(SinhVien sv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("masv", sv.getMssv());
        contentValues.put("tensv", sv.getTensv());
        contentValues.put("que", sv.getQue());
        contentValues.put("gioitinh", sv.getGioitinh());
        contentValues.put("khoa", sv.getKhoa());
        contentValues.put("khoa_sv", sv.getKhoaSv());
        contentValues.put("nganh", sv.getNganh());
        contentValues.put("email", sv.getEmail());
        contentValues.put("sdt", sv.getSdt());
        contentValues.put("ghichu", sv.getGhichu());
        SQLiteDatabase db = openDB();
        db.insert("qlsv", null, contentValues);
        closeDB(db);
    }
    public void updateSv(SinhVien sv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("masv", sv.getMssv());
        contentValues.put("tensv", sv.getTensv());
        contentValues.put("que", sv.getQue());
        contentValues.put("gioitinh", sv.getGioitinh());
        contentValues.put("khoa", sv.getKhoa());
        contentValues.put("khoa_sv", sv.getKhoaSv());
        contentValues.put("nganh", sv.getNganh());
        contentValues.put("email", sv.getEmail());
        contentValues.put("sdt", sv.getSdt());
        contentValues.put("ghichu", sv.getGhichu());
        SQLiteDatabase db = openDB();
        db.update("qlsv",  contentValues, "id" + " = ?",
                new String[]{sv.id});
        closeDB(db);
    }

    public void deleteSv(String id) {
        SQLiteDatabase db = openDB();
        db.delete("qlsv", "id" + " = ?",
                new String[]{id});
    }
//

}
