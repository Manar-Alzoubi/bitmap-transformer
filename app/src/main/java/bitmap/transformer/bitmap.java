package bitmap.transformer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bitmap {

    private String outfile;
    private BufferedImage img ;
    private BufferedImage img2;

    public bitmap(BufferedImage img, String outputFile) {
        this.img = img;
        this.outfile = outputFile;
    }
    public File imgRes(String outfile) throws IOException {
        File outfile2 = new File(outfile);
        return outfile2;
    }

    public void setimg2() {
        this.img2 = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);

    }

    public BufferedImage getimg2() {
        return img2;
    }
    public void dark()  {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("app/src/main/resources/image.bmp"));
            System.out.println("image is read");
            int width = img.getWidth();
            int height = img.getHeight();
            int rgb;

            for (int h = 1; h < height; h++) {
                for (int w = 1; w < width; w++) {
                    rgb = img.getRGB(w,h)-650;
                    img.setRGB(w, h, rgb);
                }}

                        ImageIO.write(img, "bmp", new File("app/src/main/resources/image5.bmp"));
                        System.out.println("image is written with dark mode ");

                     }catch (IOException e) {
            System.err.println("an error occurred while reading image ");
        }
    }

    public void light()  {
 try {
        img = ImageIO.read(new File("app/src/main/resources/image.bmp"));
        System.out.println("image is read");
     int rgb;
     int width = img.getWidth();
     int height = img.getHeight();

     for (int h = 1; h < height; h++) {
         for (int w = 1; w < width; w++) {
             rgb = (this.img.getRGB(w, h) * 2) %256;

             this.img.setRGB(w, h, rgb);

         } }
                ImageIO.write(img, "bmp", new File("app/src/main/resources/image6.bmp"));
                System.out.println("image is written with light mode ");


        } catch (IOException e) {
         System.err.println("an error occurred while reading image ");
     }

        }
    public void BlacknWhite()  {
        try {
            img = ImageIO.read(new File("app/src/main/resources/image.bmp"));
            System.out.println("image is read");
            int rgb;
            int width = img.getWidth();
            int height = img.getHeight();

            for (int h = 1; h < height; h++) {
                for (int w = 1; w < width; w++) {
                    rgb = (this.img.getRGB(w, h) * 256) % 5;
                    this.img.setRGB(w, h, rgb);

                } }
            ImageIO.write(img, "bmp", new File("app/src/main/resources/image3.bmp"));
            System.out.println("image is written with black and white ");


        } catch (IOException e) {
            System.err.println("an error occurred while reading image ");
        }

    }

}
