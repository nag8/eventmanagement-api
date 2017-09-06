package com.neetesh.eventmanagement.entities.projections;

import org.springframework.data.rest.core.config.Projection;

import com.neetesh.eventmanagement.entities.Participant;

@Projection(name = "participantPartial", types = { Participant.class })
public interface PartialParticipantProjection {

	String getName();

	Boolean getCheckedIn();

}
