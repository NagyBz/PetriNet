package MyListeners;

import Graphics.Drawable;
import Graphics.NetCanvas;
import Petrinet1.PetriNet;
import Petrinet1.Place;
import Graphics.Place2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;




    public  class PlaceAdderListener implements MouseListener {
        private PetriNet petriNet;
        private HashMap<Long, Drawable> drawables;
        private NetCanvas netCanvas;

        public PlaceAdderListener(PetriNet petriNet, HashMap<Long, Drawable> drawables,NetCanvas netCanvas) {
            this.petriNet = petriNet;
            this.drawables = drawables;
            this.netCanvas=netCanvas;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            petriNet.incrementID();
            Place place=new Place(1,petriNet.getID(),"");
            Place2D place2D=new Place2D(e.getX()-25,e.getY()-25,place);

            petriNet.addPlace(place);
            drawables.put(petriNet.getID(),place2D);
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

