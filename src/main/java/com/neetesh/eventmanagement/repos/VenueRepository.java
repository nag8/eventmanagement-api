package com.neetesh.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.neetesh.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
