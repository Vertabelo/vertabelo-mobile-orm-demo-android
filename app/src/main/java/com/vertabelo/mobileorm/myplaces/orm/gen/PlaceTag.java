package com.vertabelo.mobileorm.myplaces.orm.gen;

/**
 * POJO representing table place_tag.
 */
public class PlaceTag implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = 8438933205427499886L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<PlaceTagDAO> DAO_INTERFACE_CLASS = PlaceTagDAO.class;
    /**
     * Property representing column place_id
     */
    protected Integer placeId;
    /**
     * Property representing column tag_name
     */
    protected String tagName;

    /**
     * Default constructor.
     */
    public PlaceTag() {
    }

    /**
     * All columns constructor.
     * @param placeId value of column place_id.
     * @param tagName value of column tag_name.
     */
    public PlaceTag(Integer placeId, String tagName) {
        setPlaceId(placeId);
        setTagName(tagName);
    }

    /**
     * Returns value of property {@link #placeId}.
     * @return value of property {@link #placeId}.
     */
    public Integer getPlaceId() {
        return this.placeId;
    }
    /**
     * Sets new value of property {@link #placeId}.
     * @param placeId new value of property {@link #placeId}.
     */
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }
    /**
     * Returns value of property {@link #tagName}.
     * @return value of property {@link #tagName}.
     */
    public String getTagName() {
        return this.tagName;
    }
    /**
     * Sets new value of property {@link #tagName}.
     * @param tagName new value of property {@link #tagName}.
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlaceTag placeTag = (PlaceTag) o;

        if (placeId != null ? !placeId.equals(placeTag.placeId) : placeTag.placeId != null) {
            return false;
        }
        if (tagName != null ? !tagName.equals(placeTag.tagName) : placeTag.tagName != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlaceTag{"
                + "placeId='" + placeId + '\''
                + ", tagName='" + tagName + '\''
                + '}';
    }
}
