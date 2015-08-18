/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 * @author Domenico
 */
public class FL2Angle extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private final double D = 43.266615305567871517430655209646;
    private double focal, fm, angle35, angle;
    private RecordStore rs;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command okCommand;
    private Command backCommand;
    private Command exitCommand1;
    private Form form;
    private TextField textField;
    private TextField textField1;
    private StringItem stringItem;
    private ImageItem imageItem;
    private Form form1;
    private StringItem stringItem3;
    private StringItem stringItem2;
    private StringItem stringItem1;
    private StringItem stringItem4;
    private Image image;
    private Image image1;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public FL2Angle() {

        try {
            rs = RecordStore.openRecordStore("fl2angle", true);
        } catch (RecordStoreException ex) { ex.printStackTrace(); }
        
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|19-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|19-preAction
                // write pre-action user code here
                try {
                    rs.closeRecordStore();
                } catch (RecordStoreException ex) { ex.printStackTrace(); }
                exitMIDlet();//GEN-LINE:|7-commandAction|2|19-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|35-preAction
                // write pre-action user code here
                salvaDati();

                focal = Double.parseDouble(textField.getString());
                fm = Double.parseDouble(textField1.getString());
                angle35 = angle(focal, 1);
                angle = angle(focal, fm);

                switchDisplayable(null, getForm1());//GEN-LINE:|7-commandAction|4|35-postAction
                // write post-action user code here

                if(fm==1){
                    stringItem2.setLabel("");
                    stringItem2.setText("");
                    stringItem4.setLabel("");
                    stringItem4.setText("");
                }
                else{
                    stringItem2.setLabel("Lunghezza focale equivalente ("+fm+"x)");
                    stringItem2.setText(format(focal*fm)+"mm");
                    stringItem4.setLabel("Angolo di campo equivalente ("+fm+"x)");
                    stringItem4.setText(format(angle)+"°");
                }
                stringItem1.setText(format(focal)+"mm");
                stringItem3.setText(format(angle35)+"°");

            }//GEN-BEGIN:|7-commandAction|5|38-preAction
        } else if (displayable == form1) {
            if (command == backCommand) {//GEN-END:|7-commandAction|5|38-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|6|38-postAction
                // write post-action user code here
            } else if (command == exitCommand1) {//GEN-LINE:|7-commandAction|7|51-preAction
                // write pre-action user code here
                try {
                    rs.closeRecordStore();
                } catch (RecordStoreException ex) { ex.printStackTrace(); }
                exitMIDlet();//GEN-LINE:|7-commandAction|8|51-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|7-postCommandAction
        }//GEN-END:|7-commandAction|9|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|10|
    //</editor-fold>//GEN-END:|7-commandAction|10|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Esci", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("FL2Angle", new Item[] { getImageItem(), getStringItem(), getTextField(), getTextField1() });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getOkCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
            caricaDati();
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of image component.
     * @return the initialized component instance
     */
    public Image getImage() {
        if (image == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|32-getter|1|32-@java.io.IOException
                image = Image.createImage("/shutter_trasp.png");
            } catch (java.io.IOException e) {//GEN-END:|32-getter|1|32-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|32-getter|2|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|3|
        return image;
    }
    //</editor-fold>//GEN-END:|32-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            okCommand = new Command("Calcola", Command.OK, 0);//GEN-LINE:|34-getter|1|34-postInit
            // write post-init user code here
        }//GEN-BEGIN:|34-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|34-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|37-getter|0|37-preInit
            // write pre-init user code here
            backCommand = new Command("Nuovo calcolo", Command.BACK, 0);//GEN-LINE:|37-getter|1|37-postInit
            // write post-init user code here
        }//GEN-BEGIN:|37-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|37-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|42-getter|0|42-preInit
            // write pre-init user code here
            textField = new TextField("Lunghezza focale", "50.0", 32, TextField.DECIMAL);//GEN-LINE:|42-getter|1|42-postInit
            // write post-init user code here
        }//GEN-BEGIN:|42-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|42-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form1 ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initiliazed instance of form1 component.
     * @return the initialized component instance
     */
    public Form getForm1() {
        if (form1 == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
            form1 = new Form("Risultato", new Item[] { getStringItem1(), getStringItem3(), getStringItem2(), getStringItem4() });//GEN-BEGIN:|33-getter|1|33-postInit
            form1.addCommand(getBackCommand());
            form1.addCommand(getExitCommand1());
            form1.setCommandListener(this);//GEN-END:|33-getter|1|33-postInit
            // write post-init user code here
        }//GEN-BEGIN:|33-getter|2|
        return form1;
    }
    //</editor-fold>//GEN-END:|33-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of textField1 component.
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            textField1 = new TextField("Fattore moltiplicativo", "1.0", 32, TextField.DECIMAL);//GEN-LINE:|43-getter|1|43-postInit
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return textField1;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: imageItem ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of imageItem component.
     * @return the initialized component instance
     */
    public ImageItem getImageItem() {
        if (imageItem == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            imageItem = new ImageItem("", getImage1(), ImageItem.LAYOUT_DEFAULT, "<Missing Image>");//GEN-LINE:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return imageItem;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of image1 component.
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|45-getter|1|45-@java.io.IOException
                image1 = Image.createImage("/logo.png");
            } catch (java.io.IOException e) {//GEN-END:|45-getter|1|45-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|45-getter|2|45-postInit
            // write post-init user code here
        }//GEN-BEGIN:|45-getter|3|
        return image1;
    }
    //</editor-fold>//GEN-END:|45-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            stringItem = new StringItem("Calcolatore angolo di campo", " ");//GEN-LINE:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|46-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of exitCommand1 component.
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Esci", Command.EXIT, 0);//GEN-LINE:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return exitCommand1;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("Lunghezza focale (35mm):", null);//GEN-LINE:|53-getter|1|53-postInit
            // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            stringItem2 = new StringItem("Lunghezza focale equivalente:", null);//GEN-LINE:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return stringItem2;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initiliazed instance of stringItem3 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            stringItem3 = new StringItem("Angolo di campo (35mm):", null);//GEN-LINE:|55-getter|1|55-postInit
            // write post-init user code here
        }//GEN-BEGIN:|55-getter|2|
        return stringItem3;
    }
    //</editor-fold>//GEN-END:|55-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of stringItem4 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            stringItem4 = new StringItem("Angolo di campo equivalente:", null);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return stringItem4;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        //switchDisplayable (null, null);
        destroyApp(false);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    public double angle(double focal, double fm){
        return 2*atan(D/(fm*2*focal));
    }

    public double atan(double arg){
        return arctg(1, arg);
    }
    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public String format(double d){
        if(d<1)
            return "<1";
        return String.valueOf((int)d);
    }

    public void salvaDati(){
        writeString(textField.getString(), 1);
        writeString(textField1.getString(), 2);
    }

    private void caricaDati(){
        try {
            if (rs==null || rs.getNumRecords() < 2) {
                return;
            }
        } catch (RecordStoreNotOpenException ex) { return; }

        textField.setString(readString(1));
        textField1.setString(readString(2));
    }

    public void writeString(String s, int index){
        byte[] b = s.getBytes();
        if (rs != null){
            try {
                if(rs.getNumRecords()<2)
                    rs.addRecord(b, 0, b.length);
                else
                    rs.setRecord(index, b, 0, b.length);
            } catch (RecordStoreException ex) { ex.printStackTrace(); }
        }
    }

    public String readString(int index){
        String s = "";
        byte[] b = null;
        try {
            b = rs.getRecord(index);
        } catch (RecordStoreException ex) { ex.printStackTrace(); }
        if(b!=null)
            s = new String(b);
        if(s.equals("")){
            switch(index){
                case 1: textField.setString("50.0");
                case 2: textField1.setString("1.0");
            }
        }
        return s;
    }


public double arctg(double x, double y)
{
    double ris=1000;
    double t = y/x;
    if (x>=Math.abs(y))
    {
        ris = (56.47496170 - 11.97322476*t*t)*t;
        if(ris<0)
            ris = 360+ris;
    }
    if (x<0 & -x>=Math.abs(y))
        ris = (56.47496170 - 11.97322476*t*t)*t + 180;
    if (x>0 & y>x)
    {
        t = x/y;
        ris = 90 - (56.47496170 - 11.97322476*t*t)*t;
    }
    if(x<0 & y>Math.abs(x))
    {
        t = -x/y;
        ris = 90 + (56.47496170 - 11.97322476*t*t)*t;
    }
    if (x<0 & y<x)
    {
        t = x/y;
        ris = 270 - (56.47496170 - 11.97322476*t*t)*t;
    }
    if(x>0 & y<-x)
    {
        t = -x/y;
        ris = 270 + (56.47496170 - 11.97322476*t*t)*t;
    }

    return ris;
}

}
