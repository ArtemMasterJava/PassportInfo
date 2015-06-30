package Presentation;

import Models.Passport;
import Services.PassportService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassportsListApplet extends JApplet implements AddPassportJDialogDelegate
{
    private PassportService passportService = new PassportService();

    private PassportsDataModel passportsDataModel;

    private JPanel buttonsPanel;

    private JButton addButton;

    private JButton importButton;

    private JButton exportButton;

    private JTable passportsTable;

    public void init()
    {
        this.passportsDataModel = new PassportsDataModel();

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        this.addButtons(cp);

        this.passportsTable = new JTable(this.passportsDataModel);

        cp.add(new JScrollPane(this.passportsTable));
    }

    private  void addButtons(Container cp)
    {
        Dimension buttonsPanelDimension = new Dimension(cp.getWidth(), 40);
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setPreferredSize(buttonsPanelDimension);
        cp.add(this.buttonsPanel);

        this.addButton = new JButton("Add");

        this.addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addButtonClick();
            }
        });

        this.buttonsPanel.add(addButton);

        this.importButton = new JButton("Import");

        this.importButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                importButtonClick();
            }
        });

        this.buttonsPanel.add(importButton);

        this.exportButton = new JButton("Export");

        this.exportButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exportButtonClick();
            }
        });

        this.buttonsPanel.add(exportButton);
    }

    public void onSave(Passport passport)
    {
        this.passportService.addPassport(passport);
        this.passportsDataModel.reload(this.passportService.getPassports());
    }

    private void importButtonClick()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Import");

        int userSelection = fileChooser.showOpenDialog(new JFrame());

        if (userSelection == JFileChooser.APPROVE_OPTION)
        {
            this.passportService.importFromFile(fileChooser.getSelectedFile());
            this.passportsDataModel.reload(this.passportService.getPassports());
        }
    }

    private void exportButtonClick()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Export");

        int userSelection = fileChooser.showSaveDialog(new JFrame());

        if (userSelection == JFileChooser.APPROVE_OPTION)
        {
            this.passportService.exportToFile(fileChooser.getSelectedFile());
            this.passportsDataModel.reload(this.passportService.getPassports());
        }
    }

    private void addButtonClick()
    {
        AddPassportJDialog dialog = new AddPassportJDialog();
        dialog.setAddPassportDelegate(this);
        dialog.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        dialog.setVisible(true);
        dialog.pack();
    }
}