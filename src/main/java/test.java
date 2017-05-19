import java.io.File;



/**
 * Created by Jeannius on 5/18/2017.
 */
public class test {

    public static void main(String[] args){
        File f = Util.fileChooser("Choose a file");
        System.out.print(f.getPath());
    }



}
