package in.njari.timeKeeper.service;

import org.springframework.data.jpa.repository.JpaRepository;

import in.njari.timeKeeper.entity.Routine;

public  interface RoutineRepository extends JpaRepository<Routine, Long> {

}
