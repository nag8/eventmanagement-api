package com.neetesh.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neetesh.eventmanagement.controller.exceptions.NotCheckInException;
import com.neetesh.eventmanagement.entities.Participant;
import com.neetesh.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckOutController {

	@Autowired
	private ParticipantRepository participantRepository;
	
	@PostMapping("/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
		Participant participant = participantRepository.findOne(id);
		
		if(participant != null) {
			if(!(participant.getCheckedIn())) {
				throw new NotCheckInException();
			}
			participant.setCheckedIn(false);
			participantRepository.save(participant);
		}else {
			throw new ResourceNotFoundException();
		}
		
		return ResponseEntity.ok(assembler.toResource(participant));
	}
}
