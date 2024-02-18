// Arrays = week4

package ie.tudublin;

import processing.core.PApplet;

//Week 4 lab, part 4: Pie chart

public class Arrays extends PApplet {
    String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    int[] rainfall = {41, 35, 57, 24, 37, 50, 80, 48, 105, 30, 102, 60};

    public void settings() {
        size(800, 400);
    }

    public void setup() {
        colorMode(HSB, 360, 100, 100);
        background(0);
        drawRainfallPieChart();
    }

    public void draw() {
    }

    public void drawRainfallPieChart() {
		float cx = width / 2;
		float cy = height / 2;
		float diameter = (float) (min(width, height) * 0.8);
		float lastAngle = 0;
	
		float totalRainfall = 0;
		for (int i = 0; i < rainfall.length; i++) {
			totalRainfall += rainfall[i];
		}
	
		for (int i = 0; i < rainfall.length; i++) {
			float angle = radians(map(rainfall[i], 0, totalRainfall, 0, 360));
	
			noStroke(); 
			fill((i * 30) % 360, 80, 80);
			arc(cx, cy, diameter, diameter, lastAngle, lastAngle + angle, PIE);
	
			float labelRadius = diameter / 2 + 20; 
			float labelAngle = lastAngle + angle / 2; 
			float labelX = cx + labelRadius * cos(labelAngle); 
			float labelY = cy + labelRadius * sin(labelAngle); 
			fill(255);
			textAlign(CENTER, CENTER);
			text(months[i], labelX, labelY);
			lastAngle += angle;
		}
	}

}


// - - - - - - - - - - - - - - -


//Week 4 lab, part 3: Trend line chart
/* 
public class Arrays extends PApplet {
    String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    int[] rainfall = {41, 35, 57, 24, 37, 50, 80, 48, 105, 30, 102, 60};

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
        float maxRainfall = 120;

        textAlign(RIGHT, CENTER);
        for (int level = 0; level <= maxRainfall; level += 10) {
            float y = map(level, 0, maxRainfall, height, 0);
            text(level, 60, y);
        }

        textAlign(CENTER);
        for (int i = 0; i < months.length; i++) {
            float x = map(i, 0, months.length, 100, width - 100);
            text(months[i], x, height - 5);
        }

        stroke(255);
        line(100, 0, 100, height);
        line(100, height - 20, width, height - 20);

       
        beginShape();
        noFill();
        for (int i = 0; i < rainfall.length; i++) {
            float x = map(i, 0, rainfall.length - 1, 100, width - 100);
            float y = map(rainfall[i], 0, maxRainfall, height - 20, 0);
            vertex(x, y);
        }
        endShape();
    }
}
*/


// - - - - - - - - - - - - - - -


//Week 4 lab, part 2: Rainbow bar chart
/* 
public class Arrays extends PApplet {
    String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    int[] rainfall = {41, 35, 57, 24, 37, 50, 80, 48, 105, 30, 102, 60}; 

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
        float barWidth = (width - 150) / (float) (months.length + 1); 
        float maxRainfall = 120; 

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

        for (int i = 0; i < months.length; i++) {
            float x = map(i + 1, 1, months.length + 1, 140, width - 30);
            float barHeight = map(rainfall[i], 0, maxRainfall, 0, height - 20);
            
            int barColor = color(map(i, 0, months.length, 0, 360), 255, 255);
            fill(barColor);
            rect(x - barWidth / 2, height - barHeight - 20, barWidth, barHeight);
        }
    }
}
*/


// - - - - - - - - - - - - - - -


//Code for Week 4 lab, part 1 : bar chart
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





