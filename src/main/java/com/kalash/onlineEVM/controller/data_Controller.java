package com.kalash.onlineEVM.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kalash.onlineEVM.entity.voter;
import com.kalash.onlineEVM.repository.e_commissioner_repository;
import com.kalash.onlineEVM.repository.evm_Repository;
import com.kalash.onlineEVM.repository.vote_Repository;
import com.kalash.onlineEVM.server.service;


import org.springframework.ui.Model;

import com.kalash.onlineEVM.entity.e_commissioner;
import com.kalash.onlineEVM.entity.evm;

import jakarta.servlet.http.HttpSession;





@Controller
public class data_Controller {
	@Autowired
	evm_Repository evmrepo;
	@Autowired
	e_commissioner_repository erepo;
	@Autowired
	vote_Repository repoo;
	@Autowired
	service Service;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/voter")
	public String voter() {
		return "voter";
	}
	 @GetMapping("/voted")
 	public String voted() {
 		return "voted";
 	}
	 
	 @GetMapping("/evm")
	 public String evm() {
		 return "evm";
	 }
	 @GetMapping("/e_commissioner")
	 public String e_commissioner() {
		 return "e_commissioner";
	 }
	@PostMapping("/voter")
    public String insertVoter(@ModelAttribute voter v, HttpSession session) {
        // Delete the book using the service method
        boolean isInserted =Service.insertVoterById(v);

        // Set a session attribute to indicate the result of the deletion
        if (isInserted) {
        	return "redirect:/evm";
        } else {
        	
        	return "redirect:/voted";
        }
	}
        @PostMapping("/evm")
        public String insertVote(@ModelAttribute evm e, HttpSession session) {
        	boolean isVoteInserted = Service.insertVote(e);
        	 if (isVoteInserted) {
        	        return "redirect:/";
        	    } 
        	    
        	    return "redirect:/evm";
          
    }
       
        @PostMapping("/e_commissioner")
        public String updateBook(@RequestParam int id, HttpSession session) {
            // Update the book's price using the service method
            boolean login= Service.logincommissionerr(id);

            // Set a session attribute to indicate the result of the update
            if (login == true) {
                return "redirect:/read";
            } else {
                session.setAttribute("msg", "commissioner not found!");
            }

            // Redirect to the home page
            return "redirect:/evm";
        } 
        @GetMapping("/read")
    	public String getAllPartyName(Model model){
    	
    		List<evm> data  =Service.getAll();
    		System.out.println("Retrieved evms: " + data); 
    		model.addAttribute("evms",data);
    		return "read";
    	}
}
