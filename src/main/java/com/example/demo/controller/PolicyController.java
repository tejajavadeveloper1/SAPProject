package com.example.demo.controller;

import com.example.demo.model.Policy;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.exception.PolicyNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyRepository repository;

    public PolicyController(PolicyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new PolicyNotFoundException(id));
    }

    @PostMapping
    public Policy createPolicy(@Valid @RequestBody Policy policy) {
        return repository.save(policy);
    }

    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable Long id, @Valid @RequestBody Policy updatedPolicy) {
        return repository.findById(id).map(policy -> {
            policy.setName(updatedPolicy.getName());
            return repository.save(policy);
        }).orElseThrow(() -> new PolicyNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePolicy(@PathVariable Long id) {
        return repository.findById(id).map(policy -> {
            repository.delete(policy);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new PolicyNotFoundException(id));
    }
}
