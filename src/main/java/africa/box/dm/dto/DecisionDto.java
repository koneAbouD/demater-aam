package africa.box.dm.dto;

import africa.box.dm.db.entities.DecideurOfLevel;
import africa.box.dm.db.entities.LevelDecision;

import java.util.List;

// Pas utile pour l'instant
public class DecisionDto {
    private LevelDecision leveDecision;
    private List<DecideurOfLevel> decideurOfLevels;

    public DecisionDto() {
    }

    @Override
    public String toString() {
        return "DecisionDto{" +
                "leveDecision=" + leveDecision +
                ", decideurOfLevels=" + decideurOfLevels +
                '}';
    }

    public LevelDecision getLeveDecision() {
        return leveDecision;
    }

    public void setLeveDecision(LevelDecision leveDecision) {
        this.leveDecision = leveDecision;
    }

    public List<DecideurOfLevel> getDecideurOfLevels() {
        return decideurOfLevels;
    }

    public void setDecideurOfLevels(List<DecideurOfLevel> decideurOfLevels) {
        this.decideurOfLevels = decideurOfLevels;
    }
}
