package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.text.Position;

import java.awt.Color;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        
        // Making the array for notes
        Integer[] arr = notes.getNotes();

        // Getting the height and width 
        int width = getWidth();
        int height = getHeight();

        // Filling in an empty rectangle/background
        g.fillRect(0, 0, width, height);
        
        // For loop to draw each note/ the bar associated with each
        for (int i = 0; i < arr.length; i++){

            // Width of each note's bar - total width divided by the length of the array
            int barwidth = width/arr.length;

            // Each bar's height - the value associated with the specific index of the array divided by
            // the array length into height of the entire box
            double barheight = ((double)arr[i])/arr.length * height;

            // Highlighted notes are blue, otherwise green
            if (notes.isHighlighted(i)){
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.GREEN);
            }

            // Filling in each bar using fillrect.  
            g.fillRect(i*barwidth, (int) (height - barheight), barwidth, (int) barheight);
            

        }  

    }

}