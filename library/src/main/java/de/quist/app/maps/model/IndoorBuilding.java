package de.quist.app.maps.model;

import java.util.List;

public interface IndoorBuilding {

    int getDefaultLevelIndex();

    int getActiveLevelIndex();

    List<IndoorLevel> getLevels();

    boolean isUnderground();
}
