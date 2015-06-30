package Services;

import Models.Passport;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.*;

public class PassportService
{
    public PassportService()
    {
        this.passports = new ArrayList<Passport>();
    }

    private ArrayList<Passport> passports;

    public ArrayList<Passport> getPassports()
    {
        return new ArrayList<Passport>(this.passports);
    }

    public void addPassport(Passport passport)
    {
        this.passports.add(passport);
    }

    public void importFromFile(File file)
    {
        try
        {
            FileReader fileReader = new FileReader(file);
            XStream xs = new XStream();
            xs.processAnnotations(Passport.class);
            this.passports = (ArrayList<Passport>)xs.fromXML(fileReader);
            fileReader.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void exportToFile(File file)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(file);
            XStream xs = new XStream();
            xs.processAnnotations(Passport.class);
            fileWriter.write(xs.toXML(this.passports));
            fileWriter.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
