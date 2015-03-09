package de.quist.app.maps.google;

class IndoorLevel implements de.quist.app.maps.model.IndoorLevel {

    static com.google.android.gms.maps.model.IndoorLevel unwrap(de.quist.app.maps.model.IndoorLevel indoorLevel) {
        return indoorLevel != null ? ((IndoorLevel)indoorLevel).original : null;
    }

    static de.quist.app.maps.model.IndoorLevel wrap(com.google.android.gms.maps.model.IndoorLevel indoorLevel) {
        return indoorLevel != null ? new IndoorLevel(indoorLevel) : null;
    }

    final com.google.android.gms.maps.model.IndoorLevel original;

    private IndoorLevel(com.google.android.gms.maps.model.IndoorLevel original) {
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
