package com.example.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserDao service;
	
	@GetMapping("/users")
	public List<User> retrievelAllUsers() {
		return service.findAll();
	}
	
//	@GetMapping("/users/{id}")
//	public Resource<User> retrieveUser(@PathVariable int id) {
//		User user = service.findOne(id);
//		if (user==null) {
//	throw new UserNotfoundException("id- "+id);	
//		}
//		 //we want to show additional info about how to show all users
//		//we want to add the link to retrieveAllUSers so that if the URL changes we won't have to change it
//		Resource<User> resource = new Resource<User>(user);
//		
//		//this class enables us to create links from methods
//		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrievelAllUsers());
//		//now we add the link to the HATEOS resource and we choose a name for it, in this case it is "all-users"
//		resource.add(linkTo.withRel("all-users"));
//		//So now instead of returning just data we return a resource that include data and links
//		return resource;
//	}
	
	//@RequestBody means what I send in the body will be mapped with it
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		//redirect to get the new user
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest() //tabda min /user
				.path("/{id}")  //this will be added to the current path /user
				.buildAndExpand(savedUser.getId()) //this will substitute the id by the value
				.toUri(); //convert to URI
		//doing a redirect to get the created user
		//responseEntity.created save the server response
		return ResponseEntity.created(location).build();
	}
	
	
}
