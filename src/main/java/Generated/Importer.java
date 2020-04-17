package Generated;

import Generated.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Importer {

    public Document importDocument(String path) throws JAXBException , FileNotFoundException {

        FileInputStream inputStream= new FileInputStream(path);

        JAXBContext context=JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        return (Document) unmarshaller.unmarshal(inputStream);
    }



}

