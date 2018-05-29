package com.example.asus.pedrapapeltesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolhePapel(View v){
        this.opcaoSelecionada("papel");
    }

    public void escolheTesoura(View v){
        this.opcaoSelecionada("tesoura");
    }

    public void escolhePedra(View v){
        this.opcaoSelecionada("pedra");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = (TextView) findViewById(R.id.tvEscolhaAbaixo);

        //gerar opção aletatória do App
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (opcaoApp == "pedra" && escolhaUsuario == "tesoura") ||
                (opcaoApp == "papel" && escolhaUsuario == "pedra") ||
                (opcaoApp == "tesoura" && escolhaUsuario == "papel")
                ){ //verifica condições para App ganhar
            textoResultado.setText("Você perdeu!! :(");
        } else if (
                (escolhaUsuario == "pedra" && opcaoApp == "tesoura") ||
                (escolhaUsuario == "papel" && opcaoApp == "pedra") ||
                (escolhaUsuario == "tesoura" && opcaoApp == "papel")
                ){ //verifica condições para usuário ganhar
            textoResultado.setText("Você ganhou!! :)");
        } else { //empate
            textoResultado.setText("Empatamos!! ;)");
        }
    }
}
