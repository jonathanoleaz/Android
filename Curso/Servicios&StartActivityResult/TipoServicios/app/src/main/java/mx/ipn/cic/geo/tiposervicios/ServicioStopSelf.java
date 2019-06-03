package mx.ipn.cic.geo.tiposervicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServicioStopSelf extends Service {
    public ServicioStopSelf() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
    }

    public void onStart(Intent intent, int startID)
    {
        System.out.println("El servicio a comenzado...");
        this.stopSelf();
    }

    public void onDestroy()
    {
        super.onDestroy();
        System.out.println("El servicio a terminado...");
    }
}
