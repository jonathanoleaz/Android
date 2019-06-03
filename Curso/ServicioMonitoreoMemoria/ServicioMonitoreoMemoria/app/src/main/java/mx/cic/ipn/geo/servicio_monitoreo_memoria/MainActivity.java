package mx.cic.ipn.geo.servicio_monitoreo_memoria;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    // Text views para los datos
    private TextView memoryUsageText;
    private TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener las etiquetas
        memoryUsageText = this.findViewById(R.id.memory_ava_text);
        progressText = this.findViewById(R.id.progress_text);

        // Obtener botón de monitoreo de memoria
        ToggleButton button = this.findViewById(R.id.toggle_button);

        // Establecer el change listener
        button.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Intent intentMemoryService = new Intent(
                                getApplicationContext(), MemoryService.class);
                        if (isChecked) {
                            startService(intentMemoryService); // Iniciar servicio
                        } else {
                            stopService(intentMemoryService); // Detener servicio
                        }
                    }
                }
        );

        // Filtro de acciones que serán alertadas
        IntentFilter filter = new IntentFilter(Constants.ACTION_RUN_ISERVICE);
        filter.addAction(Constants.ACTION_RUN_SERVICE);
        filter.addAction(Constants.ACTION_MEMORY_EXIT);
        filter.addAction(Constants.ACTION_PROGRESS_EXIT);

        // Crear un nuevo ResponseReceiver
        ResponseReceiver receiver = new ResponseReceiver();
        // Registrar el receiver y su filtro
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }

    /**
     * Método onClick() personalizado para {@code turn_intent_service}
     * @param v View presionado
     */
    public void onClickTurnIntentService(View v) {
        Intent intent = new Intent(this, ProgressIntentService.class);
        intent.setAction(Constants.ACTION_RUN_ISERVICE);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // Broadcast receiver que recibe las emisiones desde los servicios
    private class ResponseReceiver extends BroadcastReceiver {

        // Sin instancias
        private ResponseReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case Constants.ACTION_RUN_SERVICE:
                    memoryUsageText.setText(intent.getStringExtra(Constants.EXTRA_MEMORY));
                    break;

                case Constants.ACTION_RUN_ISERVICE:
                    progressText.setText(intent.getIntExtra(Constants.EXTRA_PROGRESS, -1) + "");
                    break;

                case Constants.ACTION_MEMORY_EXIT:
                    memoryUsageText.setText(getString(R.string.memory_ava_text_string));
                    break;

                case Constants.ACTION_PROGRESS_EXIT:
                    progressText.setText(getString(R.string.progress_text_string));
                    break;
            }
        }
    }
}