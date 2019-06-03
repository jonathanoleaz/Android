package mx.cic.ipn.geo.start_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivitySumar extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumar);

        this.findViewById(R.id.buttonCalcularSuma).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double operandoUno, operandoDos;
        double resultado;

        EditText editTextOperandoUno = this.findViewById(R.id.editTextOperandoUno);
        EditText editTextOperandoDos = this.findViewById(R.id.editTextOperandoDos);
        operandoUno = Double.valueOf(editTextOperandoUno.getText().toString());
        operandoDos = Double.valueOf(editTextOperandoDos.getText().toString());
        resultado = operandoUno + operandoDos;

        Intent resultIntent = new Intent();
        resultIntent.putExtra("resultado_suma", resultado);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
