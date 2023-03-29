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


    // Get do SELECT
    @GetMapping
    public ResponseEntity get(){
        return new ResponseEntity<>(coinRepository.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllTheSame(){
        return new ResponseEntity<>(coinRepository.getAllTheSame(), HttpStatus.OK);
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

/*
    // SELECT PELO ID
    @GetMapping("/{id}")
    public ResponseEntity get(@RequestBody int id){
        try {
            return new ResponseEntity<>(coinRepository.getById(id), HttpStatus.CREATED);
        }
        catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


 */

    // SELECT PELO BODY
   @RequestMapping("/cripto")
    public ResponseEntity cripto(@RequestBody String name){
        try {
            return null; //new ResponseEntity<>(coinRepository.getByName(name), HttpStatus.OK);
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
       boolean response = false;
       response = coinRepository.remove(id);
        try {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception error) {
            return new ResponseEntity(response, HttpStatus.NO_CONTENT);
        }
    }


    // Testando o ResponseEntity

}
