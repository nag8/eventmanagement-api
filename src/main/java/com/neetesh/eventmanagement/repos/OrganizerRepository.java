package com.neetesh.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.neetesh.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
