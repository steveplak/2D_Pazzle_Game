package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable {
	final int originalTileSize = 16; // size: 16x16
	final int scale = 3;

	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 17;
	final int maxScreenRow = 20;
	final int screenWidth = tileSize * maxScreenCol; // 816 pxl
	final int screenHeight = tileSize * maxScreenRow; // 960 pxl
	
	int FPS = 60;
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);

	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		while (gameThread != null) {
			update();
			repaint();
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime /1000000;
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		player.update();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		player.draw(g2);
		g2.dispose();

	}
}
