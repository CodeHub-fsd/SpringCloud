package com.stackroute.RestFul.repository;

import com.stackroute.RestFul.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}


@Reposirty
public interface FlightRepository extends JpaRepositoty<Passenger, Integer>