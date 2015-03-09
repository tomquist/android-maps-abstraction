package de.quist.app.mapsabstraction.model;

import java.util.List;

public interface IndoorBuilding {

    int getDefaultLevelIndex();

    int getActiveLevelIndex();

    List<IndoorLevel> getLevels();

    boolean isUnderground();
}
