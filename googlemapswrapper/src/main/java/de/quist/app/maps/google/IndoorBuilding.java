package de.quist.app.maps.google;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.maps.utils.Wrapper;

class IndoorBuilding extends Wrapper<com.google.android.gms.maps.model.IndoorBuilding> implements de.quist.app.maps.model.IndoorBuilding {

    static final Mapper<de.quist.app.maps.model.IndoorBuilding, IndoorBuilding, com.google.android.gms.maps.model.IndoorBuilding> MAPPER = new DefaultMapper<de.quist.app.maps.model.IndoorBuilding, IndoorBuilding, com.google.android.gms.maps.model.IndoorBuilding>() {

        @Override
        public IndoorBuilding createWrapper(com.google.android.gms.maps.model.IndoorBuilding original) {
            return original != null ? new IndoorBuilding(original) : null;
        }
    };

    private IndoorBuilding(com.google.android.gms.maps.model.IndoorBuilding original) {
        super(original);
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
            wrappedLevels.add(IndoorLevel.MAPPER.wrap(indoorLevel));
        }
        return wrappedLevels;
    }

    @Override
    public boolean isUnderground() {
        return original.isUnderground();
    }

}
