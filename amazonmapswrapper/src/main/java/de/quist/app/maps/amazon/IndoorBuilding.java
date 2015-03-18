package de.quist.app.maps.amazon;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.maps.utils.Wrapper;

class IndoorBuilding extends Wrapper<com.amazon.geo.mapsv2.model.IndoorBuilding> implements de.quist.app.maps.model.IndoorBuilding {

    static final Mapper<de.quist.app.maps.model.IndoorBuilding, IndoorBuilding, com.amazon.geo.mapsv2.model.IndoorBuilding> MAPPER = new DefaultMapper<de.quist.app.maps.model.IndoorBuilding, IndoorBuilding, com.amazon.geo.mapsv2.model.IndoorBuilding>() {

        @Override
        public IndoorBuilding createWrapper(com.amazon.geo.mapsv2.model.IndoorBuilding original) {
            return original != null ? new IndoorBuilding(original) : null;
        }
    };

    private IndoorBuilding(com.amazon.geo.mapsv2.model.IndoorBuilding original) {
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
        List<com.amazon.geo.mapsv2.model.IndoorLevel> unwrappedLevels = original.getLevels();
        List<de.quist.app.maps.model.IndoorLevel> wrappedLevels = new ArrayList<>(unwrappedLevels.size());
        for (com.amazon.geo.mapsv2.model.IndoorLevel indoorLevel : unwrappedLevels) {
            wrappedLevels.add(IndoorLevel.MAPPER.wrap(indoorLevel));
        }
        return wrappedLevels;
    }

    @Override
    public boolean isUnderground() {
        return original.isUnderground();
    }

}
