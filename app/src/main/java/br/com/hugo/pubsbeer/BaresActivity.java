package br.com.hugo.pubsbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaresActivity extends AppCompatActivity {

    private ListView lvBares;
    private BarAdapter barAdapter;
    private Button btBuscaBar, btLimparBuscaBar;

    public static List<Bar> bares = new ArrayList<>();

    static {
        bares.add(new Bar("Bar Hubo", "Metrópole Caucaia", 1, 2, 3, 4));
        bares.add(new Bar("Python Bar", "Garrote Caucaia", 1, 2));
        bares.add(new Bar("Thor Bar", "Itambém Caucaia", 2, 3, 4));
        bares.add(new Bar("Açaí Bar", "Tucunduba Caucaia", 4, 5));
        bares.add(new Bar("Atacadão Bar", "Padre Romualdo Caucaia", 3, 4, 5));
        bares.add(new Bar("Estrela Bar", "Barra do Ceará Fortaleza", 6, 5, 4));
        bares.add(new Bar("Estrela 2 Bar", "Aldeota Fortaleza", 1, 6, 4));
        bares.add(new Bar("Thor 2 Bar", "Barra do Ceará Fortaleza", 5, 4, 2));
        bares.add(new Bar("Python 2 Bar", "Potira Fortaleza", 3, 4));
        bares.add(new Bar("Açaí 2 Bar", "Quintino Cunha Fortaleza", 1));
        bares.add(new Bar("Casa Bar", "Euzébio Fortaleza", 3, 4));
        bares.add(new Bar("To Voltando Bar", "Barra do Ceará Fortaleza", 6, 1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares);
        lvBares = (ListView) findViewById(R.id.lvBares);
        barAdapter = new BarAdapter(BaresActivity.this, BaresActivity.bares);
        lvBares.setAdapter(barAdapter);
        lvBares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(BaresActivity.this, DetalheBarActivity.class).putExtra("bar", id));
            }
        });
        btBuscaBar = (Button) findViewById(R.id.btBuscarBar);
        btLimparBuscaBar = (Button) findViewById(R.id.btLimparBuscaBar);

        btBuscaBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                barAdapter.setBares(BaresActivity.bares);
                barAdapter.notifyDataSetChanged();
            }
        });

        btBuscaBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barAdapter.setBares(BaresActivity.bares);
                barAdapter.notifyDataSetChanged();
            }
        });
    }
}
