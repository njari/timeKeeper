package in.njari.timeKeeper.service;

import org.springframework.data.jpa.repository.JpaRepository;

import in.njari.timeKeeper.entity.Activity;


public interface ActivityRepository  extends JpaRepository<Activity, Long>{

}
