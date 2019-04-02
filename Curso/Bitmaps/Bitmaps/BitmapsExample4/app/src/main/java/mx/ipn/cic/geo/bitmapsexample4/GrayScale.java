package mx.ipn.cic.geo.bitmapsexample4;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class GrayScale extends Algorithm {
    private enum OptionMethod {GREEN_VALUE, YIQ_EQUATION, READ_LINE, READ_IMAGE}

    public GrayScale(ProgressBar progressBar, Bitmap sourceImage) {
        super(progressBar, sourceImage);
        // TODO Auto-generated constructor stub
        progressBar.setMax(sourceImage.getHeight());
    }

    @Override
    protected Bitmap doInBackground(ImageView... params) {
        this.imageViewReference = new WeakReference<>(params[0]);
        OptionMethod option = OptionMethod.READ_IMAGE;

        if (option == OptionMethod.GREEN_VALUE)
            return this.convertUsingGreen();
        if (option == OptionMethod.YIQ_EQUATION)
            return this.convertUsingYIQ();
        if (option == OptionMethod.READ_LINE)
            return this.convertReadLine();
        if (option == OptionMethod.READ_IMAGE)
            return this.convertReadImage();
        return null;
    }

    private Bitmap convertUsingGreen()
    {
        int width = this.sourceImage.getWidth();
        int height = this.sourceImage.getHeight();
        int green, pixelColor;

        // Hacer un barrido top-down en la imagen a procesar.
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                // Obtener el color del pixel en la posición actual.
                pixelColor = this.sourceImage.getPixel(x, y);
                green = Color.green(pixelColor);
                this.resultImage.setPixel(x, y, Color.rgb(green, green, green));
            }
            // Mostrar en progreso del algoritmo.
            if((this.progressBarReference != null) && (this.progressBarReference.get() != null))
                publishProgress();
        }
        return this.resultImage;
    }

    private Bitmap convertUsingYIQ()
    {
        int width = this.sourceImage.getWidth();
        int height = this.sourceImage.getHeight();
        int result, pixelColor;

        // Hacer un barrido top-down en la imagen a procesar.
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                // Obtener el color del pixel en la posición actual.
                pixelColor = this.sourceImage.getPixel(x, y);
                // Obtener el nivel de gris usando ecuación modelo YIQ.
                result = (int)(Math.round((0.30)*((float)Color.red(pixelColor)) +
                         (0.59)*((float)Color.green(pixelColor)) +
                         (0.11)*((float)Color.blue(pixelColor))));
                this.resultImage.setPixel(x, y, Color.rgb(result, result, result));
            }
            // Mostrar en progreso del algoritmo.
            if((this.progressBarReference != null) && (this.progressBarReference.get() != null))
                publishProgress();
        }
        return this.resultImage;
    }

    private Bitmap convertReadLine()
    {
        int width = this.sourceImage.getWidth();
        int height = this.sourceImage.getHeight();
        int pixels[] = new int[this.sourceImage.getWidth()];
        int result, pixelColor;

        // Hacer un barrido top-down en la imagen a procesar.
        for(int y = 0; y < height; y++)
        {
            // Read a complete line from source bitmap.
            this.sourceImage.getPixels(pixels, 0, width, 0, y, width, 1);
            for(int x = 0; x < width; x++)
            {
                // Obtener el color del pixel en la posición actual.
                pixelColor = pixels[x];
                result = (int)(Math.round((0.30)*((float)Color.red(pixelColor)) +
                        (0.59)*((float)Color.green(pixelColor)) +
                        (0.11)*((float)Color.blue(pixelColor))));
                pixels[x] = Color.rgb(result, result, result);
            }
            this.resultImage.setPixels(pixels, 0, width, 0, y, width, 1);
            // Mostrar en progreso del algoritmo.
            if((this.progressBarReference != null) && (this.progressBarReference.get() != null))
                publishProgress();
        }
        return this.resultImage;
    }

    private Bitmap convertReadImage()
    {
        int width = this.sourceImage.getWidth();
        int height = this.sourceImage.getHeight();
        int pixels[] = new int[this.sourceImage.getWidth() * this.sourceImage.getHeight()];
        int result, pixelColor;

        // Read all bitmap information.
        this.sourceImage.getPixels(pixels, 0, width, 0, 0, width, height);
        // Hacer un barrido top-down en la imagen a procesar.
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                // Obtener el color del pixel en la posición actual.
                pixelColor = (pixels[(y * width) + x]);
                result= (int)(Math.round((0.30)*((float)Color.red(pixelColor)) +
                        (0.59)*((float)Color.green(pixelColor)) +
                        (0.11)*((float)Color.blue(pixelColor))));
                pixels[(y * width) + x] = Color.rgb(result, result, result);
            }
            // Mostrar en progreso del algoritmo.
            if((this.progressBarReference != null) && (this.progressBarReference.get() != null))
                publishProgress();
        }
        this.resultImage.setPixels(pixels, 0, width, 0, 0, width, height);
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
