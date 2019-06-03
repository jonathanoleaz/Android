package mx.ipn.cic.geo.tiposervicios;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private EditText editTextEntrada;
    public static TextView textViewSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEntrada = findViewById(R.id.editTextEntrada);
        textViewSalida = findViewById(R.id.textViewSalida);
    }

    public void servicioStopSelf(View v) {
        startService(new Intent(this, ServicioStopSelf.class));
    }

    public void servicioHiloPrincipal(View v) {
        double numero = Double.parseDouble(editTextEntrada.getText().toString());

        textViewSalida.append(numero + "^2 = ");
        Intent intent = new Intent(this, ServicioHiloPrincipal.class);
        intent.putExtra("numero", numero);
        startService(intent);
    }

    public void servicioIntentService(View v)
    {
        double numero = Double.parseDouble(editTextEntrada.getText().toString());

        textViewSalida.append(numero + "^2 = ");
        Intent intent = new Intent(this, ServicioIntentService.class);
        intent.putExtra("numero", numero);
        startService(intent);
    }
}
