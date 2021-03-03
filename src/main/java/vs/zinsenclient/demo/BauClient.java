package vs.zinsenclient.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class BauClient implements CommandLineRunner {
    @Autowired BauInterface bauService;

    @Override
    public void run(String... args) throws Exception {
        double kreditbetrag = Double.parseDouble(args[0]);
        double zinssatz = Double.parseDouble(args[1]);
        double rueckzahlung = Double.parseDouble(args[2]);

        System.out.println(kreditbetrag);
        System.out.println(zinssatz);
        System.out.println(rueckzahlung);


        int zeitraum = bauService.berechneGet(kreditbetrag, zinssatz, rueckzahlung);
        System.out.println("Zeitraum in Monaten: " + zeitraum);

        /*Map<String, Object> params = new HashMap<String, Object>();
        params.put("kreditbetrag", kreditbetrag);
        params.put("zinssatz", zinssatz);
        params.put("rueckzahlung", rueckzahlung);
        zeitraum = bauService.berechnePost(params);*/
        //Collection<Double> plan = bauService.rueckzahlungsplan(kreditbetrag, zinssatz, rueckzahlung);
        //System.out.println("Liste: "+ plan);
    }
}
