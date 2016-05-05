package br.com.hugo.pubsbeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetalheCervejaActivity extends AppCompatActivity {

    private TextView tvCervNome, tvCervOrigem, tvCervTipo;
    private ListView lvBaresCerveja;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cerveja);
        int index = getIntent().getIntExtra("cerveja_id", 0);
        Cerveja cerveja = CervejasActivity.cervejas.get(index);
        tvCervNome = (TextView) findViewById(R.id.tvCervNome);
        tvCervNome.setText(cerveja.getNome());
        tvCervOrigem = (TextView) findViewById(R.id.tvCervOrigem);
        tvCervOrigem.setText(cerveja.getOrigem());
        tvCervTipo = (TextView) findViewById(R.id.tvCervTipo);
        tvCervTipo.setText(cerveja.getTipo());

        lvBaresCerveja = (ListView) findViewById(R.id.lvBaresCerveja);
        List<String> nomesBares = new ArrayList<>();
        for (int bar : cerveja.getBares()) {
            nomesBares.add(BaresActivity.bares.get(bar).getNome());
        }
        ListAdapter cervejas = new ArrayAdapter<String>(DetalheCervejaActivity.this, android.R.layout.simple_list_item_1, nomesBares);
        lvBaresCerveja.setAdapter(cervejas);

    }
}

