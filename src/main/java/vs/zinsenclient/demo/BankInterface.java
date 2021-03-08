package vs.zinsenclient.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="bankService", url="http://localhost:8080/bank")
public interface BankInterface {

    @GetMapping
    double getBaukreditzinssatz();
}
