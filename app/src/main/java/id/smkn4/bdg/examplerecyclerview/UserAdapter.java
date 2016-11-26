package id.smkn4.bdg.examplerecyclerview;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.smkn4.bdg.examplerecyclerview.model.UserModel;
import id.smkn4.bdg.examplerecyclerview.retrofit.dao.UserApiDao;

/**
 * Created by root on 26/11/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<UserModel> list = new ArrayList<>();
    Context context;
    private Dialog dialog;

    public UserAdapter(List<UserModel> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtUsername.setText(list.get(position).getUsername());
        holder.txtEmail.setText(list.get(position).getEmail());

        dialog = new Dialog(context);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Data ke-"+ position, Toast.LENGTH_SHORT).show();
        //        Intent i = new Intent(this, "");
        //        i.putExtra("username", list.get(position).getUsername())
        //        context.startActivity(i);

                dialog.setTitle(list.get(position).getUsername());
                dialog.setCancelable(true);
                dialog.show();
                //dialog.setContentView(R.layout.dsadas); <== custom pake layout sendiri
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtUsername, txtEmail;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_row);
            txtEmail = (TextView) itemView.findViewById(R.id.email);
            txtUsername = (TextView) itemView.findViewById(R.id.username);
        }
    }


}
