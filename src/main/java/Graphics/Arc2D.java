package Graphics;

import Petrinet1.Arc;
import Petrinet1.Vertex;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


public  class Arc2D extends Line2D.Float implements Drawable{

    private  Arc arc;
    public Arc2D(int source_x, int source_y, int dest_x, int dest_y, Arc arc){
        super(source_x,source_y,dest_x,dest_y);
        this.arc=arc;
    }


    @Override
    public  void draw(Graphics2D graphics2D) {

        int x1 = (int) this.getX1();
        int x2 = (int) this.getX2();
        int y1 = (int) this.getY1();
        int y2 = (int) this.getY2();

        //calculating coordinates of the triangle from stackowerflow XD
        int d = 10;
        int h = 10;

        int dx = x2 - x1;
        int dy = y2 - y1;
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm * cos - ym * sin + x1;
        ym = xm * sin + ym * cos + y1;
        xm = x;

        x = xn * cos - yn * sin + x1 ;
        yn = xn * sin + yn * cos + y1;
        xn = x;

       int[] xpoints = {x2-dx/5, (int) xm-dx/5, (int) xn-dx/5};
       int[] ypoints = {y2-dy/5, (int) ym-dy/5, (int) yn-dy/5};

        int stringx= getStringCoord(getX1(), getX2());
        int stringy= getStringCoord(getY1(), getY2());

       //end of calculating coordinates of the triangle from stackowerflow XD

        graphics2D.draw(this);

        drawLabel(graphics2D, stringx, stringy);

        graphics2D.fillPolygon(xpoints, ypoints, 3);
    }

    private void drawLabel(Graphics2D graphics2D, int stringx, int stringy) {
        graphics2D.setFont(new Font("TimesRoman",Font.BOLD,15));
        graphics2D.drawString(""+arc.getWeigth(),stringx,stringy);
    }

    private int getStringCoord(double x1, double x2) {
        return (int) (x1 + x2) / 2;
    }


    public boolean contains(int x, int y) {

        Rectangle2D rectangle2D=new Rectangle2D.Double(x-5,y-5,10,10);
        return rectangle2D.intersectsLine(this);
    }

    @Override
    public void removeArcs() {
        arc.getEndPoint().getInputArcs().remove(arc);
        arc.getStartPoint().getOutputArcs().remove(arc);
    }

    @Override
    public void onClick(MouseEvent e) {
    }



    @Override
    public long getID() {
        return arc.getID();
    }

}