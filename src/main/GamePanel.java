package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	final int originalTileSize = 16; // size: 16x16
	final int scale = 3;

	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 17;
	final int maxScreenRow = 20;
	final int screenWidth = tileSize * maxScreenCol; // 816 pxl
	final int screenHeight = tileSize * maxScreenRow; // 960 pxl
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	// Players default position,speed
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

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
		double drawInterval = 1000000000/60;
		double nextDrawTime = System.nanoTime() + drawInterval;
		while (gameThread != null) {
			update();
			repaint();
		}
	}

	public void update() {
		if ((keyH.upPressed) == true) {
			
			playerY -= playerSpeed;

		} else if ((keyH.downPressed) == true) {
			
			playerY += playerSpeed;
			
		} else if ((keyH.leftPressed) == true) {
			
			playerX -= playerSpeed;
			
		} else if ((keyH.rightPressed) == true) {
			
			playerX += playerSpeed;
			
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();

	}
}
