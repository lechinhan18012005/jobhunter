package vn.hoidanit.jobhunter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vn.hoidanit.jobhunter.domain.Company;
import vn.hoidanit.jobhunter.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companies")
    public ResponseEntity<?> createCompany(@Valid @RequestBody Company companyRequest) {
        // Implementation for creating a company
        return ResponseEntity.status(HttpStatus.CREATED).body(this.companyService.createCompany(companyRequest));
    }

    @GetMapping("/companies")
    public ResponseEntity<?> getCompanies() {
        // Implementation for retrieving companies, possibly filtering by name
        List<Company> companies = this.companyService.getAllCompanies();
        return ResponseEntity.status(HttpStatus.OK).body(companies);
    }

    @PutMapping("/companies")
    public ResponseEntity<?> updateCompany(@Valid @RequestBody Company companyRequest) {
        // Implementation for updating a company
        return ResponseEntity.status(HttpStatus.OK).body(this.companyService.updateCompany(companyRequest));
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") Long id) {
        // Implementation for deleting a company
        this.companyService.deleteCompany(id);
        return ResponseEntity.ok(null);
    }

}
