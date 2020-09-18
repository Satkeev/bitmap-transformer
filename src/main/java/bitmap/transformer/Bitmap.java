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
            img = ImageIO.read(new File("src/main/resources/mario.bmp" ));
        } catch (IOException e) {

        }
        int height = img.getHeight();
        int width = img.getWidth();

        final BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

//        System.out.println(height  + "  " +  width + " " + img.getRGB(30, 30));
        int red;
        int rgb;

        for (int h = 1; h<height; h++)
        {
            for (int w = 1; w<width; w++)
            {
                rgb = img.getRGB(h,w);
                Color pixelColor = new Color(img.getRGB(h, w), true);
//                System.out.println(pixelColor);
//                System.out.println(img.getRGB(h, w));
                red = (rgb>>8) & 0x00FFFF00;
                newImage.setRGB(h, w, red);

            }
        }
        try {
            ImageIO.write(newImage, "bmp", new File("src/main/resources/testImage.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
