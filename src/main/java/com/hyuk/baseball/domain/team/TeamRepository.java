package com.hyuk.baseball.domain.team;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
	Optional<Team> findByName(String name);
	Team findByStadiumId(int id);
}
