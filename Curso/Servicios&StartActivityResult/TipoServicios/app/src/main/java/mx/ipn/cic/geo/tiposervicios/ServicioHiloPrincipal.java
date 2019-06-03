package mx.ipn.cic.geo.tiposervicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

public class ServicioHiloPrincipal extends Service {
    public ServicioHiloPrincipal() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int idArranque)
    {
        double numero = intent.getExtras().getDouble("numero");
        SystemClock.sleep(10000);
        MainActivity.textViewSalida.append(numero * numero + "\n");
        return START_STICKY;
    }
}

