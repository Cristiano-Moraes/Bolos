package com.moraes.mobile.bolos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;


public class CustomProductAdapter extends BaseAdapter {
    private ArrayList<String> listProdutos;
    private String[] produtos;
    Context ctx;

    public CustomProductAdapter(Context context, String[]p) {
        this.ctx = context;
        this.produtos = p;
        this.listProdutos = new ArrayList<String>(Arrays.asList(produtos));
    }

    private class ViewHolder {
        TextView nameCell;
    }
    @Override
    public int getCount() {
        return listProdutos.size();
    }

    @Override
    public Object getItem(int position) {
        return listProdutos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.custom_produtos_cell, parent, false);
            holder = new ViewHolder();
            holder.nameCell =  convertView.findViewById(R.id.productCustomName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameCell.setText(produtos[position]);
        return convertView;
    }



}
