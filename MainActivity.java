package com.example.cafe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mViewHolder.button_cafe = findViewById(R.id.button_cafe);
        this.mViewHolder.button_mais = findViewById(R.id.button_mais);
        this.mViewHolder.button_menos = findViewById(R.id.button_menos);
        this.mViewHolder.button_cafeLeite = findViewById(R.id.button_cafeLeite);
        this.mViewHolder.button_cappuccino = findViewById(R.id.button_cappuccino);
        this.mViewHolder.text_precoUni = findViewById(R.id.text_precoUni);
        this.mViewHolder.text_precoTotal = findViewById(R.id.text_precoTotal);
        this.mViewHolder.text_quantidade = findViewById(R.id.text_quantidade);
        this.mViewHolder.text_mensagem = findViewById(R.id.text_mensagem);


        this.mViewHolder.button_cafe.setOnClickListener(this);
        this.mViewHolder.button_cafeLeite.setOnClickListener(this);
        this.mViewHolder.button_cappuccino.setOnClickListener(this);
        this.mViewHolder.button_mais.setOnClickListener(this);
        this.mViewHolder.button_menos.setOnClickListener(this);

        Button pedido = findViewById(R.id.button_pedido);

        pedido.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //   Toast.makeText (v.getContext (), "test", Toast.LENGTH_SHORT) .show ();
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType(" * / * ");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, "cafe.do.ifc.concordia@gmail.com");
                sendEmail.putExtra(Intent.EXTRA_TEXT, "seu pedido foi realizado");
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Cafe");

                if (sendEmail.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendEmail);
                    Log.i("OnClick", "enviei:");

                }
                Log.i(" Onclick ", "botao pressionado");
            }
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        int quant = 0;
        float preco;
        float conta = 0;
        if (v.getId() == R.id.button_cafe){
            preco = 2;
            this.mViewHolder.text_precoUni.setText("R$2,00");

            if (v.getId() == R.id.button_mais){
                quant = quant + 1;
                conta = quant * preco;
                this.mViewHolder.text_quantidade.setText(quant);
                this.mViewHolder.text_precoTotal.setText((int) conta);
            }
            if (v.getId() == R.id.button_menos){
                quant = quant - 1;
                this.mViewHolder.text_quantidade.setText(quant);
                this.mViewHolder.text_precoTotal.setText((int) conta);
            }
            this.mViewHolder.text_mensagem.setText("Gostaria de "+quant+" cafes. Por Favor. O valor total sera de R$"+conta);
        }

        if (v.getId() == R.id.button_cafeLeite){
            preco = 3;
            this.mViewHolder.text_precoUni.setText("R$3,00");

            if (v.getId() == R.id.button_mais){
                quant = quant + 1;
                conta = quant * preco;
                this.mViewHolder.text_quantidade.setText(quant);
                this.mViewHolder.text_precoTotal.setText((int) conta);
            }
            if (v.getId() == R.id.button_menos){
                quant = quant - 1;
                this.mViewHolder.text_quantidade.setText(quant);
                this.mViewHolder.text_precoTotal.setText((int) conta);
            }
            this.mViewHolder.text_mensagem.setText("Gostaria de "+quant+" cafes com leite. Por Favor. O valor total sera de R$"+conta);
        }

        if (v.getId() == R.id.button_cappuccino){
            preco = 4;
            this.mViewHolder.text_precoUni.setText("R$4,00");

            if (v.getId() == R.id.button_mais){
                quant = quant + 1;
                conta = quant * preco;
                this.mViewHolder.text_quantidade.setText(quant);
                this.mViewHolder.text_precoTotal.setText((int) conta);
            }
            if (v.getId() == R.id.button_menos){
                quant = quant - 1;
                this.mViewHolder.text_quantidade.setText(quant);
                this.mViewHolder.text_precoTotal.setText((int) conta);
            }
            this.mViewHolder.text_mensagem.setText("Gostaria de "+quant+" cappuccinos. Por Favor. O valor total sera de R$"+conta);
        }

    }

    private static class ViewHolder{

        Button button_cafe;
        Button button_cafeLeite;
        Button button_cappuccino;
        Button button_mais;
        Button button_menos;
        TextView text_precoUni;
        TextView text_precoTotal;
        TextView text_quantidade;
        TextView text_mensagem;

    }
}
