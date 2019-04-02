package mx.ipn.cic.geo.bitmapsexample4;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.jtransforms.fft.DoubleFFT_2D;

import java.lang.ref.WeakReference;

public class Fourier extends Algorithm {
    public Fourier(ProgressBar progressBar, Bitmap sourceImage) {
        super(progressBar, sourceImage);
        // TODO Auto-generated constructor stub
        progressBar.setMax(sourceImage.getHeight());
    }

    @Override
    protected Bitmap doInBackground(ImageView... params) {
        this.imageViewReference = new WeakReference<>(params[0]);

        // Obtener los valores y aplicar la transformada FFT.
        int height = this.sourceImage.getHeight();
        int width = this.sourceImage.getWidth();
        int result, pixelColor;
        // Para almacenar los valores de la imagen.
        int pixels[] = new int[width * height];
        // Array que contendrá el resultado de la transformación. Es el doble porque en fourier se trabaja con parte real e imaginaria
        double data[][] = new double[height][width * 2];

        // Generar la matriz para calcular la FFT.
        this.sourceImage.getPixels(pixels, 0, width, 0, 0, width, height);
        // Hacer un barrido top-down en la imagen a procesar.
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                // Obtener el color del pixel en la posición actual.
                pixelColor = (pixels[(y * width) + x]);
                data[y][x] = Color.green(pixelColor);

            }
            // Mostrar en progreso del algoritmo.
            if((this.progressBarReference != null) && (this.progressBarReference.get() != null))
                publishProgress();
        }
        DoubleFFT_2D fourier = new DoubleFFT_2D(height, width);
        // Calcular la FFT.
        fourier.complexForward(data);
        // Calcular la FFT inversa.
        fourier.complexInverse(data, true);

        this.progressBarReference.get().setProgress(0);

        // Hacer un barrido top-down en la imagen a procesar.
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                // Obtener el color del pixel en la posición actual.
                result = (int)data[y][x];
                //NO usar el setPixel
                this.resultImage.setPixel(x, y, Color.rgb(result, result, result));
            }
            // Mostrar en progreso del algoritmo.
            if((this.progressBarReference != null) && (this.progressBarReference.get() != null))
                publishProgress();
        }
        return this.resultImage;
    }

    @Override
    protected void onProgressUpdate(Void... params)
    {
        if((this.progressBarReference != null) && (this.progressBarReference.get() != null))
            this.progressBarReference.get().incrementProgressBy(1);
    }

    // Once complete, see if ImageView is still around and set bitmap.
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.d("onPostExecute", "Algoritmo finalizó correctamente...");
        if (this.imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                imageView.postInvalidate();
            }
        }
    }
}