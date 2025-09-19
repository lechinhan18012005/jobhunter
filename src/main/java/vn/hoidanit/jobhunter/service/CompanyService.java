package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.Company;
import vn.hoidanit.jobhunter.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company companyRequest) {
        // Implementation for creating a company
        return this.companyRepository.save(companyRequest);
    }

    public List<Company> getAllCompanies() {
        // Implementation for retrieving companies, possibly filtering by name
        return this.companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        // Implementation for retrieving a company by ID
        Optional<Company> companyOptional = this.companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            return companyOptional.get();
        }
        return null;
    }

    public Company updateCompany(Company companyRequest) {
        // Implementation for updating a company
        Company existingCompany = this.getCompanyById(companyRequest.getId());
        if (existingCompany != null) {
            existingCompany.setName(companyRequest.getName());
            existingCompany.setAddress(companyRequest.getAddress());
            existingCompany.setLogo(companyRequest.getLogo());
            existingCompany.setDescription(companyRequest.getDescription());
            return this.companyRepository.save(existingCompany);
        }
        return null;
    }

    public void deleteCompany(Long id) {
        // Implementation for deleting a company
        this.companyRepository.deleteById(id);
    }
}
