package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {

	float playerX = 50.0f; 
    float playerY = 50.0f; 
    float playerWidth = 30.0f;

	public void settings() {
		size(1000, 1000);
	}

	public void setup() {
		playerX = width / 2;
        playerY = height / 2;
		
	}


	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
		}
	}

	int gameMode = 0;

	public void draw() {
		background(255); // White background
        drawPlayer(playerX, playerY, playerWidth);
	}

	public void drawPlayer(float x, float y, float w) {
        float h = w * 0.5f; // Calculate half of the width for the height
        stroke(0); // Set stroke color to black
        line(x - w / 2, y, x + w / 2, y); // Draw horizontal line
        line(x, y - h / 2, x, y + h / 2);
	}

}
