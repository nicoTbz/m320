package D2;

import java.awt.geom.Ellipse2D;

/**
 * A cloud that can be manipulated and that draws itself on a canvas.
 *
 * @author  Michael K�lling and David J. Barnes
 * @version 2024.12.02
 */

public class Cloud
{
    private int width;
    private int height;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new cloud at default position with default color.
     */
    public Cloud()
    {
        width = 100; // Default width of the cloud
        height = 60; // Default height of the cloud
        xPosition = 200; // Default x position
        yPosition = 100; // Default y position
        color = "gray"; // Default cloud color
    }

    /**
     * Make this cloud visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Move the cloud horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    public void  moveHorizontalLoop(int distance)
    {
        erase();
        xPosition += distance;
        if (xPosition > 470) {
            xPosition = -90;
        }
        draw();
    }

    /**
     * Move the cloud vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Change the size of the cloud.
     */
    public void changeSize(int newWidth, int newHeight)
    {
        erase();
        width = newWidth;
        height = newHeight;
        draw();
    }

    /**
     * Change the color of the cloud.
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Draw the cloud with current specifications on screen.
     */
    private void draw()
    {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();

            // Draw multiple overlapping ellipses to create a cloud shape
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, width, height));

            canvas.wait(10);
        }
    }

    /**
     * Erase the cloud on screen.
     */
    private void erase()
    {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}