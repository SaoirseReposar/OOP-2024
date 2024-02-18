// Arrays = week4

package ie.tudublin;

import processing.core.PApplet;

//Week 4 lab, part 2:

public class Arrays extends PApplet {
    String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "December"};
    int[] rainfall = {41, 35, 57, 24, 37, 50, 80, 48, 105, 30, 102, 60}; // Sample rainfall values for each month

    public void settings() {
        size(800, 400);
    }

    public void setup() {
        colorMode(HSB); // Use HSB color mode for easier color control
        background(0);
        drawRainfallChart();
    }

    public void draw() {
    }

    public void drawRainfallChart() {
        float barWidth = (width - 150) / (float) (months.length + 1); // Adjusted width for bars
        float maxRainfall = 120; // Maximum rainfall value

        textAlign(RIGHT, CENTER);
        for (int level = 0; level <= maxRainfall; level += 10) {
            float y = map(level, 0, maxRainfall, height, 0);
            text(level, 60, y);
        }

        textAlign(CENTER);
        for (int i = 0; i < months.length; i++) {
            float x = map(i, 0, months.length, 100, width - 100);
            text(months[i], x + barWidth / 2, height - 5);
        }

        stroke(255);
        line(100, 0, 100, height);
        line(100, height - 20, width, height - 20);

        // Draw the bars for each month with different colors
        for (int i = 0; i < months.length; i++) {
            float x = map(i + 1, 1, months.length + 1, 140, width - 30);
            float barHeight = map(rainfall[i], 0, maxRainfall, 0, height - 20);

            // Assign colors based on the month
            int barColor = color(map(i, 0, months.length, 0, 360), 255, 255);
            fill(barColor);
            rect(x - barWidth / 2, height - barHeight - 20, barWidth, barHeight);
        }
    }
}



//Code for Week 4 lab, part 1
/* 
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
    }

	public void drawRainfallChart() {
		float barWidth = (width - 150) / (float) (1.2*years.length ); 
		float maxRainfall = 100; 
	
		textAlign(RIGHT, CENTER);
		for (int level = 0; level <= maxRainfall; level += 10) {
			float y = map(level, 0, maxRainfall, height, 0);
			text(level, 60, y);
		}
	
		textAlign(CENTER);
		for (int i = 0; i < years.length; i++) {
			float x = map(i, 0, years.length, 100, width - 100);
			text(years[i], x + barWidth / 2, height - 5);
		}

		stroke(255);
    	line(100, 0, 100, height);
    	line(100, height - 20, width, height - 20);

    for (int i = 0; i < years.length; i++) {
        float x = map(i + 1, 1, years.length + 1, 140, width - 30);
        float barHeight = map(rainfall[i], 0, maxRainfall, 0, height - 20);

        stroke(255);
        strokeWeight(1);
        rect(x - barWidth / 2, height - barHeight - 20, barWidth, barHeight);
    }
}
	
}
*/





