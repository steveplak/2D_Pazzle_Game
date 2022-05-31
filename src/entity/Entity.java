package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldx, worldy;
	public int speed;

	public BufferedImage Bup, Bup1, Bup2, Bdown, Bdown1, Bright, Bright1, Bright2, Bright3, Bleft, Bleft1, Bleft2,
			Bleft3;
	public String direction;

	public int spriteCounter = 0;
	public int spriteNum = 1;
	public  Rectangle solidArea;
	public boolean collisionOn = false;
}
