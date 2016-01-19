package com.vertabelo.mobileorm.myplaces.orm.gen;

/**
 * POJO representing table place.
 */
public class Place implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -738376397025246601L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<PlaceDAO> DAO_INTERFACE_CLASS = PlaceDAO.class;
    /**
     * Property representing column id
     */
    protected Integer id;
    /**
     * Property representing column name
     */
    protected String name;
    /**
     * Property representing column address_id
     */
    protected Integer addressId;
    /**
     * Property representing column rating
     */
    protected Integer rating;
    /**
     * Property representing column added
     */
    protected java.sql.Timestamp added;
    /**
     * Property representing column comment
     */
    protected String comment;

    /**
     * Default constructor.
     */
    public Place() {
    }

    /**
     * All columns constructor.
     * @param id value of column id.
     * @param name value of column name.
     * @param addressId value of column address_id.
     * @param rating value of column rating.
     * @param added value of column added.
     * @param comment value of column comment.
     */
    public Place(Integer id, String name, Integer addressId, Integer rating, java.sql.Timestamp added, String comment) {
        setId(id);
        setName(name);
        setAddressId(addressId);
        setRating(rating);
        setAdded(added);
        setComment(comment);
    }

    /**
     * Returns value of property {@link #id}.
     * @return value of property {@link #id}.
     */
    public Integer getId() {
        return this.id;
    }
    /**
     * Sets new value of property {@link #id}.
     * @param id new value of property {@link #id}.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Returns value of property {@link #name}.
     * @return value of property {@link #name}.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Sets new value of property {@link #name}.
     * @param name new value of property {@link #name}.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns value of property {@link #addressId}.
     * @return value of property {@link #addressId}.
     */
    public Integer getAddressId() {
        return this.addressId;
    }
    /**
     * Sets new value of property {@link #addressId}.
     * @param addressId new value of property {@link #addressId}.
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
     * Returns value of property {@link #rating}.
     * @return value of property {@link #rating}.
     */
    public Integer getRating() {
        return this.rating;
    }
    /**
     * Sets new value of property {@link #rating}.
     * @param rating new value of property {@link #rating}.
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    /**
     * Returns value of property {@link #added}.
     * @return value of property {@link #added}.
     */
    public java.sql.Timestamp getAdded() {
        return this.added;
    }
    /**
     * Sets new value of property {@link #added}.
     * @param added new value of property {@link #added}.
     */
    public void setAdded(java.sql.Timestamp added) {
        this.added = added;
    }
    /**
     * Returns value of property {@link #comment}.
     * @return value of property {@link #comment}.
     */
    public String getComment() {
        return this.comment;
    }
    /**
     * Sets new value of property {@link #comment}.
     * @param comment new value of property {@link #comment}.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;

        if (id != null ? !id.equals(place.id) : place.id != null) {
            return false;
        }
        if (name != null ? !name.equals(place.name) : place.name != null) {
            return false;
        }
        if (addressId != null ? !addressId.equals(place.addressId) : place.addressId != null) {
            return false;
        }
        if (rating != null ? !rating.equals(place.rating) : place.rating != null) {
            return false;
        }
        if (added != null ? !added.equals(place.added) : place.added != null) {
            return false;
        }
        if (comment != null ? !comment.equals(place.comment) : place.comment != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (added != null ? added.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Place{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", addressId='" + addressId + '\''
                + ", rating='" + rating + '\''
                + ", added='" + added + '\''
                + ", comment='" + comment + '\''
                + '}';
    }
}
