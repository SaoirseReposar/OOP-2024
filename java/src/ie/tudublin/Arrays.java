// Arrays = week4

package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC", "JAN"};
	float[] rainfall = {200,260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};
	
	//create bar chart function
	public float map1(float a, float b, float c, float d, float e)
	{
		//map1
		float range1 = c - b;
		float range2 = e - d;
		float howFar = a - b; //("how far into the first range you are")
		return d (howFar / range1) * range2;


		return 0;
	}


	public void settings()
	{
		size(500, 500);
		
		String[] m1 = months;
		months[0] = "XXX";
		print(m1[0]);

		for(int i = 0 ; i < months.length; i++);
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}

		for(String s : m1)
		{
			println(s); 
		}

		int minIndex = 0;
		for(int i = 0 ; i < rainfall.length ; i ++);
		{
			if (rainfall[i] < rainfall[minIndex])
			{ 
				minIndex = i;
			}
		}

		int maxIndex = 0;
		for(int i = 0 ; i < rainfall.length ; i ++);
		{
			if (rainfall[i] > rainfall[maxIndex])
			{ 
				maxIndex = i;
			}
		}

		println("The month with the min rainfall was ", months[minIndex] + "with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was ", months[maxIndex] + "with " + rainfall[maxIndex] + "rain");

		//calculate average rainfall
		float total = 0;
		for(float f:rainfall)
		{
			total += f;
		}

		float avg = total / (float) rainfall.length;

		//bar chart
		println(map1(a:5, b:0, c:10, d:0, e:100)); //50
		println(map1(a:25, b:20, c:30, d:200, e:300)); //250
		println(map1(a:26, b:25, c:35, d:0, e:100)); //10

	}


	public void setup() {
		colorMode(HSB);
		background(0);
	}

	
	public void draw()
	{	
		background(0);
		float w = width / (float)months.length;
		for (int i = 0 ; i < months.length ; i++)
		{
			float x = map1( i, b:0, months.length, d:0, width);
			rect(x, height, -rainfall[i], w);

		}
	
	}
}
