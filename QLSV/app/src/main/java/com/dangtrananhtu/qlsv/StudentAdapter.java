package com.dangtrananhtu.qlsv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context context;
    ArrayList<SinhVien> list;
    DBHelper dbHelper;
    ActivityResultLauncher<Intent> getContent;
    public StudentAdapter(Context context, ArrayList<SinhVien> list,ActivityResultLauncher<Intent> getContent) {
        this.context = context;
        this.list = list;
        dbHelper = new DBHelper(context);
        this.getContent = getContent;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student, viewGroup, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(list.get(position));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, holder.tvNganh);
                popupMenu.inflate(R.menu.item_menu);
                popupMenu.setOnMenuItemClickListener(menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.edit:
                            Intent intent = new Intent(context, ActivityAdd.class);
                            intent.putExtra("edit", true);
                            intent.putExtra("id", list.get(position).id);
                            getContent.launch(intent);
                            break;
                        default:
                            dbHelper.deleteSv(list.get(position).id);
                            list.remove(position);
                            notifyItemRemoved(position);
                            notifyDataSetChanged();
                    }
                    return true;
                });
                popupMenu.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void notifyData(ArrayList<SinhVien> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId, tvTen, tvQue, tvKhoa, tvNganh,tvGioitinh, tvKhoaSv, tvEmail,tvSdt,tvGhichu;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTen = itemView.findViewById(R.id.tv_ten);
            tvQue = itemView.findViewById(R.id.tv_que);
            tvGioitinh = itemView.findViewById(R.id.tv_gioitinh);
            tvKhoa = itemView.findViewById(R.id.tv_khoa);
            tvNganh = itemView.findViewById(R.id.tv_nganh);
            tvKhoaSv = itemView.findViewById(R.id.tv_khoa_sv);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvSdt = itemView.findViewById(R.id.tv_sdt);
            tvGhichu = itemView.findViewById(R.id.tv_ghichu);

        }

        void bindData(SinhVien sinhVien) {
            tvId.setText("Mã sv: "+sinhVien.mssv);
            tvTen.setText("Họ tên: "+sinhVien.tensv);
            tvQue.setText("Quê: "+sinhVien.que);
            tvKhoa.setText("Khoa: "+sinhVien.khoa);
            tvGioitinh.setText("Giới tính: "+sinhVien.gioitinh);
            tvNganh.setText("Ngành: "+sinhVien.nganh);
            tvKhoaSv.setText("Khoá: "+sinhVien.khoaSv);
            tvEmail.setText("Email:: "+sinhVien.email);
            tvSdt.setText("Sdt: "+sinhVien.sdt);
            tvGhichu.setText("Ghichu: "+sinhVien.ghichu);
        }
    }

}
