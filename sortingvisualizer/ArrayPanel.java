package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;

    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Integer[] indices = notes.indices;
        int size = notes.indices.length;
        int width = this.getWidth()/size;
        int max_height = this.getHeight();

        int x = 0;
        for(int i = 0; i < size; i++) {
            
            //making scales color shift from brown to purple
            int purple = 19+(120/size)*indices[i];

            g.setColor(new Color(139,69,purple));


            if(notes.isHighlighted(i)) g.setColor(new Color(200,200,230));

            int height = max_height*(indices[i]+1)/size;
            g.fillRect(x, max_height-height, width, height); 
            x+=width;
        }

    }
}