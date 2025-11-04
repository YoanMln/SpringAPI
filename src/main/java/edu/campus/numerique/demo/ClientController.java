package edu.campus.numerique.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name= "Clients", description= "API for managing clients")
public class ClientController {
    @Autowired
    private ClientRepository repository;

    @GetMapping
    @Operation(summary = "Get all clients", description = "Retrieve a list of all clients")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of client list")
    public List<Client> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID")
    @ApiResponse(responseCode = "200", description = "Client founded with success")
    public Client getById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Add a new client")
    @ApiResponse(responseCode = "200", description = "Client created successfully")
    public void add(@RequestBody Client client) {
        repository.save(client);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing client by ID")
    public void update(@PathVariable int id, @RequestBody Client client) {
        client.setId(id);
        repository.save(client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client by ID")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }
}
