package com.vertabelo.mobileorm.myplaces;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.vertabelo.mobileorm.myplaces.orm.gen.Place;
import com.vertabelo.mobileorm.myplaces.orm.gen.PlaceDAO;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.Column;
import com.vertabelo.mobileorm.myplaces.orm.runtime.query.OrderByDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main activity.
 */
public class MainActivity extends AppCompatActivity {

    protected static final int ADDED_INDEX = 0;
    protected static final int RATING_INDEX = 1;
    protected static final int NAME_INDEX = 2;

    protected PlaceManager placeManager;
    protected TagManager tagManager;
    protected AddressManager addressManager;
    protected ImageManager imageManager;

    protected FilteringState filtering;
    protected SortingState sorting;

    protected PlaceStringAdapter adapter;
    protected ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.placeManager = MyPlacesApplication.getPlaceManager();
        this.tagManager = MyPlacesApplication.getTagManager();
        this.addressManager = MyPlacesApplication.getAddressManager();
        this.imageManager = MyPlacesApplication.getImageManager();

        this.filtering = new FilteringState();
        this.sorting = new SortingState();

        setContentView(R.layout.activity_main);

        this.list = (ListView) findViewById(R.id.list);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("object", (Place) parent.getAdapter().getItem(position));
                startActivity(intent);
            }
        });

        this.adapter = new PlaceStringAdapter(this);
        this.refresh();
        this.list.setAdapter(this.adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_add) {
            Intent intent = new Intent(MainActivity.this, AddNewPlaceActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_sort) {
            openSortDialog();
        } else if (id == R.id.action_filter) {
            openFilterDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void refresh() {
        this.adapter.setPlaces(this.placeManager.getPlacesList(this.filtering, this.sorting));
        this.adapter.notifyDataSetChanged();
    }

    protected void openSortDialog() {
        LayoutInflater inflater = getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View directionView = inflater.inflate(R.layout.dialog_sort, null);

        builder.setView(directionView)

                .setTitle(R.string.sort_dialog_title)

                .setSingleChoiceItems(R.array.sort_menu, columnToInt(
                        this.sorting.getSortingColumn()), null)

                .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lv = ((AlertDialog) dialog).getListView();

                        Column sortColumn = intToColumn(lv.getCheckedItemPosition());
                        OrderByDirection direction = radioButtonIdToDirection((
                                (RadioGroup) ((AlertDialog) dialog)
                                        .findViewById(R.id.direction_group))
                                .getCheckedRadioButtonId());

                        sorting.setSorting(sortColumn, direction);
                        refresh();
                    }
                })

                .setNegativeButton(R.string.cancel_button, null);

        AlertDialog alertDialog = builder.create();
        RadioGroup radioGroup = (RadioGroup) directionView.findViewById(R.id.direction_group);
        radioGroup.check(sorting.getSortingDirection() == OrderByDirection.ASC
                ? R.id.radio_asc : R.id.radio_desc);
        alertDialog.show();
    }

    protected void openFilterDialog() {
        LayoutInflater inflater = getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialog = inflater.inflate(R.layout.dialog_filter, null);
        builder.setView(dialog).setTitle(R.string.filter_dialog_title);
        setFilteringButtonListeners(builder);

        Spinner tagSpinner = (Spinner) dialog.findViewById(R.id.tag_spinner);
        Spinner countrySpinner = (Spinner) dialog.findViewById(R.id.country_spinner);
        Spinner citySpinner = (Spinner) dialog.findViewById(R.id.city_spinner);
        Spinner addressSpinner = (Spinner) dialog.findViewById(R.id.address_spinner);

        setRatingDefaultValue(dialog, R.id.rating_from_group, this.filtering.getRatingFrom() - 1);
        setRatingDefaultValue(dialog, R.id.rating_to_group, this.filtering.getRatingTo() - 1);

        initSpinner(tagSpinner, this.tagManager.getTagStringList());
        setSpinnerDefaultValue(tagSpinner, this.filtering.getFilterTag());
        initSpinner(citySpinner);
        initSpinner(addressSpinner);

        initSpinner(countrySpinner, this.addressManager.getCountryStringList());
        setSpinnerDefaultValue(countrySpinner, this.filtering.getFilterCountry());
        setCountrySpinnerListener(countrySpinner, citySpinner, addressSpinner);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    protected void setFilteringButtonListeners(AlertDialog.Builder builder) {
        builder.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        filterListView((AlertDialog) dialog);
                        refresh();

                    }
                })

                .setNeutralButton(R.string.reset_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        filtering.reset();
                        refresh();
                    }
                })

                .setNegativeButton(R.string.cancel_button, null);
    }

    protected void setCountrySpinnerListener(
            final Spinner countrySpinner, final Spinner citySpinner, final Spinner addressSpinner) {

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                final String chosenCountryName = countrySpinner.getSelectedItem().toString();
                if (chosenCountryName != null && !chosenCountryName.isEmpty()) {
                    initSpinner(citySpinner, addressManager.getCityStringList(chosenCountryName));
                    setSpinnerDefaultValue(citySpinner, filtering.getFilterCity());
                    setCitySpinnerListener(citySpinner, addressSpinner, chosenCountryName);
                } else {
                    addressSpinner.setSelection(0);
                    citySpinner.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    protected void setCitySpinnerListener(final Spinner citySpinner, final Spinner addressSpinner,
                                        final String countryName) {

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id) {
                String chosenCityName = citySpinner.getSelectedItem().toString();
                if (chosenCityName != null && !chosenCityName.isEmpty()) {
                    initSpinner(addressSpinner, addressManager.getAddressStringList(
                            chosenCityName, countryName));

                    setSpinnerDefaultValue(addressSpinner, filtering.getFilterAddress());
                } else {
                    addressSpinner.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    /**
     * Use chosen filters on a listview seen by a user.
     */
    protected void filterListView(AlertDialog dialog) {
        RadioGroup rgFrom = (RadioGroup) dialog.findViewById(R.id.rating_from_group);
        int idFrom = rgFrom.getCheckedRadioButtonId();
        View radioFrom = rgFrom.findViewById(idFrom);
        this.filtering.setRatingFrom(rgFrom.indexOfChild(radioFrom) + 1); // + 1 since indexes are from 0

        RadioGroup rgTo = (RadioGroup) dialog.findViewById(R.id.rating_to_group);
        int idTo = rgTo.getCheckedRadioButtonId();
        View radioTo = rgTo.findViewById(idTo);
        this.filtering.setRatingTo(rgTo.indexOfChild(radioTo) + 1); // + 1 since indexes are from 0

        Spinner tagSpinner = (Spinner) dialog.findViewById(R.id.tag_spinner);
        this.filtering.setFilterTag(tagSpinner.getSelectedItem().toString());

        Spinner countrySpinner = (Spinner) dialog.findViewById(R.id.country_spinner);
        this.filtering.setFilterCountry(countrySpinner.getSelectedItem().toString());

        Spinner citySpinner = (Spinner) dialog.findViewById(R.id.city_spinner);
        this.filtering.setFilterCity(citySpinner.getSelectedItem().toString());

        Spinner addressSpinner = (Spinner) dialog.findViewById(R.id.address_spinner);
        this.filtering.setFilterAddress(addressSpinner.getSelectedItem().toString());
    }

    /**
     * Sets index (from 1 to 5) for a RadioGroup with id id, which represent rating's boundaries
     * in filtering.
     * @param id id of radiogroup representing rating's border in filtering
     * @param index rating (from 1 to 5)
     */
    protected void setRatingDefaultValue(View v, int id, int index) {
        RadioGroup rg = (RadioGroup) v.findViewById(id);
        View radioButton = rg.getChildAt(index);
        rg.check(radioButton.getId());
    }


    /**
     * Sets given value in a given spinner (if exists)
     * @param spinner spinner to set default value
     * @param value string to set in spinner
     */
    protected void setSpinnerDefaultValue(Spinner spinner, String value) {
        if (value != null && !value.isEmpty()) {
            int spinnerPosition = ((ArrayAdapter<String>) spinner.getAdapter())
                    .getPosition(value);

            if (spinnerPosition >= 0) {
                spinner.setSelection(spinnerPosition);
            }
        }
    }

    protected void initSpinner(Spinner spinner) {
        initSpinner(spinner, Collections.singletonList(getString(R.string.blank)));
    }

    /**
     * Inits spinner with given string list and adds blank entry at the beginning.
     * @param spinner spinner to init
     * @param stringList strings to be inserted into spinner
     */
    protected void initSpinner(Spinner spinner, List<String> stringList) {
        List<String> listWithBlank = new ArrayList<>(stringList.size() + 1);
        listWithBlank.add("");
        listWithBlank.addAll(stringList);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(spinner.getContext(),
                android.R.layout.simple_spinner_item, listWithBlank);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    protected OrderByDirection radioButtonIdToDirection(int radioButtonId) {
        if (radioButtonId == R.id.radio_asc) {
            return OrderByDirection.ASC;
        } else if (radioButtonId == R.id.radio_desc) {
            return OrderByDirection.DESC;
        } else {
            throw new RuntimeException();
        }
    }

    protected Column intToColumn(int columnIndex) {
        switch (columnIndex) {
            case ADDED_INDEX:
                return PlaceDAO.ADDED;

            case RATING_INDEX:
                return PlaceDAO.RATING;

            case NAME_INDEX:
                return PlaceDAO.NAME;

            default:
                throw new RuntimeException();
        }
    }

    protected int columnToInt(Column column) {
        if (column.equals(PlaceDAO.ADDED)) {
            return ADDED_INDEX;
        } else if (column.equals(PlaceDAO.RATING)) {
            return RATING_INDEX;
        } else if (column.equals(PlaceDAO.NAME)) {
            return NAME_INDEX;
        } else {
            throw new RuntimeException();
        }
    }
}
