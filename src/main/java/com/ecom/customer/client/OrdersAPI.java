package com.ecom.customer.client;

import com.ecom.customer.dto.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class OrdersAPI {

    @Autowired
    private RestTemplate restTemplate;

    public List<Orders> getOrdersByCustomer(int customerNumber){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        URI targetUrl= UriComponentsBuilder.fromUriString("http://localhost:8081/orders/customer/")
                .path(String.valueOf(customerNumber))
                .build()
                .toUri();

        Orders[] orders;
        try {
            orders = restTemplate.exchange(targetUrl.toURL().toString(), HttpMethod.GET, entity, Orders[].class).getBody();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return  Arrays.asList(orders);

    }
}
