package com.nivedita.weatherutility.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by PUNEETU on 28-03-2018.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)

public @interface DatabaseInfo {
}
