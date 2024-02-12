package io.shraddha.repo;

import io.shraddha.model.ProfileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDataRepository extends JpaRepository<ProfileData, Long> {
    // You can define custom query methods here if needed
	ProfileData findByUsername(String username);
}
