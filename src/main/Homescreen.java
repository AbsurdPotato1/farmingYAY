package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Homescreen {
    GamePanel gp;
    boolean playClicked;

    public Homescreen(GamePanel gp) {
        this.gp = gp;
        playClicked = false;
    }

    public void draw(Graphics2D g2)  {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.setFont(Fonts.pressStart_2P.deriveFont(30f));
        int bheight = gp.screenHeight;
        int bwidth = bheight;

        float opacity = 0.5f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.drawImage(image, (gp.screenWidth - bwidth)/ 2, (gp.screenHeight - bheight)/2, bwidth, bheight, null);
        g2.setColor(Color.WHITE);

        opacity = 1f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

        BufferedImage start1 = null, start2 = null; // Note that start-1 and start-2 are 48x16
        try {
            start1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("loading_screen/start-1.png"));
            start2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("loading_screen/start-2.png"));
        } catch (Exception e){
            e.printStackTrace();
        }

        int starth = start1.getHeight() * 10; // start1 dimensions == start2 dims
        int startw = start1.getWidth() * 10; // Expand by 10
        long time = System.nanoTime();
        if((time % 1000000000) / 500000000 == 0) {
            g2.drawImage(start1, (gp.screenWidth - startw) / 2, (gp.screenHeight - starth) / 2, startw, starth, null);
        } else {
            g2.drawImage(start2, (gp.screenWidth - startw) / 2, (gp.screenHeight - starth) / 2, startw, starth,null);
        }
        String toDisplay = "Click start to begin!";
        int loadingScreenTextLength = (int)g2.getFontMetrics().getStringBounds(toDisplay, g2).getWidth();
        int loadingScreenTextHeight = (int)g2.getFontMetrics().getStringBounds(toDisplay, g2).getHeight();
        g2.drawString(toDisplay, (gp.screenWidth - loadingScreenTextLength) / 2, (gp.screenHeight - loadingScreenTextHeight - 170) / 2);

        g2.dispose();
    }

}
