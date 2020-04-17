package MyButtons;

import Generated.Document;
import Generated.GraphicsTransformer;
import Generated.Importer;
import Generated.PetrinetTransformer;
import Petrinet1.BadArcWeightException;
import Petrinet1.IllegalStartVertexResetArcException;
import Petrinet1.SameVertexTypeException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import Petrinet1.*;
import Graphics.NetCanvas;

public class OpenButton extends Button implements ActionListener {
   private NetCanvas netCanvas;
   private PetriNet petriNet;


    public OpenButton(String label, NetCanvas netCanvas, PetriNet petrinet) throws HeadlessException {
        super(label);
        this.netCanvas = netCanvas;
        this.petriNet = petrinet;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser("C:\\Users\\nagyb\\IdeaProjects\\Petrinet2");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML", "xml");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            Importer importer = new Importer();
            Document document = new Document();
            try {
                document = importer.importDocument(chooser.getSelectedFile().getAbsolutePath());

            } catch (JAXBException | FileNotFoundException ex) {
                ex.printStackTrace();
            }

            PetrinetTransformer petrinetTransformer = new PetrinetTransformer(petriNet);
            try {
                petrinetTransformer.transform(document);

            } catch (SameVertexTypeException | BadArcWeightException | IllegalStartVertexResetArcException ex) {
                ex.printStackTrace();
            }

            GraphicsTransformer graphicsTransformer = new GraphicsTransformer();
            graphicsTransformer.setNet(petriNet);

            netCanvas.setDrawables(graphicsTransformer.transform(document));
            netCanvas.repaint();

        }
    }
}
