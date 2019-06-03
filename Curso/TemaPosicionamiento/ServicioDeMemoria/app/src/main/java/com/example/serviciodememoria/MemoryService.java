package com.example.serviciodememoria;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MemoryService extends Service {
    private static final String TAG= MemoryService.class.getSimpleName();
    TimerTask timerTask;

    public MemoryService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    public void onCreate(){
        Log.d(TAG, "Servicio creado");
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG, "Servicio iniciado");

        final ActivityManager.MemoryInfo memoryInfo=new ActivityManager.MemoryInfo();
        final ActivityManager activityManager=(ActivityManager) getSystemService(ACTIVITY_SERVICE);

        Timer timer=new Timer();

        timerTask=new TimerTask() {
            @Override
            public void run() {
                activityManager.getMemoryInfo(memoryInfo);
                String availMem=memoryInfo.availMem/1048576 + "MB";

                Log.d(TAG, availMem);

                Intent localIntent=new Intent(Constantes.ACTION_RUN_SERVICE).putExtra(Constantes.EXTRA_MEMORY, availMem);

                LocalBroadcastManager.getInstance(MemoryService.this).sendBroadcast(localIntent);
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 1000);
        return START_NOT_STICKY;

    }

    public void onDestroy(){
        timerTask.cancel();
        Intent localIntent=new Intent(Constantes.ACTION_MEMORY_EXIT);

        //emitir el intent d ela actividad
        LocalBroadcastManager.getInstance(MemoryService.this).sendBroadcast(localIntent);
        Log.d(TAG, "Servicio destruido...");
    }

}
