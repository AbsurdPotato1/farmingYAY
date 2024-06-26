package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TitleScreen {
    GamePanel gp;
    BufferedImage image, start1, start2; // Note that start-1 and start-2 are 48x16
    // `start` stands for the START BUTTON.

    public TitleScreen(GamePanel gp) {
        this.gp = gp;
        image = UtilityTool.getImage("loading_screen/city-bng1.png");
        start1 = UtilityTool.getImage("loading_screen/start-1.png");
        start2 = UtilityTool.getImage("loading_screen/start-2.png");
    }

    public void draw(Graphics2D g2)  {
        g2.setFont(Fonts.pressStart_2P.deriveFont(30f));
        // b stands for BACKGROUND!!
        int bheight = gp.screenHeight; // Full screen height
        int bwidth = bheight * 16 / 9; // Approx 16:9 (due to int division)

        float opacity = 0.5f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.drawImage(image, (gp.screenWidth - bwidth)/ 2, (gp.screenHeight - bheight)/2, bwidth, bheight, null);
        g2.setColor(Color.WHITE);

        opacity = 1f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

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
        if(gp.mouseH.mouseClicked){
            if(gp.mouseH.mouseScreenX >= (gp.screenWidth - startw) / 2 && gp.mouseH.mouseScreenX <= (gp.screenWidth + startw) / 2 &&
                gp.mouseH.mouseScreenY >= (gp.screenHeight - starth) /2 && gp.mouseH.mouseScreenY <= (gp.screenHeight + starth) / 2){
//                gp.a.fadeOut(g2);
                gp.gameState = GamePanel.playerState;
                gp.stopMusic();
                gp.playSE(3);
                gp.playMusic(5);
            }
        }
    }



}
