package de.quist.app.mapsabstraction.amazonmapswrapper;

class IndoorLevel implements de.quist.app.mapsabstraction.model.IndoorLevel {

    static com.amazon.geo.mapsv2.model.IndoorLevel unwrap(de.quist.app.mapsabstraction.model.IndoorLevel indoorLevel) {
        return indoorLevel != null ? ((IndoorLevel)indoorLevel).original : null;
    }

    static de.quist.app.mapsabstraction.model.IndoorLevel wrap(com.amazon.geo.mapsv2.model.IndoorLevel indoorLevel) {
        return indoorLevel != null ? new IndoorLevel(indoorLevel) : null;
    }

    final com.amazon.geo.mapsv2.model.IndoorLevel original;

    private IndoorLevel(com.amazon.geo.mapsv2.model.IndoorLevel original) {
        this.original = original;
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

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IndoorLevel)) {
            return false;
        }

        IndoorLevel other = (IndoorLevel)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
