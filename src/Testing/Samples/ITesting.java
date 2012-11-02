package Testing.Samples;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class ITesting extends Component {

    BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public ITesting() {
        try {
            img = ImageIO.read(new File("strawberry.jpg"));
        } catch (IOException e) {
            System.out.println("Te fastidiaste");
        }

        for(int i=0; i<img.getWidth();i++)
            for(int j=0; j<img.getHeight();j++)
            {
                int C = img.getRGB(i,j);

                //int red = (C >> 16) & 0xFF;
               // int green = (C >> 8) & 0xFF;
               // int blue = C & 0xFF;

                /* long red = (256^3+Color)/255^2;
              long green = (256^3+Color/255)%255;
              long blue = (256^3+Color)%255;
                */

                /* int nr = red ^ 0xFF;
         int ng = green ^ 0xFF;
         int nb = blue ^ 0xFF;

         int nc = nr;
         nc = (nc << 8) + ng;
         nc = (nc << 8) + nb; */

                // nc = red<<16+green<<8+blue;

                img.setRGB(i,j,C);

               // Color e1 = new Color(0,255,0);
                //Color e2 = new Color(C);

                //if(colorDist(e1,e2)>1000)     img.setRGB(i,j,0);

               // System.out.println(colorDist(e1,e2));

                //System.out.println("Pixel ( "+i+","+j+ " es ( "+ red + ", "+green+ ", " +blue+" ) = " + C +"-"+C);
            }

        for(int i=0; i<img.getWidth();i++)
            for(int j=0; j<img.getHeight();j++)
            {
               // int C = img.getRGB(i,j);


                int color = i%256;

                //int red = color;
                //int green = color;
                //int blue = color;

                System.out.println(color+"-"+color+"-"+color);
                Color c = new Color(color,color,color);
                img.setRGB(i,j,c.getRGB());
            }

    }

   /* double colorDist(Color e1, Color e2){
       // long rmean = ( (long)e1.getRed() + (long)e2.getRed() ) / 2;
        //long gmean = ( (long)e1.getGreen() + (long)e2.getGreen() ) / 2;
       // long bmean = ( (long)e1.getBlue() + (long)e2.getBlue() ) / 2;
        long r = (long)e1.getRed() - (long)e2.getRed();
        long g = (long)e1.getGreen() - (long)e2.getGreen();
        long b = (long)e1.getBlue() - (long)e2.getBlue();
       // System.out.println(rmean);
       // System.out.println(gmean);
       // System.out.println(bmean);
        return Math.sqrt(((r*r)) + g*g + ((b*b)));
    }                                                */

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Load Image Sample");

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(new ITesting());
        f.pack();
        f.setVisible(true);
    }
}
