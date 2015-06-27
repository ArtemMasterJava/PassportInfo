import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by USER on 27.06.2015.
 */
public class ObjectToXml {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Vasya");
        customer.setLastName("Pupkin");
        customer.setAge(25);
        customer.setId(123456);
        customer.setAddress("Kharkivske shose 45");

        try{
            File file = new File("D:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
