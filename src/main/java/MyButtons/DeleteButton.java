package MyButtons;

import MyListeners.DeleteListener;
import MyListeners.PlaceAdderListener;
import Petrinet1.PetriNet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.HashMap;

import Graphics.NetCanvas;

public class DeleteButton extends Button implements ActionListener {
    private NetCanvas netCanvas;
    private PetriNet petriNet;


    public DeleteButton(String label, NetCanvas netCanvas, PetriNet petriNet) throws HeadlessException {
        super(label);
        this.netCanvas = netCanvas;
        this.petriNet = petriNet;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MouseListener[] listener=netCanvas.getMouseListeners();
        for (MouseListener listener1 :listener){
            netCanvas.removeMouseListener(listener1);
        }
        netCanvas.addMouseListener(new DeleteListener(petriNet,netCanvas.getDrawables(),netCanvas));
        netCanvas.repaint();

    }
}
