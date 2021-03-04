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

        int zeitraum = bauService.berechneMonatGet(kreditbetrag, zinssatz, rueckzahlung);

        System.out.println("Ein Kredit in Höhe von" + " " + kreditbetrag + "€" +  " " + "zu einem Zinssatz von" + " " + zinssatz + "%" + "\n" +
                            "mit einer monatlichen Rückzahlung von" + " " + rueckzahlung + "€"  + "\n" + "ist in " + zeitraum + " " + "Monaten abgezahlt.");




        Map<String, Object> params = new HashMap<String, Object>();
        params.put("kreditbetrag", kreditbetrag);
        params.put("zinssatz", zinssatz);
        params.put("rueckzahlung", rueckzahlung);
        Collection<Double> list = bauService.berechneMonatPost(params);
        System.out.println(list);

    }
}
