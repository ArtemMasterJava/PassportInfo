package Presentation;

import Models.Passport;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PassportsDataModel extends AbstractTableModel
{
    public PassportsDataModel()
    {
        this.passports = new ArrayList<Passport>();
    }

    private ArrayList<Passport> passports;

    private String[] columnNames = {"Name", "Surname", "Id"};

    public void reload(ArrayList<Passport> passports)
    {
        this.passports = passports;
        this.fireTableDataChanged();
    }

    public int getColumnCount()
    {
        return 3;
    }

    public int getRowCount()
    {
        return this.passports.size();
    }

    public Object getValueAt(int row, int col)
    {
        Object value;

        Passport passport = this.passports.get(row);

        switch (col)
        {
            case 0:
                value = passport.getName();
                break;
            case 1:
                value = passport.getSurname();
                break;
            case 2:
                value = passport.getId();
                break;
            default:
                value = "";
                break;
        }

        return value;
    }

    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    public String getColumnName(int column)
    {
        return columnNames[column];
    }
}
