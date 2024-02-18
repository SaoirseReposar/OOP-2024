package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

    int mode = 0;

    Minim minim;
    AudioOutput out;

    public void settings()
    {
        size(800, 800);
    }

    public void setup()
    {
        colorMode(HSB);
    }

    float offs = 0;

    public void draw()
    {
        background(0);
        stroke(255);
        offs += 1f;
        switch(mode)
        {
            case 0:
                int cols = mouseX;
                noStroke();
                float w = width / (float) cols;
                float cgap = 255 / (float) cols;
                for(int i= 0 ; i < cols ; i++)
                {
                    float x = i * w;
                    float c = i * cgap;
                    fill(60, 255, (cgap * i + offs) % 256);
                    rect(x, 0, w, height);
                }
                // line(0, 0, width, height);
                // Code goes here
                break;
            case 1:

                //for (int i = 0 ; i < 10 ; i ++)
                {
                    int numCircles = 10;
                    float ww = width / (float) numCircles;
                    float c = 255 / (float) numCircles;
                    noStroke();
                    for (int j = 0 ; j < numCircles ; j++)
                    { 
                        for(int i = 0 ; i < numCircles ; i++)
                        { 
                            float x = (.5f * ww) + i * ww;
                            float y = 100;
                            float cc = c * i;
                            fill(cc, 255, 255);
                            circle(x, y, ww);

                        }
                    }
                    // Code goes here

                }
                break;
            default:
                // Code goes here
                break;
        }
    }

    public void keyPressed()
    {
        
        if (key >= '0' && key <= '9')
        {
            mode = key - '0';
        }
    }
    
}
