package com.vertabelo.mobileorm.myplaces;

import android.database.sqlite.SQLiteDatabase;

import com.vertabelo.mobileorm.myplaces.orm.gen.Place;
import com.vertabelo.mobileorm.myplaces.orm.gen.PlaceTag;
import com.vertabelo.mobileorm.myplaces.orm.gen.PlaceTagDAO;
import com.vertabelo.mobileorm.myplaces.orm.gen.Tag;
import com.vertabelo.mobileorm.myplaces.orm.gen.TagDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager for tags.
 */
public class TagManager {

    protected final TagDAO tagDao;
    protected final PlaceTagDAO placeTagDao;

    public TagManager(TagDAO tagDao, PlaceTagDAO placeTagDao) {
        this.tagDao = tagDao;
        this.placeTagDao = placeTagDao;
    }

    public void insertTags(Place place, List<String> tags) {
        for (String tag : tags) {
            if (tagDao.getByName(tag) == null) {
                tagDao.insert(new Tag(tag));
            }
            placeTagDao.insert(new PlaceTag(place.getId(), tag));
        }
    }

    /**
     * Maintain added and deleted tags for place according to currentTags list.
     * If tag from currentTags is already attached for a place - it does nothing.
     * If tag from currentTags is a new tag for a place - it adds this tag.
     * If place contains any tags not listed in current tags - it deletes these tags.
     *
     * @param place place which tags are attached to
     * @param currentTags current tags for a place
     */
    public void updateTags(Place place, List<String> currentTags) {
        List<String> tagsInDatabase = this.getTags(place);

        List<String> deletedTags = new ArrayList<>(tagsInDatabase);
        deletedTags.removeAll(currentTags);

        List<String> addedTags = new ArrayList<>(currentTags);
        addedTags.removeAll(tagsInDatabase);

        SQLiteDatabase db = MyPlacesApplication.getDb();
        db.beginTransaction();
        try {
            this.deleteTags(place, deletedTags);
            this.insertTags(place, addedTags);
             db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    /**
     * @return list of all existing tag names with blank entry at the beginning
     */
    public List<String> getTagStringList() {
        List<Tag> tagList = tagDao.getTagList();
        List<String> result = new ArrayList<>(tagList.size());
        for (Tag tag : tagList) {
            result.add(tag.getName());
        }
        return result;
    }

    /**
     * @return list of strings representing all tag names attached to a given place
     */
    public List<String> getTags(Place place) {
        List<String> tagNames = new ArrayList<>();
        if (place == null) {
            return tagNames;
        }

        List<PlaceTag> placeTags = placeTagDao.getPlaceTagList(place);
        for (PlaceTag placeTag : placeTags) {
            tagNames.add(tagDao.getTag(placeTag).getName());
        }
        return tagNames;
    }

    /**
     * Deletes all attachement of tags to given place. Deletes tags not used by any other place.
     */
    public void deleteTags(Place place) {
        for (PlaceTag placeTag : this.placeTagDao.getPlaceTagList(place)) {
            deletePlaceTag(placeTag);
        }
    }

    /**
     * Deletes attachment of deletedTags to a place. If tag is not used by any other place,
     * it is deleted.
     *
     * @param place place to deletePlace tag attachment for
     * @param deletedTags list of tags, that was deleted from a given place
     */
    protected void deleteTags(Place place, List<String> deletedTags) {
        for (String tag : deletedTags) {
            this.deletePlaceTag(place.getId(), tag);
        }
    }

    /**
     * Delete placeTag from database and deletes tag if it is not in any other placeTag.
     */
    protected void deletePlaceTag(PlaceTag placeTag) {
        this.placeTagDao.delete(placeTag);

        String tagName = placeTag.getTagName();
        Long tagUsage = placeTagDao.getCount(
            PlaceTagDAO.TAG_NAME.eq(tagName));

        if (tagUsage.equals(0L)) {
            tagDao.delete(tagName);
        }
    }

    protected void deletePlaceTag(Integer id, String tag) {
        this.deletePlaceTag(new PlaceTag(id, tag));
    }
}
