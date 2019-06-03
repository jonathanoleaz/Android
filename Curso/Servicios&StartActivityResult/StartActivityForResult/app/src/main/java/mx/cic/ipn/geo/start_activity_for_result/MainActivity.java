package mx.cic.ipn.geo.start_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CALCULAR_SUMA_ACTIVITY = 0x100;
    private static final int CALCULAR_RESTA_ACTIVITY = 0x200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.buttonSumar).setOnClickListener(this);
        this.findViewById(R.id.buttonRestar).setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case (CALCULAR_SUMA_ACTIVITY) : {
                if (resultCode == Activity.RESULT_OK) {
                    double resultado_suma = data.getDoubleExtra("resultado_suma", 0.0);
                    Log.d("onActivityResult", "Resultado de la suma: " + resultado_suma);
                    String resultado = "Resultado de la suma: " + resultado_suma;
                    ((TextView)this.findViewById(R.id.textViewResultado)).setText(resultado);
                }
                break;
            }

            case (CALCULAR_RESTA_ACTIVITY) : {
                if (resultCode == Activity.RESULT_OK) {
                    double resultado_resta = data.getDoubleExtra("resultado_resta", 0.0);
                    Log.d("onActivityResult", "Resultado de la resta: " + resultado_resta);
                    String resultado = "Resultado de la resta: " + resultado_resta;
                    ((TextView)this.findViewById(R.id.textViewResultado)).setText(resultado);
                }
                break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        Button buttonOperacion = (Button)v;

        if (buttonOperacion.getText().toString().compareTo(getString(R.string.buttonSumar_Text)) == 0) {
            Intent intentSumar = new Intent(this, ActivitySumar.class);
            startActivityForResult(intentSumar, CALCULAR_SUMA_ACTIVITY);
        }
        else
        {
            Intent intentSumar = new Intent(this, ActivityRestar.class);
            startActivityForResult(intentSumar, CALCULAR_RESTA_ACTIVITY);
        }
    }
}



