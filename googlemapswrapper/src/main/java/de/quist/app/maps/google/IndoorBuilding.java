package de.quist.app.maps.google;

import java.util.ArrayList;
import java.util.List;

class IndoorBuilding implements de.quist.app.maps.model.IndoorBuilding {

    static com.google.android.gms.maps.model.IndoorBuilding unwrap(de.quist.app.maps.model.IndoorBuilding indoorBuilding) {
        return indoorBuilding != null ? ((IndoorBuilding)indoorBuilding).original : null;
    }

    static de.quist.app.maps.model.IndoorBuilding wrap(com.google.android.gms.maps.model.IndoorBuilding indoorBuilding) {
        return indoorBuilding != null ? new IndoorBuilding(indoorBuilding) : null;
    }

    final com.google.android.gms.maps.model.IndoorBuilding original;

    private IndoorBuilding(com.google.android.gms.maps.model.IndoorBuilding original) {
        this.original = original;
    }
    
    @Override
    public int getDefaultLevelIndex() {
        return original.getDefaultLevelIndex();
    }

    @Override
    public int getActiveLevelIndex() {
        return original.getActiveLevelIndex();
    }

    @Override
    public List<de.quist.app.maps.model.IndoorLevel> getLevels() {
        List<com.google.android.gms.maps.model.IndoorLevel> unwrappedLevels = original.getLevels();
        List<de.quist.app.maps.model.IndoorLevel> wrappedLevels = new ArrayList<>(unwrappedLevels.size());
        for (com.google.android.gms.maps.model.IndoorLevel indoorLevel : unwrappedLevels) {
            wrappedLevels.add(IndoorLevel.wrap(indoorLevel));
        }
        return wrappedLevels;
    }

    @Override
    public boolean isUnderground() {
        return original.isUnderground();
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IndoorBuilding)) {
            return false;
        }

        IndoorBuilding other = (IndoorBuilding)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
