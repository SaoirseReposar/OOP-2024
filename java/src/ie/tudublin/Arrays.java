// Arrays = week4

package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    String[] years = {"83", "84", "85", "86", "87", "88", "89", "90"};
    int[] rainfall = {38, 50, 42, 42, 38, 99, 15, 50};

    public void settings() {
        size(800, 400);
    }

    public void setup() {
        colorMode(HSB);
        background(0);
        drawRainfallChart();
    }

    public void draw() {
        // No animation needed
    }

	public void drawRainfallChart() {
		float barWidth = (width - 150) / (float) (years.length +1); // Adjusted width for bars
		float maxRainfall = 100; // Assuming the maximum rainfall value is 100
	
		// Draw the y-axis labels for rainfall increments by 10
		textAlign(RIGHT, CENTER);
		for (int level = 0; level <= maxRainfall; level += 10) {
			float y = map(level, 0, maxRainfall, height, 0); // Map y-coordinate
			text(level, 60, y); // Display rainfall level on the left side
		}
	
		// Draw the x-axis labels for years at the bottom of the graph
		textAlign(CENTER);
		for (int i = 0; i < years.length; i++) {
			float x = map(i, 0, years.length, 100, width - 100); // Adjusted x-coordinate
			text(years[i], x + barWidth / 2, height - 5); // Display year label
		}

		stroke(255); // Set color to white
    	line(100, 0, 100, height); // Vertical line to separate y-axis
    	line(100, height - 20, width, height - 20); // Horizontal line to separate x-axis contents

    // Draw the bars for each year
    for (int i = 0; i < years.length; i++) {
        float x = map(i + 1, 1, years.length + 1, 140, width - 30); // Adjusted x-coordinate
        float barHeight = map(rainfall[i], 0, maxRainfall, 0, height - 20); // Adjust according to the maximum rainfall value

        // Draw the bar with white color

        stroke(255);
        strokeWeight(1); // Adjust the thickness of the stroke
        rect(x - barWidth / 2, height - barHeight - 20, barWidth, barHeight);
    }
}
	
}


