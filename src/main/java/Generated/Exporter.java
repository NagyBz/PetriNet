package Generated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Exporter {


    public void export (Document document,String filename) throws JAXBException {
        JAXBContext context=JAXBContext.newInstance(Document.class);
        Marshaller marshaller=context.createMarshaller();
        marshaller.marshal(document,new File(filename));

    }
}
