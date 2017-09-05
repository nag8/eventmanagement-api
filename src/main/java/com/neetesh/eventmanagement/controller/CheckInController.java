package com.neetesh.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neetesh.eventmanagement.controller.exceptions.AllReadyCheckedIn;
import com.neetesh.eventmanagement.entities.Participant;
import com.neetesh.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
		Participant participant = participantRepository.findOne(id);
		
		
		if(participant != null) {
			if(participant.getCheckedIn()) {
				throw new AllReadyCheckedIn();
			}
			participant.setCheckedIn(true);
			participantRepository.save(participant);
		}
		return ResponseEntity.ok(assembler.toResource(participant));
	}

}
