package com.example.demo.service;

import com.example.demo.repository.CallRepository;
import org.springframework.stereotype.Service;

@Service
public class CallService {

    private final CallRepository callRepository;

    public CallService(CallRepository callRepository) {
        this.callRepository = callRepository;
    }
}
