package com.example.rupeshchaudhary.androidtest.Network;

import com.example.rupeshchaudhary.androidtest.model.Section;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public interface ApiCallback {
    void onSuccess(LinkedHashMap<String,ArrayList<Section>> sectionsMap);
    void onFailure();
}
