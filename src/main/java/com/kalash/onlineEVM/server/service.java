package com.kalash.onlineEVM.server;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalash.onlineEVM.entity.e_commissioner;
import com.kalash.onlineEVM.entity.evm;
import com.kalash.onlineEVM.entity.voter;
import com.kalash.onlineEVM.repository.e_commissioner_repository;
import com.kalash.onlineEVM.repository.evm_Repository;
import com.kalash.onlineEVM.repository.vote_Repository;






@Service
public class service {
	
	@Autowired
	evm_Repository repo;
	@Autowired
	vote_Repository repoo;
	@Autowired
	e_commissioner_repository erepo;
//	public boolean insertVoterById(int voter_id,voter v) {
//        Optional<voter> optionalVoter = repo.findById(voter_id);
//
//        // If the book exists, delete it
//        if (optionalVoter.isPresent()) {
//            
//            return false;
//        } else {
//            // If the book does not exist, return false
//            return true;
//        }
//    }
//	public boolean insertVoterById( voter v) {
//		Optional<voter> optionalVoter = repo.findById(v.getVoter_id());
//		
//		        // If the book exists, delete it
//		        if (optionalVoter.isPresent()) {
//		            
//		            return false;
//		        } else {
//		            // If the book does not exist, return false
//		            return true;
//		        }
//	} 
	public boolean insertVoterById(voter v) {
		Optional<voter> optionalVoter = repo.findById(v.getVoter_id());
		
        // If the book exists, delete it
        if (optionalVoter.isPresent()) {
            
            return false;
        } 
        repo.save(v);
        return true;
        }
	
	public boolean insertVote(evm e) {
	
        repoo.save(e);
        return true;
        }
	
	public boolean logincommissionerr(int id) {
		try {
	        // Attempt to find the commissioner by ID
	        Optional<e_commissioner> commissionerOptional = erepo.findById(id);
	        
	        if (commissionerOptional.isPresent()) {
	            // If the commissioner is found
	            System.out.println("Commissioner found: " + commissionerOptional.get());
	            return true;
	        } else {
	            // If the commissioner is not found
	            System.out.println("No commissioner found with ID: " + id);
	            return false;
	        }
	    } catch (Exception ex) {
	        // Handle any errors
	        System.err.println("Error finding commissioner by ID: " + ex.getMessage());
	        return false;
	    }
	}
	public List<evm> getAll() {
		List<evm> data = repoo.findAll();
		return data;
	}
}
