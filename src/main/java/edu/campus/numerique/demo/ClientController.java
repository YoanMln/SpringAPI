package edu.campus.numerique.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import edu.campus.numerique.demo.Client;
import edu.campus.numerique.demo.ClientDAO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name= "Clients", description= "API for managing clients")
public class ClientController {
    private ClientDAO dao = new ClientDAO();

    @GetMapping
    @Operation(summary = "Get all clients", description = "Retrieve a list of all clients")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of client list")
    public List<Client> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID")
    @ApiResponse(responseCode = "200", description = "Client founded with success")
    public Client getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @Operation(summary = "Add a new client")
    @ApiResponse(responseCode = "200", description = "Client created successfully")
    public void add(@RequestBody Client client) {
        dao.save(client);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing client by ID")
    public void update(@PathVariable int id, @RequestBody Client client) {
        client.setId(id);
        dao.save(client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client by ID")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
