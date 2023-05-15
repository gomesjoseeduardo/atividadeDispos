package com.example.decormoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    //Declarando variaveis
    EditText user, email, pwd;
    Button send;

    //Declarando o arquivo de preferencia
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        user=(EditText) findViewById(R.id.editNome);
        email=(EditText) findViewById(R.id.editEmail);
        pwd=(EditText) findViewById(R.id.editPassword);
        send=(Button) findViewById(R.id.button_cadastrar);

        //Classe SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, 0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declarando variaveis locais
                String usuariolocal = user.getText().toString();
                String emaillocal = email.getText().toString();
                String senhalocal = pwd.getText().toString();

                //Declarando editor - modo SharedPreferences no modo de edicao
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //Fazendo a persistencia dos dados
                editor.putString("usuario", usuariolocal);
                editor.putString("email", emaillocal);
                editor.putString("senha", senhalocal);

                //Confirmação da persistencia
                editor.commit();

                //Notificação do APP
                Toast.makeText(MainActivity3.this, "Dados cadastrados no arquivo .xml com sucesso!", Toast.LENGTH_SHORT).show();

                //Limpar o formulario (global) para o proximo cadastro
                user.getText().clear();
                email.getText().clear();
                pwd.getText().clear();
                user.getText().clear();
            }
        });
    }
}