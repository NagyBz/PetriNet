package Graphics;
import Petrinet1.Transition;
import Petrinet1.Vertex;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Rectangle2D.Float implements Vertex2D {
    private Transition transition;

    public Vertex getVertex(){
        return this.transition;
    }

    public Transition2D(int x, int y, Transition  transition){
        super(x,y,50,50);
        this.transition=transition;
    }

    @Override
    public int getXcoord() {
        return (int)super.getX();

    }

    @Override
    public int getYcoord() {
        return (int)super.getY();
    }

    @Override
    public long getID() {
        return transition.getID();
    }

    @Override
    public void draw(Graphics2D g) {
            if(this.transition.isFireable()) {
                drawColorTransition(g, Color.GREEN);
            }
            else{
                drawColorTransition(g, Color.RED);
            }
    }



    public void drawColorTransition(Graphics2D g, Color color) {
        g.setColor(color);
        g.fill(this);
        g.setColor(Color.BLACK);
        g.draw(this);
        drawLabel(g,this.transition.getName());
    }

    public void drawLabel(Graphics2D g2D,String label){
        g2D.setFont(new Font("TimesRoman",Font.BOLD,15));
        g2D.drawString(label,(int)getX(),(int)getY()+65);

    }

    @Override
    public boolean contains(int x, int y)
    {
        return super.contains(x,y);
    }

    @Override
    public void removeArcs() {
        transition.removeAllArcs();
    }

    @Override
    public void onClick(MouseEvent e) {
        if(this.transition.isFireable()) {
            this.transition.fireTransition();
        }
    }
}
