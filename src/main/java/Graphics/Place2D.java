package Graphics;
import Petrinet1.Place;
import Petrinet1.Vertex;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;



public class Place2D extends Ellipse2D.Float implements Vertex2D {

    private Place place;

    public Place2D(int x, int y, Place place) {
        super(x,y,50,50);
        this.place=place;

    }


    public Vertex getVertex(){
        return this.place;
   }

    @Override
    public int getXcoord() { return (int)super.getX();}

    @Override
    public int getYcoord() {
        return (int)super.getY();
    }

    @Override
    public long getID() {
        return place.getID();
    }

    @Override
    public void draw(Graphics2D g)
    {
        drawPlace2D(g);
        drawLabel(g);
    }

    private void drawPlace2D(Graphics2D g) {
        g.setPaint(Color.WHITE);
        g.fill(this);
        g.setPaint(Color.BLACK);
        g.draw(this);
    }

    private void drawLabel(Graphics2D g) {
        g.setFont(new Font("TimesRoman",Font.BOLD,15));
        g.drawString(place.getName(),(int)getCenterX(),(int)getCenterY()+40);
        g.drawString(""+place.getTokens(),(int)getCenterX(),(int)getCenterY());
    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x,y);
    }

    @Override
    public void removeArcs() {
        this.place.removeAllArcs();

    }

    @Override
    public void onClick(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){

            this.place.addToken(1);
        }
        else if(e.getButton()==MouseEvent.BUTTON3){

            if(this.place.getTokens()>0)
            this.place.removeToken(1);
        }
    }
}
