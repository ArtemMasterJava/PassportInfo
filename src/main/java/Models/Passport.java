package Models;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Passport")
public class Passport
{
    public Passport()
    {
    }
    @XStreamAlias("Name")
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public  String getName()
    {
        return this.name;
    }

    @XStreamAlias("Surname")
    private String surname;

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public  String getSurname()
    {
        return this.surname;
    }

    @XStreamAlias("Id")
    private String id;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
