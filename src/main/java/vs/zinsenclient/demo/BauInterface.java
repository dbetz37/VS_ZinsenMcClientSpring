package vs.zinsenclient.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@FeignClient(name="BauService", url="http://localhost:8080/baukapital")
public interface BauInterface {

    @GetMapping
    int berechneMonatGet(
            @RequestParam double kreditbetrag,
            @RequestParam double zinssatz,
            @RequestParam double rueckzahlung);

    @PostMapping
    int berechneMonatPost(@RequestBody Map<String,Object> params);

}
