package BusinessLogic.Entities;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import java.awt.image.BufferedImage;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class LZCodigoQR {
    public static void generateQR(String data, String filePath) {
        int width = 300;
        int height = 300;
        String format = "png";

        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
            Path path = FileSystems.getDefault().getPath(filePath);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ImageIO.write(image, format, new File(path.toString()));
            System.out.println("Código QR generado con éxito.");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
