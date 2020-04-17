package MyListeners;

import Graphics.Arc2D;
import Graphics.Drawable;
import Graphics.NetCanvas;
import Graphics.Vertex2D;
import Petrinet1.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;



public class ArcAdderListener implements MouseListener {
    private PetriNet petriNet;
    private HashMap<Long, Drawable> drawables;
    private NetCanvas netCanvas;
    private Drawable StartPoint=null;
    private Drawable EndPoint=null;


    private NormalArc normalArc;
    private int counter=0;
    public ArcAdderListener(PetriNet petriNet, HashMap<Long, Drawable> drawables, NetCanvas netCanvas) {
        this.petriNet = petriNet;
        this.drawables = drawables;
        this.netCanvas = netCanvas;
    }

    @Override
    public void mouseClicked(MouseEvent e){

        if(counter==0)
        {
                for (Drawable drawable : drawables.values()) {
                    try {
                        if (((Vertex2D)drawable).contains(e.getX(), e.getY())) {
                            StartPoint = (drawable);
                            counter++;
                        }

                    }catch (ClassCastException ex){}
                }
        }

        else if(1 == counter)
        {


            for (Drawable drawable : drawables.values()) {
                   try {
                       if (((Vertex2D) drawable).contains(e.getX(), e.getY())) {
                           if (StartPoint != drawable) {
                               EndPoint = (drawable);
                               counter++;
                           }
                       }
                   }catch (ClassCastException ex){}
            }
        }

        if(EndPoint !=null && StartPoint!=null){

            try {
                petriNet.incrementID();
                normalArc = new NormalArc(((Vertex2D)StartPoint).getVertex(),((Vertex2D)EndPoint).getVertex(),1,petriNet.getID());
                Arc2D arc2D=new Arc2D(((Vertex2D)StartPoint).getXcoord()+25,((Vertex2D)StartPoint).getYcoord()+25,((Vertex2D)EndPoint).getXcoord()+25,((Vertex2D)EndPoint).getYcoord()+25,normalArc);
                petriNet.addArc(normalArc);
                drawables.put(petriNet.getID(),arc2D);
                counter=0;
                netCanvas.repaint();

                this.StartPoint=null;
                this.EndPoint=null;


            } catch (SameVertexTypeException ex) {
                System.out.println(ex.getMessage());
                this.StartPoint=null;
                this.EndPoint=null;
                counter=0;
            } catch (BadArcWeightException ex) {

            }

            counter=0;

        }
        netCanvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
