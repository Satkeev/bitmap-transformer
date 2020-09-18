package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import static java.awt.Color.yellow;

public class Bitmap {
    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/BitMapImage.bmp" ));
        } catch (IOException e) {

        }
        int height = img.getHeight();
        int width = img.getWidth();

        final BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        System.out.println(height  + "  " +  width + " " + img.getRGB(30, 30));

        for (int h = 1; h<height; h++)
        {
            for (int w = 1; w<width; w++)
            {
                Color pixelColor = new Color(img.getRGB(h, w), true);
                newImage.setRGB(h, w, yellow.getRGB());

            }
        }
        try {
            ImageIO.write(newImage, "bmp", new File("src/main/resources/testImage.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
