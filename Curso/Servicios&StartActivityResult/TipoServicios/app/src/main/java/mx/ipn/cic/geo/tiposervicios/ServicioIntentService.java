package mx.ipn.cic.geo.tiposervicios;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

public class ServicioIntentService extends IntentService {
    public ServicioIntentService() {
        super("ServicioIntentService");
    }

    @Override

    protected void onHandleIntent(Intent intent) {
        double numero = intent.getExtras().getDouble("numero");

        SystemClock.sleep(25000);
        MainActivity.textViewSalida.append(numero*numero + "\n");
    }
}
