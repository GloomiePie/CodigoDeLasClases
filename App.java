package semana11;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class App {

    public static void main(String[] args) throws InterruptedException{
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        //Crear el subscriber y subscripcion
        PrinterSubcriber printerSubcriber = new PrinterSubcriber();

        //Funcion
        Function<String, String> toUpper = String::toUpperCase;
        //Crear Processor
        TransformProcessor transformProcessor = new TransformProcessor(toUpper);

        //Subcripcion
        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(printerSubcriber);

        List<String> items = List.of("juan", "pedro", "mayra", "ana", "ariel", "el diego");
        //Enviar los datos a los suscriptores
        items.forEach(publisher::submit);

        Thread.sleep(1 * 1000);

        publisher.close();
    }

}
