package com.zerobase.challenge.domain.repository;

import com.zerobase.challenge.domain.entity.ChallengeEntity;
import com.zerobase.challenge.domain.enums.ChallengeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<ChallengeEntity, Long> {
    List<ChallengeEntity> findAllByUserId(Long userId);

    List<ChallengeEntity> findByStatus(ChallengeStatus challengeStatus);

    @Query("SELECT c" +
            " FROM challenge c " +
            "WHERE c.id = :id AND " +
            "c.userId = :userId AND " +
            "c.status <> 'COMPLETED' AND c.status <> 'EXPIRED'")
    Optional<ChallengeEntity> findUpdatableByIdAndUserId(Long id, Long userId);

    List<ChallengeEntity> findAllByUserIdOrderByCreatedAtDesc(Long userId);

    Optional<ChallengeEntity> findByIdAndUserId(Long id, Long userId);


    Optional<ChallengeEntity> findByIdAndUserIdAndStatusIn(
            Long challengeId, Long userId, List<ChallengeStatus> statuses
    );
}
