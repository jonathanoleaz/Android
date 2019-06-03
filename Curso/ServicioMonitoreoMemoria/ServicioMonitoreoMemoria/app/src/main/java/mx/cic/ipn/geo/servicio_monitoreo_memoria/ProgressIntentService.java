package mx.cic.ipn.geo.servicio_monitoreo_memoria;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Un {@link IntentService} que simula un proceso en primer plano
 * <p>
 */
public class ProgressIntentService extends IntentService {
    private static final String TAG = ProgressIntentService.class.getSimpleName();

    public ProgressIntentService() {
        super("ProgressIntentService");
    }

    private void startMyOwnForeground(int max, int progress) {
        String NOTIFICATION_CHANNEL_ID = "mx.cic.ipn.geo.servicio_monitoreo_memoria";
        String channelName = "My Background Service";
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(chan);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(true)
                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                .setContentTitle("App is running in background")
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setProgress(max, progress, false)
                .build();
        startForeground(2, notification);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (Constants.ACTION_RUN_ISERVICE.equals(action)) {
                handleActionRun();
            }
        }
    }

    /**
     * Maneja la acción de ejecución del servicio
     */
    private void handleActionRun() {
        int for_count = 25;
        try {
            // Se construye la notificación
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.stat_sys_download_done)
                    .setContentTitle("Servicio en segundo plano")
                    .setContentText("Procesando...");
            // Ciclo for de simulación
            for (int i = 1; i <= for_count; i++) {
                Log.d(TAG, i + ""); // Escribir mensaje en el log

                // Poner en primer plano
                builder.setProgress(10, i, false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    startMyOwnForeground(for_count, i);
                else
                    startForeground(1, builder.build());
                Intent localIntent = new Intent(Constants.ACTION_RUN_ISERVICE)
                        .putExtra(Constants.EXTRA_PROGRESS, i);

                // Emisión de {@code localIntent}
                LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

                // Retardo de 1 segundo en la iteración
                Thread.sleep(1000);
            }
            // Quitar de primer plano
            stopForeground(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Servicio destruido...", Toast.LENGTH_SHORT).show();

        // Emisión para avisar que se terminó el servicio
        Intent localIntent = new Intent(Constants.ACTION_PROGRESS_EXIT);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}
