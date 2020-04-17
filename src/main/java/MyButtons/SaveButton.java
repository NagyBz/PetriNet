package MyButtons;

import Generated.Document;
import Generated.Exporter;
import Generated.ToDocuTransformer;
import Petrinet1.PetriNet;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import Graphics.NetCanvas;

public class SaveButton extends Button implements ActionListener {

    PetriNet petrinet;
    NetCanvas netCanvas;

    public SaveButton(String label, PetriNet petrinet, NetCanvas netCanvas) throws HeadlessException {
        super(label);
        this.petrinet = petrinet;
        this.netCanvas = netCanvas;
        this.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser chooser = new JFileChooser("C:\\Users\\nagyb\\IdeaProjects\\Petrinet2");
        int retrival = chooser.showSaveDialog(this);
        if(retrival==JFileChooser.APPROVE_OPTION){

            ToDocuTransformer toDocuTransformer=new ToDocuTransformer();
            Document document=toDocuTransformer.transform(petrinet,netCanvas.getDrawables());

            Exporter exporter=new Exporter();
            try {
                exporter.export(document,chooser.getSelectedFile().getAbsolutePath());
            } catch (JAXBException ex) {
                ex.printStackTrace();
            }

        }



    }
}
