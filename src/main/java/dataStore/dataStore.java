package dataStore;

import model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by USER on 27.06.2015.
 */
public class dataStore implements dataStoreImpl{

    public Person addPerson(Person person) {
        Person newPerson = null;
        try{
            File file = new File("D:\\.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            newPerson = (Person) unmarshaller.unmarshal(file);
        }catch (JAXBException e){
            e.printStackTrace();
        }
        Person  person = new Person.Builder()
                .name(newPerson.getName())
                .lastName(newPerson.getLastName())
                .id(newPerson.getId())
                .age(newPerson.getAge())
                .address(newPerson.getAddress())
                .build();

        addPerson(person);
        return person;
    }
}
