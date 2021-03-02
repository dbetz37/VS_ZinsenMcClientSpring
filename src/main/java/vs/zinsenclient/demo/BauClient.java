package vs.zinsenclient.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BauClient implements CommandLineRunner {
    @Autowired
    BauInterface bauService;
    @Override
    public void run(String... args) throws Exception {
        double kreditbetrag = Double.parseDouble(args[0]);
        double zinssatz = Double.parseDouble(args[1]);
        double rueckzahlung = Double.parseDouble(args[2]);


        int zeitraum = bauService.berechneLaufzeitInMonaten(kreditbetrag, zinssatz, rueckzahlung);
        System.out.println("Zeitraum in Monaten: " + zeitraum);

        Collection<Double> plan = bauService.rueckzahlungsplan(kreditbetrag, zinssatz, rueckzahlung);
        System.out.println("Liste: "+ plan);
    }
}
