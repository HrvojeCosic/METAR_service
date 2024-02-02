package com.example.demo.controllers;

import com.example.demo.domain.dto.SubscribeRequestDto;
import com.example.demo.domain.entities.Subscription;
import com.example.demo.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
@RequiredArgsConstructor
public class SubscriptionController {

    private final ModelMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    @PostMapping("/subscribe")
    public ResponseEntity<Long> subscribeAirport(@RequestBody SubscribeRequestDto subscriptionRequestDto) {
        Long id = subscriptionService.subscribe(subscriptionMapper.map(subscriptionRequestDto, Subscription.class));

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}