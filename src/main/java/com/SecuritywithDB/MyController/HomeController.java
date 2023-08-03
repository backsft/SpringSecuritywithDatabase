package com.SecuritywithDB.MyController;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

		@GetMapping("/normal")
		public ResponseEntity<String> getNormalUser(Principal principal) {

			return ResponseEntity.ok("welcome "+principal.getName()+" Yes...I am normal user");
		}

		@GetMapping("/public")
		public ResponseEntity<String> getPublicUser() {

			return ResponseEntity.ok("Yes...I am public user");
		}

		@GetMapping("/admin")
		public ResponseEntity<String> getAdminUser() {

			return ResponseEntity.ok("Yes...I am admin user");
		}

		//@PreAuthorize("hasRole('Admin')")
		@GetMapping("/secretpoint")
		public ResponseEntity<String> getSecretUser() {

			return ResponseEntity.ok("Yes...I am secret user");
		}
		
		// user having multiple roles can accsess some points let's check on securityfilterchain
		
		@GetMapping("/superadmin")
		public ResponseEntity<String> superadmin() {

			return ResponseEntity.ok("Yes...I am superadmin ");
		}
	
		

		@GetMapping("/test")
		public ResponseEntity<String> test() {

			return ResponseEntity.ok("Yes...this is test point only accsessible by READER AND WRITTERS  ");
		}
	
		
	}




