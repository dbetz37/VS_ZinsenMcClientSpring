package vs.zinsenclient.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(name="baukapital", url="http://localhost:8080/baukapital")
public interface BauInterface {

    int berechneLaufzeitInMonaten(double kapital, double zinssatz, double rueckzahlung);

    Collection<Double> rueckzahlungsplan(double kapital, double zinssatz, double rueckzahlung);
}
