package br.com.hugo.pubsbeer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> acounts = new ArrayList<String>();

    private TextView etEmail, etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (TextView) findViewById(R.id.etEmail);
        etSenha = (TextView) findViewById(R.id.etSenha);
        findViewById(R.id.btEntrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String conta : acounts) {
                    String[] credenciais = conta.split(":");
                    String email = etEmail.getText().toString();
                    String senha = etSenha.getText().toString();
                    if (credenciais[0].equals(email)) {
                        if (credenciais[1].equals(senha)) {
                            startActivity(new Intent(MainActivity.this, MesaActivity.class));
                            return;
                        }
                    }
                }
                Toast.makeText(MainActivity.this, "Não existe usuário cadastrado com estas credenciais", Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btCadastrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });
    }
}
