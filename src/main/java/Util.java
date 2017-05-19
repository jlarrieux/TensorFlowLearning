import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;



/**
 * Created by Jeannius on 5/18/2017.
 */
public class Util {

    public static File fileChooser(String title){
        JFileChooser chooser = createChooser(title);
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\images"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Picture Files", "jpg", "jif");
        chooser.setFileFilter(filter);
        return chooserOutput(chooser);
    }

    private static JFileChooser createChooser(String title){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(title);
        return chooser;
    }

    private static File chooserOutput(JFileChooser chooser){
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) return chooser.getSelectedFile();
        else return null;
    }
}
