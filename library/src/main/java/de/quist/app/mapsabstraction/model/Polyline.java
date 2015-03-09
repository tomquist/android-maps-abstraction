package de.quist.app.mapsabstraction.model;

public interface Polyline extends MapOverlay, PointSequence, Strokeable, ZOrderable {

    /**
     * Maintains api compatibility to original api
     * @see #setStrokeWidth(float)
     */
    void setWidth(float width);

    /**
     * Maintains api compatibility to original api
     * @see #getStrokeWidth()
     */
    float getWidth();

    /**
     * Maintains api compatibility to original api
     * @see #setStrokeColor(int)
     */
    void setColor(int color);

    /**
     * Maintains api compatibility to original api
     * @see #getStrokeColor()
     */
    int getColor();

}
