package de.quist.app.maps.google;

import de.quist.app.maps.utils.Wrapper;

class IndoorLevel extends Wrapper<com.google.android.gms.maps.model.IndoorLevel> implements de.quist.app.maps.model.IndoorLevel {

    static final Mapper<de.quist.app.maps.model.IndoorLevel, IndoorLevel, com.google.android.gms.maps.model.IndoorLevel> MAPPER = new DefaultMapper<de.quist.app.maps.model.IndoorLevel, IndoorLevel, com.google.android.gms.maps.model.IndoorLevel>() {

        @Override
        public IndoorLevel createWrapper(com.google.android.gms.maps.model.IndoorLevel original) {
            return original != null ? new IndoorLevel(original) : null;
        }
    };

    private IndoorLevel(com.google.android.gms.maps.model.IndoorLevel original) {
        super(original);
    }

    @Override
    public String getName() {
        return original.getName();
    }

    @Override
    public String getShortName() {
        return original.getShortName();
    }

    @Override
    public void activate() {
        original.activate();
    }

}
