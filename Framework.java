package canardleport;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Framework extends Canvas {

    public static int frameWidth;
    public static int frameHeight;
    public static final long secInNanosec = 1000000000L;
    public static final long milisecInNanosec = 1000000L;
    private final int GAME_FPS = 60;
    private final long GAME_UPDATE_PERIOD = secInNanosec / GAME_FPS;
    public static enum GameState{STARTING, VISUALIZING, GAME_CONTENT_LOADING, MAIN_MENU, OPTIONS, PLAYING, GAMEOVER, DESTROYED}
    public static GameState gameState;
    private long gameTime;
    private long lastTime;
    private Game game;
    private BufferedImage canardImg;    
    
    
    public Framework ()
    {
        super();
        gameState = GameState.VISUALIZING;
        Thread gameThread = new Thread() {
            @Override
            public void run(){
                GameLoop();
            }
        };
        gameThread.start();
    }
    
    

    private void Initialize()
    {
    }
    private void LoadContent()
    {
        try
        {
            URL canardImgUrl = this.getClass().getResource("/resources/images/menu.jpg");
            canardImg = ImageIO.read(canardImgUrl);

            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("/resources/Cash Cash - Overtime.wav"));
            clip.open(inputStream);
            clip.start();
        }
        catch (IOException ex) {
            Logger.getLogger(Framework.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private void GameLoop()
    {
        long visualizingTime = 0, lastVisualizingTime = System.nanoTime();
        long beginTime, timeTaken, timeLeft;
        while(true)
        {
            beginTime = System.nanoTime();
            
            switch (gameState)
            {
                case PLAYING:
                    gameTime += System.nanoTime() - lastTime;
                    
                    game.UpdateGame(gameTime, mousePosition());
                    
                    lastTime = System.nanoTime();
                break;
                case GAMEOVER:
                break;
                case MAIN_MENU:
                break;
                case OPTIONS:
                break;
                case GAME_CONTENT_LOADING:
                break;
                case STARTING:
                    Initialize();
                    LoadContent();
                    gameState = GameState.MAIN_MENU;
                break;

            }

            repaint();
            timeTaken = System.nanoTime() - beginTime;
            timeLeft = (GAME_UPDATE_PERIOD - timeTaken) / milisecInNanosec;
            if (timeLeft < 10)
                timeLeft = 10;
            try {
                 Thread.sleep(timeLeft);
            } catch (InterruptedException ex) { }
        }
    }


    @Override
    public void Draw(Graphics2D g2d)
    {
        switch (gameState)
        {
            case PLAYING:
                game.Draw(g2d, mousePosition());
            break;
            case GAMEOVER:
                game.DrawGameOver(g2d, mousePosition());
            break;
            case MAIN_MENU:
                g2d.drawImage(canardImg, 0, 0, frameWidth, frameHeight, null);
                g2d.drawString("Lance des nenuphres avec le clic gauche.", frameWidth / 2 - 83, (int)(frameHeight * 0.65));
                g2d.drawString("Clic gauche pour commencer la partie.", frameWidth / 2 - 100, (int)(frameHeight * 0.67));
                g2d.drawString("ESC Pour quitter.", frameWidth / 2 - 75, (int)(frameHeight * 0.70));
                g2d.setColor(Color.white);
                g2d.drawString("Made by Kanard le Port", 7, frameHeight - 5);
            break;
            case OPTIONS:
                //...
            break;
            case GAME_CONTENT_LOADING:
                g2d.setColor(Color.white);
                g2d.drawString("Jeu en chargement", frameWidth / 2 - 50, frameHeight / 2);
            break;
        }
    }
    

    private void newGame()
    {
        gameTime = 0;
        lastTime = System.nanoTime();
        game = new Game();
    }
    

    private void restartGame()
    {
        gameTime = 0;
        lastTime = System.nanoTime();
        game.RestartGame();
        gameState = GameState.PLAYING;
    }
    

    private Point mousePosition()
    {        try        {
            Point mp = this.getMousePosition();
            
            if(mp != null)
                return this.getMousePosition();
            else
                return new Point(0, 0);
        }
        catch (Exception e)
        {
            return new Point(0, 0);
        }
    }

    @Override
    public void keyReleasedFramework(KeyEvent e)
    {        switch (gameState)        {
            case GAMEOVER:
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
                else if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER)
                    restartGame();
            break;
            case PLAYING:
            case MAIN_MENU:
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            break;
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e)
    {
        switch (gameState)
        {
            case MAIN_MENU:
                if(e.getButton() == MouseEvent.BUTTON1)
                    newGame();
            break;
        }
    }
}
