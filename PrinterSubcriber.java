package semana11;

import java.sql.SQLOutput;
import java.util.concurrent.Flow;
public class PrinterSubcriber implements Flow.Subscriber<String>{

    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Sus ඞ");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.printf("Valor: %s\n", item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Todo procesado papá ;)");
    }
}
