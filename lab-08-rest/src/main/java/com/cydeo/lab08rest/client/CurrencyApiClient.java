package com.cydeo.lab08rest.client;

import com.cydeo.lab08rest.dto.CurrencyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.currencylayer.com", name = "CURRENCY-CLIENT")
public interface CurrencyApiClient {

    //http://api.currencylayer.com/live?access_key=7e96fc324c82df28fb575deb000578c9&currencies=EUR&source=USD&format=1

    @GetMapping("/live")
    CurrencyApiResponse getCurrencyRates(@RequestParam ("access_key") String accessKey,
                                         @RequestParam ("currencies") String currencies,
                                         @RequestParam("source") String source,
                                         @RequestParam("format") int format);
}
