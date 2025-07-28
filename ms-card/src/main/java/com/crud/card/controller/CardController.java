package com.crud.card.controller;

import com.crud.card.model.Card;
import com.crud.card.model.ServiceResponse;
import com.crud.card.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping("api/v1/card")
@CrossOrigin("*")

public class CardController {

    @Autowired
    private ICardService iCardService;

    @GetMapping("/List")
    public ResponseEntity<List<Card>> List(){
        var result = iCardService.findALl();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Card card) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.save(card);
        if (result == 1) {
            serviceResponse.setMessage("Item salvado satisfactoriamemte");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Card card) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.update(card);
        if (result == 1) {
            serviceResponse.setMessage("Item actualizado satisfactoriamemte");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Item removido satisfactoriamemte");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }


}
