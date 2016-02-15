#  MyPlaces – Vertabelo Mobile ORM example app
The example android app that laverages the Vertabelo Mobile ORM to add and manage places in the SQLite database.

## Screenshots

<img src="http://www.vertabelo.com/_file/github/android-demo-app/my_places_activity.png" width="250" hspace="20"/>
<img src="http://www.vertabelo.com/_file/github/android-demo-app/add_new_place.png" width="250" hspace="20"/>
<img src="http://www.vertabelo.com/_file/github/android-demo-app/details.png" width="250" hspace="10"/>
<img src="http://www.vertabelo.com/_file/github/android-demo-app/sorting.png" width="250" hspace="100" vspace="30"/>
<img src="http://www.vertabelo.com/_file/github/android-demo-app/filtering.png" width="250" vspace="30"/>


## Overview

The app does the following:
- Displays a list of places retrieved from the SQLite database,
- Enables to perform sorting and filtering operations,
- Shows details of the selected item with possibility to edit/delete it.

For connection to database stands  listed below main components:
- **orm package** – generated Java classes that maps the database model and classes with defined operations for creating, reading, updating and deleting objects in/from a database. 
- `PlaceManager` -  class that is responsible for managing places (insert, delete, update, select)
- `TagsManager` – class that handles inserting, deleting tags.
- `AddressManager` – class that manages countries and cities associated with the places.

## Requirements

- min Android SDK: 15
- Gradle 2.5

## Documentation

To find more information on how to use Vertabelo Mobile ORM, visit: <br>
 http://mobile-orm.vertabelo.com/docs/vertabelo-mobile-orm-docs.html
