package Presentation;

import Models.Passport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPassportJDialog extends JDialog
{
    private JTextField nameTextField;

    private JTextField surnameTextField;

    private JTextField idTextField;

    private JButton saveButton;

    public AddPassportJDialog()
    {
        super();

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        this.nameTextField = this.createTextField("Name");
        this.surnameTextField = this.createTextField("Surname");
        this.idTextField = this.createTextField("Id");

        this.saveButton = new JButton("Save");

        this.saveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                save();
            }
        });

        this.getContentPane().add(this.saveButton);
    }

    private JTextField createTextField(String title)
    {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(this.getWidth(), 40));

        JLabel label = new JLabel(title);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 40));
        panel.add(textField);

        this.getContentPane().add(panel);

        return textField;
    }

    private AddPassportJDialogDelegate addPassportDelegate;

    public AddPassportJDialogDelegate getAddPassportDelegate()
    {
        return addPassportDelegate;
    }

    public void setAddPassportDelegate(AddPassportJDialogDelegate addPassportDelegate)
    {
        this.addPassportDelegate = addPassportDelegate;
    }

    private void save()
    {
        Passport passport = new Passport();

        passport.setName(this.nameTextField.getText());
        passport.setSurname(this.surnameTextField.getText());
        passport.setId(this.idTextField.getText());

        if (getAddPassportDelegate() != null)
        {
            getAddPassportDelegate().onSave(passport);
        }

        this.setVisible(false);
    }
}
