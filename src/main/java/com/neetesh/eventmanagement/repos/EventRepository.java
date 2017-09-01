package com.neetesh.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.neetesh.eventmanagement.entities.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
