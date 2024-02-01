package ie.tudublin;

import processing.core.PApplet;



public class BugZap extends PApplet {
	//Players health fields
	float playerX = 100.0f;
	float playerY = 60.0f;
	float playerWidth =140.0f;

	float bugX = 50.0f;
	float bugY = 750.0f;
	float bugWidth = 50.0f;
	public void settings() {
		size(1000, 1000);


	}

	public void setup() {

		//playerWidth = width / 2;
		
	}


	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");

			playerX = playerX - 30;

				if (playerX <50)
				{
					playerX =950;
				}
			
				
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
			// Since the max with is 1000 we made the maximum it can reach 950
			
				playerX = playerX + 30;
			
			//It can no longer increment so while it reaches the edge reset it back to its orignial point
			if (playerX > 950)
			{
			//PlayerX is back at its starting point
				playerX = 100;
			}
			
			
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
			drawline();
		}
	}

	int gameMode = 0;

	public void draw() {
		background(0); // Clear the background each frame
        drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY, bugWidth);
		if ((frameCount % 60) == 0)
		{
			bugY -= 30;
		}
		if ((frameCount % 60) == 0)
		{
		
			bugX = random(50,950);
		
		}
		fill(255); // Set the fill color to white (RGB: 255, 255, 255)
		textSize(32); // Set the text size
		textAlign(RIGHT, TOP); // Align text to the top-right corner

		String message = "Score : 0"; // The text you want to display
		float x = width; // Align to the right
		float y = 0; // Align to the top

		text(message, x, y); // Display the text on the screen
	}

	public void drawline()
	{
		stroke(255);
		//I drew the line to go till the end of the screen
		line(playerX,playerY+50,playerX,1000);
	}
	
	void drawPlayer(float x, float y, float w)
	{
		float h = w * 0.5f; // Height is half of the width

		stroke(255);

		line(x - w * 0.5f, y - h * 0.5f, x + w * 0.5f, y - h * 0.5f); // Top line
       	line(x - w * 0.5f, y - h * 0.5f, x, y + h * 0.5f); // Left line
       	line(x + w * 0.5f, y - h * 0.5f, x, y + h * 0.5f); // Right line
	   
	
    }

	void drawBug(float x, float y, float w)
	{

		float h = w * 0.5f;
			// Draw a simple bug as a circle
			fill(255, 0, 0);
			ellipse(x, y, w, w);

			ellipse(x, y - h * 0.75f, w * 0.5f, h * 0.5f);
			//eyes
			float eyeOffsetX = w * 0.2f;
			float eyeOffsetY = h * 0.15f;

			ellipse(x - eyeOffsetX, y - h * 0.75f - eyeOffsetY, w * 0.1f, w * 0.1f);
    		ellipse(x + eyeOffsetX, y - h * 0.75f - eyeOffsetY, w * 0.1f, w * 0.1f);
			float legLength = h * 0.8f;
    		line(x - w * 0.3f, y + h * 0.5f, x - w * 0.3f, y + h * 0.5f + legLength);
    		line(x + w * 0.3f, y + h * 0.5f, x + w * 0.3f, y + h * 0.5f + legLength);

			// Black dots on the back
			fill(0); // Set fill color to black
			noStroke(); // Remove stroke for the dots
			
			// Draw one or two dots
			ellipse(x, y + h * 0.25f, w * 0.1f, w * 0.1f);
			ellipse(x + w * 0.1f, y + h * 0.25f, w * 0.1f, w * 0.1f);
	}

			
			
		

	}