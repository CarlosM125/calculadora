package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private TextView tvRes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRes=findViewById(R.id.textView);
    }
    public void calcular (View view){
        Button boton = (Button) view;
        switch (boton.getText().toString()){
            case "=":
                resultados(tvRes.getText().toString());
                break;
            case "C":
                if(tvRes.getText().toString()!=""){
                    tvRes.setText("");
                }

                break;
            case "DEL":
                if(tvRes.getText().toString()!=""){
                    tvRes.setText(tvRes.getText().toString().substring(0,tvRes.getText().toString().length()-1));
                }
                break;
            default:
                tvRes.setText(""+tvRes.getText() + boton.getText());
                break;
        }
    }
    public void resultados (String valores){
        try {
            valores=valores.replace("X","*");
            Expression expression = new ExpressionBuilder(valores).build();
            double result = expression.evaluate();
            tvRes.setText("" + result);

        } catch (Exception e) {
            tvRes.setText("Error en la expresión");
        }

    }


}