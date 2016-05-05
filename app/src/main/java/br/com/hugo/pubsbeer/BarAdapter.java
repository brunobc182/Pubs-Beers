package br.com.hugo.pubsbeer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class BarAdapter extends BaseAdapter {

    private Context context;
    private List<Bar> bares;

    public BarAdapter(Context contexto, List<Bar> bares) {
        this.context = contexto;
        this.bares = bares;
    }

    @Override
    public int getCount() {
        return bares.size();
    }

    @Override
    public Object getItem(int position) {
        return bares.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bares.indexOf(bares.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_bar_adapter, null);
        ((TextView) convertView.findViewById(R.id.tvBarAdapter)).setText(bares.get(position).getNome());
        ((TextView) convertView.findViewById(R.id.tvEnderecoBarAdapter)).setText(bares.get(position).getEndereco());
        return convertView;
    }

    public List<Bar> getBares() {
        return bares;
    }

    public void setBares(List<Bar> bares) {
        this.bares = bares;
    }
}
