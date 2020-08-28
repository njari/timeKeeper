package in.njari.timeKeeper.service;

import org.springframework.data.jpa.repository.JpaRepository;

import in.njari.timeKeeper.entity.Action;


public interface ActionRepository  extends JpaRepository<Action, Long>{

}
