package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;;
	
	
	public Player(GamePanel gp, KeyHandler keyH ){
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		
		x = 100;
		y = 100;
		speed = 4; 
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			
			Bup = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BUp/pixil-frame-0.png"));
			Bup1 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BUp/pixil-frame-0 (1).png"));
			Bup2 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BUp/pixil-frame-0 (2).png"));
			Bdown = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BDown/pixil-frame-0.png"));
			Bdown1 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BDown/pixil-frame-0 (1).png"));
			Bright = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BRight/pixil-frame-0.png"));
			Bright1 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BRight/pixil-frame-0 (1).png"));
			Bright2 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BRight/pixil-frame-0 (2).png"));
			Bright3 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BRight/pixil-frame-0 (3).png"));
			Bleft = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BLeft/pixil-frame-0.png"));
			Bleft1 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BLeft/pixil-frame-0 (1).png"));
			Bleft2 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BLeft/pixil-frame-0 (2).png"));
			Bleft3 = ImageIO.read(getClass().getResourceAsStream("/player/sprights/Blue/BLeft/pixil-frame-0 (3).png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if ((keyH.upPressed) == true) {
		direction = "up";
			y -= speed;

		} else if ((keyH.downPressed) == true) {
			direction = "down";
			y += speed;
			
		} else if ((keyH.leftPressed) == true) {
			direction = "left";
			x -= speed;
			
		} else if ((keyH.rightPressed) == true) {
			direction = "right";
			x += speed;
			
		}
		spriteCounter++;
		if(spriteCounter > 20) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}else if(spriteNum == 2) {
				spriteNum = 3;
			}else if(spriteNum == 3) {
				spriteNum = 4;
			}else if(spriteNum == 4) {
				spriteNum = 5;
			}else if(spriteNum == 5) {
				spriteNum = 6;
			}else if(spriteNum == 6) {
				spriteNum = 7;
			}else if(spriteNum == 7) {
				spriteNum = 8;
			}else if(spriteNum == 8) {
				spriteNum = 9;
			}else if(spriteNum == 9) {
				spriteNum = 10;
			}else if(spriteNum == 10) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	public void draw(Graphics2D g2) {
	//	g2.setColor(Color.white);
	//	g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum <= 8) {
				image = Bup;
			}
			if(spriteNum == 9) {
				image = Bup1;
			}
			if(spriteNum == 10) {
				image = Bup2;
			}
			
			break;
		case "down":
			if(spriteNum <= 9) {
				image = Bdown;
			}
			if(spriteNum == 10) {
				image = Bdown1;
			}
		    break;
		case "left":
			if(spriteNum <= 7) {
				image = Bleft;
			}
			if(spriteNum == 8) {
				image = Bleft1;
			}
			if(spriteNum == 9) {
				image = Bleft2;
			}
			if(spriteNum == 10) {
				image = Bleft3;
			}
			break;
		case "right":
			if(spriteNum <= 7) {
				image = Bright;
			}
			if(spriteNum == 8) {
				image = Bright1;
			}
			if(spriteNum == 9) {
				image = Bright2;
			}
			if(spriteNum == 10) {
				image = Bright3;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
}
