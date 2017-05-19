
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;



/**
 * Created by Jeannius on 5/18/2017.
 */
public class HelloTensorFlow {

    public static void main(String[] args) throws Exception{
        try (Graph g = new Graph()){
            final java.lang.String value = "Hello from " + TensorFlow.version();

            try(Tensor t = Tensor.create(value.getBytes("UTF-8"))) {
                g.opBuilder("Const", "MyConst")
                        .setAttr("dtype", t.dataType())
                        .setAttr("value", t)
                        .build();
            }

            try(Session s = new Session(g);
            Tensor output = s.runner().fetch("MyConst").run().get(0)){
                System.out.println(new java.lang.String(output.bytesValue(), "UTF-8"));
            }

        }
    }


}
