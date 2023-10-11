package com.github.markahenrich.testapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericData {
    Long id;
    String strData;
    int numData;
    boolean isEnabled;
}
