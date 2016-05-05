package br.com.hugo.pubsbeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetalheBarActivity extends AppCompatActivity {

    private TextView tvDetBarNome, tvDetBarEndereco;
    private ListView lvCervejaBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_bar);
        int index = getIntent().getIntExtra("bar_id", 0);
        Bar bar = BaresActivity.bares.get(index);

        tvDetBarNome = (TextView) findViewById(R.id.tvDetBarNome);
        tvDetBarNome.setText(bar.getNome());
        tvDetBarEndereco = (TextView) findViewById(R.id.tvDetBarEndereco);
        tvDetBarEndereco.setText(bar.getEndereco());

        lvCervejaBar = (ListView) findViewById(R.id.lvCervejaBar);
        List<String> nomesCervejas = new ArrayList<>();
        for (int cerveja : bar.getCervejas()) {
            nomesCervejas.add(CervejasActivity.cervejas.get(cerveja).getNome());
        }
        ListAdapter cervejas = new ArrayAdapter<String>(DetalheBarActivity.this, android.R.layout.simple_list_item_1, nomesCervejas);
        lvCervejaBar.setAdapter(cervejas);
    }
}
