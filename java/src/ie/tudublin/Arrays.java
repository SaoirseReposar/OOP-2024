// Arrays = week4

package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; 
    int[] rainfall = {40, 50, 38, 38, 10, 30, 90, 50, 70, 80, 60, 45}; 

    public void settings() {
        size(600, 400);
    }

    public void setup() {
        colorMode(HSB);
        background(0); 
        drawBarChart();
    }

    public void drawBarChart() {
        int numberOfMonths = months.length;
        int[] colors = new int[numberOfMonths];

        for (int i = 0; i < numberOfMonths; i++) {
            colors[i] = color(map(i, 0, numberOfMonths, 0, 255), 255, 255);
        }
    
        float startAngle = 0;
        float totalRainfall = 0;
        for (int i = 0; i < rainfall.length; i++) {
            totalRainfall += rainfall[i];
        }
    
        float radius = 150; 
        float labelRadius = radius + 40; 
    
        for (int i = 0; i < numberOfMonths; i++) {
            float angle = radians(map(rainfall[i], 0, totalRainfall, 0, 360));
            float labelAngle = startAngle + angle / 2; 
           
            fill(colors[i]);
            arc(width/2, height/2, radius * 2, radius * 2, startAngle, startAngle + angle);
            
            float x = width/2 + cos(labelAngle) * labelRadius;
            float y = height/2 + sin(labelAngle) * labelRadius;
    
            textAlign(CENTER, CENTER);
            fill(255);
            text(months[i], x, y);
    
            startAngle += angle; 
        }
    }
    

}


//Part 3:
/* 
public class Arrays extends PApplet {
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; // Months of the year
    int[] rainfall = {40, 50, 38, 38, 10, 30, 90, 50, 70, 80, 60, 45}; // Example rainfall data

    public void settings() {
        size(600, 400);
    }

    public void setup() {
        colorMode(HSB);
        background(0); 
        drawBarChart();
    }

    public void drawBarChart() {
        int numberOfBars = months.length;
        int gap = 5; 
        int totalGapWidth = (numberOfBars - 1) * gap;
        int barWidth = (width - totalGapWidth - 100) / numberOfBars; 
    
        int maxRainfall = max(100, max(rainfall));

        stroke(255);
        line(0, height - 20, width, height - 20); 
    
        line(50, 0, 50, height - 20);

        textAlign(CENTER);
        textSize(12);
        fill(255);
        for (int i = 0; i < months.length; i++) {
            float x = 50 + i * (barWidth + gap) + barWidth / 2;
            text(months[i], x, height - 5); 
        }

        textAlign(RIGHT);
        textSize(12);
        fill(255);
        for (int i = 0; i <= maxRainfall; i += 10) {
            float y = map(i, 0, maxRainfall, height - 20, 0);
            text(i, 45, y + 5); 
        }

        stroke(255); 
        for (int i = 1; i < months.length; i++) {

            float startX = 50 + (i - 1) * (barWidth + gap) + barWidth / 2;
            float startY = height - map(rainfall[i - 1], 0, maxRainfall, 0, height - 20) - 20;
            float endX = 50 + i * (barWidth + gap) + barWidth / 2;
            float endY = height - map(rainfall[i], 0, maxRainfall, 0, height - 20) - 20;
    
            line(startX, startY, endX, endY); 
        }
    }
    
}
*/


//Part 2
/* 
public class Arrays extends PApplet {
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; // Months of the year
    int[] rainfall = {40, 50, 38, 38, 10, 30, 90, 50, 70, 80, 60, 45}; // Example rainfall data

    public void settings() {
        size(600, 400);
    }

    public void setup() {
        colorMode(HSB);
        background(0); // Set background color to black
        drawBarChart();
    }

    public void drawBarChart() {
        int numberOfBars = months.length;
        int gap = 5; // Adjust the gap between bars
    
        int totalGapWidth = (numberOfBars - 1) * gap;
        int barWidth = (width - totalGapWidth - 100) / numberOfBars; // Adjust the width to accommodate gaps
    
        // Find the maximum value in rainfall data, capped at 100
        int maxRainfall = max(100, max(rainfall));
    
        // Draw x-axis line
        stroke(255); // Set color to white
        line(0, height - 20, width, height - 20); // Draw x-axis line slightly above the bottom
    
        // Draw y-axis line
        line(50, 0, 50, height - 20); // Draw y-axis line
    
        // Display months below x-axis line
        textAlign(CENTER);
        textSize(12);
        fill(255);
        for (int i = 0; i < months.length; i++) {
            float x = 50 + i * (barWidth + gap) + barWidth / 2;
            text(months[i], x, height - 5); // Adjust text position
        }
    
        // Display rain increments on the left side of the y-axis line
        textAlign(RIGHT);
        textSize(12);
        fill(255);
        for (int i = 0; i <= maxRainfall; i += 10) {
            float y = map(i, 0, maxRainfall, height - 20, 0);
            text(i, 45, y + 5); // Adjust text position
        }
    
        // Draw bars with rainbow colors
        for (int i = 0; i < months.length; i++) {
            float x = 50 + i * (barWidth + gap); // Shift bars to the right to leave space for y-axis
            float barHeight = map(rainfall[i], 0, maxRainfall, 0, height - 20);
            float y = height - barHeight - 20; // Adjust for the space at the bottom
    
            fill(map(i, 0, months.length, 0, 255), 255, 255); // Rainbow color
            rect(x, y, barWidth, barHeight);
        }
    }
}
*/



//Part 1:
/* 
public class Arrays extends PApplet {
    String[] years = {"83", "84", "85", "86", "87", "88", "89", "90"}; // Example years as strings
    int[] rainfall = {40, 50, 38, 38, 10, 30, 90, 50}; // Example rainfall data

    public void settings() {
        size(600, 400);
    }

    public void setup() {
        colorMode(HSB);
        background(0); // Set background color to black
        drawBarChart();
    }

    public void drawBarChart() {
        int numberOfBars = years.length;
        int gap = 5; // Adjust the gap between bars
    
        int totalGapWidth = (numberOfBars - 1) * gap;
        int barWidth = (width - totalGapWidth - 100) / numberOfBars; // Adjust the width to accommodate gaps
    
        // Find the maximum value in rainfall data, capped at 100
        int maxRainfall = max(100, max(rainfall));
    
        // Draw x-axis line
        stroke(255); // Set color to white
        line(0, height - 20, width, height - 20); // Draw x-axis line slightly above the bottom
    
        // Draw y-axis line
        line(50, 0, 50, height - 20); // Draw y-axis line
    
        // Display years below x-axis line
        textAlign(CENTER);
        textSize(12);
        fill(255);
        for (int i = 0; i < years.length; i++) {
            float x = 50 + i * (barWidth + gap) + barWidth / 2;
            text(years[i], x, height - 5); // Adjust text position
        }
    
        // Display rain increments on the left side of the y-axis line
        textAlign(RIGHT);
        textSize(12);
        fill(255);
        for (int i = 0; i <= maxRainfall; i += 10) {
            float y = map(i, 0, maxRainfall, height - 20, 0);
            text(i, 45, y + 5); // Adjust text position
        }
    
        // Draw bars
        for (int i = 0; i < years.length; i++) {
            float x = 50 + i * (barWidth + gap); // Shift bars to the right to leave space for y-axis
            float barHeight = map(rainfall[i], 0, maxRainfall, 0, height - 20);
            float y = height - barHeight - 20; // Adjust for the space at the bottom
    
            fill(255); // Make the bars hollow
            stroke(255); // Set stroke color to white
            rect(x, y, barWidth, barHeight);
        }
    }
    
}    
*/

