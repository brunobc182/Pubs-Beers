package br.com.hugo.pubsbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome, etSobrenome, etNascimento, etEmail, etSenha, etConfirmarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etNome = (EditText) findViewById(R.id.etNomeCadastro);
        etSobrenome = (EditText) findViewById(R.id.etSobrenome);
        etNascimento = (EditText) findViewById(R.id.etNasciemento);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etConfirmarSenha = (EditText) findViewById(R.id.etConfirmarSenha);

        findViewById(R.id.btSubmeterCadastro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String senha = etSenha.getText().toString();
                String senhaConf = etConfirmarSenha.getText().toString();
                if (!TextUtils.isEmpty(email)) {
                    if ((!TextUtils.isEmpty(senha)) && senha.equals(senhaConf)) {
                        MainActivity.acounts.add(email + ":" + senha);
                        startActivity(new Intent(CadastroActivity.this, MainActivity.class));
                        return;
                    }
                }
                Toast.makeText(CadastroActivity.this, "E-mail e ou Senha vazios ou Senha e Confirmação não estão iguais!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
