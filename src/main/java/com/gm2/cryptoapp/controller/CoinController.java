package com.gm2.cryptoapp.controller;

import com.gm2.cryptoapp.entity.Coin;
import com.gm2.cryptoapp.repository.coinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@RestController
@RequestMapping("/coin")
public class CoinController {

    // Constructor (Já instanciada)
    @Autowired
    private coinRepository coinRepository;

    @Bean
    public Coin init() {

        Coin c1 = new Coin();
        c1.setName("BITCOIN");
        c1.setPrice(new BigDecimal(100));
        c1.setQuantity(new BigDecimal(0.0005));
        c1.setDateTime(new Timestamp(System.currentTimeMillis()));

        Coin c2 = new Coin();
        c2.setName("BITCOIN");
        c2.setPrice(new BigDecimal(150));
        c2.setQuantity(new BigDecimal(0.0025));
        c2.setDateTime(new Timestamp(System.currentTimeMillis()));

        Coin c3 = new Coin();
        c3.setName("ETHEREUM");
        c3.setPrice(new BigDecimal(500));
        c3.setQuantity(new BigDecimal(0.0045));
        c3.setDateTime(new Timestamp(System.currentTimeMillis()));

        coinRepository.insert(c1);
        coinRepository.insert(c2);
        coinRepository.insert(c3);

        // Só temos que retornar algo mesmo
        return c1;
    }

    // Get do SELECT
    @GetMapping
    public ResponseEntity get(){
        return new ResponseEntity<>(coinRepository.getAll(), HttpStatus.OK);
    }

    // SELECT PELO NOME, PELA URL
    @GetMapping("/{name}")
    public ResponseEntity get(@PathVariable String name){
        try {
            return new ResponseEntity<>(coinRepository.getByName(name), HttpStatus.CREATED);
        }
        catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // SELECT PELO BODY
    @RequestMapping("/cripto")
    public ResponseEntity cripto(@RequestBody String name){
        try {
            return new ResponseEntity<>(coinRepository.getByName(name), HttpStatus.OK);
        }
        catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // UPDATE
    @PutMapping
    public ResponseEntity put(@RequestBody Coin coin) {
        try {
            // Vou definir data e hora agora
            coin.setDateTime(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(coinRepository.update(coin), HttpStatus.OK);
        }
        catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    // O retorno vai ser um ResponseEntity
    // INSERT PELO BODY
    @PostMapping
    public ResponseEntity post(@RequestBody Coin coin){
        try {
            // Vou definir data e hora agora
            coin.setDateTime(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity(coinRepository.insert(coin), HttpStatus.OK);
        }
        catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Lembrando que {} vira parametro de variavel
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            return new ResponseEntity<>(coinRepository.remove(id), HttpStatus.OK);
        }
        catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.NO_CONTENT);
        }
    }


    // Testando o ResponseEntity
    @GetMapping("/teste")
    public ResponseEntity<String> teste(){
        return new ResponseEntity<>("Hello Get", HttpStatus.CREATED);
    }
}
