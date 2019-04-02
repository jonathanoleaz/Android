package mx.ipn.cic.geo.bitmapsexample4;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class Algorithm extends AsyncTask<ImageView, Void, Bitmap> {
    protected WeakReference<ImageView> imageViewReference = null;
    protected WeakReference<ProgressBar> progressBarReference = null;
    protected Bitmap sourceImage;
    protected Bitmap resultImage;

    public Algorithm(ProgressBar progressBar, Bitmap sourceImage)
    {
        try
        {
            // Asignar la referencia a la imagen original a manipular.
            this.sourceImage = sourceImage;
            // Crear una imagen donde se guardarán los resultados del algoritmo.
            this.resultImage = Bitmap.createBitmap(this.sourceImage.getWidth(),
                    this.sourceImage.getHeight(),
                    this.sourceImage.getConfig());
            // Asignar la referencia al control que mostrará el progreso del algoritmo.
            if(progressBar != null)
                this.progressBarReference = new WeakReference<>(progressBar);
        }
        catch(Exception e)
        {
            // Escribir el mensaje de error en el log.
            Log.e("Algorithm", "Ocurrió un error en la creación del mapa de bits" + e.toString());
            this.sourceImage = null;
            this.resultImage = null;
            this.sourceImage = null;
        }
    }

    @Override
    protected Bitmap doInBackground(ImageView... params) {
        // TODO Auto-generated method stub
        return null;
    }

    public Bitmap getResultBitmap()
    {
        return this.resultImage;
    }
}
