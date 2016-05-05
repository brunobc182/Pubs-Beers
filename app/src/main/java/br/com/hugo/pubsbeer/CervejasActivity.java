package br.com.hugo.pubsbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CervejasActivity extends AppCompatActivity {

    public static List<Cerveja> cervejas = new ArrayList<>();

    private ListView lvCervejas;

    static {
        cervejas.add(new Cerveja("Bavária", "Bulgaria", "Maltada", 1, 2));
        cervejas.add(new Cerveja("Antártica", "Brasil", "Maltada", 1, 2));
        cervejas.add(new Cerveja("Coca Cola", "E.U.A", "Refri", 2, 3));
        cervejas.add(new Cerveja("Fanta", "E.U.A", "Refri", 3, 4));
        cervejas.add(new Cerveja("Guaraná", "Brasil", "Refri", 3));
        cervejas.add(new Cerveja("Dolly", "Brasil", "Refri", 1, 2));
        cervejas.add(new Cerveja("Budwheiser", "Belgica", "Trigo", 4, 5));
        cervejas.add(new Cerveja("Bhrama", "Brasil", "Manteiga", 1));
        cervejas.add(new Cerveja("Chopp", "Holanda", "Maltada", 2, 4, 5));
        cervejas.add(new Cerveja("Skol", "Brasil", "Maltada", 5, 6));
        cervejas.add(new Cerveja("Korona", "México", "Suave", 3, 6));
        cervejas.add(new Cerveja("Beats", "Brasil", "Maltada", 3, 2));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cervejas);
        lvCervejas = (ListView) findViewById(R.id.lvCervejas);
        List<String> nomesCervejas = new ArrayList<>();
        for (Cerveja cerveja : CervejasActivity.cervejas) {
            nomesCervejas.add(cerveja.getNome());
        }
        ListAdapter cervejas = new ArrayAdapter<String>(CervejasActivity.this, android.R.layout.simple_list_item_1, nomesCervejas);
        lvCervejas.setAdapter(cervejas);

        lvCervejas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(CervejasActivity.this, DetalheCervejaActivity.class).putExtra("cerveja_id", position));
            }
        });
    }
}
