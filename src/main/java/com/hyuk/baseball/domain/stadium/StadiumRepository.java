package com.hyuk.baseball.domain.stadium;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
	Stadium findByTeamId(int id);
}
