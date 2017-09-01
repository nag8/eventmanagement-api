package com.neetesh.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.neetesh.eventmanagement.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
