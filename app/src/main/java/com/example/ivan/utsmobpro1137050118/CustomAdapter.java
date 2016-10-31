package com.example.ivan.utsmobpro1137050118;

/**
 * Created by adrian on 31/10/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
    private Activity activity;
    private int[] gambar;
    private String[] deskripsi;
    private LayoutInflater inflater;

    public CustomAdapter(Activity activity, int[] gambar, String[] deskripsi) {
        // TODO Auto-generated method stub
        this.activity = activity;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return deskripsi.length;
    }

    @Override
    public Object getItem(int location) {
        // TODO Auto-generated method stub
        return location;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder{
        TextView textDeskripsi;
        ImageView imageGambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        Holder holder = new Holder();

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.nama_android, null);

        // set text deskripsi
        holder.textDeskripsi = (TextView) convertView.findViewById(R.id.txt_deskripsi);

        holder.textDeskripsi.setText(deskripsi[position]);

        // set gambar
        holder.imageGambar = (ImageView) convertView.findViewById(R.id.img_gambar);
        holder.imageGambar.setImageResource(gambar[position]);

        return convertView;
    }

}
