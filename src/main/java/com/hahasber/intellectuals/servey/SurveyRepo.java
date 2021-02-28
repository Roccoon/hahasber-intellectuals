package com.hahasber.intellectuals.servey;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepo extends JpaRepository<SurveyEntity, UUID> {

}
